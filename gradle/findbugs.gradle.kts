apply { plugin("findbugs") }

//findbugs {
//  effort = "max"
//  toolVersion = versions.findbugs
//  excludeFilter = file("$rootDir/config/findbugs/findbugs-exclude.xml")
//}

tasks.withType<FindBugs> {
  group = "Findbugs"
  reports {
    xml.setEnabled(false)
    html.setEnabled(true)
  }
}
