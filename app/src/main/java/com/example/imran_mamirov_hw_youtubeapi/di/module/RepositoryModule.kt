package com.example.imran_mamirov_hw_youtubeapi.di.module

import com.example.imran_mamirov_hw_youtubeapi.data.repository.Repository
import org.koin.dsl.module

val RepositoryModule = module  {
    factory {
        Repository(get())
    }
}