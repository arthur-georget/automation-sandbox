# Automation Sandbox
Java REST API automation server

https://img.shields.io/badge/Java-orange?style=flat&logo=openjdk
https://img.shields.io/badge/Maven-black?style=flat&logo=apachemaven&logoColor=blue
https://img.shields.io/badge/junit-%23E33332?logo=junit5&logoColor=white

## Dependencies
* **Maven 17**
* **JUnit 5.8.0**
* **Jakarta 10**
* **Github-API 1.327**

## Works with
* **payara 7.2026.4**

## Install and run

1. **Clone the repository :**
   ```bash
   git clone [https://github.com/arthur-georget/automation-sandbox.git](https://github.com/arthur-georget/automation-sandbox.git)
   cd automation-sandbox/sandbox
   ```

2. **Build the war package**
    ```bash
    mvn clean package
    ```

3. **Run the package with Payara7**
Either you can install Payara7 server on your machine. I personnaly used VSCode Community Server Connector extension with Payara 7. You then just need to right click on sandbox.war file and select "Run on Server".