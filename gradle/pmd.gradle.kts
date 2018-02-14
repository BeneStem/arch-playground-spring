apply { plugin("pmd") }

//pmd {
//  ruleSetFiles = files("${rootDir}/config/pmd/ruleset.xml")
//  toolVersion = plugin_versions.pmd
//  consoleOutput = false
//}

tasks.withType<Pmd> {
  group = "PMD"
  reports {
    xml.setEnabled(false)
    html.setEnabled(true)
  }
}
