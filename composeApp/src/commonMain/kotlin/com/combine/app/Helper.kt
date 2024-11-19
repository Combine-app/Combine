package com.combine.app

import com.combine.app.di.appModule
import com.combine.chain.di.chainModule
import com.combine.home.di.homeModule
import com.combine.login.di.loginModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(appModule)
        modules(chainModule)
        modules(homeModule)
        modules(loginModule)
    }
}