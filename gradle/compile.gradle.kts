apply { plugin("java") }

tasks.withType<JavaCompile> {
  options.encoding = "UTF-8"
  options.compilerArgs.addAll(arrayOf("-Xlint:all", "-parameters"))
}
