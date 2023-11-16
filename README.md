# JavaPackagerDemo

Mainly used to demonstrate the basic packaging process

## How to use this plugin

### Package your app with Maven

Add the following `plugin` tag to your `pom.xml`:

In the introduction of the plugin homepage, only a single plugin was introduced. I don't know why the packaging results cannot run. After adjustment, it was found that the above plugins were used simultaneously. Simply execute the

```
mvn clean package
```

```
<plugin>
   <groupId>org.apache.maven.plugins</groupId>
   <artifactId>maven-shade-plugin</artifactId>
   <version>3.2.4</version>
   <executions>
      <execution>
         <phase>package</phase>
         <goals>
            <goal>shade</goal>
         </goals>
         <configuration>
            <transformers>
               <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                  <mainClass>${main.class}</mainClass>
               </transformer>
            </transformers>
         </configuration>
      </execution>
   </executions>
</plugin>

<plugin>
   <groupId>org.apache.maven.plugins</groupId>
   <artifactId>maven-jar-plugin</artifactId>
   <version>3.2.2</version>
   <configuration>
      <skipIfEmpty>true</skipIfEmpty>
      <archive>
         <manifestEntries>
            <addClasspath>true</addClasspath>
            <Main-Class>${main.class}</Main-Class>
            <Program-Version>${project.version}</Program-Version>
            <Implementation-Version>${project.version}</Implementation-Version>
         </manifestEntries>
      </archive>
      <includes>
         <include>**/*.class</include>
      </includes>
   </configuration>
</plugin>

<plugin>
   <groupId>org.openjfx</groupId>
   <artifactId>javafx-maven-plugin</artifactId>
   <version>0.0.8</version>
   <configuration>
      <mainClass>${main.class}</mainClass>
   </configuration>
</plugin>

<plugin>
   <groupId>io.github.fvarrui</groupId>
   <artifactId>javapackager</artifactId>
   <version>1.7.5</version>
   <configuration>
      <mainClass>${main.class}</mainClass>
      <name>JavaFxApp</name>
      <bundleJre>true</bundleJre>
      <generateInstaller>true</generateInstaller>
      <platform>windows</platform>
   </configuration>
   <executions>
      <execution>
         <id>windows</id>
         <phase>package</phase>
         <goals>
            <goal>package</goal>
         </goals>
      </execution>
   </executions>
</plugin>
```

Packaged directory
target\JavaFxApp\JavaFxApp.exe can be directly double-click to run

JavaPackagerDemo.jar can be executed through commands

```
java -jar .\target\JavaPackagerDemo.jar
```

```
- target
    - assets
      - JavaFxApp.exe.manifest
      - JavaFxApp.ico
      - JavaFxApp.iss
      - JavaFxApp.msm.wxs
    - classes
      - module-info.class
      - org
        - example
          - Launcher.class
          - PrintDirectoryStructure.class
          - ShortcutExample.class
    - generated-sources
      - annotations
    - generated-test-sources
      - test-annotations
    - JavaFxApp
      - JavaFxApp.exe
      - jre
        - bin
          - api-ms-win-core-console-l1-1-0.dll
          - api-ms-win-core-console-l1-2-0.dll
          - api-ms-win-core-datetime-l1-1-0.dll
          - api-ms-win-core-debug-l1-1-0.dll
          - api-ms-win-core-errorhandling-l1-1-0.dll
          - api-ms-win-core-file-l1-1-0.dll
          - api-ms-win-core-file-l1-2-0.dll
          - api-ms-win-core-file-l2-1-0.dll
          - api-ms-win-core-handle-l1-1-0.dll
          - api-ms-win-core-heap-l1-1-0.dll
          - api-ms-win-core-interlocked-l1-1-0.dll
          - api-ms-win-core-libraryloader-l1-1-0.dll
          - api-ms-win-core-localization-l1-2-0.dll
          - api-ms-win-core-memory-l1-1-0.dll
          - api-ms-win-core-namedpipe-l1-1-0.dll
          - api-ms-win-core-processenvironment-l1-1-0.dll
          - api-ms-win-core-processthreads-l1-1-0.dll
          - api-ms-win-core-processthreads-l1-1-1.dll
          - api-ms-win-core-profile-l1-1-0.dll
          - api-ms-win-core-rtlsupport-l1-1-0.dll
          - api-ms-win-core-string-l1-1-0.dll
          - api-ms-win-core-synch-l1-1-0.dll
          - api-ms-win-core-synch-l1-2-0.dll
          - api-ms-win-core-sysinfo-l1-1-0.dll
          - api-ms-win-core-timezone-l1-1-0.dll
          - api-ms-win-core-util-l1-1-0.dll
          - api-ms-win-crt-conio-l1-1-0.dll
          - api-ms-win-crt-convert-l1-1-0.dll
          - api-ms-win-crt-environment-l1-1-0.dll
          - api-ms-win-crt-filesystem-l1-1-0.dll
          - api-ms-win-crt-heap-l1-1-0.dll
          - api-ms-win-crt-locale-l1-1-0.dll
          - api-ms-win-crt-math-l1-1-0.dll
          - api-ms-win-crt-multibyte-l1-1-0.dll
          - api-ms-win-crt-private-l1-1-0.dll
          - api-ms-win-crt-process-l1-1-0.dll
          - api-ms-win-crt-runtime-l1-1-0.dll
          - api-ms-win-crt-stdio-l1-1-0.dll
          - api-ms-win-crt-string-l1-1-0.dll
          - api-ms-win-crt-time-l1-1-0.dll
          - api-ms-win-crt-utility-l1-1-0.dll
          - awt.dll
          - fontmanager.dll
          - freetype.dll
          - java.dll
          - java.exe
          - javajpeg.dll
          - javaw.exe
          - jawt.dll
          - jfr.exe
          - jimage.dll
          - jli.dll
          - jsound.dll
          - jvmcicompiler.dll
          - keytool.exe
          - lcms.dll
          - mlib_image.dll
          - msvcp140.dll
          - net.dll
          - nio.dll
          - prefs.dll
          - server
            - jvm.dll
          - splashscreen.dll
          - ucrtbase.dll
          - vcruntime140.dll
          - vcruntime140_1.dll
          - verify.dll
          - zip.dll
        - conf
          - net.properties
          - security
            - java.policy
            - java.security
            - policy
              - limited
                - default_local.policy
                - default_US_export.policy
                - exempt_local.policy
              - README.txt
              - unlimited
                - default_local.policy
                - default_US_export.policy
          - sound.properties
        - lib
          - classlist
          - fontconfig.bfc
          - fontconfig.properties.src
          - jawt.lib
          - jfr
            - default.jfc
            - profile.jfc
          - jrt-fs.jar
          - jvm.cfg
          - jvm.lib
          - modules
          - psfont.properties.ja
          - psfontj2d.properties
          - security
            - blocked.certs
            - cacerts
            - default.policy
            - public_suffix_list.dat
          - tzdb.dat
          - tzmappings
        - release
      - libs
        - javafx-base-21-win.jar
        - javafx-base-21.jar
        - javafx-controls-21-win.jar
        - javafx-controls-21.jar
        - javafx-graphics-21-win.jar
        - javafx-graphics-21.jar
    - JavaFxApp_1.0-SNAPSHOT.exe
    - JavaPackagerDemo-runnable.jar
    - JavaPackagerDemo.jar
    - launch4j
      - app.exe
      - app.exe.manifest
      - app.ico
      - app.jar
    - maven-archiver
      - pom.properties
    - maven-status
      - maven-compiler-plugin
        - compile
          - default-compile
            - createdFiles.lst
            - inputFiles.lst
        - testCompile
          - default-testCompile
            - createdFiles.lst
            - inputFiles.lst
    - original-JavaPackagerDemo.jar
    - test-classes
      - META-INF
        - jpms.args
```

