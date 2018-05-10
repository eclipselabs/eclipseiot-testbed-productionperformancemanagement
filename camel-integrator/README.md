# Apache Camel PPMP Integrator

This project gives multiple examples on how to use Apache Camel with Production Performance Management Protocol. Most of the examples are based on spring xml. These among other configuration files are located in `src/main/resources`:
* `application-context.xml`
  Main entry file to start camel routes. It contains a general PPMP validation REST endpoint that reuses the route from `ppmp-validate-context.xml`
* `mqtt-context.xml`
  A simple example of converting transport protocol (mqtt to REST), without looking at the payload
* `ppmp-splitAndRewrite-context.xml`
  Shows how to receive (PPMP-) payload via different REST paths (/rest or /ppm), and each forwarding to two seperate endpoints (/rest and /ppm)
  * `ppmpRewrite.xml` and `ppmRewrite.xml`
    mapping examples to rewrite the urls
* `ppmp-validate-context.xml`
  A simple validation route for PPMP messages that can be reused in many other routes.
* `psi6000-transform-context.xml`
  A more advanced example of converting a psi6000 JSON format, converting it to plain old java object (POJO), transforming that to PPMP POJOs (using [unide.java](https://github.com/eclipse/unide.java)) and forwarding these to actual REST endpoints
* `application.properties`
  Contains key/value pairs that can be used in the camel context configurations.
* `log4j.properties`
  The configuration for logging. For testing purposes, the log4j.properties in /src/test/resources is used.

## Prerequisites
All dependencies are listed in the `pom.xml`. Among them:
* `ppmp-schema`
  Download or checkout [unide](https://github.com/eclipse/unide)/ppmp-schema first and register it in your local maven via
  ```bash
  mvn install
  ```
* `ppmp-java-binding`
  Download or checkout [unide.java](https://github.com/eclipse/unide.java) first and register it in your local maven via
  ```bash
  mvn install
  ```

## Run

For a quick testrun, use
```bash
mvn exec:java
```

To build this project use
```bash
mvn package
```
The resulting package will then be located in target/integrator-*-assembly.zip. It contains:
* `bin`
  files for starting the integrator (`IntegratorStarter*`) and for installing Windows Services (`ServiceInstaller.bat`). Use `ServiceUninstaller.bat` to remove the service again. The Service is called "Integrator Service".
* `conf`
  The files from `src/main/resources`. See above.
* `lib`
  All java dependencies used by this project and the xml configuration files
* `logs`
  Log files created when running the integrator and the service.

For more help see the Apache Camel documentation
```bash
http://camel.apache.org/
```

