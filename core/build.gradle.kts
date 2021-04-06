plugins {
    id("org.jetbrains.kotlin.js")
    `maven-publish`
}

version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(project(":openrct2-dukat"))
}

kotlin {
    js(LEGACY) {
        browser {}
    }
}

publishing {
    publications {
        register("PerfectDreams", MavenPublication::class.java) {
            from(components["kotlin"])
        }
    }
}