val pluginVersions = extra["pluginVersions"] as Map<*, *>

apply { plugin("jacoco") }

configure<JacocoPluginExtension> {
  toolVersion = pluginVersions["jacoco"] as String
}

tasks.withType<JacocoReport> {
  group = "Coverage"
  reports {
    xml.setEnabled(false)
    html.setEnabled(true)
    html.destination = file("$buildDir/reports/coverage/server")
  }
}

tasks.withType<Test> {
  finalizedBy("jacocoTestReport")
}
