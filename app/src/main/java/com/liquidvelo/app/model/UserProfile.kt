package com.liquidvelo.app.model

data class UserProfile(
    val name: String = "VeloRider",
    val bio: String = "追求纯粹空气动力学与机械韵律",
    val avatarUri: String? = null,
    val bannerUri: String? = null,
    val isBannerVideo: Boolean = false,
    val riderWeightKg: Float = 68.0f,
    val bikeWeightKg: Float = 7.6f,
    val bikeModel: String = "S-Works Tarmac SL8",
    val tireWidthMm: Float = 28.0f,
    val ftpWatts: Int = 265,
    val totalRidesCount: Int = 42,
    val totalDistanceKm: Double = 1845.6
)
