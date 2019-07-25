package com.interpark.mvvmapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.interpark.mvvmapplication.core.BaseViewModel
import com.interpark.mvvmapplication.data.db.dao.AddressDao
import com.interpark.mvvmapplication.data.db.entity.Address
import com.interpark.mvvmapplication.data.remote.domain.AddressData
import com.interpark.mvvmapplication.extension.ioThread

class AddressViewModel (private val dao: AddressDao) : BaseViewModel() {
    val items: LiveData<PagedList<Address>> = LivePagedListBuilder(dao.getAllAddress(),  /* page size */ 10).build()

    fun delete(address: Address) = ioThread { dao.delete(address) }

    fun saveToBookmark(addressData: AddressData) = ioThread { dao.insert(Address.to(addressData)) }
}