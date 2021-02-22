import sbt._

object Dependencies {
  lazy val akkaHttpVersion = "10.1.8"
  lazy val akkaVersion = "2.5.25"
  lazy val graalAkkaVersion = "0.5.0"

  lazy val libraries = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.github.vmencik" %% "graal-akka-http" % graalAkkaVersion
  )
}