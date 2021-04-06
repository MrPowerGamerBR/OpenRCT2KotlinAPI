plugins {
    id("org.jetbrains.kotlin.js")
    `maven-publish`
}

// Matches OpenRCT2 Version
version = "0.3.3"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

kotlin {
    js(LEGACY) {
        browser {
        }
        // binaries.executable()
    }
}

publishing {
    publications {
        register("PerfectDreams", MavenPublication::class.java) {
            from(components["kotlin"])
        }
    }
}