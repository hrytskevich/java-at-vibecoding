plugins {
    id("java")
}

group = "com.lesson.homework"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    testCompileOnly("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    testImplementation("com.fasterxml.jackson.core:jackson-annotations:2.17.0")
    testImplementation("com.codeborne:selenide:7.5.0")
    testImplementation("io.cucumber:cucumber-java:7.18.0")
    testImplementation("io.cucumber:cucumber-junit:7.18.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.18.0")
    testImplementation("org.junit.platform:junit-platform-suite:1.10.3")

}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}