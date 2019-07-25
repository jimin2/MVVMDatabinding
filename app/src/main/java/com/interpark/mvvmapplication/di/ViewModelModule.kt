package com.interpark.mvvmapplication.di

import com.interpark.mvvmapplication.ui.main.AddressViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { AddressViewModel(get()) }
}
