package com.narbase.narnic.main

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


const val isDev = true

fun main() {
    buildServer()
    println("Done")
}

fun buildServer() {
    embeddedServer(Netty, port = 8030, watchPaths = listOf("classes"), module = Application::module).start(wait = true)

}

fun Application.module() {
    install(AutoHeadResponse)
    install(Compression)
    install(PartialContent) {
        maxRangeCount = 10
    }
    routing {
        static("public") {
            files("public")
        }
        get("/") {
            call.respondText(NarsiteLandingPage().get().build(), ContentType.Text.Html)
        }
    }
}