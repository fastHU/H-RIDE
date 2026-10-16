<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>Android のための、ポケットサイズのサイクルコンピューター。</b><br>
  リアルタイム速度 · リアルタイム G フォース · 平均＆最高速度 · 標高 · 走行距離
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
  <a href="README.zh-TW.md">繁體中文</a> ·
  <b>日本語</b> ·
  <a href="README.ko-KR.md">한국어</a> ·
  <a href="README.es-ES.md">Español</a> ·
  <a href="README.ru-RU.md">Русский</a>
</p>

---

## 👋 H RIDE とは？

**H RIDE** は、あなたのスマートフォンをサイクルコンピューターに変えます。ハンドルバーに取り付けてスタートを押せば、
ライドで本当に大切なもの — どれくらいの速さで走っているか、どれくらい強く加速しているか、
どれだけ登ったか — を記録し、走りながらでも一秒で読み取れる、クリーンで視認性の高い
ハイコントラストなインターフェースで表示します。

アカウントは不要。サインアップも不要。サブスクリプションもありません。APK をインストールして、走るだけです。

> **このリポジトリについて** — `Core` は H RIDE の公式配布リポジトリです。リリースビルド、リリースノート、
> ドキュメントを公開しています。公開されるビルドは開発者のリリースキーで署名されているため、
> すべてのアップデートが以前のバージョンの上にクリーンにインストールされます。

## ✨ 機能

| | 機能 | 説明 |
|:--:|---|---|
| ⚡ | **リアルタイム速度** | GPS から継続的に更新されるライブ速度表示。km/h または mph で表示します。 |
| 🌀 | **リアルタイム G フォース** | 端末のモーションセンサーがとらえるライブの加速度負荷。ブレーキ、コーナリング、スプリントの強さがひと目でわかります。 |
| 📊 | **平均速度** | ライド全体の移動平均を、走りながら随時更新します。 |
| 🏁 | **最高速度** | ライド中の最速ポイントを自動で記録します。 |
| ⛰️ | **標高** | 現在の標高と獲得標高を表示するので、山がどれだけ残っているかが常にわかります。 |
| 📏 | **距離＆時間** | 総走行距離と経過時間を、記録セッションと同期して表示します。 |
| 🗺️ | **地形図** | 地形・テレインタイルレイヤー（OpenTopoMap、Thunderforest、USGS）を備えたライブマップ表示 — 市街地だけでなく、トレイルのために作られています。 |
| 🌙 | **バックグラウンド記録** | フォアグラウンドサービスにより、画面オフやアプリ切り替え中でもライドを記録し続けます。 |
| 🎨 | **Jetpack Compose で構築** | モダンで滑らかなネイティブ Android UI。 |

## 📥 ダウンロード

最新の APK は [**Releases**](https://github.com/fastHU/Core/releases/latest) ページから入手してください。

| バージョン | ファイル | サイズ | 必要条件 | SHA-256 |
|---|---|---|---|---|
| **v1.0.0** | [`H-RIDE-v1.0.0.apk`](https://github.com/fastHU/Core/releases/latest) | 17.1 MiB | Android 7.0+ (API 24) | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

インストール前にダウンロードしたファイルを検証してください：

```bash
# macOS / Linux
shasum -a 256 H-RIDE-v1.0.0.apk

# Windows (PowerShell)
Get-FileHash .\H-RIDE-v1.0.0.apk -Algorithm SHA256
```

表示されたハッシュが上記の SHA-256 と一致していなければなりません。一致しない場合は、ファイルを削除してもう一度ダウンロードしてください。

## 🚀 インストール

1. スマートフォンで `H-RIDE-v1.0.0.apk` をダウンロードします。
2. ファイルを開きます。この提供元からのアプリのインストールを許可するよう Android が求めてきますので、許可してください
   (*設定 → アプリ → 特別なアクセス → 不明なアプリのインストール*)。
3. インストールして H RIDE を開き、求められたら位置情報の権限を許可します。
4. スマートフォンを取り付けて、スタートを押して、走りましょう。

<details>
<summary>代わりに ADB でインストールする</summary>

```bash
adb install -r H-RIDE-v1.0.0.apk
```
</details>

**対応 ABI：** `arm64-v8a`、`armeabi-v7a`、`x86`、`x86_64` — APK にはこの 4 つがすべて含まれているため、
事実上すべての Android スマートフォンとタブレットで動作します。

## 🔐 権限とプライバシー

H RIDE が求めるのは、サイクルコンピューターに必要なものだけで、それ以上はありません：

| 権限 | 必要な理由 |
|---|---|
| `ACCESS_FINE_LOCATION` / `ACCESS_COARSE_LOCATION` | 速度、距離、標高、地図はすべて GPS の位置情報から算出されます。 |
| `FOREGROUND_SERVICE` / `FOREGROUND_SERVICE_LOCATION` | 画面がオフのときや他のアプリを使っているときでも、常駐通知とともにライドの記録を続けます。 |
| `POST_NOTIFICATIONS` | バックグラウンドでの位置情報利用のために Android が要求する、記録中の通知を表示します。 |
| `INTERNET` / `ACCESS_NETWORK_STATE` / `ACCESS_WIFI_STATE` | マップ表示用の地図タイルを取得します。 |
| モーションセンサー | リアルタイム G フォースは端末の加速度センサーから読み取ります。 |

**プライバシーをひと言で：** アカウントも H RIDE のサーバーもありません。ライドの統計はすべて
端末上で計算されます。地図タイルは公開タイルプロバイダー（OpenTopoMap、Thunderforest、
USGS、OpenStreetMap）から取得するため、これらのサービスには他のオンライン地図と同様にあなたの IP アドレスが見えます。APK には
標準的な Google Play 開発者サービス / Firebase ライブラリも同梱されています。権限の全リストは `aapt2 dump badging H-RIDE-v1.0.0.apk`
でご自身で監査できます。

## 🧱 使用技術

- UI には **Kotlin** + **Jetpack Compose**
- 地図には地形タイルレイヤー対応の **osmdroid**
- 信頼性の高いライド記録のための Android **位置情報 API** と**フォアグラウンドサービス**
- Target SDK 36 · Min SDK 24

## ❓ よくある質問

<details>
<summary><b>H RIDE は Google Play にありますか？</b></summary>

まだありません — ここで署名済み APK として配布しています。GitHub でのリリースが公式ビルドです。
</details>

<details>
<summary><b>対応している Android のバージョンは？</b></summary>

Android 7.0 (API 24) 以降で、32 ビット端末と 64 ビット端末の両方に対応しています。
</details>

<details>
<summary><b>APK のインストール時に Android が警告を出すのはなぜですか？</b></summary>

Play ストア以外からインストールするすべてのアプリで、この警告が表示されます。この APK は
一貫したリリースキー（証明書 SHA-256
`d3257079398d904ef92b6508e33b0b46b022f43f74237a4e3d4596ce65d681d5`）で署名されており、ファイルの SHA-256 は
上記で公開しているので、ご自身で検証できます。
</details>

<details>
<summary><b>ソースコードはどこにありますか？</b></summary>

このリポジトリでは現在、公式ビルドとドキュメントを公開しています。Android の完全な
ソースコードの公開は[ロードマップ](#-ロードマップ)に含まれています — リポジトリをウォッチして通知を受け取ってください。
</details>

## 🗺️ ロードマップ

- [x] 初回公開リリース（`v1.0.0`）
- [ ] Android の完全なソースコードを公開
- [ ] ライド履歴とライドごとの統計
- [ ] ライドのエクスポート（GPX）
- [ ] 単位、テーマ、言語の追加

アイデアやバグ報告は [Issues](https://github.com/fastHU/Core/issues) でお待ちしています。

## 🤝 コントリビューション

- 🐞 バグを見つけましたか？ お使いの端末モデル、Android のバージョン、発生した内容を添えて
  [Issue を作成](https://github.com/fastHU/Core/issues/new)してください。
- 💡 アイデアがありますか？ Issue でディスカッションを始めましょう — 機能リクエストがロードマップを形作ります。
- 🌍 この README の翻訳を歓迎します：`README.md` をコピーして翻訳し、プルリクエストをお送りください。
- ⭐ H RIDE がお役に立つなら、スターが他のライダーの目に留まる助けになります。

## 📄 ライセンス

[MIT License](LICENSE) のもとで公開されています © 2026 fastHU.

## 🙏 謝辞

- [OpenStreetMap](https://www.openstreetmap.org/) のコントリビューター — 地図データ
- [OpenTopoMap](https://opentopomap.org/)、[Thunderforest](https://www.thunderforest.com/)、
  [USGS](https://www.usgs.gov/) — 地形タイルレイヤー
- [osmdroid](https://github.com/osmdroid/osmdroid) — 地図エンジン
- [Jetpack Compose](https://developer.android.com/compose) — UI ツールキット

<div align="center">
  <br>
  <a href="https://star-history.com/#fastHU/Core&Date">
    <img src="https://api.star-history.com/svg?repos=fastHU/Core&type=Date" alt="Star history" width="600">
  </a>
  <br><br>
  <sub>ライダーのために、ライダーが作りました。🚵</sub>
</div>
