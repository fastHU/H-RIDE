<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>口袋裡的自行車碼表，就在 Android 上。</b><br>
  即時速度 · 即時 G 力 · 平均與最高速度 · 海拔高度 · 騎乘距離
</p>

<p align="center">
  <a href="https://github.com/fastHU/Core/releases/latest"><img alt="Release" src="https://img.shields.io/github/v/release/fastHU/Core?style=for-the-badge&label=Release&color=FFC400&labelColor=1A1A1A"></a>
  <a href="https://github.com/fastHU/Core/releases"><img alt="Downloads" src="https://img.shields.io/github/downloads/fastHU/Core/total?style=for-the-badge&label=Downloads&color=FFC400&labelColor=1A1A1A"></a>
  <a href="LICENSE"><img alt="License" src="https://img.shields.io/github/license/fastHU/Core?style=for-the-badge&label=License&color=FFC400&labelColor=1A1A1A"></a>
  <a href="https://github.com/fastHU/Core/stargazers"><img alt="Stars" src="https://img.shields.io/github/stars/fastHU/Core?style=for-the-badge&label=Stars&color=FFC400&labelColor=1A1A1A"></a>
  <img alt="Platform" src="https://img.shields.io/badge/Android-7.0%2B-FFC400?style=for-the-badge&labelColor=1A1A1A&logo=android&logoColor=white">
  <a href="https://github.com/fastHU/Core/issues"><img alt="Issues" src="https://img.shields.io/github/issues/fastHU/Core?style=for-the-badge&label=Issues&color=FFC400&labelColor=1A1A1A"></a>
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

**H RIDE** 讓你的手機變身自行車碼表。裝上車把手，按下開始，
它就會忠實記錄騎乘中真正重要的一切——你騎得多快、加速多猛、
爬了多少坡——並以簡潔、一目了然、高對比度的介面呈現，
讓你在騎車時只需瞄一眼就能讀懂。

免帳號。免註冊。免訂閱。裝上 APK，上路就對了。

> **關於本儲存庫** —— `Core` 是 H RIDE 的官方發佈儲存庫，負責存放正式版本、版本說明與
> 相關文件。發佈的版本皆以開發者的正式簽署金鑰簽章，因此每次更新都能直接覆蓋舊版、
> 乾淨升級。

## ✨ 功能特色

| | 功能 | 說明 |
|:--:|---|---|
| ⚡ | **即時速度** | 持續依 GPS 更新的即時速度讀數，支援 km/h 與 mph。 |
| 🌀 | **即時 G 力** | 取自裝置動態感測器的即時加速度負載，讓你清楚看見自己煞車、過彎與衝刺有多猛。 |
| 📊 | **平均速度** | 整趟騎乘的移動平均值，隨騎隨算。 |
| 🏁 | **最高速度** | 自動追蹤整趟騎乘的最速瞬間。 |
| ⛰️ | **海拔高度** | 目前海拔與累計爬升，讓你隨時掌握前方還剩多少山要爬。 |
| 📏 | **距離與時間** | 總騎乘距離與經過時間，與錄製工作階段保持同步。 |
| 🗺️ | **地形圖** | 即時地圖檢視，支援地形／地貌圖磚圖層（OpenTopoMap、Thunderforest、USGS）——為越野路線而生，不只適用市區街道。 |
| 🌙 | **背景錄製** | 前景服務讓螢幕關閉或切換 App 時仍持續記錄騎乘。 |
| 🎨 | **以 Jetpack Compose 打造** | 現代、流暢的原生 Android 介面。 |

## 📥 下載

請至 [**Releases**](https://github.com/fastHU/Core/releases/latest) 頁面取得最新版 APK。

| 版本 | 檔案 | 大小 | 需求 | SHA-256 |
|---|---|---|---|---|
| **v1.0.0** | [`H-RIDE-v1.0.0.apk`](https://github.com/fastHU/Core/releases/latest) | 17.1 MiB | Android 7.0+ (API 24) | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

安裝前請先驗證下載檔案：

```bash
# macOS / Linux
shasum -a 256 H-RIDE-v1.0.0.apk

# Windows (PowerShell)
Get-FileHash .\H-RIDE-v1.0.0.apk -Algorithm SHA256
```

輸出的雜湊值必須與上方 SHA-256 相符。若不符，請刪除檔案並重新下載。

## 🚀 安裝

1. 在手機上下載 `H-RIDE-v1.0.0.apk`。
2. 開啟它。Android 會詢問是否允許從此來源安裝應用程式——請允許
   （*設定 → 應用程式 → 特殊應用程式存取權 → 安裝未知的應用程式*）。
3. 安裝完成後開啟 H RIDE，並在系統詢問時授予位置權限。
4. 架好手機，按下開始，出發騎乘。

<details>
<summary>改用 ADB 安裝</summary>

```bash
adb install -r H-RIDE-v1.0.0.apk
```
</details>

**支援的 ABI：** `arm64-v8a`、`armeabi-v7a`、`x86`、`x86_64` —— APK 四種全數內含，因此幾乎
所有 Android 手機與平板都能運行。

## 🔐 權限與隱私

H RIDE 只索取自行車碼表真正需要的權限，不多要任何一項：

| 權限 | 需要的原因 |
|---|---|
| `ACCESS_FINE_LOCATION` / `ACCESS_COARSE_LOCATION` | 速度、距離、海拔與地圖全都來自你的 GPS 位置。 |
| `FOREGROUND_SERVICE` / `FOREGROUND_SERVICE_LOCATION` | 在螢幕關閉或你正在使用其他 App 時，透過常駐通知持續記錄騎乘。 |
| `POST_NOTIFICATIONS` | 顯示 Android 對背景位置存取所要求的錄製通知。 |
| `INTERNET` / `ACCESS_NETWORK_STATE` / `ACCESS_WIFI_STATE` | 為地圖檢視取得圖磚。 |
| 動態感測器 | 即時 G 力讀取自裝置的加速度計。 |

**隱私簡述：** 沒有帳號，也沒有 H RIDE 伺服器。你的騎乘統計資料全都在裝置上運算。地圖圖磚
是向公開圖磚供應商（OpenTopoMap、Thunderforest、USGS、OpenStreetMap）請求，這些供應商如同
任何線上地圖一樣會看到你的 IP 位址。APK 另內含標準的 Google Play 服務／Firebase 函式庫；
你可以用 `aapt2 dump badging H-RIDE-v1.0.0.apk`
自行稽核完整權限清單。

## 🧱 技術組成

- 介面採用 **Kotlin** + **Jetpack Compose**
- 地圖採用 **osmdroid** 並搭配地形圖磚圖層
- 以 Android **location APIs** 與 **foreground service** 實現可靠的騎乘錄製
- Target SDK 36 · Min SDK 24

## ❓ 常見問題

<details>
<summary><b>H RIDE 在 Google Play 上架了嗎？</b></summary>

還沒有——目前是以簽章過的 APK 在此發佈。GitHub 上的 Releases 即為官方版本。
</details>

<details>
<summary><b>支援哪些 Android 版本？</b></summary>

Android 7.0 (API 24) 及以上，32 位元與 64 位元裝置皆可。
</details>

<details>
<summary><b>為什麼 Android 會警告我安裝 APK 有風險？</b></summary>

任何非經 Play 商店安裝的應用程式都會觸發這項警告。此 APK 以一致的正式簽署金鑰簽章（憑證
SHA-256
`d3257079398d904ef92b6508e33b0b46b022f43f74237a4e3d4596ce65d681d5`），且檔案的 SHA-256 已
公佈於上方，供你自行驗證。
</details>

<details>
<summary><b>原始碼在哪裡？</b></summary>

本儲存庫目前存放官方版本與相關文件。完整 Android 原始碼的公開已列入[路線圖](#-路線圖)
——歡迎關注本儲存庫以取得通知。
</details>

## 🗺️ 路線圖

- [x] 首次公開發佈（`v1.0.0`）
- [ ] 公開完整 Android 原始碼
- [ ] 騎乘歷史與單趟騎乘統計
- [ ] 匯出騎乘紀錄（GPX）
- [ ] 更多單位、主題與語言

歡迎在 [Issues](https://github.com/fastHU/Core/issues) 提出想法與錯誤回報。

## 🤝 參與貢獻

- 🐞 發現錯誤？請[開一個 issue](https://github.com/fastHU/Core/issues/new)，附上你的手機型號、
  Android 版本以及當時發生的狀況。
- 💡 有好點子？在 issue 中發起討論——功能許願會形塑我們的路線圖。
- 🌍 歡迎翻譯這份 README：複製 `README.md`、翻譯後送出 pull request。
- ⭐ 如果 H RIDE 對你有幫助，給顆星能讓更多車友發現它。

## 📄 授權條款

以 [MIT License](LICENSE) 發佈 © 2026 fastHU。

## 🙏 致謝

- [OpenStreetMap](https://www.openstreetmap.org/) 的貢獻者 —— 地圖資料
- [OpenTopoMap](https://opentopomap.org/)、[Thunderforest](https://www.thunderforest.com/) 與
  [USGS](https://www.usgs.gov/) —— 地形圖磚圖層
- [osmdroid](https://github.com/osmdroid/osmdroid) —— 地圖引擎
- [Jetpack Compose](https://developer.android.com/compose) —— 介面工具組

<div align="center">
  <br>
  <a href="https://star-history.com/#fastHU/Core&Date">
    <img src="https://api.star-history.com/svg?repos=fastHU/Core&type=Date" alt="Star history" width="600">
  </a>
  <br><br>
  <sub>由車友為車友打造。🚵</sub>
</div>

