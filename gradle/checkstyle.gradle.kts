apply { plugin("checkstyle") }

configure<CheckstyleExtension> {
  toolVersion = "8.8"
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
