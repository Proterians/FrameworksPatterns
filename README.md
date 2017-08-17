# FrameworksPatterns
Task:
Code Design Patterns in Test Automation

PREREQUISITES: project with Selenium WebDriver HW-s (parts 1-3) done.
MANDATORY: Implement the following design patterns in your solution from previous module:
a. Singleton
b. Factory Method
c. Decorator
You can use any area of you code to apply the pattern (any code layer – test, service or page object and their combinations). 
Implement the pattern in form, which is more convenient for you – there is no strict requirements or restrictions. 
You can consult with your mentor about the correct area of applying the pattern as well, but it’s better to do it by yourself.


This test runs on the Chrome driver. Because we use pattern "Singletone" so we can't run another instance of WebDriver.
If you want change Chrome driver to another, please use java class src/test/java/patterns/singletone/WebDriverSingletone.java

To change login and password for Gmail please go to "account.properies" in 'src/test/resources'

For prepare tests you should do next:
If you want to run test with a formal test letter, you should:
1. open 'src/test/java/runner/XMLRunner.xml'
2. change parameter name="letterParam" to value="formal"

or if you want to run test with an informal test letter, you should:
1. open 'src/test/java/runner/XMLRunner.xml'
2. change parameter name="letterParam" to value="informal"

For running test click MRB on '/src/test/java/runner/XMLRunner.xml' and than "Run as -> TestNG Suite"