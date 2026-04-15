import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "3.2.4"
    id("org.flywaydb.flyway") version "9.22.3"
}

tasks.withType<BootJar>().configureEach {
    archiveFileName.set("tablepay.jar")
}

flyway {
    url = "jdbc:postgresql://localhost:5432/tablepay"
    user = "tablepay"
    password = "tablepay"
    locations = arrayOf("filesystem:src/main/resources/db/migration")
}

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.2.4"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.flywaydb:flyway-core")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}