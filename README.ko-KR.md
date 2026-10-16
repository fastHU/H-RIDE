<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>안드로이드를 위한 주머니 속 사이클링 컴퓨터.</b><br>
  실시간 속도 · 실시간 G-포스 · 평균 및 최고 속도 · 고도 · 주행 거리
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
  <a href="README.ja-JP.md">日本語</a> ·
  <b>한국어</b> ·
  <a href="README.es-ES.md">Español</a> ·
  <a href="README.ru-RU.md">Русский</a>
</p>

---

## 👋 H RIDE란 무엇인가요?

**H RIDE**는 스마트폰을 사이클링 컴퓨터로 바꿔 줍니다. 핸들바에 장착하고 시작 버튼만 누르면,
라이딩에서 정말 중요한 것들 — 지금 얼마나 빠르게 달리고 있는지, 얼마나 강하게 가속하고 있는지,
얼마나 올라왔는지 — 을 기록하고, 주행 중에도 단 1초 만에 읽어낼 수 있는 깔끔하고 시원한
고대비 인터페이스로 보여 줍니다.

계정도, 회원가입도, 구독도 필요 없습니다. APK를 설치하고 바로 달리면 됩니다.

> **이 저장소에 대하여** — `Core`는 H RIDE의 공식 배포 저장소입니다. 릴리스 빌드와 릴리스 노트,
> 문서를 이곳에서 제공합니다. 게시되는 빌드는 개발자의 릴리스 키로 서명되므로, 모든 업데이트가
> 이전 버전 위에 깔끔하게 설치됩니다.

## ✨ 주요 기능

| | 기능 | 설명 |
|:--:|---|---|
| ⚡ | **실시간 속도** | GPS에서 끊임없이 갱신되는 실시간 속도를 km/h 또는 mph로 보여 줍니다. |
| 🌀 | **실시간 G-포스** | 기기의 모션 센서로 측정한 실시간 가속 부하로, 브레이크와 코너링, 스프린트가 얼마나 강한지 한눈에 확인할 수 있습니다. |
| 📊 | **평균 속도** | 라이딩 전체의 이동 평균으로, 달리는 동안 계속 갱신됩니다. |
| 🏁 | **최고 속도** | 라이딩 중 가장 빨랐던 순간을 자동으로 기록합니다. |
| ⛰️ | **고도** | 현재 고도와 누적 상승량을 보여 주어, 앞에 남은 산이 얼마나 되는지 항상 알 수 있습니다. |
| 📏 | **거리 및 시간** | 총 주행 거리와 경과 시간을 기록 세션과 동기화해 유지합니다. |
| 🗺️ | **지형 지도** | 지형/지세 타일 레이어(OpenTopoMap, Thunderforest, USGS)를 갖춘 실시간 지도 뷰 — 도심 도로가 아니라 트레일을 위해 만들었습니다. |
| 🌙 | **백그라운드 기록** | 화면이 꺼져 있거나 다른 앱으로 전환해도 포그라운드 서비스가 라이딩 기록을 이어 갑니다. |
| 🎨 | **Jetpack Compose로 제작** | 현대적이고 부드러운 네이티브 Android UI. |

## 📥 다운로드

최신 APK는 [**릴리스**](https://github.com/fastHU/Core/releases/latest) 페이지에서 받으세요.

| 버전 | 파일 | 크기 | 요구 사항 | SHA-256 |
|---|---|---|---|---|
| **v1.0.0** | [`H-RIDE-v1.0.0.apk`](https://github.com/fastHU/Core/releases/latest) | 17.1 MiB | Android 7.0+ (API 24) | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

설치하기 전에 다운로드한 파일을 검증하세요:

```bash
# macOS / Linux
shasum -a 256 H-RIDE-v1.0.0.apk

# Windows (PowerShell)
Get-FileHash .\H-RIDE-v1.0.0.apk -Algorithm SHA256
```

출력된 해시가 위의 SHA-256과 일치해야 합니다. 일치하지 않으면 파일을 삭제하고 다시 다운로드하세요.

## 🚀 설치

1. 스마트폰에서 `H-RIDE-v1.0.0.apk`를 다운로드합니다.
2. 파일을 열면 Android가 이 출처의 앱 설치를 허용할지 물어봅니다 — 허용해 주세요
   (*설정 → 앱 → 특수 권한 → 알 수 없는 앱 설치*).
3. 설치한 뒤 H RIDE를 열고, 위치 권한을 요청하면 허용해 주세요.
4. 스마트폰을 장착하고 시작 버튼을 누른 다음, 달리세요.

<details>
<summary>ADB로 설치하기</summary>

```bash
adb install -r H-RIDE-v1.0.0.apk
```
</details>

**지원 ABI:** `arm64-v8a`, `armeabi-v7a`, `x86`, `x86_64` — APK에 네 가지가 모두 들어 있어,
사실상 모든 Android 스마트폰과 태블릿에서 실행됩니다.

## 🔐 권한 및 개인정보

H RIDE는 사이클링 컴퓨터에 꼭 필요한 것만 요청하며, 그 이상은 요청하지 않습니다:

| 권한 | 필요한 이유 |
|---|---|
| `ACCESS_FINE_LOCATION` / `ACCESS_COARSE_LOCATION` | 속도, 거리, 고도, 지도는 모두 GPS 위치를 바탕으로 계산됩니다. |
| `FOREGROUND_SERVICE` / `FOREGROUND_SERVICE_LOCATION` | 화면이 꺼져 있거나 다른 앱을 쓰는 동안에도 상시 알림과 함께 라이딩 기록을 유지합니다. |
| `POST_NOTIFICATIONS` | 백그라운드 위치 사용 시 Android가 요구하는 기록 알림을 표시합니다. |
| `INTERNET` / `ACCESS_NETWORK_STATE` / `ACCESS_WIFI_STATE` | 지도 뷰에 표시할 지도 타일을 내려받습니다. |
| 모션 센서 | 실시간 G-포스는 기기의 가속도계에서 읽어 옵니다. |

**개인정보 요약:** 계정도, H RIDE 서버도 없습니다. 라이딩 통계는 기기에서 계산됩니다. 지도
타일은 공개 타일 제공자(OpenTopoMap, Thunderforest, USGS, OpenStreetMap)에 요청되며, 이들은 여느
온라인 지도와 마찬가지로 여러분의 IP 주소를 확인할 수 있습니다. APK에는 표준 Google Play
서비스 / Firebase 라이브러리도 포함되어 있는데, `aapt2 dump badging H-RIDE-v1.0.0.apk` 명령으로
전체 권한 목록을 직접 확인할 수 있습니다.

## 🧱 사용 기술

- UI에는 **Kotlin** + **Jetpack Compose**
- 지도에는 지형 타일 레이어를 갖춘 **osmdroid**
- 안정적인 라이딩 기록을 위한 Android **위치 API**와 **포그라운드 서비스**
- Target SDK 36 · Min SDK 24

## ❓ 자주 묻는 질문

<details>
<summary><b>H RIDE는 Google Play에 있나요?</b></summary>

아직 없습니다 — 이곳에서 서명된 APK로 배포됩니다. GitHub의 릴리스가 공식 빌드입니다.
</details>

<details>
<summary><b>어떤 Android 버전을 지원하나요?</b></summary>

Android 7.0 (API 24) 이상이며, 32비트와 64비트 기기 모두에서 동작합니다.
</details>

<details>
<summary><b>APK를 설치할 때 Android가 왜 경고하나요?</b></summary>

Play 스토어 밖에서 설치하는 모든 앱에 이 경고가 표시됩니다. 이 APK는 일관된 릴리스 키(인증서
SHA-256
`d3257079398d904ef92b6508e33b0b46b022f43f74237a4e3d4596ce65d681d5`)로 서명되어 있고, 파일의
SHA-256도 위에 공개되어 있으니 직접 검증할 수 있습니다.
</details>

<details>
<summary><b>소스 코드는 어디에 있나요?</b></summary>

이 저장소는 현재 공식 빌드와 문서를 제공합니다. 전체 Android 소스 공개는
[로드맵](#-로드맵)에 있습니다 — 저장소를 워치해 두면 알림을 받을 수 있습니다.
</details>

## 🗺️ 로드맵

- [x] 첫 공개 릴리스 (`v1.0.0`)
- [ ] 전체 Android 소스 코드 공개
- [ ] 라이딩 기록과 라이딩별 통계
- [ ] 라이딩 내보내기 (GPX)
- [ ] 더 많은 단위, 테마, 언어

아이디어와 버그 제보는 [이슈](https://github.com/fastHU/Core/issues)에서 언제나 환영합니다.

## 🤝 기여하기

- 🐞 버그를 발견하셨나요? 스마트폰 모델과 Android 버전, 발생한 상황을 적어
  [이슈를 열어 주세요](https://github.com/fastHU/Core/issues/new).
- 💡 아이디어가 있으신가요? 이슈에서 논의를 시작해 주세요 — 기능 요청이 로드맵을 만들어 갑니다.
- 🌍 이 README의 번역도 환영합니다: `README.md`를 복사해 번역한 뒤 풀 리퀘스트를 열어 주세요.
- ⭐ H RIDE가 도움이 되었다면, 스타 하나가 다른 라이더들이 이 앱을 찾도록 도와줍니다.

## 📄 라이선스

[MIT License](LICENSE) © 2026 fastHU에 따라 배포됩니다.

## 🙏 감사의 말

- [OpenStreetMap](https://www.openstreetmap.org/) 기여자분들 — 지도 데이터
- [OpenTopoMap](https://opentopomap.org/), [Thunderforest](https://www.thunderforest.com/),
  [USGS](https://www.usgs.gov/) — 지형 타일 레이어
- [osmdroid](https://github.com/osmdroid/osmdroid) — 지도 엔진
- [Jetpack Compose](https://developer.android.com/compose) — UI 툴킷

<div align="center">
  <br>
  <a href="https://star-history.com/#fastHU/Core&Date">
    <img src="https://api.star-history.com/svg?repos=fastHU/Core&type=Date" alt="Star history" width="600">
  </a>
  <br><br>
  <sub>라이더가 라이더를 위해 만들었습니다. 🚵</sub>
</div>
