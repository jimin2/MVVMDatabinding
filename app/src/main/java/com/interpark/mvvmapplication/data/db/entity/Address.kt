package com.interpark.mvvmapplication.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.interpark.mvvmapplication.data.remote.domain.AddressData

/**
 * Room 데이터베이스에 사용될 데이터 모델
 */
@Entity(tableName = "address")
data class Address(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "address")
    var address: String = "",
    @ColumnInfo(name = "date")
    var date: Int = 0
){
    companion object {
        fun to(addressData: AddressData): Address {
            return Address(
                name = addressData.name,
                address = addressData.address,
                date = addressData.date
            )
        }
    }
}