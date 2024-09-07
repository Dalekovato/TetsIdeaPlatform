package com.example.tetsideaplatform.data

import com.example.tetsideaplatform.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    val itemList: Flow<List<Item>>

    fun changeAmount(goods: Item)

    fun deleteItem(goods: Item)

}