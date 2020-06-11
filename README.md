# Domain-Objects
This repository contains domain objects which are used for data transfer between 
multiple services of the WettkampfDB domain. You can add `domain-objects` to 
your project by adding one of the following dependencies:

###### Maven

Add the following to your `pom.xml` file:

```xml
<dependency>
  <groupId>de.wettkampfdb</groupId>
  <artifactId>domain-objects</artifactId>
  <version>1.0.0</version>
</dependency>
```

###### Gradle

Add the following to your `build.gradle` file:

```groovy
implementation "de.wettkampfdb:domain-objects:1.0.0"
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

-----
Gemacht ⚒️ im Ruhrgebiet