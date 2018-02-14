apply { plugin("com.github.ben-manes.versions") }

//dependencyUpdates.resolutionStrategy = {
//  componentSelection { rules ->
//    rules.all {
//      ComponentSelection selection ->
//      boolean rejected =["alpha", "beta", "b", "rc", "cr", "m", "ea", "incubating", "atlassian", "snap"].any { qualifier ->
//        selection.candidate.version == ~ / (?i).*[.-]${ qualifier }[.\ w \ d -]*/
//      }
//      if (rejected) {
//        selection.reject("Ignore due to beta/alpha pattern: ${selection.candidate}")
//      }
//      if (selection.candidate.group == "me.moocar" && selection.candidate.module == "logback-gelf" && selection.candidate.version == ~ / 0.[1, 9].* /) {
//        selection.reject(
//          "Logback Gelf has a major screw up in ther version numbering, 0.12, 0.9.6 etc. are not newer than 0.3!!!")
//      }
//    }
//  }
//}
