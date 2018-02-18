import com.github.benmanes.gradle.versions.updates.DependencyUpdates
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType
import org.springframework.boot.gradle.run.BootRunTask

apply {
  plugin("java")
  plugin("idea")
}

buildscript {
  val springVersion = "5.0.3.RELEASE"
  val springBootVersion = "1.5.10.RELEASE"
  extra["springVersion"] = springVersion
  extra["springBootVersion"] = springBootVersion
  extra["edison"] = "1.2.9"

  repositories {
    jcenter()
    maven { setUrl("https://plugins.gradle.org/m2/") }
  }
  dependencies {
    classpath("gradle.plugin.com.gorylenko.gradle-git-properties:gradle-git-properties:1.4.20")
    classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    classpath("com.github.ben-manes:gradle-versions-plugin:0.17.0")
  }
}

version = "1.0.0-SNAPSHOT"
configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
  jcenter()
}

apply {
  plugin("com.gorylenko.gradle-git-properties")
  plugin("org.springframework.boot")
  plugin("com.github.ben-manes.versions")
}

val springVersion = extra["springVersion"] as String
val springBootVersion = extra["springBootVersion"] as String
val edison = extra["edison"] as String

ext["thymeleaf.version"] = "3.0.9.RELEASE"
ext["thymeleaf-layout-dialect.version"] = "2.3.0"

dependencies {
  "compileOnly"("org.projectlombok:lombok:1.16.20")
  "compileOnly"("com.google.code.findbugs:annotations:3.0.1")
  "compileOnly"("org.springframework:spring-context-indexer:$springVersion")

  "compile"("org.hibernate:hibernate-validator:5.4.2.Final")
  "compile"("com.googlecode.owasp-java-html-sanitizer:owasp-java-html-sanitizer:20171016.1")
  "compile"("org.springframework.boot:spring-boot-starter-jetty:$springBootVersion")
  "compile"("de.otto.edison:edison-core:$edison")
  "compile"("de.otto.edison:edison-jobs:$edison")
  "compile"("org.mongodb:mongodb-driver:3.6.3")
  "compile"("de.otto.edison:edison-mongo:$edison")
  "compile"("de.otto.edison:edison-hal:2.0.0-m1")
  "compile"("de.otto.edison:edison-togglz:$edison")
  "compile"("org.jongo:jongo:1.3.0")
  "compile"("de.undercouch:bson4jackson:2.9.0")
  "compile"("de.otto.edison:edison-vault:2.0.4")
  "compile"("com.damnhandy:handy-uri-templates:2.1.6")
  "compile"("org.apache.httpcomponents:httpclient:4.5.5")

  "compile"("org.springframework.boot:spring-boot-devtools:$springBootVersion")

  "testCompileOnly"("org.projectlombok:lombok:1.16.20")

  "testCompile"("de.flapdoodle.embed:de.flapdoodle.embed.mongo:2.0.3")
  "testCompile"("org.mockito:mockito-core:2.15.0")
  "testCompile"("de.otto.edison:edison-testsupport:$edison")
  "testCompile"("com.github.baev:hamcrest-optional:1.0")
  "testCompile"("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
}

apply {
  from("$rootDir/gradle/checkstyle.gradle.kts")
  from("$rootDir/gradle/findbugs.gradle.kts")
  from("$rootDir/gradle/pmd.gradle.kts")
  from("$rootDir/gradle/test.gradle.kts")
  from("$rootDir/gradle/jacoco.gradle.kts")
}

tasks {
  withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.addAll(arrayOf("-Xlint:all", "-parameters"))
  }

  withType<BootRunTask> {
    systemProperties = System.getProperties().mapKeys { entry -> entry.key.toString() }.toMap()
  }

  "dependencyUpdates"(DependencyUpdatesTask::class) {
    resolutionStrategy = closureOf<ResolutionStrategy> {
      componentSelection {
        all {
          val alphaBetaPattern = Regex("^.*[\\.-](alpha|beta|b|rc|cr|m|ea|incubating|atlassian|snap)[\\.\\w\\d-]*$",
            RegexOption.IGNORE_CASE)
          if (candidate.version.matches(alphaBetaPattern)) {
            reject("Rejected by alpha/beta revision: ${candidate}")
          }
        }
      }
    }
  }
}
