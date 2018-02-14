apply { plugin("checkstyle") }

//checkstyle {
//  showViolations = false
//  toolVersion = plugin_versions.checkstyle
//}

tasks.withType<Checkstyle> {
  group = "Checkstyle"
  reports {
    xml.setEnabled(false)
    html.setEnabled(true)
  }
}
