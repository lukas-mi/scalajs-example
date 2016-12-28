name := "scalajs-example"

version := "1.0"

scalaVersion := "2.11.0"

libraryDependencies ++= Seq(
  "org.scala-js"  %   "scalajs-dom_sjs0.6_2.11" % "0.9.0",
  "be.doeraene"   %%% "scalajs-jquery"          % "0.9.1",
  "com.lihaoyi"   %%% "utest"                   % "0.4.4" % "test"
)

jsDependencies ++= Seq(
  "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js",
  // make the DOM available (so run and test works)
  RuntimeDOM
)

testFrameworks += new TestFramework("utest.runner.Framework")

lazy val root = (project in file(".")).enablePlugins(ScalaJSPlugin)

// uses FullOptStage instead of FastOptStage in run and test
// set scalaJSStage in Global := FullOptStage <- in sbt console

// can use tutorial-launcher.js without calling main method explicitly (it's already called in launcher)
persistLauncher in Compile := true

persistLauncher in Test := false

skip in packageJSDependencies := false

//mainClass in (Compile, run) := Some("tutorial.webapp.TutorialAppDom")