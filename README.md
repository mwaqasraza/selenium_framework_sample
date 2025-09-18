# Selenium Framework Sample (Java 17, Maven, Selenium 4, Cucumber/TestNG) 🚀

A minimal, modern UI test automation framework using:

- Java 17
- Maven
- Selenium 4
- Cucumber 7 (BDD) with TestNG runner
- Log4j 2

The project is configured to compile and run on JDK 17.

## Tech stack

- Selenium: `org.seleniumhq.selenium:selenium-java:4.23.0`
- Cucumber: `io.cucumber:cucumber-java` and `io.cucumber:cucumber-testng:7.14.0`
- Test framework: `org.testng:testng:7.10.2`
- Logging: `org.apache.logging.log4j:log4j-api` and `log4j-core:2.23.1`
- Build plugins: `maven-compiler-plugin 3.13.0` with `<release>17</release>`, `maven-surefire-plugin 3.2.5`

## Prerequisites

- JDK 17 installed and set as the project SDK
- Maven 3.8+ (3.9+ recommended)
- Chrome or Firefox installed (Selenium Manager will auto-manage drivers)

Verify your Java/Maven setup:

```bash
mvn -version
```

Ensure it shows Java version 17.

## Project structure

- `src/main/java/config/ConfigReader.java` — Loads properties and environment-specific overrides
- `src/main/java/utils/DriverFactory.java` — Provides a singleton `WebDriver` (Chrome/Firefox)
- `src/main/java/utils/WaitUtils.java` — Explicit waits wrapping `WebDriverWait`
- `src/main/java/utils/LogHelper.java` — Thin wrapper over Log4j `Logger`
- `src/main/java/pages/` — Page Objects (`HomePage`, `ElementsPage`)
- `src/test/java/runners/TestRunner.java` — Cucumber TestNG runner
- `src/test/java/hooks/Hooks.java` — Cucumber hooks (setup/teardown, screenshots)
- `src/test/java/stepdefinitions/DemoQASteps.java` — Step definitions
- `src/test/resources/features/demoqa.feature` — Sample BDD feature
- `src/test/resources/config.properties` — Default config (env, browser, timeout)
- `src/test/resources/config.<env>.properties` — Env-specific config (e.g. `qa`, `dev`, `prod`)

## Configuration

The framework reads config from `src/test/resources/`:

- `config.properties` (defaults):
  - `env` — target environment key (e.g., `qa`)
  - `browser` — `chrome` or `firefox`
  - `timeout` — explicit wait timeout (seconds)
- `config.<env>.properties` (environment overrides):
  - `base.url` — application base URL

At runtime, `env` can be overridden via system property:

```bash
mvn test -Denv=qa
```

Note: `browser` and `timeout` are read from the properties file (not via `-D`), so edit `config.properties` to change them.

## Build

```bash
mvn clean package -DskipTests
```

## Run tests

Run the full test suite (Cucumber + TestNG):

```bash
mvn test -Denv=qa
```

Outputs:

- Cucumber HTML report: `target/cucumber-report.html`
- Surefire reports: `target/surefire-reports/`

Optional Cucumber filters:

```bash
# Run scenarios by tag (add tags in your feature files first)
mvn test -Denv=qa -Dcucumber.filter.tags="@smoke"

# Run a specific feature file
mvn test -Denv=qa -Dcucumber.features="src/test/resources/features/demoqa.feature"
```

## IDE setup (IntelliJ IDEA)

- File → Project Structure → Project SDK: set to JDK 17
- Language level: 17 (or “SDK default”)
- Maven tool window → Reimport to pick up `pom.xml`

## Troubleshooting

- Drivers not found: Selenium Manager in Selenium 4 auto-downloads drivers; ensure Chrome/Firefox are installed and the machine has internet access. Behind a proxy, set `HTTPS_PROXY`/`HTTP_PROXY`.
- Timeouts or flakiness: increase `timeout` in `config.properties`.
- Opening the wrong browser: set `browser=chrome|firefox` in `config.properties`.

## Notes

- The runner is `TestRunner` using `AbstractTestNGCucumberTests` with glue packages: `stepdefinitions`, `hooks`.
- Hooks capture a screenshot on failure and attach it to the scenario.

