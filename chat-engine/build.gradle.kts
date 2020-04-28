plugins {
    java
}

val javaVersion: JavaVersion by rootProject.extra
val junitVersion: String by rootProject.extra

java {
    sourceCompatibility = javaVersion
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
