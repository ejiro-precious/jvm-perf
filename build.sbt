val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        organization := "com.depop",
        scalaVersion := "2.13.10"
      )
    ),
    name           := "jvm-perf",
    libraryDependencies ++= Seq(
      "org.openjdk.jmh" % "jmh-core" % "1.32"
    )
  )
  .enablePlugins(JmhPlugin)
