apply { plugin("findbugs") }

configure<FindBugsExtension> {
  toolVersion = "3.0.1"
  effort = "max"
  excludeFilter = file("$rootDir/config/findbugs/findbugs-exclude.xml")
}

tasks.withType<FindBugs> {
  group = "Findbugs"
  reports {
    xml.setEnabled(false)
    html.setEnabled(true)
  }
}
