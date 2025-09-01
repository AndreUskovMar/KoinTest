package ru.auskov.kointest.di

// import org.koin.core.module.dsl.factoryOf
// import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.scopedOf
import org.koin.dsl.module
import ru.auskov.kointest.MainActivity
import ru.auskov.kointest.data.BTConnection
import ru.auskov.kointest.data.MainConnection

val mainModule = module {
    // singleOf(::MainConnection)
    // singleOf(::BTConnection)

    scope<MainActivity> {
        scopedOf(::MainConnection)
        scopedOf(::BTConnection)
    }
}