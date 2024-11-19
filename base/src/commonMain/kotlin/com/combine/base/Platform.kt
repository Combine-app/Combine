package com.combine.base

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform