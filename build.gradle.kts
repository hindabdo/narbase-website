allprojects {
    group = "com.narbase"
    version = "1.0.7"
}

plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.4.32" apply false
    kotlin("jvm") version "1.4.32" apply false
    kotlin("js") version "1.4.32" apply false
}


tasks.register("buildSsr") {
    dependsOn(":narsite-server:jar")
    dependsOn(":narsite-web:build")
    doLast {
        println("Building SSR")
        val releaseDir = File("./releases/$version/")
        val publicReleaseDir = File("./releases/$version/public/")
        val webReleaseDir = File("./releases/$version/public/js/client/")
        releaseDir.deleteRecursively()
        releaseDir.mkdirs()
        publicReleaseDir.mkdirs()
        webReleaseDir.mkdirs()
        File("./public").copyRecursively(publicReleaseDir, overwrite = true)
        webReleaseDir.deleteRecursively()
        File("./narsite-web/build/distributions/").copyRecursively(webReleaseDir, overwrite = true)
        File("./narsite-server/build/libs/narsite-server-$version.jar").copyTo(
            File("${releaseDir.path}/narsite-server.jar"),
            overwrite = true
        )
    }
}
tasks.register("deploySsr") {
    dependsOn("buildSsr")
    doLast {
        exec {
            workingDir = File("$projectDir/releases/")
            executable = "$projectDir/releases/deploy.sh"
            args = listOf("$version")
        }
    }
}

tasks.register("runDev") {
    dependsOn(":narsite-server:build")
    dependsOn(":narsite-web:run")
}