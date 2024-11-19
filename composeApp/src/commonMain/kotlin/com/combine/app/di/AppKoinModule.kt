package com.combine.app.di

import com.combine.app.AppScreenModel
import org.koin.dsl.module

val appModule = module {
    factory { AppScreenModel() }
}