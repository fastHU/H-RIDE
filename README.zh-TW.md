<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>新世代空氣力學騎行碼錶與 Android 騎乘追蹤夥伴。</b><br>
  Apple 級流體 Dock · 即時速度與 G 力 · 雙模衛星地圖 · 海拔剖面圖 · 胎壓計算器
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
  <a href="README.md">English</a> ·
  <a href="README.zh-CN.md">简体中文</a> ·
  <b>繁體中文</b> ·
  <a href="README.ja-JP.md">日本語</a> ·
  <a href="README.ko-KR.md">한국어</a> ·
  <a href="README.es-ES.md">Español</a> ·
  <a href="README.ru-RU.md">Русский</a>
</p>

---

## 👋 H RIDE 是什麼？

**H RIDE** 將 Android 手機變成空氣力學騎行碼錶與騎乘追蹤工具。固定在車把或龍頭上，輕觸開始，即可查看速度、G 力、即時海拔剖面與雙層衛星地圖。

介面避開刺眼螢光色，在正午直射陽光或夜間騎乘時都能清晰閱讀。無需強制雲端帳號、訂閱或隱私追蹤。

<div align="center">
  <img src="assets/app-preview.png" alt="H RIDE 介面" width="100%">
</div>

> **v7.7.0+ 版本說明** — 從 **v7.7.0** 起，H RIDE 是**可編譯的純 Kotlin + Jetpack Compose 開源 Android Studio 專案**（`app/`）。v1.0.0 的反編譯程式碼保留在 [`decompiled/`](decompiled/) 作為歷史參考。

> **介面語言：** 目前版本為簡體中文介面，繁體中文與英文介面已在規劃中。

---

## ✨ 功能

| | 功能 | 說明 |
|:--:|---|---|
| 🍏 | **Apple 級流體 Dock** | 具彈簧物理與拖曳手勢的底部導覽列。 |
| ⚡ | **即時速度計** | 以漸層圓弧顯示速度、平均與最高速度（km/h）。 |
| 🌀 | **G 力雷達** | 透過裝置感測器呈現加速與過彎負載。 |
| 🛰️ | **雙模地圖引擎** | OpenStreetMap 向量地形與 ArcGIS World Imagery 衛星影像，支援離線快取。 |
| ⛰️ | **即時海拔剖面** | 顯示高度曲線、坡度與累計爬升。 |
| 🔧 | **胎壓計算器** | 依騎士體重、車重、輪胎寬度、胎體類型與地形/路況計算前後輪 PSI 與 bar。 |
| 📊 | **騎乘歷史與統計** | 記錄路線、累計爬升、平均與最高速度。 |
| 🌙 | **前景服務** | 螢幕關閉或切到背景時仍持續記錄。 |

---

## 📥 下載

| 版本 | 檔案 | 大小 | SHA-256 |
|---|---|---|---|
| **v7.7.0**（最新） | `H_RIDE.apk` | 約 15.3 MiB | `824e2d64cc9b6083339b50d4da7b61443015ba0086a329eacee288c8c9bc70c2` |
| **v1.0.0**（舊版） | `H-RIDE-v1.0.0.apk` | 約 17.1 MiB | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

> **簽名說明：** v7.7.0 APK 使用 Android 標準偵錯金鑰（`CN=Android Debug`）簽名，並標記為 `debuggable`。它適用於側載與測試，不是應用商店的正式簽名版本。v1.0.0 使用原 H RIDE 發行金鑰簽名。

> **從 v1.0.0 升級：** v7.7.0 使用應用程式 ID `com.liquidvelo.app`，v1.0.0 使用 `com.aistudio.summitpath.mtb`。兩個版本可並存安裝，但騎乘資料不會自動移轉。

---

## 🚀 編譯

需求：Android Studio Hedgehog 以上、JDK 17、compileSdk 34、minSdk 26。儲存庫已包含 Gradle wrapper（Gradle 8.2）。

```bash
git clone https://github.com/fastHU/H-RIDE.git
cd H-RIDE
./gradlew assembleRelease
```

---

## 🔐 權限與隱私

本應用程式要求精確/概略位置、含位置的 foreground 服務、通知、地圖網路存取、動作感測器、wake lock、震動，以及讀取圖片/影片作為個人封面。沒有自有帳號或伺服器；騎乘資料儲存在裝置上。

---

## 📄 授權

依 [MIT License](LICENSE) 發布 © 2026 fastHU。

---

<div align="center">
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <sub>由騎士打造，為騎士而生。🚴‍♂️💨</sub>
</div>
