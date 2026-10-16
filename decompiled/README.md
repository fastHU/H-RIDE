# H RIDE — decompiled reference

> ⚠️ **This is NOT the original source code.** It is machine-generated Java produced by
> decompiling the official `H-RIDE-v1.0.0.apk` release. It is published as an architecture
> reference because the original Kotlin project is no longer available. It does **not** compile as-is.

## What is this?

The original H RIDE project was created in **Google AI Studio** and built with Android Studio.
After switching Google accounts the project was lost, and the only surviving artifact was the
released APK. This folder is a best-effort recovery: the app's own classes decompiled back into
readable Java.

It is genuinely useful because the release build kept **all real class, field and method names**
(it was minified but not obfuscated), so the app's architecture — Room database, foreground ride
tracking service, Compose screens, map layer — is fully readable.

## How it was produced

```bash
jadx --no-res --show-bad-code -j 4 -d out H-RIDE-v1.0.0.apk   # app code
jadx --no-src               -d res-out H-RIDE-v1.0.0.apk      # AndroidManifest.xml
```

- Tool: **jadx 1.5.6**
- Input: `H-RIDE-v1.0.0.apk` (SHA-256 `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76`)
- Output: only the app's own packages are included here — **no third-party library code** is
  redistributed.

## What survived, and what did not

| ✅ Preserved | ❌ Lost |
|---|---|
| Real package / class / field / method names (`RideTrackingManager`, `RideRecordDao`, `avgSpeedKmH`, `maxGForce`, …) | Kotlin syntax and idioms — everything is plain Java |
| The app's package structure (`data/db`, `data/service`, `ui/screens`, `ui/map`, `ui/theme`, `util`) | Comments and formatting; Kotlin nullability, default arguments and coroutines are degraded |
| Room entities/DAOs, `StateFlow`-based tracking state, Compose screen structure | Compose UI code is expanded into unreadable builder calls; it cannot be recompiled |
| Kotlin `@Metadata` annotations, which reveal the original `.kt` file each class came from | Resources are not included (only the decoded `AndroidManifest.xml`) |

## Layout

```
AndroidManifest.xml                     decoded manifest (aapt2/jadx, real XML)
sources/com/example/MainActivity.java   entry point
sources/com/example/data/db/            Room database: entities, DAO, repository, track points
sources/com/example/data/service/       foreground ride tracking service + manager
sources/com/example/ui/screens/         Compose screens (home, recording, history, ride detail)
sources/com/example/ui/map/             osmdroid map view, tile sources, map mode switch
sources/com/example/ui/navigation/      navigation models and routing UI
sources/com/example/ui/theme/           theme and glassmorphism components
sources/com/example/util/               location search and helpers
```

## Caveats

- `ui/map/OsmMapViewKt.java` is enormous (~110k lines) because jadx expanded the inlined Compose
  lambdas of one large `@Composable` function. It is the least readable file here.
- Generated members are included (`R.java`, Room `*_Impl.java`) — they are decompiler artifacts,
  not hand-written code.
- 354 of the APK's ~50k classes could not be decompiled cleanly (nearly all of them third-party);
  the app's own classes are present.
- **Do not treat this as maintainable source.** Use it to understand what the app does, then write
  a clean Kotlin implementation.

## License

The code here is H RIDE's own code, licensed [MIT](../LICENSE) © 2026 fastHU — the same license as
the rest of this repository.

---

## 简体中文说明

⚠️ **这不是原始源码**，而是用 **jadx 1.5.6** 从官方发布的 `H-RIDE-v1.0.0.apk` 反编译出来的 Java
代码。原 Kotlin 工程在 Google AI Studio 中创建，后因账号更换而丢失，只剩 APK，所以放这份
"架构参考"。

**为什么它仍然有价值**：发布版只是被压缩（minify）、**没有混淆**，所以真实的类名/字段名/方法名
全部保留——Room 数据库、前台骑行追踪服务、Compose 界面、地图图层都能看懂。

**保留了什么**：真实的包结构与命名、数据库实体与 DAO、`StateFlow` 追踪状态、界面结构、Kotlin
`@Metadata`（能看出每个类原本的 `.kt` 文件名）。
**丢掉了什么**：Kotlin 语法（全部变成 Java）、注释、协程与空安全细节；Compose 代码被展开成难以阅
读的构建器调用；**无法直接编译运行**。

**说明**：这里只放应用自身的代码，**不包含任何第三方库代码**（避免许可证问题）；`OsmMapViewKt.java`
约 11 万行是反编译器展开 Compose lambda 的结果，属正常现象。想真正维护这个 App，请把它当作参考，
用 Kotlin 重写一份干净的实现。
