package com.liquidvelo.app

import android.Manifest
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.liquidvelo.app.data.LocationTrackingHelper
import com.liquidvelo.app.data.RideRepository
import com.liquidvelo.app.data.SensorManagerHelper
import com.liquidvelo.app.theme.LiquidVeloTheme
import com.liquidvelo.app.theme.LocalThemePalette
import com.liquidvelo.app.theme.ThemeManager
import com.liquidvelo.app.ui.components.AppleDockBar
import com.liquidvelo.app.ui.screens.HistoryScreen
import com.liquidvelo.app.ui.screens.MapScreen
import com.liquidvelo.app.ui.screens.ProfileScreen
import com.liquidvelo.app.ui.screens.RideActiveScreen
import com.liquidvelo.app.ui.screens.ToolsScreen
import kotlinx.coroutines.launch
import java.io.File

class MainActivity : ComponentActivity() {
    private lateinit var repository: RideRepository
    private lateinit var sensorHelper: SensorManagerHelper
    private lateinit var trackingHelper: LocationTrackingHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // Crash logger guard
        val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            try {
                Log.e("HRideCrash", "Uncaught exception on thread: $thread", throwable)
                val crashFile = File(applicationContext.filesDir, "last_crash.txt")
                crashFile.writeText("Thread: ${thread.name}\n${throwable.stackTraceToString()}")
            } catch (e: Throwable) {
                e.printStackTrace()
            }
            defaultHandler?.uncaughtException(thread, throwable)
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.navigationBarColor = Color.TRANSPARENT
        window.statusBarColor = Color.TRANSPARENT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
            window.isStatusBarContrastEnforced = false
        }

        ThemeManager.init(applicationContext)
        repository = RideRepository(applicationContext)
        sensorHelper = SensorManagerHelper(applicationContext)
        trackingHelper = LocationTrackingHelper(applicationContext, sensorHelper)

        setContent {
            LiquidVeloTheme {
                RequestPermissionsFlow(trackingHelper)

                MainAppContainer(
                    repository = repository,
                    trackingHelper = trackingHelper
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        sensorHelper.stopListening()
    }
}

@Composable
fun RequestPermissionsFlow(trackingHelper: LocationTrackingHelper) {
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { results ->
        val fineGranted = results[Manifest.permission.ACCESS_FINE_LOCATION] == true
        if (fineGranted) {
            trackingHelper.startGpsWarmup()
        }
    }

    LaunchedEffect(Unit) {
        val permissions = mutableListOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissions.add(Manifest.permission.POST_NOTIFICATIONS)
        }
        permissionLauncher.launch(permissions.toTypedArray())
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainAppContainer(
    repository: RideRepository,
    trackingHelper: LocationTrackingHelper
) {
    val palette = LocalThemePalette.current
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 4 })
    val coroutineScope = rememberCoroutineScope()
    var isRideActive by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableIntStateOf(0) }

    // Synchronize selectedTab from pager only when not animating/scrolling
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTab = pagerState.currentPage
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(palette.background)
    ) {
        // Horizontal Pager kept resident to prevent MapView tearing down on ride activation
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            beyondBoundsPageCount = 3,
            userScrollEnabled = !isRideActive && pagerState.currentPage != 0 // Disable horizontal swipe on Map page or while riding
        ) { page ->
            when (page) {
                0 -> MapScreen(
                    trackingHelper = trackingHelper,
                    onStartRideConfirmed = {
                        try {
                            trackingHelper.startRide()
                        } catch (e: Throwable) {
                            e.printStackTrace()
                        }
                        isRideActive = true
                    }
                )
                1 -> HistoryScreen(repository = repository)
                2 -> ToolsScreen()
                3 -> ProfileScreen(repository = repository)
            }
        }

        // Apple Floating Dock Bar - automatically hidden when riding
        if (!isRideActive) {
            AppleDockBar(
                currentTabIndex = selectedTab,
                onTabSelected = { index ->
                    selectedTab = index
                    coroutineScope.launch {
                        pagerState.scrollToPage(index)
                    }
                },
                onLocationClick = {
                    trackingHelper.triggerRecenterMap()
                },
                onStartRideClick = {
                    trackingHelper.triggerStartRide()
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        // RideActiveScreen overlay with clean transitions (Map stays intact underneath)
        AnimatedVisibility(
            visible = isRideActive,
            enter = fadeIn(animationSpec = tween(300)) + scaleIn(initialScale = 0.94f, animationSpec = tween(300)),
            exit = fadeOut(animationSpec = tween(200))
        ) {
            RideActiveScreen(
                trackingHelper = trackingHelper,
                repository = repository,
                onFinishRide = {
                    isRideActive = false
                    selectedTab = 1
                    coroutineScope.launch { pagerState.scrollToPage(1) } // Navigate to history after ride saved
                },
                onDiscardRide = {
                    isRideActive = false
                    selectedTab = 0
                    coroutineScope.launch { pagerState.scrollToPage(0) } // Keep on home/map after discard!
                }
            )
        }
    }
}