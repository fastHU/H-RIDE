<div align="center">
  <img src="assets/banner.png" alt="H RIDE" width="100%">
</div>

<h1 align="center">H RIDE</h1>

<p align="center">
  <b>Ciclocomputador aero de nueva generación y compañero de seguimiento para Android.</b><br>
  Dock fluido estilo Apple · velocidad y fuerza G en tiempo real · mapas satelitales duales · perfil de elevación · calculadora de presión de neumáticos
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
  <b>Español</b> ·
  <a href="README.ru-RU.md">Русский</a>
</p>

---

## 👋 ¿Qué es H RIDE?

**H RIDE** convierte tu teléfono Android en un ciclocomputador aero y una herramienta completa de seguimiento de rutas. Montado en el manillar o la potencia, ofrece datos instantáneos y legibles: velocidad, fuerza G, perfil de elevación en tiempo real y mapas satelitales de doble capa.

La interfaz evita los colores fluorescentes habituales y está pensada para leerse con claridad bajo el sol directo o de noche. Sin cuentas obligatorias, suscripciones ni rastreo de privacidad.

<div align="center">
  <img src="assets/app-preview.png" alt="Vista previa de H RIDE" width="100%">
</div>

> **Aviso para v7.7.0+** — Desde **v7.7.0**, H RIDE es un proyecto Android Studio 100 % open source y compilable, escrito en Kotlin puro y Jetpack Compose (`app/`). El código descompilado de v1.0.0 se conserva en [`decompiled/`](decompiled/) como referencia histórica.

> **Idioma de la interfaz:** la versión actual tiene la interfaz en chino simplificado. La localización al español está en la hoja de ruta.

---

## ✨ Funciones

| | Función | Descripción |
|:--:|---|---|
| 🍏 | **Dock fluido estilo Apple** | Navegación inferior con física de resorte y gestos de arrastre. |
| ⚡ | **Velocímetro en tiempo real** | Velocidad, promedio y máxima en km/h con arco degradado. |
| 🌀 | **Radar de fuerza G** | Aceleración y carga en curvas a partir de los sensores del dispositivo. |
| 🛰️ | **Mapas de doble motor** | OpenStreetMap vectorial y ArcGIS World Imagery con caché fuera de línea. |
| ⛰️ | **Perfil de elevación en vivo** | Curva de altitud, pendiente y desnivel acumulado. |
| 🔧 | **Calculadora de presión** | PSI y bar para delantera y trasera según peso del ciclista y de la bici, ancho de neumático, carcasa y terreno. |
| 📊 | **Historial y estadísticas** | Registro de rutas, desnivel, velocidades media y máxima. |
| 🌙 | **Servicio en primer plano** | Grabación continua con la pantalla apagada o la app en segundo plano. |

---

## 📥 Descarga

| Versión | Archivo | Tamaño | SHA-256 |
|---|---|---|---|
| **v7.7.0** (última) | `H_RIDE.apk` | ~15,3 MiB | `824e2d64cc9b6083339b50d4da7b61443015ba0086a329eacee288c8c9bc70c2` |
| **v1.0.0** (legado) | `H-RIDE-v1.0.0.apk` | ~17,1 MiB | `e8a5df497ba00f605bc6b3943e68b8ad10011dbb20457455a68214ec9bb34b76` |

> **Firma:** el APK v7.7.0 está firmado con la clave de depuración estándar de Android (`CN=Android Debug`) y marcado como `debuggable`. Está pensado para instalación manual y pruebas, no como una compilación de producción para la tienda. El APK v1.0.0 se firmó con la clave de publicación original de H RIDE.

> **Actualización desde v1.0.0:** v7.7.0 usa el ID de aplicación `com.liquidvelo.app`; v1.0.0 usaba `com.aistudio.summitpath.mtb`. Ambas versiones pueden convivir, pero los datos de rutas no se migran automáticamente.

---

## 🚀 Compilación

Requisitos: Android Studio Hedgehog o superior, JDK 17, compileSdk 34 y minSdk 26. El repositorio incluye el Gradle wrapper (Gradle 8.2).

```bash
git clone https://github.com/fastHU/H-RIDE.git
cd H-RIDE
./gradlew assembleRelease
```

---

## 🔐 Permisos y privacidad

La app solicita ubicación precisa y aproximada, servicio en primer plano con ubicación, notificaciones, acceso a red para los mapas, sensores de movimiento, wake lock, vibración y lectura de imágenes/vídeo para la portada del perfil. No hay cuentas ni servidores propios; los datos de las rutas se guardan en el dispositivo.

---

## 📄 Licencia

Publicado bajo la [licencia MIT](LICENSE) © 2026 fastHU.

---

<div align="center">
  <img src="assets/icon.png" alt="H RIDE" width="72">
  <br><br>
  <sub>Hecho por ciclistas, para ciclistas. 🚴‍♂️💨</sub>
</div>
