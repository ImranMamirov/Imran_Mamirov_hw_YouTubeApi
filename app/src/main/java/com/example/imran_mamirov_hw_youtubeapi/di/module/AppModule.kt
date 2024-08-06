package com.example.imran_mamirov_hw_youtubeapi.di.module

import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module{
    includes(networkModule, ViewModelModule, RepositoryModule)
}