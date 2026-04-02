# skeleton-api-karate

Skeleton API test framework using Karate on Java 21 and Maven. Tests are written in plain Gherkin syntax — no Java knowledge required to write them.

## Project structure

| File/Folder | What it is |
|---|---|
| `Dockerfile` | Builds the test image — installs Maven and Java, downloads dependencies, copies the tests |
| `pom.xml` | Lists the Maven packages the project depends on and configures how tests are run |
| `src/test/java/SampleRunner.java` | Tells the test runner which feature files to pick up and run |
| `src/test/java/sample.feature` | One sample test written in Karate's Gherkin syntax — calls a public API and checks the response |
| `.devcontainer/devcontainer.json` | Dev container configuration for VS Code — includes Docker so you can run builds from inside it |

## Build and run

```bash
docker build -t skeleton-karate . && docker run --rm skeleton-karate
```

> The first build will take a few minutes — Maven downloads all dependencies into the image. Subsequent builds are fast.

## Writing tests

Tests are written in `.feature` files using Karate's syntax. No Java needed:

```gherkin
Scenario: get a user
  Given url 'https://api.example.com'
  And path '/users/1'
  When method GET
  Then status 200
  And match response.name == '#string'
```

Add new `.feature` files alongside `sample.feature` and the runner will pick them up automatically.
