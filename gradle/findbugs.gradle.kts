val versions = extra["versions"] as Map<*, *>

apply(plugin = "findbugs")

configure<FindBugsExtension> {
  toolVersion = versions["findbugs"] as String
  effort = "max"
  excludeFilter = file("$rootDir/config/findbugs/findbugs-exclude.xml")
}

tasks.withType<FindBugs> {
  group = "Findbugs"
  reports {
    xml.isEnabled = false
    html.isEnabled = true
  }
}
