<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>装进口袋里的新一代智能流体骑行码表与运动伴侣。</b><br>
  苹果级流体 Dock · 实时速度与 G 力 · 双模高清卫星地图 · 海拔剖面图 · 科学胎压计算器
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
  <b>简体中文</b> ·
  <a href="README.zh-TW.md">繁體中文</a> ·
  <a href="README.ja-JP.md">日本語</a> ·
  <a href="README.ko-KR.md">한국어</a> ·
  <a href="README.es-ES.md">Español</a> ·
  <a href="README.ru-RU.md">Русский</a>
</p>

---

## 👋 H RIDE 是什么？

**H RIDE** 是一款专为公路骑行、碎石越野与日常通勤打造的 Android 原生新一代智能骑行码表。把它固定在车把或把立上，轻触开始，就能以极具科技感与克制美学的高对比度界面，毫秒级呈现真正核心的骑行遥测数据——实时车速、过弯加速度负载、路段海拔升降波形、双模卫星实景以及科学胎压参考。

告别花哨杂乱、充满廉价荧光 AI 颜色的界面。H RIDE 采用经过烈日直射考验的高对比度抗反光调色系统，无论是正午高山公路下坡还是深夜刷街，都能一眼看清关键读数。

无需账号，无需注册，无需订阅。装上 APK，即刻启程。

<div align="center">
  <img src="assets/app-preview.png" alt="H RIDE 界面效果" width="100%" style="border-radius: 12px; margin: 16px 0;">
</div>

> **v7.7.0+ 版本重要说明** — 从 **v7.7.0** 版本开始，H RIDE 已全量升级为**原生可编译的纯 Kotlin + Jetpack Compose 源码工程**（位于 `app/` 根目录）。历史版本从 APK 反编译的代码已归档至 [`decompiled/`](decompiled/) 供参考。

> **界面语言：** 当前安装包为简体中文界面，英文界面已在计划中。

---

## ✨ 核心功能与亮点

| | 功能 | 说明 |
|:--:|---|---|
| 🍏 | **苹果级流体 Dock 栏** | 智能形态切换导航栏，主图模式下收缩为精巧圆角药丸且四周等距对称；支持手指全局平滑拖拽跟手与弹性回弹。 |
| ⚡ | **流体瞬时速度计** | 毫秒级 GPS 速度刷新，动效渐变圆弧，同时记录全程均速与最高极速（km/h）。 |
| 🌀 | **实时 G 力雷达** | 硬件加速度传感器精准捕获过弯离心力、强力制动与冲刺爆发负荷。 |
| 🛰️ | **双模地图引擎** | 一键平滑切换 OpenStreetMap 矢量地貌与 ArcGIS 高清卫星实景航拍，支持断网离线瓦片缓存。 |
| 🧭 | **动态航向光标** | 集成物理航向三角箭头、速度呼吸脉冲波与 GPS 定位精度光晕。 |
| ⛰️ | **实时海拔剖面图** | 动态绘制骑行海拔曲线，实时显示坡度百分比与累计爬升/下降米数。 |
| 🔧 | **科学胎压计算器** | 综合骑手体重、整车重量、轮胎宽度（25c - 45c）、胎体类型及地形/路况，智能推导前后轮最佳 PSI 与 Bar 气压。 |
| 🎨 | **抗反光调色板与 HEX 取色器** | 预置深空暗黑、曜石碳黑、赛车绿、高山白等经典色板，支持直接输入 6 位十六进制色值或 RGB 滑块精细微调。 |
| 🖼️ | **个性化封面自由裁剪** | 内置双指手势缩放和平移裁切画板，随心定制个人背景；提供 3 秒长按重置防护。 |
| 📊 | **骑行历史与数据复盘** | 完整保存历次骑行活动日志、总爬升、平均与极速数据。 |
| 🌙 | **前台常驻低功耗守护** | 采用系统级前台服务 (`CyclingTrackingService`)，锁屏及后台切出不掉线、防系统误杀。 |

---

## 📂 源代码与工程结构

本项目采用现代 Android 架构规范，全部源码可直接在 Android Studio 中打开并一键编译：

```
H-RIDE/
├── app/
│   ├── build.gradle.kts                   # 模块依赖与 Android 14 (API 34) 配置
│   ├── proguard-rules.pro                 # 混淆与优化规则
│   └── src/main/
│       ├── AndroidManifest.xml            # 前台服务与精确定位权限清单
│       ├── java/com/liquidvelo/app/
│       │   ├── MainActivity.kt            # 应用入口与全局 Compose 导航控制
│       │   ├── data/                      # GPS 传感器驱动与数据仓库
│       │   │   ├── LocationTrackingHelper.kt
│       │   │   ├── RideRepository.kt
│       │   │   └── SensorManagerHelper.kt
│       │   ├── model/                     # 骑行数据与胎压计算模型
│       │   ├── service/                   # 前台常驻骑行记录服务
│       │   │   └── CyclingTrackingService.kt
│       │   ├── theme/                     # 极简色彩引擎、玻璃拟态与排版
│       │   └── ui/
│       │       ├── components/            # 高阶交互组件（AppleDockBar, SpeedometerDial, ElevationChart 等）
│       │       └── screens/               # MapScreen, RideActiveScreen, HistoryScreen, ToolsScreen, ProfileScreen
│       └── res/                           # 矢量图标、主题配置与字符串资源
├── assets/                                # 宣传横幅、预览图与品牌素材
├── decompiled/                            # 历史 v1.0.0 反编译参考归档
├── build.gradle.kts                       # 根构建脚本
├── settings.gradle.kts                    # Gradle 项目配置
├── gradlew / gradlew.bat                  # Gradle Wrapper 启动脚本
├── gradle/wrapper/                        # Wrapper JAR 与发行版配置
└── README.zh-CN.md
```

---

## 📥 安装包下载与校验

安装包可在 [GitHub Releases 页面](https://github.com/fastHU/H-RIDE/releases) 下载。

| 版本 | 文件名 | 体积 | SHA-256 校验码 |
|---|---|---|---|
| **v7.7.0** (最新版) | `H_RIDE.apk` | ~15.3 MiB | `824e2d64cc9b6083339b50d4da7b61443015ba0086a329eacee288c8c9bc70c2` |
| **v1.0.0** (历史版) | `H-RIDE-v1.0.0.apk` | ~17.1 MiB | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

> **签名说明：** v7.7.0 安装包使用 Android 标准调试密钥签名（`CN=Android Debug`），并标记为 `debuggable`。它适用于侧载与测试，不是应用商店的生产签名包。v1.0.0 使用原 H RIDE 发布密钥签名（证书 SHA-256 `d3257079398d904ef92b6508e33b0b46b022f43f74237a4e3d4596ce65d681d5`）。

> **从 v1.0.0 升级：** v7.7.0 使用应用 ID `com.liquidvelo.app`，v1.0.0 使用 `com.aistudio.summitpath.mtb`。两个版本可以并存安装，但骑行数据不会自动迁移。

### 校验文件哈希
```bash
# macOS / Linux
shasum -a 256 H_RIDE.apk

# Windows PowerShell
Get-FileHash H_RIDE.apk -Algorithm SHA256
```

---

## 🚀 编译与运行

### 开发环境
- **Android Studio**：Hedgehog (2023.1.1) 或更高版本
- **JDK**：Java 17
- **Target SDK**：API 34 · **Min SDK**：API 26 (Android 8.0+)

### 从源码编译 Release 安装包

仓库已包含 Gradle Wrapper（Gradle 8.2），首次运行会自动下载对应发行版。

```bash
git clone https://github.com/fastHU/H-RIDE.git
cd H-RIDE

# 编译 Release APK
./gradlew assembleRelease
```

### 通过 ADB 安装
```bash
adb install -r H_RIDE.apk
```

---

## 🔐 权限与隐私说明

| 权限 | 用途说明 |
|---|---|
| `ACCESS_FINE_LOCATION` / `ACCESS_COARSE_LOCATION` | 获取毫秒级 GPS 瞬时车速、骑行总里程、海拔与航向角。 |
| `FOREGROUND_SERVICE` / `FOREGROUND_SERVICE_LOCATION` | 确保锁屏或切换应用时持续稳定记录骑行轨迹，并在通知栏展示数据。 |
| `POST_NOTIFICATIONS` | 遵循 Android 系统要求显示前台长驻通知。 |
| `INTERNET` / `ACCESS_NETWORK_STATE` | 下载 OpenStreetMap 与 ArcGIS 高清卫星地图瓦片。 |
| 运动传感器 (Accelerometer) | 读取骑行加减速及过弯 G 力过载。 |
| `HIGH_SAMPLING_RATE_SENSORS` | 以高采样率读取运动传感器，驱动实时 G 力雷达。 |
| `WAKE_LOCK` | 长时间记录骑行时保持 CPU 唤醒。 |
| `VIBRATE` | 控件与提醒的触感反馈。 |
| `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` | 申请忽略激进的后台省电策略，避免长距离骑行被系统中断。 |
| `READ_MEDIA_IMAGES` / `READ_MEDIA_VIDEO` | 选择并裁剪个人资料封面（Android 13+）。 |

---

## 🗺️ 发展路线图 (Roadmap)

- [x] 首次公开发布 (`v1.0.0`)
- [x] 基于纯 Kotlin + Jetpack Compose 全量重构并开源原生工程 (`v7.7.0`)
- [x] 苹果级流体 Dock 栏与手势跟手阻尼拖动
- [x] ArcGIS 卫星影像与 OSM 矢量双模地图
- [x] 实时海拔升降图与动态坡度显示
- [x] 骑行历史日志与数据统计
- [x] 专业级胎压科学计算器
- [x] 户外抗反光色系与自定义 HEX/RGB 色盘
- [ ] 英文界面本地化
- [ ] 可复现的发布签名构建 / CI
- [ ] 导出骑行轨迹为标准 GPX 文件
- [ ] 蓝牙低功耗 (BLE) 踏频与心率带传感器直连

---

## 📄 开源许可证

本项目基于 [MIT License](LICENSE) 协议开源 © 2026 fastHU。

---

<div align="center">
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <sub>骑手打造，献给骑手。🚴‍♂️💨</sub>
</div>
