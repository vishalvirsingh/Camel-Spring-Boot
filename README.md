# Project skeleton

This is a basic project skeleton for working with Apache Camel and Spring Boot.

## Pre-requisites
1. Java 8
2. Spring Boot v2.1.8.RELEASE
3. Apache Camel 2.24.0
4. Gradle 4.10.3
5. Eclipse IDE

There are several items that need updates specific to your project.
These include:

   * **build.gradle**  
   Update buildscript and/or project dependencies as necessary.
   
   * **gradle.properties**  
   Supply appropriate values for the `springBootVersion` and `camelVersion` and `junitVersion' properties.
   * **settings.gradle**  
   Supply an appropriate value for the `rootProject.name` property.

## Spring Boot Apache Camel Configuration

   * **Since Camel 2.15**
   Spring Boot component provides auto-configuration for Apache Camel. Apache Camel auto-configuration of the Camel
   context auto-detects Camel routes available in the Spring context and registers the key Camel utilities (like producer
   template, consumer template and the type converter) as beans.
   camel-spring-boot jar comes with the spring.factories file, so as soon as you add that dependency into your classpath,
   Spring Boot will automatically auto-configure Camel for you.
   Add following dependency to build.gradle for using camel-spring-boot.
   ```
   compile group: 'org.apache.camel', name: 'camel-spring-boot', version: "${camelVersion}"
   
   ```
   
   * **Since Camel 2.17**
   CAMEL SPRING BOOT STARTER
   Apache Camel ships a Spring Boot Starter module that allows you to develop Spring Boot applications using starters.
   Add following dependency to build.gradle file for using camel-spring-boot-starter.
   ```
   compile group: 'org.apache.camel', name: 'camel-spring-boot-starter', version: "${camel.version}"
   
   ```
   

Follow link (https://camel.apache.org/components/3.0.x/spring-boot.html) for more information.

   
## Startup and application Flow
Application can run as a simple java application from com.camel.main.Application.java.
Provide following properties in application.properties file.
1.server.port: Spring boot applications start with embedded tomcat server start at default port 8080, specify port incase you want to change it.
2.inputPath: specify input path location to read .csv files
3.outputPath: specify output path location
4.processedPath= Specify location where files read(.csv) will be kept on successful transaction
5.errorPath= Specify location where files read(.csv) will be kept on failed transaction

   * **Flow**
   A basic application is developed using a camel route which will poll continously for csv files at input path location.
   And it will copy the content of csv file into a txt file. The output path contains all txt files of all csv files read.
   And if there is any exception or error occurs while processing, the csv file will be sent to errorPath.






