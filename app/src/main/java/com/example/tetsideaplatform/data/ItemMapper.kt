package com.example.tetsideaplatform.data

import androidx.room.TypeConverter
import com.example.tetsideaplatform.domain.model.ItemDomain
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ItemMapper @Inject constructor()  {


    fun mapEntityToDto(item: ItemDomain)= ItemDto(
        id = item.id,
        name = item.name,
        time = item.time,
        tags = Converters.fromListToString(item.tags),
        amount = item.amount
    )

    fun mapDbModetToEntity(itemDto: ItemDto )= ItemDomain(
        id = itemDto.id?:0,
        name = itemDto.name.orEmpty(),
        time = itemDto.time?:0,
        tags = Converters.fromStringToList(itemDto.tags),
        amount = itemDto.amount?:0
    )

    fun mapListDbModelToListEntity(list: List<ItemDto>)= list.map{
        mapDbModetToEntity(it)
    }

}

object Converters {

    // other converters

    @TypeConverter
    @JvmStatic
    fun fromListToString(list: List<String>): String {
        return Gson().toJson(list) as String
    }

    @TypeConverter
    @JvmStatic
    fun fromStringToList(value: String?): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }


}