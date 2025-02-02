resolvers += Resolver.bintrayIvyRepo("s22s", "sbt-plugins")

addSbtPlugin(
  "org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0" excludeAll (ExclusionRule(organization = "com.danieltrinh"))
)

addSbtPlugin("com.github.sbt" % "sbt-unidoc" % "0.5.0")

addSbtPlugin("com.typesafe" % "sbt-mima-plugin" % "1.0.1")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")

addSbtPlugin("org.hammerlab.sbt" % "assembly" % "5.0.0")

addSbtPlugin("com.geirsson" % "sbt-ci-release" % "1.5.7")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.10")

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.1.2")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.4")
