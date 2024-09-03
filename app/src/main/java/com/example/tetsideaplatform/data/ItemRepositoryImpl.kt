package com.example.tetsideaplatform.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.tetsideaplatform.domain.ItemRepository
import com.example.tetsideaplatform.domain.model.ItemDomain

class ItemRepositoryImpl (
    private val itemDao: ItemDao,
    private val mapper: ItemMapper
): ItemRepository {



    override suspend fun dellItem(item: ItemDomain) {
        itemDao.deleteItem(item.id)
    }

    override suspend fun editItem(item: ItemDomain) {
        itemDao.editItem(mapper.mapEntityToDto(item))
    }

    override fun getItemList(): LiveData<List<ItemDomain>> = MediatorLiveData<List<ItemDomain>>().apply {
        addSource(itemDao.getItems()){
            value = mapper.mapListDbModelToListEntity(it)
        }
    }


}