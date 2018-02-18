// TODO (BS)
/**
 * For an example
 * @see https://raw.githubusercontent.com/ben-manes/caffeine/master/gradle/dependencies.gradle
 */
//ext {
// versions = [
//   bson_4_jackson: '2.8.0-SNAPSHOT',
//   commons_compress: '1.15',
//   commons_lang_3: '3.7',
//   commons_text: '1.1',
//   commons_validator: '1.6',
//   edison: '1.2.3',
//   edison_aws: '0.2.0-SNAPSHOT',
//   edison_hal: '1.0.0.RC5',
//   edison_productimport: '14.1.0',
//   edison_vault: '2.0.4',
//   findbugs: '3.0.1',
//   hal_browser: '3325375',
//   handy_uri_templates: '2.1.6',
//   hibernate_validator: '6.0.4.Final',
//   hmac_auth_common: '2.3.1',
//   httpclient: '4.5.3',
//   janino: '3.0.7',
//   javax_validation: '2.0.0.Final',
//   javax_ws_rs: '2.1',
//   jongo: '1.3.0',
//   jose4j: '0.6.1',
//   language_tool: '3.9',
//   logback_gelf: '0.3',
//   lombok: '1.16.18',
//   mongodb_driver: '3.5.0',
//   owasp_java_html_sanitizer: '20171016.1',
//   spring_boot: '1.5.8.RELEASE',
//   spring_data: '2.6.4.RELEASE',
//   thymeleaf_layout_dialect: '2.2.0',
//   thymeleaf: '3.0.3.RELEASE',
//   verification_domain_authentication: '1.160.01001'
// ]
// test_versions = [
//   hamcrest_optional: '1.0',
//   commons_io: '2.6'
// ]
// plugin_versions = [
//   versions: '0.17.0',
//   checkstyle: '8.4',
//   pmd: '5.8.1',
//   jacoco: '0.7.10-SNAPSHOT',
//   git_properties: '1.4.17'
// ]
//
// libraries = [
//   lombok: "org.projectlombok:lombok:${versions.lombok}",
//   findbugs_annotations: "com.google.code.findbugs:annotations:${versions.findbugs}",
//   hibernate_validator: "org.hibernate:hibernate-validator:${versions.hibernate_validator}",
//   commons_validator: "commons-validator:commons-validator:${versions.commons_validator}",
//   commons_text: "org.apache.commons:commons-text:${versions.commons_text}",
//   hmac_auth_common: "de.otto:hmac-auth-common:${versions.hmac_auth_common}",
//   hmac_auth_server: "de.otto:hmac-auth-server:${versions.hmac_auth_common}",
//   verification_domain_authentication: "de.otto:verification-domain-authentication:${versions.verification_domain_authentication}",
//   jose4j: "org.bitbucket.b_c:jose4j:${versions.jose4j}",
//   owasp_java_html_sanitizer: "com.googlecode.owasp-java-html-sanitizer:owasp-java-html-sanitizer:${versions.owasp_java_html_sanitizer}",
//   spring_boot_starter_jetty: "org.springframework.boot:spring-boot-starter-jetty:${versions.spring_boot}",
//   spring_boot_starter_hateoas: "org.springframework.boot:spring-boot-starter-hateoas:${versions.spring_boot}",
//   spring_boot_starter_data_mongodb: "org.springframework.boot:spring-boot-starter-data-mongodb:${versions.spring_boot}",
//   spring_boot_starter_data_rest: "org.springframework.boot:spring-boot-starter-data-rest:${versions.spring_boot}",
//   edison_core: "de.otto.edison:edison-core:${versions.edison}",
//   mongodb_driver: "org.mongodb:mongodb-driver:${versions.mongodb_driver}",
//   edison_mongo: "de.otto.edison:edison-mongo:${versions.edison}",
//   edison_aws_core: "de.otto.edison:edison-aws-core:${versions.edison_aws}",
//   edison_aws_config: "de.otto.edison:edison-aws-config:${versions.edison_aws}",
//   edison_aws_metrics: "de.otto.edison:edison-aws-metrics:${versions.edison_aws}",
//   edison_jobs: "de.otto.edison:edison-jobs:${versions.edison}",
//   edison_togglz: "de.otto.edison:edison-togglz:${versions.edison}",
//   edison_hal: "de.otto.edison:edison-hal:${versions.edison_hal}",
//   edison_vault: "de.otto.edison:edison-vault:${versions.edison_vault}",
//   edison_productimport: "de.otto.edison:edison-productimport:${versions.edison_productimport}",
//   hal_browser: "org.webjars:hal-browser:${versions.hal_browser}",
//   jongo: "org.jongo:jongo:${versions.jongo}",
//   commons_compress: "org.apache.commons:commons-compress:${versions.commons_compress}",
//   spring_boot_devtools: "org.springframework.boot:spring-boot-devtools:${versions.spring_boot}",
//   logback_gelf: "me.moocar:logback-gelf:${versions.logback_gelf}",
//   janino: "org.codehaus.janino:janino:${versions.janino}",
//   language_tool: "org.languagetool:languagetool-core:${versions.language_tool}",
//   language_tool_de: "org.languagetool:language-de:${versions.language_tool}",
//   language_tool_en: "org.languagetool:language-en:${versions.language_tool}",
//   bson_4_jackson: "de.undercouch:bson4jackson:${versions.bson_4_jackson}",
//   javax_ws_rs: "javax.ws.rs:javax.ws.rs-api:${versions.javax_ws_rs}",
//   javax_validation: "javax.validation:validation-api:${versions.javax_validation}",
//   commons_lang_3: "org.apache.commons:commons-lang3:${versions.commons_lang_3}",
//   handy_uri_templates: "com.damnhandy:handy-uri-templates:${versions.handy_uri_templates}",
//   httpclient: "org.apache.httpcomponents:httpclient:${versions.httpclient}"
// ]
// test_libraries = [
//   hamcrest_optional: "com.github.baev:hamcrest-optional:${test_versions.hamcrest_optional}",
//   spring_boot_starter_test: "org.springframework.boot:spring-boot-starter-test:${versions.spring_boot}",
//   edison_testsupport: "de.otto.edison:edison-testsupport:${versions.edison}",
//   commons_io: "commons-io:commons-io:${test_versions.commons_io}"
// ]
// gradle_plugins = [
//   versions: "com.github.ben-manes:gradle-versions-plugin:${plugin_versions.versions}",
//   spring_boot: "org.springframework.boot:spring-boot-gradle-plugin:${versions.spring_boot}",
//   git_properties: "gradle.plugin.com.gorylenko.gradle-git-properties:gradle-git-properties:${plugin_versions.git_properties}"
// ]
//}
