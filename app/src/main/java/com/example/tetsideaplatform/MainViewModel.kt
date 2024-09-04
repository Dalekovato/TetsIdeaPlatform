package com.example.tetsideaplatform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tetsideaplatform.data.ItemRepositoryImpl
import com.example.tetsideaplatform.domain.ItemRepository
import com.example.tetsideaplatform.domain.model.ItemDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemRepository: ItemRepositoryImpl
): ViewModel() {

    private val _items = MutableStateFlow<List<ItemDomain>>(emptyList())
    val items: StateFlow<List<ItemDomain>> = _items.asStateFlow()

    init {
        viewModelScope.launch {
            itemRepository.getItemList().collect {
                _items.value = it
            }
        }
    }

    val _searchItem = MutableStateFlow("")

    fun searchItem(string: String) {
        _searchItem.value = string
    }

    fun deleteItem(item: ItemDomain) {
        viewModelScope.launch {
            itemRepository.dellItem(item)
        }
    }

    fun editItem(item: ItemDomain) {
        viewModelScope.launch {
            itemRepository.editItem(item)
        }
    }
}
