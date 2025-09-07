package ru.auskov.kointest.di

import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.auskov.kointest.MainViewModel
import ru.auskov.kointest.data.BTConnection
import ru.auskov.kointest.data.MainConnection

val mainModule = module {
    factoryOf(::BTConnection)
    factoryOf(::MainConnection)
    viewModelOf(::MainViewModel)
}