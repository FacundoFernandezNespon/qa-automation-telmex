# 🧪 Framework de Automatización - Telmex

Este proyecto es un framework de automatización desarrollado para **Telmex**, utilizando tecnologías modernas como **Java 17**, **Maven**, **Serenity BDD** y **Cucumber**. Está orientado a automatizar flujos dentro de **Salesforce**, específicamente enfocados en la generación de **Cotizaciones** para diferentes **Partners** y productos.

---

## ⚙️ Tecnologías Utilizadas

- **Java v17.0.12**
- **Maven v3.9.9**
- **Serenity BDD v4.1.12**
- **Cucumber v7.16.1**
- **JUnit v5.10.2**

---

## 🧩 Estructura del Proyecto

Este framework sigue la arquitectura estándar de Serenity con Cucumber, estructurando el código en capas claras:

- `features/`: Contiene los archivos `.feature` de Cucumber.
- `stepdefinitions/`: Clases que implementan los pasos definidos en los `.feature`.
- `tasks/`: Acciones específicas que realiza el actor.
- `interactions/`: Interacciones reutilizables con la interfaz.
- `questions/`: Validaciones o consultas al estado de la UI.
- `models/`: Estructuras de datos utilizadas.
- `utils/`: Utilidades y helpers.
- `runners/`: Clases para ejecutar los distintos escenarios.

---

## 🚀 Ejecución de Pruebas

Para ejecutar una prueba, debes situarte en la raíz del proyecto y lanzar el siguiente comando:
(Puedes ejecutar mas de una prueba separando los @tags con la palabra 'and' )

```bash
mvn clean verify "-Dcucumber.filter.tags=@Plata"

TAGS DISPONIBLES:

@Platino: Flujo de cotización para Partners Platino.

@Plata: Flujo de cotización para Partners Plata.

@Oro: Flujo de cotización para Partners Oro.

```

### 🏢 Contacto
Para más información o soporte técnico, por favor contacta al equipo de QA de Nespon o a facundo.fernandez@nespon.com
