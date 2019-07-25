package com.interpark.mvvmapplication.di

import com.interpark.mvvmapplication.data.db.AddressDatabase
import com.interpark.mvvmapplication.data.db.dao.AddressDao
import com.interpark.mvvmapplication.data.db.entity.Address
import com.interpark.mvvmapplication.ui.main.AddressViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * single로 선언된 블록 안에 초기화 코드 넣음
 * -> single instance만 제공함
 * 이렇게 작성된 module은 application 시작할때 startKoin을 통해 인자로 넘겨주면 됨
 */
val roomModule = module {
    single { AddressDatabase.getInstance(androidApplication()) }
    single(createOnStart = false)  { get<AddressDatabase>().getAddressDao() }
}