plugins {
    id("java")
}

group = "es.angelillo15"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.nookure.com/repository/maven-public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    compileOnly("es.angelillo15:MAStaff-API:2.1.0-beta2")
    compileOnly("org.yaml:snakeyaml:1.33")
    compileOnly("com.github.Carleslc.Simple-YAML:Simple-Yaml:1.8.3")
    compileOnly("org.spigotmc:spigot-api:1.13-R0.1-SNAPSHOT")
}

tasks.processResources {
    filesMatching("addon.properties") {
        expand("version" to (parent?.version ?: project.version))
    }
}