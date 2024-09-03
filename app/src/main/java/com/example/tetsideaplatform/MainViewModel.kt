package com.example.tetsideaplatform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tetsideaplatform.domain.ItemInteractorImpl
import com.example.tetsideaplatform.domain.model.ItemDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
private val itemInteractorImpl: ItemInteractorImpl
): ViewModel() {






    private val _searchItem = MutableStateFlow("")


    val itemList = itemInteractorImpl.getItemList()


    fun searchItem (string: String){
        _searchItem.value = string
    }


    fun deleteItem(item: ItemDomain){
        viewModelScope.launch {
            itemInteractorImpl.dellItem(item)
        }
    }

    fun editItem(item: ItemDomain){
        viewModelScope.launch {
            itemInteractorImpl.editItem(item)
        }
    }

}