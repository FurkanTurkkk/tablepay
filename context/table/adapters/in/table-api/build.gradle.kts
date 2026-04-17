dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation(project(":table-application"))

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}