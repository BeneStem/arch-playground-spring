val pluginVersions = extra["pluginVersions"] as Map<*, *>

apply { plugin("pmd") }

configure<PmdExtension> {
  toolVersion = pluginVersions["pmd"] as String
  ruleSetFiles = files("$rootDir/config/pmd/ruleset.xml")
  isConsoleOutput = false
}

tasks.withType<Pmd> {
  group = "PMD"
  reports {
    xml.isEnabled = false
    html.isEnabled = true
  }
}
