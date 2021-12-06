ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.12"

/* We are providing the classpath because our modules are dependent on each other */
lazy val root = (project in file(".")).aggregate(questionOneAndTwo, questionThree)
  .settings(
    name := "UT_IT"
  )

lazy val questionOneAndTwo = project.in(file("questionOneAndTwo"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )

lazy val questionThree = project.in(file("questionThree"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )


