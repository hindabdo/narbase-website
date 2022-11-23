buildscript {

    repositories {
        jcenter()
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    }
}

group = "com.narbase.bos.web"
version = "0.1.0"
val kotlinVersion = "1.4.32"

plugins {
    id("org.jetbrains.kotlin.js")
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(project(":narsite-common"))
    implementation("com.narbase.kunafa:core:0.3.0-beta.7")
//    implementation("com.narbase:kunafa:0.3.0-beta.4")

    testImplementation("org.jetbrains.kotlin:kotlin-test-js:$kotlinVersion")

}

kotlin {
    js {
        browser {
//            distribution {
//                directory = File("${projectDir.parent}/public/js/client/")
//            }
        }
        binaries.executable()

//        compilations.all {
//            kotlinOptions {
//                sourceMap = true
//                sourceMapEmbedSources = "always"
//            }
//        }
    }
}
