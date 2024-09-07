package com.example.tetsideaplatform.data

import com.example.tetsideaplatform.data.db.ItemDao
import com.example.tetsideaplatform.data.db.toEntity
import com.example.tetsideaplatform.data.db.toModel
import com.example.tetsideaplatform.domain.model.Item
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
):ItemRepository {

    override val itemList: Flow<List<Item>>
        get() = itemDao.getItems().map { it -> it.map { it.toEntity() } }

    override fun changeAmount(goods: Item) {
        itemDao.updateItem(goods.toModel())
    }

    override fun deleteItem(goods: Item) {
        itemDao.deleteItem(goods.toModel())
    }

}