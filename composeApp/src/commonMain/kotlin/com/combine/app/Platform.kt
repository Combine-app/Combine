package com.combine.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform