plugins {
    id("org.jetbrains.kotlin.js") version "1.4.32"
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

allprojects {
    group = "com.mrpowergamerbr.openrct2kotlinapi"
}

subprojects {
    apply<MavenPublishPlugin>()

    publishing {
        repositories {
            maven {
                name = "PerfectDreams"
                url = uri("https://repo.perfectdreams.net/")

                credentials {
                    username = System.getProperty("USERNAME") ?: System.getenv("USERNAME")
                    password = System.getProperty("PASSWORD") ?: System.getenv("PASSWORD")
                }
            }
        }
    }
}

kotlin {
    js(LEGACY) {
        browser {
        }
        // binaries.executable()
    }
}