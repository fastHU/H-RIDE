<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>Un ciclocomputador de bolsillo para Android.</b><br>
  Velocidad en tiempo real · fuerza G en tiempo real · velocidad media y máxima · altitud · distancia recorrida
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
  <b>Español</b> ·
  <a href="README.ru-RU.md">Русский</a>
</p>

---

## 👋 ¿Qué es H RIDE?

**H RIDE** convierte tu teléfono en un ciclocomputador. Móntalo en el manillar, pulsa iniciar y
registrará lo que de verdad importa en una salida: a qué velocidad vas, con cuánta fuerza aceleras y
cuánto desnivel has subido, y te lo mostrará en una interfaz limpia, legible de un vistazo y de alto
contraste que puedes interpretar en un segundo mientras pedaleas.

Sin cuenta. Sin registro. Sin suscripción. Solo tienes que instalar el APK y salir a rodar.

> **Sobre este repositorio**: `H-RIDE` es el repositorio oficial de H RIDE, y aloja las compilaciones
> publicadas, las notas de versión y la documentación. Estas compilaciones van firmadas con la clave
> de publicación del desarrollador, así que cada actualización se instala sobre la anterior sin más.

## ✨ Funciones

| | Función | Descripción |
|:--:|---|---|
| ⚡ | **Velocidad en tiempo real** | Lectura de velocidad en vivo, actualizada de forma continua desde el GPS, en km/h o mph. |
| 🌀 | **Fuerza G en tiempo real** | Carga de aceleración en vivo a partir de los sensores de movimiento del dispositivo, para que veas con cuánta fuerza frenas, tomas las curvas y esprintas. |
| 📊 | **Velocidad media** | Media en movimiento de toda la salida, actualizada sobre la marcha. |
| 🏁 | **Velocidad máxima** | El punto más rápido de tu salida, registrado automáticamente. |
| ⛰️ | **Altitud** | Altitud actual y desnivel acumulado, para que sepas siempre cuánta montaña queda. |
| 📏 | **Distancia y duración** | Distancia total de la salida y tiempo transcurrido, sincronizados con la sesión de grabación. |
| 🗺️ | **Mapa topográfico** | Vista de mapa en vivo con capas de teselas topográficas y de terreno (OpenTopoMap, Thunderforest, USGS): pensado para senderos, no solo para calles de ciudad. |
| 🌙 | **Grabación en segundo plano** | Un servicio en primer plano mantiene la grabación de la salida aunque apagues la pantalla o cambies de aplicación. |
| 🎨 | **Hecho con Jetpack Compose** | Una interfaz de Android nativa, moderna y fluida. |

## 📥 Descarga

Consigue el APK más reciente en la página de [**Releases**](https://github.com/fastHU/H-RIDE/releases/latest).

| Versión | Archivo | Tamaño | Requiere | SHA-256 |
|---|---|---|---|---|
| **v1.0.0** | [`H-RIDE-v1.0.0.apk`](https://github.com/fastHU/H-RIDE/releases/latest) | 17.1 MiB | Android 7.0+ (API 24) | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

Verifica tu descarga antes de instalar:

```bash
# macOS / Linux
shasum -a 256 H-RIDE-v1.0.0.apk

# Windows (PowerShell)
Get-FileHash .\H-RIDE-v1.0.0.apk -Algorithm SHA256
```

El hash que se muestre debe coincidir con el SHA-256 de arriba. Si no coincide, borra el archivo y vuelve a descargarlo.

## 🚀 Instalación

1. Descarga `H-RIDE-v1.0.0.apk` en tu teléfono.
2. Ábrelo. Android te pedirá que permitas instalar aplicaciones desde esta fuente: concédelo
   (*Ajustes → Aplicaciones → Acceso especial → Instalar aplicaciones desconocidas*).
3. Instálalo, abre H RIDE y concede el permiso de ubicación cuando te lo pida.
4. Monta el teléfono, pulsa iniciar y a rodar.

<details>
<summary>Instalar con ADB en su lugar</summary>

```bash
adb install -r H-RIDE-v1.0.0.apk
```
</details>

**ABIs compatibles:** `arm64-v8a`, `armeabi-v7a`, `x86`, `x86_64` — el APK incluye las cuatro, así que
funciona prácticamente en cualquier teléfono y tableta Android.

## 🔐 Permisos y privacidad

H RIDE pide exactamente lo que necesita un ciclocomputador, y nada más:

| Permiso | Por qué es necesario |
|---|---|
| `ACCESS_FINE_LOCATION` / `ACCESS_COARSE_LOCATION` | La velocidad, la distancia, la altitud y el mapa se obtienen de tu posición GPS. |
| `FOREGROUND_SERVICE` / `FOREGROUND_SERVICE_LOCATION` | Mantiene la grabación de la salida mientras la pantalla está apagada o usas otra aplicación, con una notificación permanente. |
| `POST_NOTIFICATIONS` | Muestra la notificación de grabación que Android exige para la ubicación en segundo plano. |
| `INTERNET` / `ACCESS_NETWORK_STATE` / `ACCESS_WIFI_STATE` | Descarga las teselas del mapa para la vista de mapa. |
| Sensores de movimiento | La fuerza G en tiempo real se lee del acelerómetro del dispositivo. |

**Privacidad en resumen:** no hay cuenta ni servidor de H RIDE. Las estadísticas de tus salidas se
calculan en el propio dispositivo. Las teselas del mapa se solicitan a proveedores públicos de
teselas (OpenTopoMap, Thunderforest, USGS, OpenStreetMap), que ven tu dirección IP como cualquier
mapa en línea. El APK también incluye las bibliotecas estándar de Google Play Services / Firebase;
puedes auditar tú mismo la lista completa de permisos con `aapt2 dump badging H-RIDE-v1.0.0.apk`.

## 🧱 Creado con

- **Kotlin** + **Jetpack Compose** para la interfaz
- **osmdroid** con capas de teselas topográficas para el mapa
- Las **API de ubicación** de Android y un **servicio en primer plano** para una grabación fiable de las salidas
- Target SDK 36 · Min SDK 24

## ❓ Preguntas frecuentes

<details>
<summary><b>¿H RIDE está en Google Play?</b></summary>

Todavía no: aquí se distribuye como un APK firmado. Las versiones publicadas en GitHub son las compilaciones oficiales.
</details>

<details>
<summary><b>¿Qué versiones de Android son compatibles?</b></summary>

Android 7.0 (API 24) y posteriores, tanto en dispositivos de 32 bits como de 64 bits.
</details>

<details>
<summary><b>¿Por qué Android me avisa al instalar el APK?</b></summary>

Toda aplicación instalada fuera de Play Store activa ese aviso. El APK está firmado con una clave de
publicación coherente (certificado SHA-256
`d3257079398d904ef92b6508e33b0b46b022f43f74237a4e3d4596ce65d681d5`) y el SHA-256 del archivo se
publica más arriba para que puedas verificarlo.
</details>

<details>
<summary><b>¿Dónde está el código fuente?</b></summary>

Actualmente este repositorio aloja las compilaciones oficiales y la documentación. Publicar todo el
código fuente de Android está en la [hoja de ruta](#-hoja-de-ruta): sigue el repositorio para recibir el aviso.
</details>

## 🗺️ Hoja de ruta

- [x] Primera versión pública (`v1.0.0`)
- [ ] Publicar todo el código fuente de Android
- [ ] Historial de salidas y estadísticas por salida
- [ ] Exportar salidas (GPX)
- [ ] Más unidades, temas e idiomas

Las ideas y los informes de errores son bienvenidos en [Issues](https://github.com/fastHU/H-RIDE/issues).

## 🤝 Contribuir

- 🐞 ¿Has encontrado un error? [Abre una incidencia](https://github.com/fastHU/H-RIDE/issues/new) con el modelo de tu teléfono,
  la versión de Android y lo que ocurrió.
- 💡 ¿Tienes una idea? Inicia un debate en una incidencia: las peticiones de funciones dan forma a la hoja de ruta.
- 🌍 Las traducciones de este README son bienvenidas: copia `README.md`, tradúcelo y abre una pull request.
- ⭐ Si H RIDE te resulta útil, una estrella ayuda a que otros ciclistas lo descubran.

## 📄 Licencia

Publicado bajo la [Licencia MIT](LICENSE) © 2026 fastHU.

## 🙏 Agradecimientos

- Colaboradores de [OpenStreetMap](https://www.openstreetmap.org/) — los datos del mapa
- [OpenTopoMap](https://opentopomap.org/), [Thunderforest](https://www.thunderforest.com/) y
  [USGS](https://www.usgs.gov/) — las capas de teselas topográficas
- [osmdroid](https://github.com/osmdroid/osmdroid) — el motor de mapas
- [Jetpack Compose](https://developer.android.com/compose) — el conjunto de herramientas de interfaz

<div align="center">
  <br>
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <a href="https://star-history.com/#fastHU/H-RIDE&Date">
    <img src="https://api.star-history.com/svg?repos=fastHU/H-RIDE&type=Date" alt="Star history" width="600">
  </a>
  <br><br>
  <sub>Hecho para ciclistas, por un ciclista. 🚵</sub>
</div>
