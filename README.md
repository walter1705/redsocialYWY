# Proyecto programacion II: Marketplace - MVC con patrones de diseño en JavaFX

Este proyecto es una red social básica desarrollada en **Java** utilizando **JavaFX** para la interfaz gráfica y la arquitectura **Modelo-Vista-Controlador (MVC)**. Está diseñado para demostrar cómo los patrones de diseño mejoran la mantenibilidad y escalabilidad del código.

## Características
- **Gestión de usuarios**: Registro, inicio de sesión y actualización de perfiles.
- **Publicaciones**: Crear, editar, eliminar y comentar publicaciones.
- **Sistema de notificaciones**: Notificaciones en tiempo real para interacciones.
- **Búsqueda avanzada**: Encuentra usuarios y publicaciones con filtros personalizados.

## Arquitectura
- **Modelo (Model)**: Gestiona los datos y la lógica del negocio.
- **Vista (View)**: Responsable de la interfaz gráfica, creada con FXML.
- **Controlador (Controller)**: Enlaza la vista con el modelo.

## Patrones de Diseño Utilizados
- **Singleton**: Para la gestión centralizada de recursos como la conexión a la base de datos.
- **Observer**: Implementado para el sistema de notificaciones en tiempo real.
- **Factory**: Para la creación dinámica de componentes de la interfaz.

## Mini Guia
Esta seccion sera una breve guia y/o recomendaciones para tu proyecto.

## Tecnologías Usadas
- **Java - JavaFX 22**

## Requisitos
- JDK 17 o superior.
- Apache Maven instalado.
- Editor de código (recomendado: IntelliJ IDEA o Eclipse).
