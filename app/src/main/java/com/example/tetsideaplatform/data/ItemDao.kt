package com.example.tetsideaplatform.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
    fun getItems(): Flow<List<ItemDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun editItem(itemDto: ItemDto)


    @Query("DELETE FROM item WHERE id =:itemId")
    suspend fun deleteItem(itemId: Int)



}