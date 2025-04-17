# TO RUN
First, install maven.  
`mvn dependency:copy-dependencies`  
`mvn clean compile exec:java`

There may be an issue where the `items` folder under `src/main/java` is mistakenly called `Items`. In that case, renaming the folder as such will solve the problem.

# JAVADOC
Javadoc is in `target/reports/apidocs`. Public version is in `target/site`.