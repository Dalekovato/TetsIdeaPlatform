package com.example.tetsideaplatform.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.tetsideaplatform.domain.ItemRepository
import com.example.tetsideaplatform.domain.model.ItemDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
    private val mapper: ItemMapper
): ItemRepository {



    override suspend fun dellItem(item: ItemDomain) = itemDao.deleteItem(item.id)


    override suspend fun editItem(item: ItemDomain) = itemDao.editItem(mapper.mapEntityToDto(item))

        override fun getItemList(): Flow<List<ItemDomain>> = itemDao.getItems().map {
            it.map {
                mapper.mapDbModetToEntity(it)
            }
        }


//    override fun getItemList(): LiveData<List<ItemDomain>> = MediatorLiveData<List<ItemDomain>>().apply {
//        addSource(itemDao.getItems()){
//            value = mapper.mapListDbModelToListEntity(it)
//        }
//    }


}