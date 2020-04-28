plugins {
    java
    application
}

val javaVersion: JavaVersion by rootProject.extra

java {
    sourceCompatibility = javaVersion
}

application {
    mainClassName = "jeff.app.homework.console.App"
}

dependencies {
    implementation(project(":chat-engine"))
}
