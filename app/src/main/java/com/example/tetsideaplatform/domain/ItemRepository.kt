package com.example.tetsideaplatform.domain

import androidx.lifecycle.LiveData
import com.example.tetsideaplatform.domain.model.ItemDomain
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    suspend fun dellItem(item: ItemDomain)

    suspend fun editItem(item: ItemDomain)

    fun getItemList(): Flow<List<ItemDomain>>
}