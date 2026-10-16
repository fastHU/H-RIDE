# H RIDE — source reference

This folder contains the code of **H RIDE**, recovered from the official `H-RIDE-v1.0.0.apk`
release with [jadx](https://github.com/skylot/jadx). It is the reference implementation published
with this repository.

> **Generated Java, not the original Kotlin.** The release build was minified but not obfuscated, so
> every real class, field and method name survived and the whole architecture is readable — but the
> generated code does not compile as-is. Read it as the map of the app.

## How it was produced

```bash
jadx --no-res --show-bad-code -j 4 -d out H-RIDE-v1.0.0.apk   # application code
jadx --no-src               -d res-out H-RIDE-v1.0.0.apk      # AndroidManifest.xml
```

- Tool: **jadx 1.5.6**
- Input: `H-RIDE-v1.0.0.apk` — SHA-256 `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76`
- Scope: only the app's own packages are included here — **no third-party library code** is
  redistributed.

## What is readable, and what is not

| ✅ Readable | ❌ Not recoverable |
|---|---|
| Real package / class / field / method names (`RideTrackingManager`, `RideRecordDao`, `avgSpeedKmH`, `maxGForce`, …) | Kotlin syntax and idioms — everything is plain Java |
| The app's package structure (`data/db`, `data/service`, `ui/screens`, `ui/map`, `ui/theme`, `util`) | Comments and formatting; Kotlin nullability, default arguments and coroutines are degraded |
| Room entities/DAOs, `StateFlow`-based tracking state, Compose screen structure | Compose UI code is expanded into builder calls and cannot be recompiled |
| Kotlin `@Metadata` annotations, which reveal the original `.kt` file each class came from | Resources — only the decoded `AndroidManifest.xml` is included |

## Layout

```
AndroidManifest.xml                     decoded manifest (real XML)
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
- Generated members are included (`R.java`, Room `*_Impl.java`) — decompiler artifacts, not
  hand-written code.
- 354 of the APK's ~50k classes could not be decompiled cleanly (nearly all of them third-party);
  the app's own classes are all present.
- **Treat this as a reference, not as maintainable source.** Read it to understand what the app
  does, then write a clean Kotlin implementation.

## License

The code here is H RIDE's own code, licensed [MIT](../LICENSE) © 2026 fastHU — the same license as
the rest of this repository.

---

## 简体中文说明

本目录包含 **H RIDE** 的代码，由官方发布的 `H-RIDE-v1.0.0.apk` 经
[jadx](https://github.com/skylot/jadx) 恢复而来，是本仓库随附的参考实现。

⚠️ **这是生成的 Java 代码，不是原始的 Kotlin 源码。** 发布版只做了压缩、没有混淆，所以真实的类名、
字段名与方法名全部保留，整体架构可读——但它不能直接编译。请把它当作这个应用的地图来读。

**生成方式**：`jadx --no-res --show-bad-code`（应用代码）+ `jadx --no-src`（AndroidManifest.xml），
工具版本 jadx 1.5.6。这里**只放应用自身的代码，不包含任何第三方库代码**。

**能读到什么**：真实的包结构与命名、Room 实体与 DAO、`StateFlow` 追踪状态、Compose 界面结构，以及
Kotlin `@Metadata`（可看出每个类原本对应的 `.kt` 文件名）。
**读不到什么**：Kotlin 语法与惯用法（全部变成 Java）、注释与格式；空安全、默认参数与协程细节退化；
Compose 代码被展开成构建器调用，无法还原；不含资源文件（只解码了 `AndroidManifest.xml`）。

**注意**：`ui/map/OsmMapViewKt.java` 约 11 万行，是 jadx 展开内联 Compose lambda 的结果，可读性最差；
`R.java`、Room 的 `*_Impl.java` 属生成物。请把它当参考，理解应用做了什么，然后用 Kotlin 重写一份
干净、可编译的实现。
