# Autotests project for https://miro.com/

# Tech stack
<p align="center">
<img width="16%" title="Gradle" src="readme_images/Gradle.svg">
<img width="16%" title="Java" src="readme_images/Java.svg">
<img width="16%" title="JUnit5" src="readme_images/JUnit5.svg">
<img width="16%" title="Selenide" src="readme_images/Selenide.svg">
<img width="16%" title="Allure Report" src="readme_images/Allure_Report.svg">
<img width="16%" title="Jenkins" src="readme_images/Jenkins.svg">
</p>

# Project in Allure TestOps with manual & automated tests
<a target="_blank" href="https://allure.autotests.cloud/project/%s">allure.autotests.cloud/project/%s</a> (ask admin@qa.guru for access)

# Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/%s">jenkins.autotests.cloud/job/%s</a>


# USAGE examples
You can start tests local and remote.
The properties of the project would be set in:
* system properties
* resources/config/local.properties
* resources/config/remote.properties

### For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)


Local tests run
```bash
gradle clean test
```

Run tests with not filled remote.properties:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Serve report:
```bash
allure serve build/allure-results
```

## Notifications
It used `allure-notifications`

Send notifications by local running tests to `Telegram`:
```
java  "-DprojectName=PROJECT_NAME" "-Denv=ENVIRONMENT" "-DreportLink=BUILD_URL" "-Dcomm=Any comment here" "-Dconfig.file=notifications/telegram.json" -jar notifications/allure-notifications-3.1.2.jar
```
##<img width="4%" title="Telegram" src="readme_images/Telegram.svg">Telegram notification


