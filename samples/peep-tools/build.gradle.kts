plugins {
    id("org.jetbrains.kotlin.js")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    api(project(":core"))
}

kotlin {
    js(LEGACY) {
        // Compiled to the browser target, because the browser target uses Webpack so it automatically merges all JS dependencies automatically
        browser {
            commonWebpackConfig {
                // Disable sourceMaps because the comment at the end of the file confuses OpenRCT2, also because OpenRCT2 doesn't use source maps
                this.sourceMaps = false
            }
        }
    }
}