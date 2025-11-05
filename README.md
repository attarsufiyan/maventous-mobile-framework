Maventous Mobile Automation Framework

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

📘 Project Overview

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

* The Maventous Mobile Automation Framework is a scalable and modular automation framework built using Appium, Java, and TestNG for testing Android applications.

* It automates functional and UI testing for the Maventous mobile app, covering key user journeys such as Login, Signup, and Navigation.

* The framework follows the Page Object Model (POM) design pattern for better reusability and maintainability of code.

* It integrates with Extent Reports for detailed execution results and can be easily extended for cross-platform or cloud-based testing using BrowserStack or Sauce Labs.

<p align="center">
  <img src="https://github.com/user-attachments/assets/bd49125a-c527-49ef-b70c-42a9deb89d3a" height="400" style="margin-right:10px;" />
  <img src="https://github.com/user-attachments/assets/81d9b311-cf3d-4513-a9e5-7891f71ba375" height="400" />
</p>



----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

⚙️ Key Features

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

* Automates Android mobile application testing using Appium.

* Built using the Page Object Model (POM) structure for clean separation of test logic and UI elements.

* Supports data-driven testing through external JSON files.

* Generates detailed HTML reports using Extent Reports.

* Implements Listeners for event handling and automatic screenshot capture on test failure.

* Uses BaseTest class for environment setup and teardown.

* Compatible with real devices and emulators.

* Easily integrable with CI/CD pipelines using Jenkins.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

🧰 Tech Stack

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

* Programming Language: Java — Core language used for test development.

* Automation Tool: Appium — Automates mobile app testing on Android devices and emulators.

* Testing Framework: TestNG — Manages test execution and suite configuration.

* Design Pattern: Page Object Model (POM) — Enhances test scalability and reduces code duplication.

* Build Tool: Maven — Manages dependencies and build lifecycle.

* Reporting Tool: Extent Reports — Generates interactive HTML reports with screenshots.

* Utilities: Custom AppiumUtils and AndroidActions classes for common actions.

* Data Handling: JSON and .properties files for storing test data and configurations.

* Version Control: Git & GitHub — Source code management and version tracking.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<img width="1916" height="897" alt="image" src="https://github.com/user-attachments/assets/0e3e15c1-793f-4062-8efe-fe056cd1b788" />


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

🧱 Project Structure

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Root Folder: maventous_mobile_framework/ — Main directory containing source code, reports, and test suites.

* src/main/java/Utils/

   --> Contains utility classes for Appium setup and mobile gestures.

      Example:

    --> AppiumUtils.java → Initializes Appium driver and configurations.

     --> AndroidActions.java → Defines common Android gestures like scroll, swipe, and tap.

* src/main/java/com/dcentmass/maventous_mobile_framework/

   --> Contains all Page Object Classes representing mobile app screens.

   --> Example:

   --> WelcomePage.java → Represents welcome screen and navigation actions.

   --> SignInPage.java → Contains login elements and methods.

   --> SignUpPage.java → Defines sign-up form interactions.

   --> HomePage.java → Represents home screen validations.

* src/main/java/resources/

  --> Holds configuration files such as:

  --> data.properties → Contains environment and device setup details.

* src/test/java/TestUtils
  
  --> Contains reusable framework utilities and configurations.

  --> Example:

* BaseTest.java → Handles driver setup, teardown, and test initialization.

* Listeners.java → Implements TestNG listeners for logging and screenshot capture.

* ExtentReporterNG.java → Configures and generates Extent Reports.

* src/test/java/com/dcentmass/maventous_mobile_framework/
  
  --> Contains all TestNG-based test classes for automation execution.

  --> Example:

* Login_ptc.java → Positive test case for successful login validation.

* Login_ntc.java → Negative test case for invalid credentials.

* Standalone.java → End-to-end test for multiple user journeys.

* src/test/java/testData/
  
  --> Contains external test data files used for data-driven testing.

  --> Example:

* Ed-Tech.json → Data for positive test scenarios.

* loginntc.json → Data for negative test cases.

* src/test/java/apk/
  --> Stores the application under test.
  --> Example: Maventous.apk

* TestNGSuites/
  
  --> Contains suite configuration files for grouped and smoke test executions.
  
  --> Example:

      testng.xml → Master suite file for all tests.

      testNG_Smoke.xml → Smoke test suite configuration.

* reports/
  
  --> Stores generated HTML reports after execution.

  --> Example: index.html

* target/
  
  --> Contains compiled class files, generated reports, and build outputs.

* test-output/
  
  --> Stores default TestNG HTML and XML reports after execution.

* pom.xml
  
  --> Maven configuration file managing dependencies, plugins, and project build lifecycle.

* logging & Screenshots
  
  --> Stores execution logs and test evidence screenshots.
  
  --> Example files:

      reportsvalidLogin.png

      reportsinvalidlogin.png

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

👨‍💻 Author

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Name: Sufiyan Attar

Role: QA Automation Engineer

Email:sufiyanattar@hotmail.com
