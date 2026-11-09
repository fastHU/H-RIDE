<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>Аэродинамический велокомпьютер нового поколения и трекинг-компаньон для Android.</b><br>
  Плавный Dock в стиле Apple · скорость и перегрузки в реальном времени · двойные спутниковые карты · профиль высоты · калькулятор давления в шинах
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
  <a href="README.ko-KR.md">한국어</a> ·
  <a href="README.es-ES.md">Español</a> ·
  <b>Русский</b>
</p>

---

## 👋 Что такое H RIDE?

**H RIDE** превращает телефон Android в аэродинамический велокомпьютер и инструмент для записи поездок. Закрепите его на руле или выносе, нажмите «Старт» — и получите скорость, перегрузки G, профиль высоты в реальном времени и двухслойные спутниковые карты.

Интерфейс избегает кричащих неоновых цветов и остаётся читаемым под прямым солнцем и ночью. Без обязательных облачных аккаунтов, подписок и отслеживания.

<div align="center">
  <img src="assets/app-preview.png" alt="Интерфейс H RIDE" width="100%">
</div>

> **Примечание для v7.7.0+** — Начиная с **v7.7.0** H RIDE — это **открытый проект Android Studio, который можно собрать**, написанный на чистом Kotlin и Jetpack Compose (`app/`). Декомпилированный код v1.0.0 сохранён в [`decompiled/`](decompiled/) как исторический справочник.

> **Язык интерфейса:** текущая сборка имеет упрощённый китайский интерфейс. Русская локализация запланирована.

---

## ✨ Возможности

| | Функция | Описание |
|:--:|---|---|
| 🍏 | **Плавный Dock в стиле Apple** | Нижняя навигация с пружинной физикой и перетаскиванием. |
| ⚡ | **Спидометр в реальном времени** | Скорость, средняя и максимальная в км/ч с градиентной дугой. |
| 🌀 | **Радар перегрузок G** | Ускорение и нагрузки в поворотах по датчикам устройства. |
| 🛰️ | **Двойные карты** | Векторный OpenStreetMap и ArcGIS World Imagery с офлайн-кешем. |
| ⛰️ | **Профиль высоты** | Кривая высоты, уклон и суммарный набор. |
| 🔧 | **Калькулятор давления** | PSI и bar для переднего и заднего колеса по весу райдера и велосипеда, ширине шины, каркасу и покрытию. |
| 📊 | **История и статистика** | Журнал поездок, набор высоты, средняя и максимальная скорость. |
| 🌙 | **Foreground-сервис** | Запись продолжается при выключенном экране и в фоне. |

---

## 📥 Скачать

| Версия | Файл | Размер | SHA-256 |
|---|---|---|---|
| **v7.7.0** (последняя) | `H_RIDE.apk` | ~15,3 МиБ | `824e2d64cc9b6083339b50d4da7b61443015ba0086a329eacee288c8c9bc70c2` |
| **v1.0.0** (старая) | `H-RIDE-v1.0.0.apk` | ~17,1 МиБ | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

> **Подпись:** APK v7.7.0 подписан стандартным отладочным ключом Android (`CN=Android Debug`) и помечен как `debuggable`. Он предназначен для ручной установки и тестирования, а не для публикации в магазине. APK v1.0.0 подписан исходным ключом выпуска H RIDE.

> **Обновление с v1.0.0:** v7.7.0 использует ID приложения `com.liquidvelo.app`, v1.0.0 — `com.aistudio.summitpath.mtb`. Обе версии можно установить рядом, но данные поездок не переносятся автоматически.

---

## 🚀 Сборка

Требования: Android Studio Hedgehog или новее, JDK 17, compileSdk 34, minSdk 26. В репозитории есть Gradle wrapper (Gradle 8.2).

```bash
git clone https://github.com/fastHU/H-RIDE.git
cd H-RIDE
./gradlew assembleRelease
```

---

## 🔐 Разрешения и конфиденциальность

Приложение запрашивает точное и приблизительное местоположение, foreground-сервис с геолокацией, уведомления, доступ к сети для карт, датчики движения, wake lock, вибрацию и чтение изображений/видео для обложки профиля. Собственных аккаунтов и серверов нет; данные поездок хранятся на устройстве.

---

## 📄 Лицензия

Распространяется по [лицензии MIT](LICENSE) © 2026 fastHU.

---

<div align="center">
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <sub>Сделано райдерами для райдеров. 🚴‍♂️💨</sub>
</div>
