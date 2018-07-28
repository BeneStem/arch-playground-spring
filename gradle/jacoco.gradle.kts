val pluginVersions = extra["pluginVersions"] as Map<*, *>

apply(plugin = "jacoco")

configure<JacocoPluginExtension> {
  toolVersion = pluginVersions["jacoco"] as String
}

tasks.withType<JacocoReport> {
  group = "Coverage"
  reports {
    xml.isEnabled = false
    html.isEnabled = true
    html.destination = file("$buildDir/reports/coverage/server")
  }
}

tasks.withType<Test> {
  finalizedBy("jacocoTestReport")
}
