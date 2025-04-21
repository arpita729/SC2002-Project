# TO RUN
First, install maven.  
`mvn dependency:copy-dependencies`  
`mvn exec:java@run`  
to test: `mvn exec:java@test`

There may be an issue where the `items` folder under `src/main/java` is mistakenly called `Items`. In that case, renaming the folder as such will solve the problem.

# JAVADOC
Javadoc is in `target/reports/apidocs`. Public version is in `target/site`.  
`mvn javadoc:javadoc`  
`mvn javadoc:jar`  
`mvn site`

# DIAGRAMS
Diagrams can be found under `SC2002 FOLDER`. Raw versions of the plantUML can be found under `SC2002 FOLDER/raw`.