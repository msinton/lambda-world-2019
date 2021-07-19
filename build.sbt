name := "lambd-world"

version := "0.1"

val scala212 = "2.12.10"

lazy val scalaSettings = Seq(
  scalaVersion := scala212,
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding",
    "UTF-8",
    "-feature",
    "-language:experimental.macros",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Ywarn-unused",
    "-Ypartial-unification"
  ),
  scalacOptions in (Compile, console) --= Seq("-Xlint", "-Ywarn-unused"),
  scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value,
  libraryDependencies ++= Seq(
    "org.scalacheck" %% "scalacheck" % "1.14.1" % "test"
  )
)

lazy val testSettings = Seq(
  logBuffered in Test := false
//   parallelExecution in Test := false,
)

lazy val check = project
  .in(file("modules/check"))
  .settings(
    moduleName := "check",
    name := moduleName.value,
    scalaSettings,
    testSettings
  )
