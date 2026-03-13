# AUTO_FRONT_SCREENPLAY

Automatización Frontend con patrón **Screenplay** usando **Serenity BDD** con Selenium WebDriver.

Repositorios a los que se le aplica el test: https://github.com/orgs/equipo-6-uruguay/repositories?q=repo%3A+infra+OR+repo%3A+frontend+OR+repo%3A+backend-users-service+OR+repo%3A+backend-notification-service+OR+repo%3A+backend-assignment-service+OR+repo%3A+backend-ticket-service

## Tecnologías

| Herramienta          | Versión  |
|----------------------|----------|
| Java                 | 17+      |
| Gradle               | 8.10.2   |
| Serenity BDD         | 4.2.1    |
| Serenity Screenplay  | 4.2.1    |
| Serenity Cucumber    | 4.2.1    |
| JUnit 4              | 4.13.2   |

## Patrón Screenplay

El patrón Screenplay organiza la automatización en torno a **Actores** que realizan **Tareas** e interrogan el sistema con **Preguntas**, interactuando con la UI mediante **Targets**.

### Principio de Responsabilidad Única (SRP)

Cada Task tiene una **única responsabilidad**:

| Task                         | Responsabilidad                              |
|------------------------------|----------------------------------------------|
| `NavigateToLoginPage`        | Abrir la URL de login                        |
| `LoginWithCredentials`       | Ingresar credenciales y hacer clic en login  |
| `NavigateToCreateTicketForm` | Hacer clic en el enlace de crear ticket      |
| `EnterTicketTitle`           | Ingresar el título del ticket                |
| `EnterTicketDescription`     | Ingresar la descripción del ticket           |
| `SubmitTicketForm`           | Hacer clic en el botón de enviar             |

## Estructura del Proyecto

```
src/test/
├── java/com/ticketsystem/
│   ├── hooks/                → ScreenplayHooks (setup del Actor y Stage)
│   ├── questions/            → Questions (verificaciones del estado)
│   │   ├── LoginPageIsLoaded.java
│   │   ├── CreateTicketPageIsLoaded.java
│   │   ├── IsOnTicketListPage.java
│   │   ├── IsOnCreateTicketPage.java
│   │   ├── TicketIsDisplayed.java
│   │   └── CurrentUrl.java
│   ├── runners/              → TestRunner (CucumberWithSerenity + JUnit)
│   ├── stepdefinitions/      → Step Definitions (Gherkin → Screenplay)
│   ├── tasks/                → Tasks (acciones del actor, SRP)
│   │   ├── NavigateToLoginPage.java
│   │   ├── LoginWithCredentials.java
│   │   ├── NavigateToCreateTicketForm.java
│   │   ├── EnterTicketTitle.java
│   │   ├── EnterTicketDescription.java
│   │   └── SubmitTicketForm.java
│   └── ui/                   → UI Targets (localizadores)
│       ├── LoginPageUI.java
│       ├── CreateTicketPageUI.java
│       └── TicketListPageUI.java
└── resources/
    ├── features/             → Archivos .feature (Gherkin en español)
    │   └── crear_ticket.feature
    └── serenity.conf          → Configuración Serenity (driver, URL, screenshots)
```

## Flujo E2E Cubierto

1. El usuario navega a la página de login
2. Inicia sesión con email y contraseña
3. Es redirigido a la lista de tickets
4. Navega al formulario de creación de ticket
5. Completa título y descripción
6. Envía el formulario
7. El sistema guarda el ticket y redirige a la lista
8. El ticket aparece visible en la lista

## Ejecución

```bash
# Compilar
./gradlew.bat compileTestJava

# Ejecutar todos los tests y generar reportes Serenity
./gradlew.bat test

# Ejecutar solo el happy path
./gradlew.bat test -Dcucumber.filter.tags="@happy_path"

# Generar reportes Serenity manualmente
./gradlew.bat aggregate
```

Los reportes Serenity se generan en `target/site/serenity/index.html`.

## Configuración

Editar `src/test/resources/serenity.conf`:

```hocon
serenity {
    project.name = "Ticket System - Screenplay Tests"
    take.screenshots = FOR_EACH_ACTION
}

webdriver {
    driver = firefox
    autodownload = true
    timeouts {
        implicitlywait = 10000
        fluentwait = 15000
    }
}

headless.mode = false

environments {
    default {
        webdriver.base.url = "http://localhost:3000"
    }
}
```