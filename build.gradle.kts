allprojects {
    repositories {
        jcenter()
    }
}

subprojects {
    version = "1.0"
}

val javaVersion by extra(JavaVersion.VERSION_11)
val junitVersion by extra("5.6.2")
