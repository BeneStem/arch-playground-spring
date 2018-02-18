apply { plugin("jacoco") }

configure<JacocoPluginExtension> {
  toolVersion = "0.8.0"
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
