package com.example.tetsideaplatform.domain

import androidx.lifecycle.LiveData
import com.example.tetsideaplatform.domain.model.ItemDomain

class ItemInteractorImpl(private val itemRepository: ItemRepository) {


    suspend fun dellItem(shopItem: ItemDomain) {
        itemRepository.dellItem(shopItem)
    }
    suspend fun editItem(shopItem: ItemDomain){
        itemRepository.editItem(shopItem)
    }
    fun getItemList(): LiveData<List<ItemDomain>> {
        return itemRepository.getItemList()
    }

}