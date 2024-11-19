package com.combine.home.di

import com.combine.home.presentation.HomeScreenImpl
import com.combine.home.presentation.HomeScreenModel
import com.combine.navigation.destinations.HomeScreen
import org.koin.dsl.module

val homeModule = module {
    factory<HomeScreen> { HomeScreenImpl() }
    factory { HomeScreenModel() }
}