# Changelog

All notable changes to H RIDE are documented in this file.
The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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

[1.0.0]: https://github.com/fastHU/H-RIDE/releases/tag/v1.0.0
