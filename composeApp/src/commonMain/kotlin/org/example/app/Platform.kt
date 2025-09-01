package org.example.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform