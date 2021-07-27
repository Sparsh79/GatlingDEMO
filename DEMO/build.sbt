name := "DEMO"

version := "0.1"

scalaVersion := "2.12.10"
val gatlingHighchartsVersion = "3.0.0"
val gatlingFrameworkVersion = "3.0.0"
val typesafeVersion = "0.13.15"
enablePlugins(GatlingPlugin)
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingHighchartsVersion % "test,it"
libraryDependencies += "io.gatling" % "gatling-test-framework" % gatlingFrameworkVersion % "test,it"
libraryDependencies += "com.typesafe.sbt" % "sbt-interface" % typesafeVersion