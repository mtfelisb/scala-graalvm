lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization    := "com.github.mtfelisb",
      scalaVersion    := "2.13.0"
    )),
    name := "scala-graalvm",
    libraryDependencies ++= Dependencies.libraries
  )

resolvers += Resolver.sonatypeRepo("releases")

enablePlugins(GraalVMNativeImagePlugin)

graalVMNativeImageOptions ++= Seq(
  "-H:IncludeResources=.*\\.properties",
   "-H:ReflectionConfigurationFiles=" + baseDirectory.value / "graal" / "reflect.json",
    "--initialize-at-build-time",
    "--initialize-at-run-time=" +
    "akka.protobuf.DescriptorProtos," +
    "com.typesafe.config.impl.ConfigImpl$EnvVariablesHolder," +
    "com.typesafe.config.impl.ConfigImpl$SystemPropertiesHolder",
    "--no-fallback",
    "--allow-incomplete-classpath"
)