scalaVersion := "2.11.8"

libraryDependencies += "org.scala-lang.modules" %% "scala-java8-compat" % "0.7.0"

scalacOptions ++= List("-Ybackend:GenBCode", "-Ydelambdafy:method", "-target:jvm-1.8", "-Yopt:l:classpath")
