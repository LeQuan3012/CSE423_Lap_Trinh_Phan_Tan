plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "javax.jms", name = "javax.jms-api", version = "2.0.1")
    implementation(group = "org.apache.activemq", name = "activemq-core", version = "5.7.0")
    implementation("ch.qos.logback:logback-classic:1.4.12")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}


tasks.test {
    useJUnitPlatform()
}