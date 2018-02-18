apply { plugin("pmd") }

configure<PmdExtension> {
  toolVersion = "5.8.1"
  ruleSetFiles = files("${rootDir}/config/pmd/ruleset.xml")
  isConsoleOutput = false
}

tasks.withType<Pmd> {
  group = "PMD"
  reports {
    xml.setEnabled(false)
    html.setEnabled(true)
  }
}
