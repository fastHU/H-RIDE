<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>Карманный велокомпьютер на Android.</b><br>
  Скорость в реальном времени · перегрузки в реальном времени · средняя и максимальная скорость · высота · дистанция поездки
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
  <a href="README.zh-CN.md">简体中文</a> ·
  <a href="README.zh-TW.md">繁體中文</a> ·
  <a href="README.ja-JP.md">日本語</a> ·
  <a href="README.ko-KR.md">한국어</a> ·
  <a href="README.es-ES.md">Español</a> ·
  <b>Русский</b>
</p>

---

## 👋 Что такое H RIDE?

**H RIDE** превращает ваш телефон в велокомпьютер. Закрепите его на руле, нажмите «старт» — и он
запишет всё, что действительно важно в поездке: как быстро вы едете, как резко ускоряетесь,
сколько высоты уже набрали — и покажет это в чистом, читаемом с одного взгляда интерфейсе с высоким
контрастом, который можно понять за секунду прямо на ходу.

Без аккаунта. Без регистрации. Без подписки. Просто установите APK и катайтесь.

> **Об этом репозитории** — `H-RIDE` — официальный репозиторий распространения H RIDE. Здесь лежат
> релизные сборки, примечания к выпускам и документация. Опубликованные сборки подписаны релизным
> ключом разработчика, поэтому каждое обновление ставится поверх предыдущего без проблем.

## ✨ Возможности

| | Возможность | Описание |
|:--:|---|---|
| ⚡ | **Скорость в реальном времени** | Текущая скорость, непрерывно обновляемая по GPS, в км/ч или милях/ч. |
| 🌀 | **Перегрузки в реальном времени** | Живая нагрузка ускорения с датчиков движения телефона — видно, как резко вы тормозите, входите в поворот и спринтуете. |
| 📊 | **Средняя скорость** | Средняя скорость за всю поездку, обновляется прямо по ходу. |
| 🏁 | **Максимальная скорость** | Самый быстрый момент поездки, фиксируется автоматически. |
| ⛰️ | **Высота** | Текущая высота и набор высоты — вы всегда знаете, сколько горы ещё осталось. |
| 📏 | **Дистанция и время** | Общая дистанция поездки и время в пути, синхронизированы с сессией записи. |
| 🗺️ | **Топографическая карта** | Живая карта с топографическими и рельефными слоями (OpenTopoMap, Thunderforest, USGS) — создана для трейлов, а не только для городских улиц. |
| 🌙 | **Запись в фоне** | Foreground-сервис продолжает запись поездки, когда экран выключен или вы переключились в другое приложение. |
| 🎨 | **Сделано на Jetpack Compose** | Современный, плавный, нативный интерфейс Android. |

## 📥 Загрузка

Возьмите последний APK со страницы [**Releases**](https://github.com/fastHU/H-RIDE/releases/latest).

| Версия | Файл | Размер | Требуется | SHA-256 |
|---|---|---|---|---|
| **v1.0.0** | [`H-RIDE-v1.0.0.apk`](https://github.com/fastHU/H-RIDE/releases/latest) | 17,1 МиБ | Android 7.0+ (API 24) | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

Проверьте загрузку перед установкой:

```bash
# macOS / Linux
shasum -a 256 H-RIDE-v1.0.0.apk

# Windows (PowerShell)
Get-FileHash .\H-RIDE-v1.0.0.apk -Algorithm SHA256
```

Напечатанный хеш должен совпадать с SHA-256 выше. Если он не совпадает, удалите файл и скачайте его заново.

## 🚀 Установка

1. Скачайте `H-RIDE-v1.0.0.apk` на телефон.
2. Откройте его. Android попросит разрешить установку приложений из этого источника — разрешите
   (*Настройки → Приложения → Особый доступ → Установка неизвестных приложений*).
3. Установите, откройте H RIDE и дайте разрешение на геолокацию, когда оно запросится.
4. Закрепите телефон, нажмите «старт» — и в путь.

<details>
<summary>Установка через ADB</summary>

```bash
adb install -r H-RIDE-v1.0.0.apk
```
</details>

**Поддерживаемые ABI:** `arm64-v8a`, `armeabi-v7a`, `x86`, `x86_64` — в APK есть все четыре, поэтому она
работает практически на любом телефоне и планшете с Android.

## 🔐 Разрешения и конфиденциальность

H RIDE запрашивает ровно то, что нужно велокомпьютеру, и ничего лишнего:

| Разрешение | Зачем оно нужно |
|---|---|
| `ACCESS_FINE_LOCATION` / `ACCESS_COARSE_LOCATION` | Скорость, дистанция, высота и карта — всё строится на вашей GPS-позиции. |
| `FOREGROUND_SERVICE` / `FOREGROUND_SERVICE_LOCATION` | Продолжает запись поездки, когда экран выключен или вы пользуетесь другим приложением, с постоянным уведомлением. |
| `POST_NOTIFICATIONS` | Показывает уведомление о записи, которого Android требует для фонового определения местоположения. |
| `INTERNET` / `ACCESS_NETWORK_STATE` / `ACCESS_WIFI_STATE` | Загружает тайлы карты для картографического вида. |
| Датчики движения | Перегрузки в реальном времени считываются с акселерометра устройства. |

**Коротко о конфиденциальности:** аккаунта нет, сервера H RIDE тоже нет. Ваша статистика поездки
считается на самом устройстве. Тайлы карты запрашиваются у публичных поставщиков (OpenTopoMap,
Thunderforest, USGS, OpenStreetMap): они видят ваш IP-адрес так же, как любая онлайн-карта. В APK также
встроены стандартные библиотеки Google Play services / Firebase; полный список разрешений можно
проверить самостоятельно командой `aapt2 dump badging H-RIDE-v1.0.0.apk`.

## 🧱 Технологии

- **Kotlin** + **Jetpack Compose** для интерфейса
- **osmdroid** с топографическими слоями тайлов для карты
- **API геолокации** Android и **foreground-сервис** для надёжной записи поездок
- Target SDK 36 · Min SDK 24

## ❓ Частые вопросы

<details>
<summary><b>H RIDE есть в Google Play?</b></summary>

Пока нет — здесь он распространяется как подписанный APK. Релизы на GitHub — официальные сборки.
</details>

<details>
<summary><b>Какие версии Android поддерживаются?</b></summary>

Android 7.0 (API 24) и новее, на 32- и 64-битных устройствах.
</details>

<details>
<summary><b>Почему Android предупреждает меня при установке APK?</b></summary>

Любое приложение, установленное вне Play Store, вызывает такое предупреждение. APK подписан
постоянным релизным ключом (сертификат SHA-256
`d3257079398d904ef92b6508e33b0b46b022f43f74237a4e3d4596ce65d681d5`), а SHA-256 самого файла
опубликован выше, чтобы вы могли его проверить.
</details>

<details>
<summary><b>Где исходный код?</b></summary>

В этом репозитории публикуются официальные сборки, документация и [справочный код, полученный декомпиляцией APK](decompiled/). Исходный проект на Kotlin утрачен, поэтому это не оригинальный исходный код, и он не собирается как есть.
</details>

## 🗺️ План развития

- [x] Первый публичный релиз (`v1.0.0`)
- [ ] Восстановить чистый собираемый проект на Kotlin на основе декомпилированного справочника
- [ ] История поездок и статистика по каждой поездке
- [ ] Экспорт поездок (GPX)
- [ ] Больше единиц измерения, тем и языков

Идеи и сообщения об ошибках ждём в [Issues](https://github.com/fastHU/H-RIDE/issues).

## 🤝 Участие в проекте

- 🐞 Нашли баг? [Откройте issue](https://github.com/fastHU/H-RIDE/issues/new) с моделью телефона,
  версией Android и описанием того, что произошло.
- 💡 Есть идея? Начните обсуждение в issue — запросы функций формируют план развития.
- 🌍 Переводы этого README приветствуются: скопируйте `README.md`, переведите его и откройте pull request.
- ⭐ Если H RIDE вам полезен, звезда поможет другим райдерам его найти.

## 📄 Лицензия

Распространяется по [лицензии MIT](LICENSE) © 2026 fastHU.

## 🙏 Благодарности

- Участники [OpenStreetMap](https://www.openstreetmap.org/) — данные карты
- [OpenTopoMap](https://opentopomap.org/), [Thunderforest](https://www.thunderforest.com/) и
  [USGS](https://www.usgs.gov/) — топографические слои тайлов
- [osmdroid](https://github.com/osmdroid/osmdroid) — движок карты
- [Jetpack Compose](https://developer.android.com/compose) — инструментарий для интерфейса

<div align="center">
  <br>
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <a href="https://star-history.com/#fastHU/H-RIDE&Date">
    <img src="https://api.star-history.com/svg?repos=fastHU/H-RIDE&type=Date" alt="Star history" width="600">
  </a>
  <br><br>
  <sub>Сделано для райдеров, райдером. 🚵</sub>
</div>
