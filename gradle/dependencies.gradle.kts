val versions = mapOf(
  Pair("thymeleaf", "3.0.9.RELEASE"),
  Pair("thymeleaf-layout-dialect", "2.3.0"),
  Pair("lombok", "1.16.20"),
  Pair("findbugs", "3.0.1"),
  Pair("spring", "5.0.4.RELEASE"),
  Pair("hibernate-validator", "6.0.7.Final"),
  Pair("owasp-java-html-sanitizer", "20171016.1"),
  Pair("spring-boot", "2.0.0.RELEASE"),
  Pair("edison", "2.0.0-m1-SNAPSHOT"),
  Pair("mongodb-driver", "3.6.3"),
  Pair("edison-hal", "2.0.0-m1"),
  Pair("jongo", "1.3.1"),
  Pair("bson4jackson", "2.9.0"),
  Pair("edison-vault", "2.0.4"),
  Pair("handy-uri-templates", "2.1.6"),
  Pair("httpclient", "4.5.5")
)
val testVersions = mapOf(
  Pair("embed-mongo", "2.0.3"),
  Pair("mockito-core", "2.16.0"),
  Pair("hamcrest-optional", "1.0")
)
val pluginVersions = mapOf(
  Pair("git-properties", "1.4.21"),
  Pair("versions", "0.17.0"),
  Pair("checkstyle", "8.8"),
  Pair("jacoco", "0.8.0"),
  Pair("pmd", "5.8.1")
)

val libraries = mapOf(
  Pair("lombok", "org.projectlombok:lombok:${versions["lombok"]}"),
  Pair("findbugs-annotations", "com.google.code.findbugs:annotations:${versions["findbugs"]}"),
  Pair("spring-context-indexer", "org.springframework:spring-context-indexer:${versions["spring"]}"),
  Pair("hibernate-validator", "org.hibernate:hibernate-validator:${versions["hibernate-validator"]}"),
  Pair("owasp-java-html-sanitizer",
    "com.googlecode.owasp-java-html-sanitizer:owasp-java-html-sanitizer:${versions["owasp-java-html-sanitizer"]}"),
  Pair("spring-boot-starter-web", "org.springframework.boot:spring-boot-starter-web:${versions["spring-boot"]}"),
  Pair("spring-boot-starter-actuator", "org.springframework.boot:spring-boot-starter-actuator:${versions["spring-boot"]}"),
  Pair("spring-boot-starter-thymeleaf", "org.springframework.boot:spring-boot-starter-thymeleaf:${versions["spring-boot"]}"),
  Pair("spring-boot-starter-json", "org.springframework.boot:spring-boot-starter-json:${versions["spring-boot"]}"),
  Pair("spring-boot-starter", "org.springframework.boot:spring-boot-starter:${versions["spring-boot"]}"),
  Pair("spring-boot-starter-logging", "org.springframework.boot:spring-boot-starter-logging:${versions["spring-boot"]}"),
  Pair("edison-core", "de.otto.edison:edison-core:${versions["edison"]}"),
  Pair("edison-jobs", "de.otto.edison:edison-jobs:${versions["edison"]}"),
  Pair("mongodb-driver", "org.mongodb:mongodb-driver:${versions["mongodb-driver"]}"),
  Pair("edison-mongo", "de.otto.edison:edison-mongo:${versions["edison"]}"),
  Pair("edison-hal", "de.otto.edison:edison-hal:${versions["edison-hal"]}"),
  Pair("edison-togglz", "de.otto.edison:edison-togglz:${versions["edison"]}"),
  Pair("jongo", "org.jongo:jongo:${versions["jongo"]}"),
  Pair("bson4jackson", "de.undercouch:bson4jackson:${versions["bson4jackson"]}"),
  Pair("edison-vault", "de.otto.edison:edison-vault:${versions["edison-vault"]}"),
  Pair("handy-uri-templates", "com.damnhandy:handy-uri-templates:${versions["handy-uri-templates"]}"),
  Pair("httpclient", "org.apache.httpcomponents:httpclient:${versions["httpclient"]}"),
  Pair("spring-boot-devtools", "org.springframework.boot:spring-boot-devtools:${versions["spring-boot"]}")
)
val testLibraries = mapOf(
  Pair("embed-mongo", "de.flapdoodle.embed:de.flapdoodle.embed.mongo:${testVersions["embed-mongo"]}"),
  Pair("mockito-core", "org.mockito:mockito-core:${testVersions["mockito-core"]}"),
  Pair("edison-testsupport", "de.otto.edison:edison-testsupport:${versions["edison"]}"),
  Pair("hamcrest-optional", "com.github.baev:hamcrest-optional:${testVersions["hamcrest-optional"]}"),
  Pair("spring-boot-starter-test", "org.springframework.boot:spring-boot-starter-test:${versions["spring-boot"]}")
)

val gradlePlugins = mapOf(
  Pair("git-properties",
    "gradle.plugin.com.gorylenko.gradle-git-properties:gradle-git-properties:${pluginVersions["git-properties"]}"),
  Pair("spring-boot", "org.springframework.boot:spring-boot-gradle-plugin:${versions["spring-boot"]}"),
  Pair("versions", "com.github.ben-manes:gradle-versions-plugin:${pluginVersions["versions"]}")
)

extra["versions"] = versions
extra["testVersions"] = testVersions
extra["pluginVersions"] = pluginVersions

extra["libraries"] = libraries
extra["testLibraries"] = testLibraries

extra["gradlePlugins"] = gradlePlugins
