package com.interpark.mvvmapplication.data.db.dao

import androidx.paging.DataSource
import androidx.room.*
import com.interpark.mvvmapplication.data.db.entity.Address

/**
 * data access object로 실 데이터에 접근하도록 도와주는 helper 클래스
 */
@Dao
interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(address: Address)

    @Delete
    fun delete(address: Address)

    /**
     *  데이터를 조회하고 수정, 삭제하여 상태가 변화되면 UI에서 변화된 상태를 받기 위해 LiveData 사용
     */
    @Query("SELECT * FROM address ORDER BY date DESC")
    fun getAllAddress(): DataSource.Factory<Int, Address>
}