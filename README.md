WikiaQATest
===========

Coding test for Wikia

The code was written on Mac OS 10.9 using Eclipse Kepler service release 2 IDE with Maven and TestNG plugins. The tests ran on eclipse but I couldn't get them to run on command line.

The following was attempted:

1. set CLASSPATH to where the class files and testng.jar are located: /target/classes/wikiaqatest/* 
2. cd to the CLASSPATH
3. ran the following command:  java org.testng.TestNG -testclass LoginTest
and got a class not found error
