<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>차세대 에어로 사이클링 컴퓨터 &amp; Android 트래킹 컴패니언.</b><br>
  Apple급 플루이드 Dock · 실시간 속도와 G-force · 듀얼 위성 지도 · 고도 프로필 · 타이어 공기압 계산기
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
  <a href="README.ja-JP.md">日本語</a> ·
  <b>한국어</b> ·
  <a href="README.es-ES.md">Español</a> ·
  <a href="README.ru-RU.md">Русский</a>
</p>

---

## 👋 H RIDE 소개

**H RIDE**는 Android 스마트폰을 에어로 사이클링 컴퓨터이자 라이드 추적 도구로 바꿔 줍니다. 핸들바나 스템에 장착하고 시작 버튼을 누르면 속도, G-force, 실시간 고도 프로필, 2중 위성 지도를 한눈에 확인할 수 있습니다.

눈부신 형광색을 피하고 직사광선 아래나 야간에도 읽기 쉬운 인터페이스를 적용했습니다. 필수 클라우드 계정, 구독, 개인정보 추적이 없습니다.

<div align="center">
  <img src="assets/app-preview.png" alt="H RIDE 화면" width="100%">
</div>

> **v7.7.0+ 안내** — **v7.7.0**부터 H RIDE는 순수 Kotlin과 Jetpack Compose로 작성된 **컴파일 가능한 오픈소스 Android Studio 프로젝트**(`app/`)입니다. v1.0.0의 디컴파일 코드는 [`decompiled/`](decompiled/)에 역사적 참고용으로 보존되어 있습니다.

> **UI 언어:** 현재 빌드는 중국어 간체 인터페이스를 제공합니다. 한국어 현지화는 로드맵에 포함되어 있습니다.

---

## ✨ 기능

| | 기능 | 설명 |
|:--:|---|---|
| 🍏 | **Apple급 플루이드 Dock** | 스프링 물리와 드래그 제스처를 지원하는 하단 내비게이션. |
| ⚡ | **실시간 속도계** | 속도, 평균, 최고 속도를 km/h로 보여 주는 그라데이션 아크. |
| 🌀 | **G-force 레이더** | 기기 센서로 가속과 코너링 하중을 시각화. |
| 🛰️ | **듀얼 맵 엔진** | OpenStreetMap 벡터 지형과 ArcGIS World Imagery를 오프라인 캐시와 함께 전환. |
| ⛰️ | **실시간 고도 프로필** | 고도 곡선, 경사도, 누적 상승 고도를 표시. |
| 🔧 | **타이어 공기압 계산기** | 라이더 체중, 자전거 무게, 타이어 폭, 카커스, 노면 상태로 앞/뒤 PSI와 bar를 계산. |
| 📊 | **라이드 기록과 통계** | 라이드 로그, 누적 상승, 평균/최고 속도를 기록. |
| 🌙 | **포그라운드 서비스** | 화면이 꺼지거나 백그라운드에 있어도 기록을 계속. |

---

## 📥 다운로드

| 버전 | 파일 | 크기 | SHA-256 |
|---|---|---|---|
| **v7.7.0** (최신) | `H_RIDE.apk` | 약 15.3 MiB | `824e2d64cc9b6083339b50d4da7b61443015ba0086a329eacee288c8c9bc70c2` |
| **v1.0.0** (레거시) | `H-RIDE-v1.0.0.apk` | 약 17.1 MiB | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

> **서명 안내:** v7.7.0 APK는 Android 표준 디버그 키(`CN=Android Debug`)로 서명되었고 `debuggable`로 표시됩니다. 사이드로드와 테스트용이며 스토어 배포용 정식 서명이 아닙니다. v1.0.0은 원래 H RIDE 릴리스 키로 서명되었습니다.

> **v1.0.0에서 업그레이드:** v7.7.0은 애플리케이션 ID `com.liquidvelo.app`을 사용하고, v1.0.0은 `com.aistudio.summitpath.mtb`를 사용했습니다. 두 버전은 함께 설치할 수 있지만 라이드 데이터는 자동으로 이전되지 않습니다.

---

## 🚀 빌드

필요 사항: Android Studio Hedgehog 이상, JDK 17, compileSdk 34, minSdk 26. 저장소에 Gradle wrapper(Gradle 8.2)가 포함되어 있습니다.

```bash
git clone https://github.com/fastHU/H-RIDE.git
cd H-RIDE
./gradlew assembleRelease
```

---

## 🔐 권한과 개인정보

앱은 정확/대략 위치, 위치 포그라운드 서비스, 알림, 지도용 네트워크, 모션 센서, wake lock, 진동, 프로필 커버용 이미지/동영상 읽기 권한을 요청합니다. 자체 계정이나 서버는 없으며 라이드 데이터는 기기에 저장됩니다.

---

## 📄 라이선스

[MIT License](LICENSE)에 따라 공개됩니다 © 2026 fastHU.

---

<div align="center">
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <sub>라이더가 라이더를 위해 만들었습니다. 🚴‍♂️💨</sub>
</div>
