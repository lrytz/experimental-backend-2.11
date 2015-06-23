resolvers ++= List(
  "2.11.7 core"    at "https://oss.sonatype.org/content/repositories/orgscala-lang-1229/",
  "2.11.7 plugins" at "https://oss.sonatype.org/content/repositories/orgscala-lang-1230/org/"
)

scalaVersion := "2.11.7"

libraryDependencies += "org.scala-lang.modules" %% "scala-java8-compat" % "0.5.0"

scalacOptions ++= List("-Ybackend:GenBCode", "-Ydelambdafy:method", "-target:jvm-1.8", "-Yopt:l:classpath")
