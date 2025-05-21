# hello-adk-java

Hello world agent using Google's adk-java framework

```bash
mvn exec:java \
    -Dexec.mainClass="com.google.adk.web.AdkWebServer" \
    -Dexec.args="--adk.agents.source-dir=src/main/java" \
    -Dexec.classpathScope="compile"
```


```bash
mvn compile exec:java -Dexec.mainClass="agents.multitool.MultiToolAgent"
```
