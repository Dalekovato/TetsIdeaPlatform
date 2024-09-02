package com.example.tetsideaplatform.domain

import androidx.lifecycle.LiveData
import com.example.tetsideaplatform.domain.model.ItemDomain

interface ItemRepository {

    suspend fun dellItem(item: ItemDomain)

    suspend fun editItem(item: ItemDomain)

    fun getItemList(): LiveData<List<ItemDomain>>
}