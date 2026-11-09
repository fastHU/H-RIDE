# Changelog

All notable changes to H RIDE are documented in this file.
The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [7.7.0] — 2026-11-09

Major evolution release. 🎉
Complete native rewrite in pure Kotlin & Jetpack Compose with Apple-grade fluid interactions, precision GPS telemetry, dual-engine mapping, and aero cockpit.

### Added

- **First-Class Open Source Kotlin Project**: Replaced decompiled bytecode with clean, buildable, native Jetpack Compose source tree directly in the repository.
- **Apple-Grade Fluid Dock**: Elastic spring physics, interactive draggable pill indicator with continuous gesture tracking, and adaptive morphological transitions.
- **Strictly Equalized Dock Margins**: In Home/Map view, the Dock contracts into a compact circular pill with balanced uniform margins (horizontal and vertical distances strictly equalized).
- **Smooth 4-Tab Non-Stutter Navigation**: Direct instantaneous switching across any tab index (e.g. Tab 1 directly to Tab 4) without intermediate hitching or scale stutter.
- **Dual-Engine Mapping**: Seamless toggle between vector OpenStreetMap terrain and high-resolution ArcGIS World Imagery satellite photography with resilient offline caching.
- **Smart Directional Puck**: Live orientation heading arrow, speed-reactive pulse wave, and GPS accuracy ring.
- **Advanced Dynamic Cockpit**: Speedometer dial with gradient arc, elevation profile chart with climb percentage, and live multi-axis G-Force acceleration radar.
- **Tire Pressure Science Calculator**: Optimal front/rear PSI & Bar computation based on rider weight, bike type, rim inner width, tire size, and road surface conditions.
- **Comprehensive Theme Engine & Pro HEX/RGB Color Picker**: Deep Space Dark, Obsidian Carbon, Titanium Grey, Racing Green, Alpine White, Midnight Blue, plus live custom HEX and RGB slider controls.
- **Interactive Photo Background Cropper**: 2D gesture pinch-to-zoom and pan cropper for personalized profile covers, with 3-second long-press reset safety confirmation.
- **Ride History & Telemetry Logs**: Detailed trip logging, total climb, average and maximum velocity records.

### Fixed

- Fixed Dock bar drag gesture freeze and gesture blocking.
- Fixed Tab 4 routing bug where clicking Tab 4 jumped to Tab 3.
- Removed micro-stutter when indicator slides past intermediate tabs.
- Completely purged legacy personalized language code with zero leftovers.

### Notes

- Android 8.0 (API 26) or newer (Target SDK 34).
- Release APK: `H-RIDE-v7.7.apk` (SHA-256: `824e2d64cc9b6083339b50d4da7b61443015ba0086a329eacee288c8c9bc70c2`).

## [1.0.0] — 2026-10-16

First public release. 🎉

### Added

- **Real-time speed** readout driven by GPS.
- **Real-time G-force** from the device motion sensors.
- **Average speed** and **max speed** tracking for the whole ride.
- **Altitude** display for climbs and descents.
- **Ride distance and duration** counters.
- **Topographic map view** (OpenTopoMap / Thunderforest / USGS tile layers via osmdroid).
- **Background recording** through a foreground service, with a persistent notification.
- Native **Jetpack Compose** interface.

### Notes

- Requires Android 7.0 (API 24) or newer.
- Universal APK: `arm64-v8a`, `armeabi-v7a`, `x86`, `x86_64`.
- Signed with the H RIDE release key (certificate SHA-256
  `d3257079398d904ef92b6508e33b0b46b022f43f74237a4e3d4596ce65d681d5`).

[7.7.0]: https://github.com/fastHU/H-RIDE/releases/tag/v7.7
[1.0.0]: https://github.com/fastHU/H-RIDE/releases/tag/v1.0.0
