package com.example.tetsideaplatform

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.tetsideaplatform.domain.ItemRepository
import com.example.tetsideaplatform.domain.model.ItemDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val itemInteractor: ItemRepository
): ViewModel() {


    fun getItems() = itemInteractor.getItemList()

    private val _searchItem = MutableStateFlow("")

    fun searchItem (string: String){
        _searchItem.value = string
    }


    fun deleteItem(item: ItemDomain){
        viewModelScope.launch {
            itemInteractor.dellItem(item)
        }
    }

    fun editItem(item: ItemDomain){
        viewModelScope.launch {
            itemInteractor.editItem(item)
        }
    }

}