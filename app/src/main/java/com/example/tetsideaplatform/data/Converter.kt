package com.example.tetsideaplatform.data

import androidx.room.TypeConverter
import org.json.JSONArray

class Converter {

    @TypeConverter
    fun fromTagsList(tags: List<String>): String {
        return JSONArray(tags).toString()
    }

    @TypeConverter
    fun toTagsList(tagsString: String): List<String> {
        val jsonArray = JSONArray(tagsString)
        val list = mutableListOf<String>()
        for (i in 0 until jsonArray.length()) {
            list.add(jsonArray.getString(i))
        }
        return list
    }

}