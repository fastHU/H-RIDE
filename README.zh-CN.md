<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>装进口袋里的 Android 码表。</b><br>
  实时速度 · 实时 G 力 · 平均与最高速度 · 海拔 · 骑行里程
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
  <a href="README.md">English</a> ·
  <b>简体中文</b> ·
  <a href="README.zh-TW.md">繁體中文</a> ·
  <a href="README.ja-JP.md">日本語</a> ·
  <a href="README.ko-KR.md">한국어</a> ·
  <a href="README.es-ES.md">Español</a> ·
  <a href="README.ru-RU.md">Русский</a>
</p>

---

## 👋 H RIDE 是什么？

**H RIDE** 把你的手机变成一台骑行码表。把它装在车把上，按下开始，
它就会记录骑行中真正重要的数据——你骑得有多快、加得多猛、
爬了多少坡——并用干净利落、一眼可读的高对比度界面呈现出来，
让你在骑行途中只需扫一眼就能看清。

无需账号，无需注册，无需订阅。装上 APK，直接上路。

> **关于本仓库** — `H-RIDE` 是 H RIDE 的官方发布仓库，用于托管发行版本、
> 更新日志与文档。已发布的安装包均使用开发者的正式发布密钥签名，
> 因此每次更新都能直接覆盖上一版本，干净利落。

## ✨ 功能特性

| | 功能 | 说明 |
|:--:|---|---|
| ⚡ | **实时速度** | 基于 GPS 持续刷新的实时速度读数，支持 km/h 或 mph。 |
| 🌀 | **实时 G 力** | 由设备运动传感器实时读取加速度负载，刹车、过弯、冲刺有多猛一目了然。 |
| 📊 | **平均速度** | 全程移动平均值，随着骑行实时更新。 |
| 🏁 | **最高速度** | 自动记录全程的速度峰值。 |
| ⛰️ | **海拔** | 当前海拔与累计爬升，还剩多少山要爬心里有数。 |
| 📏 | **距离与时长** | 本次骑行的总里程与用时，始终与记录会话保持同步。 |
| 🗺️ | **地形图** | 可切换地形/地势瓦片图层的实时地图（OpenTopoMap、Thunderforest、USGS）——为越野而做，而不只是城市街道。 |
| 🌙 | **后台记录** | 前台服务让骑行记录在熄屏或切换到其他应用时依然继续。 |
| 🎨 | **基于 Jetpack Compose 打造** | 现代、顺滑的原生 Android 界面。 |

## 📥 下载

前往 [**Releases**](https://github.com/fastHU/H-RIDE/releases/latest) 页面获取最新版 APK。

| 版本 | 文件 | 大小 | 系统要求 | SHA-256 |
|---|---|---|---|---|
| **v1.0.0** | [`H-RIDE-v1.0.0.apk`](https://github.com/fastHU/H-RIDE/releases/latest) | 17.1 MiB | Android 7.0+ (API 24) | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

安装前请先校验下载文件：

```bash
# macOS / Linux
shasum -a 256 H-RIDE-v1.0.0.apk

# Windows (PowerShell)
Get-FileHash .\H-RIDE-v1.0.0.apk -Algorithm SHA256
```

输出的哈希值必须与上方的 SHA-256 完全一致。若不一致，请删除该文件并重新下载。

## 🚀 安装

1. 在手机上打开 `H-RIDE-v1.0.0.apk` 下载安装包。
2. 打开它。Android 会询问是否允许从此来源安装应用——请允许
   （*设置 → 应用 → 特殊权限 → 安装未知应用*）。
3. 安装完成后打开 H RIDE，在弹出提示时授予定位权限。
4. 装好手机，按下开始，出发。

<details>
<summary>改用 ADB 安装</summary>

```bash
adb install -r H-RIDE-v1.0.0.apk
```
</details>

**支持的 ABI：** `arm64-v8a`、`armeabi-v7a`、`x86`、`x86_64`——这个 APK 四种全都包含，
因此几乎在任何 Android 手机和平板上都能运行。

## 🔐 权限与隐私

H RIDE 只申请骑行码表真正需要的权限，一项不多：

| 权限 | 用途 |
|---|---|
| `ACCESS_FINE_LOCATION` / `ACCESS_COARSE_LOCATION` | 速度、距离、海拔与地图都来自你的 GPS 定位。 |
| `FOREGROUND_SERVICE` / `FOREGROUND_SERVICE_LOCATION` | 在熄屏或使用其他应用时继续记录骑行，并显示常驻通知。 |
| `POST_NOTIFICATIONS` | 显示 Android 对后台定位所要求的记录通知。 |
| `INTERNET` / `ACCESS_NETWORK_STATE` / `ACCESS_WIFI_STATE` | 为地图视图获取地图瓦片。 |
| 运动传感器 | 实时 G 力读取自设备的加速度计。 |

**隐私简述：** 没有账号，也没有 H RIDE 服务器。你的骑行数据全部在设备本地计算。
地图瓦片由公共瓦片服务商（OpenTopoMap、Thunderforest、USGS、OpenStreetMap）提供，
和任何在线地图一样，它们会看到你的 IP 地址。APK 同时打包了标准的 Google Play
services / Firebase 库；你也可以用 `aapt2 dump badging H-RIDE-v1.0.0.apk`
自行审查完整的权限列表。

## 🧱 技术栈

- UI 采用 **Kotlin** + **Jetpack Compose**
- 地图使用 **osmdroid** 及地形瓦片图层
- 依靠 Android **定位 API** 与**前台服务**实现可靠的骑行记录
- Target SDK 36 · Min SDK 24

## ❓ 常见问题

<details>
<summary><b>H RIDE 上架 Google Play 了吗？</b></summary>

还没有——目前以签名 APK 的形式在此分发。GitHub 上的 Releases 就是官方版本。
</details>

<details>
<summary><b>支持哪些 Android 版本？</b></summary>

Android 7.0 (API 24) 及以上，32 位与 64 位设备均可。
</details>

<details>
<summary><b>为什么 Android 会提示安装 APK 有风险？</b></summary>

任何在 Play 商店之外安装的应用都会触发该提示。这个 APK 使用固定的发布密钥签名
（证书 SHA-256
`d3257079398d904ef92b6508e33b0b46b022f43f74237a4e3d4596ce65d681d5`），
并且文件的 SHA-256 已在上面公布，方便你自行校验。
</details>

<details>
<summary><b>源代码在哪里？</b></summary>

本仓库目前托管官方发行版本与文档。公开完整的 Android 源码已在[路线图](#-路线图)之中——
关注本仓库即可收到通知。
</details>

## 🗺️ 路线图

- [x] 首次公开发布（`v1.0.0`）
- [ ] 公开完整的 Android 源代码
- [ ] 骑行历史与单次骑行统计
- [ ] 导出骑行记录（GPX）
- [ ] 更多单位、主题与语言

欢迎在 [Issues](https://github.com/fastHU/H-RIDE/issues) 中提出想法和反馈 bug。

## 🤝 参与贡献

- 🐞 发现 bug？请[提交 issue](https://github.com/fastHU/H-RIDE/issues/new)，附上你的手机型号、
  Android 版本以及问题发生的经过。
- 💡 有想法？在 issue 里发起讨论——功能建议会直接影响路线图。
- 🌍 欢迎翻译本 README：复制 `README.md`，翻译后提交 pull request。
- ⭐ 如果 H RIDE 对你有用，点个 star 能帮更多骑友发现它。

## 📄 许可证

基于 [MIT License](LICENSE) 发布 © 2026 fastHU。

## 🙏 致谢

- [OpenStreetMap](https://www.openstreetmap.org/) 贡献者——地图数据
- [OpenTopoMap](https://opentopomap.org/)、[Thunderforest](https://www.thunderforest.com/) 与
  [USGS](https://www.usgs.gov/)——地形瓦片图层
- [osmdroid](https://github.com/osmdroid/osmdroid)——地图引擎
- [Jetpack Compose](https://developer.android.com/compose)——UI 工具包

<div align="center">
  <br>
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <a href="https://star-history.com/#fastHU/H-RIDE&Date">
    <img src="https://api.star-history.com/svg?repos=fastHU/H-RIDE&type=Date" alt="Star history" width="600">
  </a>
  <br><br>
  <sub>骑手打造，献给骑手。🚵</sub>
</div>
