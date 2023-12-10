# Maven
Maven is a **build management tool** which can do all the things like adding dependencies, managing the classpath to project, generating war and jar file automatically and many other things.

It is a *Java tool, so you must have [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed in order to proceed.*

```bash
❯ mvn --version
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T21:41:47+03:00)
Maven home: /usr/local/Cellar/maven/3.6.0/libexec
Java version: 1.8.0_202, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre
Default locale: en_GB, platform encoding: UTF-8
OS name: "mac os x", version: "10.14.1", arch: "x86_64", family: "mac"
```

### Core concepts

1. **POM Files:** 

    Project Object Model(POM) Files are XML file that contains information related to the project and configuration information such as dependencies, source directory, plugin, goals etc. used by Maven to build the project. When you should execute a maven command you give maven a POM file to execute the commands. Maven reads pom.xml file to accomplish its configuration and operations.


2. **Dependencies and Repositories:**
    
    Dependencies are external Java libraries required for Project and repositories are directories of packaged JAR files. The local repository is just a directory on your machine hard drive. If the dependencies are not found in the local Maven repository, Maven downloads them from a central Maven repository and puts them in your local repository.


3. **Build Life Cycles, Phases and Goals:**

   A build life cycle consists of a sequence of build phases, and each build phase consists of a sequence of goals. Maven command is the name of a build lifecycle, phase or goal. If a lifecycle is requested executed by giving maven command, all build phases in that life cycle are executed also. If a build phase is requested executed, all build phases before it in the defined sequence are executed too.


4. **Build Profiles:**

   Build profiles a set of configuration values which allows you to build your project using different configurations. For example, you may need to build your project for your local computer, for development and test. To enable different builds you can add different build profiles to your POM files using its profiles elements and are triggered in the variety of ways.


6. **Build Plugins:**

    Build plugins are used to perform specific goal. you can add a plugin to the POM file. Maven has some standard plugins you can use, and you can also implement your own in Java

### Keywords

1. **project -** It is the root element of the pom.xml file.
2. **modelVersion -** modelversion means what version of the POM model you are using. Use version 4.0.0 for maven 2 and maven 3.
3. **groupId -** groupId means the id for the project group. It is unique and Most often you will use a group ID which is similar to the root Java package name of the project like we used the groupId com.adobe.devcamp.
4. **artifactId -** artifactId used to give name of the project you are building.in our example name of our project is AdvertisingCampaignManagement.
5. **version -** version element contains the version number of the project. If your project has been released in different versions then it is useful to give version of your project.
6. **dependencies -** dependencies element is used to defines a list of dependency of project.
7. **dependency -** dependency defines a dependency and used inside dependencies tag. Each dependency is described by its groupId, artifactId and version.
8. **name -** this element is used to give name to our maven project.
9. **scope -** this element used to define scope for this maven project that can be compile, runtime, test, provided system etc.
10. **packaging -** packaging element is used to packaging our project to output types like JAR, WAR etc.