plugins {
    java
    application
}

val javaVersion: JavaVersion by rootProject.extra
val junitVersion: String by rootProject.extra
val mockitoVersion: String by rootProject.extra

java {
    sourceCompatibility = javaVersion
}

application {
    mainClassName = "jeff.app.homework.console.ConsoleApplication"
}

dependencies {
    implementation(project(":chat-engine"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}
