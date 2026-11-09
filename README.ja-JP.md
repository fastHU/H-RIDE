<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>次世代エアロ・サイクルコンピューター＆Android向けトラッキング・コンパニオン。</b><br>
  Apple級の流動Dock · リアルタイム速度とGフォース · デュアル衛星マップ · 標高プロファイル · タイヤ空気圧計算機
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
  <a href="README.zh-TW.md">繁體中文</a> ·
  <b>日本語</b> ·
  <a href="README.ko-KR.md">한국어</a> ·
  <a href="README.es-ES.md">Español</a> ·
  <a href="README.ru-RU.md">Русский</a>
</p>

---

## 👋 H RIDE とは

**H RIDE** は、Android スマートフォンをエアロ・サイクルコンピューター兼ライド追跡ツールに変えるアプリです。ハンドルバーやステムにマウントして開始するだけで、速度、Gフォース、リアルタイムの標高プロファイル、二層の衛星マップを一目で確認できます。

派手な蛍光色を避けた、直射日光下でも夜間でも読みやすいインターフェースを採用しています。必須のクラウドアカウント、サブスクリプション、プライバシー追跡はありません。

<div align="center">
  <img src="assets/app-preview.png" alt="H RIDE の画面" width="100%">
</div>

> **v7.7.0 以降のお知らせ** — **v7.7.0** から、H RIDE は純粋な Kotlin と Jetpack Compose で書かれた**コンパイル可能なオープンソースの Android Studio プロジェクト**（`app/`）になりました。v1.0.0 の逆コンパイル済みコードは [`decompiled/`](decompiled/) に歴史的参考として保存されています。

> **UI 言語：** 現在のビルドは簡体字中国語のインターフェースです。日本語化はロードマップに含まれています。

---

## ✨ 機能

| | 機能 | 説明 |
|:--:|---|---|
| 🍏 | **Apple級の流動Dock** | バネ物理とドラッグ操作に対応した下部ナビゲーション。 |
| ⚡ | **リアルタイム速度計** | 速度、平均、最高速を km/h で表示するグラデーション弧。 |
| 🌀 | **Gフォース・レーダー** | 端末センサーによる加速とコーナリング荷重の可視化。 |
| 🛰️ | **デュアルマップ** | OpenStreetMap のベクター地形と ArcGIS World Imagery をオフラインキャッシュ付きで切替。 |
| ⛰️ | **ライブ標高プロファイル** | 高度曲線、勾配、累積獲得標高を表示。 |
| 🔧 | **タイヤ空気圧計算機** | ライダー重量、車体重量、タイヤ幅、カーカス、路面状況から前後輪の PSI と bar を算出。 |
| 📊 | **ライド履歴と統計** | ルートログ、獲得標高、平均・最高速度を記録。 |
| 🌙 | **フォアグラウンド・サービス** | 画面オフやバックグラウンドでも記録を継続。 |

---

## 📥 ダウンロード

| バージョン | ファイル | サイズ | SHA-256 |
|---|---|---|---|
| **v7.7.0**（最新） | `H_RIDE.apk` | 約 15.3 MiB | `824e2d64cc9b6083339b50d4da7b61443015ba0086a329eacee288c8c9bc70c2` |
| **v1.0.0**（旧版） | `H-RIDE-v1.0.0.apk` | 約 17.1 MiB | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

> **署名について：** v7.7.0 の APK は Android 標準のデバッグキー（`CN=Android Debug`）で署名され、`debuggable` が有効です。サイドロードとテスト用であり、ストア配布用の本番署名ではありません。v1.0.0 は元の H RIDE リリースキーで署名されています。

> **v1.0.0 からのアップグレード：** v7.7.0 のアプリケーション ID は `com.liquidvelo.app`、v1.0.0 は `com.aistudio.summitpath.mtb` です。両バージョンは共存できますが、ライドデータは自動移行されません。

---

## 🚀 ビルド

必要なもの：Android Studio Hedgehog 以降、JDK 17、compileSdk 34、minSdk 26。リポジトリには Gradle wrapper（Gradle 8.2）が含まれています。

```bash
git clone https://github.com/fastHU/H-RIDE.git
cd H-RIDE
./gradlew assembleRelease
```

---

## 🔐 権限とプライバシー

本アプリは、正確・概算の位置情報、位置情報付きフォアグラウンドサービス、通知、地図取得のためのネットワークアクセス、モーションセンサー、ウェイクロック、振動、プロフィールカバー用の画像・動画読み取り権限を要求します。独自のアカウントやサーバーはなく、ライドデータは端末内に保存されます。

---

## 📄 ライセンス

[MIT License](LICENSE) の下で公開されています © 2026 fastHU。

---

<div align="center">
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <sub>ライダーによって、ライダーのために。🚴‍♂️💨</sub>
</div>
