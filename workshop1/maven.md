# Maven

Maven is a powerful build automation and project management tool designed to simplify the software development process, 
particularly in the Java ecosystem. It addresses common challenges faced by developers by providing a standardized and 
efficient way to manage projects. Maven uses a Project Object Model (POM) and follows a convention over configuration 
approach to streamline the build lifecycle and project setup.


```bash
❯ mvn --version
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T21:41:47+03:00)
Maven home: /usr/local/Cellar/maven/3.6.0/libexec
Java version: 1.8.0_202, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre
Default locale: en_GB, platform encoding: UTF-8
OS name: "mac os x", version: "10.14.1", arch: "x86_64", family: "mac"
```

Problems Maven Solves:

1. Dependency Management: Maven simplifies the management of project dependencies. It automates the process of downloading and integrating external libraries, reducing the manual effort required to handle dependencies.

2. Build Lifecycle: Maven defines a standard build lifecycle with predefined phases such as clean, validate, compile, test, package, install, and deploy. This standardized approach ensures consistency across projects and simplifies the execution of common build tasks.

3. Project Organization: Maven promotes a structured project organization by using conventions for source code, resources, and output directories. This helps developers adhere to a consistent project structure, making it easier for team members to understand and contribute to projects.

4. Convention over Configuration: Maven reduces the need for explicit configuration by providing sensible defaults and conventions. This simplifies project setup and allows developers to focus more on coding rather than spending time on configuring build processes.

5. Transitive Dependency Resolution: Maven automatically resolves and manages transitive dependencies. If a project depends on library A, and A depends on library B, Maven will handle the download and inclusion of both A and B without manual intervention.

6. Reusability with Plugins: Maven's plugin architecture allows developers to extend and customize the build process easily. This promotes code reuse and enables the integration of various tools and functionalities seamlessly into the build lifecycle.



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