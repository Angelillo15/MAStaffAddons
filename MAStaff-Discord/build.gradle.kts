plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "4.0.4"
}

group = "es.angelillo15"
version = "1.1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.nookure.com/repository/maven-public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("es.angelillo15:MAStaff-API:2.2.0-beta1")
    compileOnly("org.yaml:snakeyaml:1.33")
    compileOnly("com.github.Carleslc.Simple-YAML:Simple-Yaml:1.8.3")
    compileOnly("org.spigotmc:spigot-api:1.13-R0.1-SNAPSHOT")
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    compileOnly("io.github.waterfallmc:waterfall-api:1.19-R0.1-SNAPSHOT")
}

tasks.processResources {
    filesMatching("addon.properties") {
        expand("version" to (project.version))
    }

    filesMatching("addon-bungee.properties") {
        expand("version" to (project.version))
    }
}

tasks.shadowJar {
    relocate("org.yaml.snakeyaml", "es.angelillo15.mast.libs.snakeyaml")
    relocate("org.simpleyaml", "es.angelillo15.mast.libs.simpleyaml")
}