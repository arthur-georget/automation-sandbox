# Automation Sandbox
Java REST API automation server

[![JAVA](https://img.shields.io/badge/Java-orange?style=flat&logo=openjdk)](JAVA)
[![MAVEN](https://img.shields.io/badge/Maven-black?style=flat&logo=apachemaven&logoColor=blue)](MAVEN)
[![JUNIT](https://img.shields.io/badge/JUnit-%23E33332?logo=junit5&logoColor=white)](JUNIT)

## Dependencies
* **Java 21**
* **Maven 17**
    * **Surefire 3.2.5**
    * **War 3.5.1**
* **JUnit 5.8.0**
* **Mockito 5.14.2**
* **Jakarta 10**
* **Github-API 1.327**

## Works with
* **payara 7.2026.4**

## Install and run

1. **Clone the repository :**
   ```bash
   git clone https://github.com/arthur-georget/automation-sandbox.git
   cd automation-sandbox/sandbox
   ```

2. **Build the war package**
    ```bash
    mvn clean package
    ```

3. **Generate a Github Personal Access Token**
[Github Documentation on PAT](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens)

4. **Add you token to your server's environment variables**
    * Windows
    ```bash
        setx GITHUB_OAUTH yourPersonnalAccessToken
    ```
    * Linux
    ```bash
        export GITHUB_OAUTH="yourPersonnalAccessToken"
    ```
5. **Run the package with Payara7**
Either you can install Payara7 server on your machine. I personnaly used VSCode Community Server Connector extension with Payara 7. You then just need to right click on sandbox.war file and select "Run on Server".

6. **Send HTTP requests to (http://yourserverip:8080/sandbox/api/) to trigger automations**

### Requests available

* **POST /codeReviewed**
To trigger preprod-auto-merge.yml Github action
    * Don't forget the body to specify your Github branch target name
    ```
    {
        "branch": "yourGithubBranchName"
    }
    ```