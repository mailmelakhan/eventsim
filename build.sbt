

name := "eventsim"

version := "1.0"

resolvers +=
  "Confluent IO" at "https://packages.confluent.io/maven/"

libraryDependencies += "org.apache.commons" % "commons-math3" % "3.5"

libraryDependencies += "de.jollyday" % "jollyday" % "0.5.1"

libraryDependencies += "org.rogach" %% "scallop" % "6.0.0"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.6.1"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.1"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "3.7.1"

libraryDependencies += "com.lihaoyi" %% "upickle" % "3.1.0"

libraryDependencies += "com.google.cloud.hosted.kafka" % "managed-kafka-auth-login-handler" % "1.0.6" excludeAll(
  ExclusionRule(organization = "io.confluent", name = "kafka-schema-registry-client")
  )

assembly / assemblyMergeStrategy := {
  case PathList("module-info.class") => MergeStrategy.discard
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  //case PathList("javax", "xml", "bind", ps @ _*) => MergeStrategy.first
  case other                         => (assembly / assemblyMergeStrategy).value(other) // Use the default strategy for other files
}