<img src="https://raw.githubusercontent.com/WettkampfDB/Domain-Objects/master/.github/assets/wdb-header.svg?sanitize=true">

# Domain-Objects
![Build Release](https://github.com/WettkampfDB/Domain-Objects/workflows/Build%20Release/badge.svg)

This repository contains domain objects which are used for data transfer between 
multiple services of the WettkampfDB domain. You can add `domain-objects` to 
your project by adding one of the following dependencies:

###### Maven

Add the following to your `pom.xml` file:

```xml
<dependency>
  <groupId>de.wettkampfdb</groupId>
  <artifactId>domain-objects</artifactId>
  <version>1.0.1</version>
</dependency>
```

###### Gradle

Add the following to your `build.gradle` file:

```groovy
repositories {
    maven {
        url "https://maven.pkg.github.com/WettkampfDB/Domain-Objects"
        credentials {
            username = System.getenv("GITHUB_USERNAME")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation "de.wettkampfdb:domain-objects:1.0.1"
}
```

## Usage

You can create a simple `Competition` by invoking the `.builder()` method:

```java
Competition competition = Competition.builder()
            .name("Test Marathon")
            .startDate(LocalDate.now())
            .endDate(LocalDate.now())
            .url("https://www.wettkampfdb.de")
            .build();
```

<img src="https://raw.githubusercontent.com/WettkampfDB/Domain-Objects/master/.github/assets/wdb-footer.svg?sanitize=true">
