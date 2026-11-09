<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>Next-Generation Aero Cycling Computer &amp; Tracking Companion for Android.</b><br>
  Apple-grade fluid Dock · real-time speed &amp; G-force · dual satellite mapping · elevation profile · tire pressure calculator
</p>

<p align="center">
  <a href="https://github.com/fastHU/H-RIDE/releases/latest"><img alt="Release" src="https://img.shields.io/github/v/release/fastHU/H-RIDE?style=for-the-badge&label=Release&color=FFC400&labelColor=1A1A1A"></a>
  <a href="https://github.com/fastHU/H-RIDE/releases"><img alt="Downloads" src="https://img.shields.io/github/downloads/fastHU/H-RIDE/total?style=for-the-badge&label=Downloads&color=FFC400&labelColor=1A1A1A"></a>
  <a href="LICENSE"><img alt="License" src="https://img.shields.io/github/license/fastHU/H-RIDE?style=for-the-badge&label=License&color=FFC400&labelColor=1A1A1A"></a>
  <a href="https://github.com/fastHU/H-RIDE/stargazers"><img alt="Stars" src="https://img.shields.io/github/stars/fastHU/H-RIDE?style=for-the-badge&label=Stars&color=FFC400&labelColor=1A1A1A"></a>
  <img alt="Platform" src="https://img.shields.io/badge/Android-8.0%2B-FFC400?style=for-the-badge&labelColor=1A1A1A&logo=android&logoColor=white">
  <a href="app/"><img alt="Code" src="https://img.shields.io/badge/Kotlin-Jetpack_Compose-FFC400?style=for-the-badge&labelColor=1A1A1A&logo=kotlin&logoColor=white"></a>
  <a href="https://github.com/fastHU/H-RIDE/issues"><img alt="Issues" src="https://img.shields.io/github/issues/fastHU/H-RIDE?style=for-the-badge&label=Issues&color=FFC400&labelColor=1A1A1A"></a>
</p>

<p align="center">
  <b>English</b> ·
  <a href="README.zh-CN.md">简体中文</a> ·
  <a href="README.zh-TW.md">繁體中文</a> ·
  <a href="README.ja-JP.md">日本語</a> ·
  <a href="README.ko-KR.md">한국어</a> ·
  <a href="README.es-ES.md">Español</a> ·
  <a href="README.ru-RU.md">Русский</a>
</p>

---

## 👋 What is H RIDE?

**H RIDE** turns your Android phone into an aero cycling computer and ride tracking powerhouse. Mount it on your handlebar or stem, tap start, and get instant, glanceable telemetry on everything that counts — speed, acceleration G-force, real-time elevation profile, and dual-layer satellite mapping.

Engineered with a **restrained, anti-glare aesthetic** that avoids garish fluorescent "AI" palettes, H RIDE ensures crystal-clear outdoor legibility under scorching direct sunlight or pitch-black night rides.

No mandatory cloud accounts. No subscriptions. No privacy tracking. Just install the APK and hit the road.

<div align="center">
  <img src="assets/app-preview.png" alt="H RIDE Preview" width="100%" style="border-radius: 12px; margin: 16px 0;">
</div>

> **Notice for v7.7.0+** — Starting with version **v7.7.0**, H RIDE is a **100% open-source, compilable Android Studio project** written natively in pure Kotlin and Jetpack Compose (`app/`). The legacy decompiled bytecode from v1.0.0 is preserved in [`decompiled/`](decompiled/) for historical reference.

> **UI language:** the current build ships with a Simplified Chinese interface. English localization is on the roadmap.

---

## ✨ Features

| | Feature | Description |
|:--:|---|---|
| 🍏 | **Apple-Grade Fluid Dock** | Dynamic morphological bottom navigation dock with spring physics, full touch-and-drag gesture tracking, and balanced equalized margins in map mode. |
| ⚡ | **Real-Time Speedometer** | Responsive speed readout with dynamic gradient arc, max speed, and moving average in km/h. |
| 🌀 | **G-Force Radar** | Multi-axis acceleration &amp; cornering load from device motion sensors for braking, sprinting, and descending telemetry. |
| 🛰️ | **Dual-Engine Mapping** | Seamless toggle between OpenStreetMap vector terrain and high-definition ArcGIS World Imagery satellite photography with offline disk caching. |
| 🧭 | **Smart Directional Puck** | Orientation heading arrow, speed-reactive pulse wave, and GPS accuracy halo indicator. |
| ⛰️ | **Live Elevation Profile** | Dynamic altitude graph displaying ascent/descent curves, gradient slope percentage, and cumulative climbing. |
| 🔧 | **Tire Pressure Calculator** | Scientific front and rear tire pressure calculation (PSI &amp; Bar) based on rider weight, bike weight, tire width, casing type, and terrain/road conditions. |
| 🎨 | **Anti-Glare Palette &amp; HEX Picker** | Curated outdoor palettes (Deep Space Dark, Obsidian Carbon, Racing Green, etc.) plus exact 6-character HEX code input and RGB sliders. |
| 🖼️ | **Custom Cover Cropper** | Full 2D gesture photo cropper (pinch zoom, drag pan) for personalized profile backgrounds with a 3-second long-press reset guard. |
| 📊 | **Ride History &amp; Stats** | Comprehensive activity tracking, total elevation gain, average/max speeds, and session logs. |
| 🌙 | **Foreground Battery Shield** | Background recording powered by an efficient Android Foreground Service (`CyclingTrackingService`) that resists aggressive OS kills. |

---

## 📂 Source Code &amp; Project Structure

The full, compilable, idiomatic **Kotlin + Jetpack Compose** source code is included directly in this repository:

```
H-RIDE/
├── app/
│   ├── build.gradle.kts                   # Dependencies & compile SDK 34 config
│   ├── proguard-rules.pro                 # Release code optimization rules
│   └── src/main/
│       ├── AndroidManifest.xml            # Service & location permission declarations
│       ├── java/com/liquidvelo/app/
│       │   ├── MainActivity.kt            # App container & bottom sheet coordinator
│       │   ├── data/                      # GPS Location & Sensor helpers
│       │   │   ├── LocationTrackingHelper.kt
│       │   │   ├── RideRepository.kt
│       │   │   └── SensorManagerHelper.kt
│       │   ├── model/                     # Data models (Ride, Tire Pressure, User)
│       │   ├── service/                   # Foreground tracking service
│       │   │   └── CyclingTrackingService.kt
│       │   ├── theme/                     # Color palette engine & typography
│       │   └── ui/
│       │       ├── components/            # Reusable widgets (AppleDockBar, SpeedometerDial, ElevationChart, etc.)
│       │       └── screens/               # MapScreen, RideActiveScreen, HistoryScreen, ToolsScreen, ProfileScreen
│       └── res/                           # Vector icons, themes, and strings
├── assets/                                # Banners, icons, and preview media
├── decompiled/                            # Historical legacy v1.0.0 reference archive
├── build.gradle.kts                       # Root build configuration
├── settings.gradle.kts                    # Gradle project settings
├── gradlew / gradlew.bat                  # Gradle wrapper scripts
├── gradle/wrapper/                        # Wrapper JAR & distribution config
└── README.md
```

---

## 📥 Download &amp; Verification

Release builds are available on the [Releases page](https://github.com/fastHU/H-RIDE/releases).

| Version | File | Size | SHA-256 |
|---|---|---|---|
| **v7.7.0** (Latest) | `H_RIDE.apk` | ~15.3 MiB | `824e2d64cc9b6083339b50d4da7b61443015ba0086a329eacee288c8c9bc70c2` |
| **v1.0.0** (Legacy) | `H-RIDE-v1.0.0.apk` | ~17.1 MiB | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

> **Signing note:** the v7.7.0 APK is signed with the standard Android debug key (`CN=Android Debug`) and is marked `debuggable`. It is intended for sideloading and testing, not as a Play Store production build. The v1.0.0 APK was signed with the original H RIDE release key (certificate SHA-256 `d3257079398d904ef92b6508e33b0b46b022f43f74237a4e3d4596ce65d681d5`).

> **Upgrading from v1.0.0:** v7.7.0 uses the application ID `com.liquidvelo.app`; v1.0.0 used `com.aistudio.summitpath.mtb`. Both versions can be installed side by side, but ride data is not migrated automatically.

### Verify Checksum
```bash
# macOS / Linux
shasum -a 256 H_RIDE.apk

# Windows PowerShell
Get-FileHash H_RIDE.apk -Algorithm SHA256
```

---

## 🚀 Building &amp; Installation

### Requirements
- **Android Studio**: Hedgehog (2023.1.1) or newer
- **JDK**: Java 17
- **Target SDK**: Android 14 (API 34) · **Min SDK**: Android 8.0 (API 26)

### Build From Source

The repository includes the Gradle wrapper (Gradle 8.2); the first run downloads the distribution automatically.

```bash
git clone https://github.com/fastHU/H-RIDE.git
cd H-RIDE

# Build Release APK
./gradlew assembleRelease
```

### Install APK via ADB
```bash
adb install -r H_RIDE.apk
```

---

## 🔐 Permissions &amp; Privacy

| Permission | Why it is needed |
|---|---|
| `ACCESS_FINE_LOCATION` / `ACCESS_COARSE_LOCATION` | Real-time GPS speed, odometer distance, elevation, and heading puck. |
| `FOREGROUND_SERVICE` / `FOREGROUND_SERVICE_LOCATION` | Uninterrupted ride recording with screen turned off or in the background. |
| `POST_NOTIFICATIONS` | Displays the persistent system tracking notification required by Android. |
| `INTERNET` / `ACCESS_NETWORK_STATE` | Fetches OpenStreetMap and ArcGIS satellite map tiles. |
| Motion Sensors | Live G-force and cornering acceleration from the hardware accelerometer. |
| `HIGH_SAMPLING_RATE_SENSORS` | High-rate motion sampling for the live G-force radar. |
| `WAKE_LOCK` | Keeps the CPU awake during long ride recordings. |
| `VIBRATE` | Haptic feedback for controls and alerts. |
| `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` | Lets the app ask to be exempted from aggressive battery savers during long rides. |
| `READ_MEDIA_IMAGES` / `READ_MEDIA_VIDEO` | Lets you pick and crop a profile cover photo (Android 13+). |

---

## 🗺️ Roadmap

- [x] First public release (`v1.0.0`)
- [x] Full Kotlin &amp; Jetpack Compose rewrite with compilable source (`v7.7.0`)
- [x] Apple-grade fluid Dock bar with gesture dragging &amp; spring physics
- [x] ArcGIS satellite imagery &amp; OSM vector dual mapping
- [x] Live elevation chart &amp; slope percentage display
- [x] Ride history logs &amp; activity metrics
- [x] Professional tire pressure calculator
- [x] Curated anti-glare color palettes &amp; custom HEX picker
- [ ] English UI localization
- [ ] Reproducible release-signed builds / CI
- [ ] GPX track export &amp; import
- [ ] Bluetooth LE cadence &amp; heart rate sensor pairing

---

## 📄 License

Released under the [MIT License](LICENSE) © 2026 fastHU.

---

<div align="center">
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <sub>Crafted for riders, by riders. 🚴‍♂️💨</sub>
</div>
