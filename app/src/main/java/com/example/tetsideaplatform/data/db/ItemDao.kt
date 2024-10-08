package com.example.tetsideaplatform.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    //Вызов списка товаров для отображения
    @Query("SELECT * FROM item")
    fun getItems(): Flow<List<ItemDb>>

    //Удаление товара из базы данных
    @Delete
    fun deleteItem(item: ItemDb)

    //Изменение количества товара в базе данных
    @Update
    fun updateItem(item: ItemDb)



}