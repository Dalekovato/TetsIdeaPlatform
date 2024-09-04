package com.example.tetsideaplatform.domain

import androidx.lifecycle.LiveData
import com.example.tetsideaplatform.domain.model.ItemDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemInteractorImpl @Inject constructor(private val itemRepository: ItemRepository) {

    fun getItemList(): Flow<List<ItemDomain>> {
        return itemRepository.getItemList()
    }

    suspend fun dellItem(shopItem: ItemDomain) {
        itemRepository.dellItem(shopItem)
    }
    suspend fun editItem(shopItem: ItemDomain){
        itemRepository.editItem(shopItem)
    }


}