# Changelog Viewer
![Java CI with Maven](https://github.com/metglobal-compass/spring-changelog-viewer/workflows/Java%20CI%20with%20Maven/badge.svg?branch=develop)

A changelog rendering helper package written in Spring boot

### Summary

It adds a controller for viewing change logs in browser by `/changelog` route.

(e.g. if your project URL is `http://localhost:8080`, then you can access changelog page on `http://localhost:8080/changelog`)

For default usage, CHANGELOG.md should be in default resource folder (`src/main/resources`)
or you should include file as a resource like shown in below pom.xml code. If
filename is different, then you should specify `fileName` in URL query. (e.g. `/changelog?fileName=Different.md`)

### Usage

It can be used by just adding one dependency to project's pom.xml.
 Needed controllers and other components already exist in package.
 
pom.xml code (replace "latest version" with project version (e.g. 0.1.0)):
 
 ```
 <dependencies>
     ..............
     <!-- changelog viewer !-->
     <dependency>
 	<groupId>com.github.metglobal-compass</groupId>
 	<artifactId>spring-changelog-viewer</artifactId>
 	<version>"latest version"</version>
     </dependency>
     ..............
 </dependencies>
  ...........
 <build>
    ...
    <resources>
        <resource>
           <!-- NOTE: This is required if resource usage is needed !-->
           <!-- because this is Spring Boot's default resource directory !-->
           <directory>src/main/resources</directory>
        </resource>
        <resource>
           <directory>${project.basedir}</directory>
              <includes>
                 <!-- This is example for file in root directory !-->
                 <!-- If file is in any subfolder, you should change it like subdir/CHANGELOG.md !-->
                 <include>CHANGELOG.md</include>
              </includes>
        </resource>
    </resources>
    ...
 </build>
 ```

After adding that, run `` mvn install`` to import dependency. And scan the package by 
adding or editing annotation in main application class.

If your application's running class is `MainApplication`, then annotiations will be like this:

```
@SpringBootApplication(scanBasePackages={"com.compass.changelog", ...})
............
public class MainApplication {
```

or

```
@SpringBootApplication
@ComponentScan(basePackages={"com.compass.changelog", ...})
............
public class MainApplication {
```