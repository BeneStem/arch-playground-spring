val pluginVersions = extra["pluginVersions"] as Map<*, *>

apply { plugin("checkstyle") }

configure<CheckstyleExtension> {
  toolVersion = pluginVersions["checkstyle"] as String
  configFile = file("$rootDir/config/checkstyle/checkstyle.xml")
  isShowViolations = false
}

tasks.withType<Checkstyle> {
  group = "Checkstyle"
  reports {
    xml.setEnabled(false)
    html.setEnabled(true)
  }
}
