<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>A pocket cycling computer for Android.</b><br>
  Real-time speed · real-time G-force · average &amp; max speed · altitude · ride distance
</p>

<p align="center">
  <a href="https://github.com/fastHU/H-RIDE/releases/latest"><img alt="Release" src="https://img.shields.io/github/v/release/fastHU/H-RIDE?style=for-the-badge&label=Release&color=FFC400&labelColor=1A1A1A"></a>
  <a href="https://github.com/fastHU/H-RIDE/releases"><img alt="Downloads" src="https://img.shields.io/github/downloads/fastHU/H-RIDE/total?style=for-the-badge&label=Downloads&color=FFC400&labelColor=1A1A1A"></a>
  <a href="LICENSE"><img alt="License" src="https://img.shields.io/github/license/fastHU/H-RIDE?style=for-the-badge&label=License&color=FFC400&labelColor=1A1A1A"></a>
  <a href="https://github.com/fastHU/H-RIDE/stargazers"><img alt="Stars" src="https://img.shields.io/github/stars/fastHU/H-RIDE?style=for-the-badge&label=Stars&color=FFC400&labelColor=1A1A1A"></a>
  <img alt="Platform" src="https://img.shields.io/badge/Android-7.0%2B-FFC400?style=for-the-badge&labelColor=1A1A1A&logo=android&logoColor=white">
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

**H RIDE** turns your phone into a cycling computer. Mount it on the handlebar, hit start, and it
records what actually matters on a ride — how fast you are going, how hard you are accelerating,
how much climbing you have done — and shows it in a clean, glanceable, high-contrast interface you
can read in one second while riding.

No account. No sign-up. No subscription. Just install the APK and ride.

> **About this repository** — `H-RIDE` is the official distribution repository for H RIDE. It hosts
> the release builds, release notes and documentation. Published builds are signed with the
> developer's release key, so every update installs cleanly over the previous one.

## ✨ Features

| | Feature | Description |
|:--:|---|---|
| ⚡ | **Real-time speed** | Live speed readout, refreshed continuously from GPS, in km/h or mph. |
| 🌀 | **Real-time G-force** | Live acceleration load from the device's motion sensors, so you can see how hard you brake, corner and sprint. |
| 📊 | **Average speed** | Moving average for the whole ride, updated as you go. |
| 🏁 | **Max speed** | The fastest point of your ride, tracked automatically. |
| ⛰️ | **Altitude** | Current elevation and climbing, so you always know how much mountain is left. |
| 📏 | **Distance &amp; duration** | Total ride distance and elapsed time, kept in sync with the recording session. |
| 🗺️ | **Topographic map** | A live map view with topo/terrain tile layers (OpenTopoMap, Thunderforest, USGS) — built for trails, not just city streets. |
| 🌙 | **Background recording** | A foreground service keeps the ride recording when the screen is off or you switch apps. |
| 🎨 | **Built with Jetpack Compose** | A modern, smooth, native Android UI. |

## 📥 Download

Grab the latest APK from the [**Releases**](https://github.com/fastHU/H-RIDE/releases/latest) page.

| Version | File | Size | Requires | SHA-256 |
|---|---|---|---|---|
| **v1.0.0** | [`H-RIDE-v1.0.0.apk`](https://github.com/fastHU/H-RIDE/releases/latest) | 17.1 MiB | Android 7.0+ (API 24) | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

Verify your download before installing:

```bash
# macOS / Linux
shasum -a 256 H-RIDE-v1.0.0.apk

# Windows (PowerShell)
Get-FileHash .\H-RIDE-v1.0.0.apk -Algorithm SHA256
```

The printed hash must match the SHA-256 above. If it does not, delete the file and download it again.

## 🚀 Install

1. Download `H-RIDE-v1.0.0.apk` on your phone.
2. Open it. Android will ask you to allow installing apps from this source — allow it
   (*Settings → Apps → Special access → Install unknown apps*).
3. Install, open H RIDE and grant the location permission when asked.
4. Mount the phone, press start, ride.

<details>
<summary>Install over ADB instead</summary>

```bash
adb install -r H-RIDE-v1.0.0.apk
```
</details>

**Supported ABIs:** `arm64-v8a`, `armeabi-v7a`, `x86`, `x86_64` — the APK contains all four, so it
runs on essentially every Android phone and tablet.

## 🔐 Permissions &amp; privacy

H RIDE asks for exactly what a cycling computer needs, and nothing more:

| Permission | Why it is needed |
|---|---|
| `ACCESS_FINE_LOCATION` / `ACCESS_COARSE_LOCATION` | Speed, distance, altitude and the map are all derived from your GPS position. |
| `FOREGROUND_SERVICE` / `FOREGROUND_SERVICE_LOCATION` | Keeps the ride recording while the screen is off or you are using another app, with a persistent notification. |
| `POST_NOTIFICATIONS` | Shows the recording notification required by Android for background location. |
| `INTERNET` / `ACCESS_NETWORK_STATE` / `ACCESS_WIFI_STATE` | Fetches map tiles for the map view. |
| Motion sensors | Real-time G-force is read from the device's accelerometer. |

**Privacy in short:** there is no account and no H RIDE server. Your ride statistics are computed
on the device. Map tiles are requested from public tile providers (OpenTopoMap, Thunderforest,
USGS, OpenStreetMap), which see your IP address like any online map does. The APK also bundles
standard Google Play services / Firebase libraries; you can audit the full permission list yourself
with `aapt2 dump badging H-RIDE-v1.0.0.apk`.

## 🧱 Built with

- **Kotlin** + **Jetpack Compose** for the UI
- **osmdroid** with topographic tile layers for the map
- Android **location APIs** and a **foreground service** for reliable ride recording
- Target SDK 36 · Min SDK 24

## ❓ FAQ

<details>
<summary><b>Is H RIDE on Google Play?</b></summary>

Not yet — it is distributed here as a signed APK. Releases on GitHub are the official builds.
</details>

<details>
<summary><b>Which Android versions are supported?</b></summary>

Android 7.0 (API 24) and newer, on both 32-bit and 64-bit devices.
</details>

<details>
<summary><b>Why does Android warn me about installing the APK?</b></summary>

Every app installed outside the Play Store triggers that warning. The APK is signed with a
consistent release key (certificate SHA-256
`d3257079398d904ef92b6508e33b0b46b022f43f74237a4e3d4596ce65d681d5`) and the SHA-256 of the file is
published above so you can verify it.
</details>

<details>
<summary><b>Where is the source code?</b></summary>

This repository publishes the official builds, the documentation and a [machine-decompiled reference](decompiled/) of the app's code. The original Kotlin project was lost, so that reference is not the original source and does not build as-is.
</details>

## 🗺️ Roadmap

- [x] First public release (`v1.0.0`)
- [ ] Reconstruct a clean, buildable Kotlin project from the decompiled reference
- [ ] Ride history and per-ride statistics
- [ ] Export rides (GPX)
- [ ] More units, themes and languages

Ideas and bug reports are welcome in [Issues](https://github.com/fastHU/H-RIDE/issues).

## 🤝 Contributing

- 🐞 Found a bug? [Open an issue](https://github.com/fastHU/H-RIDE/issues/new) with your phone model,
  Android version and what happened.
- 💡 Have an idea? Start a discussion in an issue — feature requests shape the roadmap.
- 🌍 Translations of this README are welcome: copy `README.md`, translate it and open a pull request.
- ⭐ If H RIDE is useful to you, a star helps other riders find it.

## 📄 License

Released under the [MIT License](LICENSE) © 2026 fastHU.

## 🙏 Acknowledgements

- [OpenStreetMap](https://www.openstreetmap.org/) contributors — the map data
- [OpenTopoMap](https://opentopomap.org/), [Thunderforest](https://www.thunderforest.com/) and
  [USGS](https://www.usgs.gov/) — topographic tile layers
- [osmdroid](https://github.com/osmdroid/osmdroid) — the map engine
- [Jetpack Compose](https://developer.android.com/compose) — the UI toolkit

<div align="center">
  <br>
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <a href="https://star-history.com/#fastHU/H-RIDE&Date">
    <img src="https://api.star-history.com/svg?repos=fastHU/H-RIDE&type=Date" alt="Star history" width="600">
  </a>
  <br><br>
  <sub>Made for riders, by a rider. 🚵</sub>
</div>
