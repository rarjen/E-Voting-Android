package com.example.evoting.di

import com.example.evoting.api.APIClient
import com.example.evoting.repository.MyRepository
import com.example.evoting.viewmodel.MyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinModule {
    val dataModule
        get() = module {
            single { APIClient.instance }

            factory { MyRepository() }
        }

    val uiModule
        get() = module {
            viewModel { MyViewModel(get()) }
        }
}