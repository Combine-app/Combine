package com.combine.login.di

import com.combine.login.presentation.LoginScreenImpl
import com.combine.login.presentation.LoginScreenModel
import com.combine.navigation.destinations.LoginScreen
import org.koin.dsl.module

val loginModule = module {
    factory<LoginScreen> { LoginScreenImpl() }
    factory { LoginScreenModel() }
}