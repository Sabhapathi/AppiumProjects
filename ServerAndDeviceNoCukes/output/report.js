$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/mobile.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "As a user I should be able to perform mobile actions and Web Browser actions also.",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Mobile App Login",
  "description": "",
  "id": "login;mobile-app-login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 5,
      "value": "#####  ON Mobile   ########################"
    }
  ],
  "line": 6,
  "name": "user is on mobile home page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user enter \"999999999\" into activation field",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 9,
      "value": "#Given I enter \"999999999\" to activate worker"
    }
  ],
  "line": 10,
  "name": "user press on \"Activate\" button",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user should see the text \"Set Bridge URL\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user change the URL to \"http://stg-bridge.xora.com/bridge/DeviceBridgeServlet\"",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user press on \"Update\" button",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user enter valid phone number \"9999900111\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user press on \"Activate\" button",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "user should see the text \"EULA\"",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "user clicks on \"I Agree\" button",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "user should see the text \"Warning\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "user clicks on \"Ok\" button",
  "keyword": "And "
});
formatter.match({
  "location": "MobileSteps.I_am_on_the_landing_page()"
});
formatter.result({
  "duration": 229052724,
  "error_message": "cucumber.runtime.CucumberException: Failed to instantiate class com.xora.test.stepDefinition.MobileSteps\r\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.cacheNewInstance(DefaultJavaObjectFactory.java:46)\r\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.getInstance(DefaultJavaObjectFactory.java:32)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:299)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCukes(TestNGCucumberRunner.java:50)\r\n\tat com.xora.test.admin.HomePageTest.loginShouldLoadLastVisitedPageBeforeLogoff(HomePageTest.scala:36)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:85)\r\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:659)\r\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:845)\r\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1153)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:125)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:108)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:771)\r\n\tat org.testng.TestRunner.run(TestRunner.java:621)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:357)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:352)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:310)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:259)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1199)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1124)\r\n\tat org.testng.TestNG.run(TestNG.java:1032)\r\n\tat org.testng.remote.RemoteTestNG.run(RemoteTestNG.java:111)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:204)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:175)\r\n\tat org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:125)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat com.intellij.rt.execution.application.AppMain.main(AppMain.java:140)\r\nCaused by: java.lang.reflect.InvocationTargetException\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.cacheNewInstance(DefaultJavaObjectFactory.java:40)\r\n\t... 40 more\r\nCaused by: org.openqa.selenium.SessionNotCreatedException: A new session could not be created. (Original error: Requested a new session but one was in progress) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 69 milliseconds\nBuild info: version: \u00272.52.0\u0027, revision: \u00274c2593cfc3689a7fcd7be52549167e5ccc93ad28\u0027, time: \u00272016-02-11 11:22:43\u0027\nSystem info: host: \u0027NANSU-T440\u0027, ip: \u002710.112.224.122\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: io.appium.java_client.android.AndroidDriver\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:180)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:249)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:131)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:158)\r\n\tat io.appium.java_client.AppiumDriver.\u003cinit\u003e(AppiumDriver.java:109)\r\n\tat io.appium.java_client.android.AndroidDriver.\u003cinit\u003e(AndroidDriver.java:39)\r\n\tat com.xora.mobileappdriver.DriverFactory.configureSessionForDevice(DriverFactory.java:76)\r\n\tat com.xora.mobileappdriver.DriverFactory.initializeAndroidDriver(DriverFactory.java:51)\r\n\tat com.xora.mobileappdriver.DriverFactory.\u003cinit\u003e(DriverFactory.java:28)\r\n\tat com.xora.test.stepDefinition.MobileSteps.\u003cinit\u003e(MobileSteps.java:20)\r\n\t... 45 more\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "999999999",
      "offset": 12
    }
  ],
  "location": "MobileSteps.I_enter_phoneNumber_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Activate",
      "offset": 15
    }
  ],
  "location": "MobileSteps.user_press_on_button(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Set Bridge URL",
      "offset": 26
    }
  ],
  "location": "MobileSteps.I_should_see_the_visibleText(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "http://stg-bridge.xora.com/bridge/DeviceBridgeServlet",
      "offset": 24
    }
  ],
  "location": "MobileSteps.I_change_url_to(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Update",
      "offset": 15
    }
  ],
  "location": "MobileSteps.user_press_on_button(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "9999900111",
      "offset": 31
    }
  ],
  "location": "MobileSteps.I_enter_valid_phoneNumber_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Activate",
      "offset": 15
    }
  ],
  "location": "MobileSteps.user_press_on_button(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "EULA",
      "offset": 26
    }
  ],
  "location": "MobileSteps.I_should_see_the_visibleText(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "I Agree",
      "offset": 16
    }
  ],
  "location": "MobileSteps.user_clicks_on_button(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Warning",
      "offset": 26
    }
  ],
  "location": "MobileSteps.I_should_see_the_visibleText(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Ok",
      "offset": 16
    }
  ],
  "location": "MobileSteps.user_clicks_on_button(String)"
});
formatter.result({
  "status": "skipped"
});
});