## Test adequacy sandbox

These are code snippets for my testing lecture in CSC 305

See the `pom.xml` file. Note the following:
* It contains JUnit 5 as a dependency.
* It contains PIT as a plugin.
* The PIT plugin itself has a "JUnit 5 plugin" as a dependency.

This PIT plugin adds a "mutationCoverage" maven task that can be run as follows:

```
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```

For this to work, the `JAVA_HOME` environment variable will need to be set. (Or, at least it did on my Mac.)

Right now, the PIT plugin is configured (see the `configuration` block in the `pom.xml`) to mutate all classes matching the glob `demo*`, and is treating as tests all classes that match the glob `demo*Test*`.

Similarly, you could add a Jacoco plugin to collect code coverage info, which you will also need for this project.

## Project structure

The files are laid out as:

* src
  - main
    - java 
      - demo
        - Source files here are treated as being in package `demo`
  - test
    - java
      - demo
        - Source files here are _tests_, and are also treated as being in the package `demo`

This is the "default" maven package setup. Unfortunately, the submissions you'll be working with are _not_ organised this way, since the students weren't using Maven. The submissions you are dealing with are organised, roughly, as:

* src
  - main
    - Source files are treated as being in package `main`
    - Possibly have deeper nesting
  - other
    - Some projects (like, one or two) have additional packages here, instead of as children of `main`
  - test
    - Source files here are treated as being in package `test`
    - Possibly have deeper nesting


So you have two choices:

1. Maven configurations (i.e., through the `pom.xml` file) allows you to specify the "source directory" and the "test directory". You could create a `pom.xml` and set the source and test directories according to the setup above instead of the default. Or
2. You could write some scripts to restructure the projects (or even, god forbid, do it manually) so that they follow the "default" Maven setup. This may make your life easier in some hard-to-predict ways when Maven issues crop up.

