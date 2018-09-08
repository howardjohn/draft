val Http4sVersion = "0.19.0-M1"

lazy val root = (project in file("."))
  .settings(
    name := "example-scala",
    scalaVersion := "2.12.6",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
      "org.http4s" %% "http4s-dsl"          % Http4sVersion,
    )
  )
