package com.example.tetsideaplatform.domain.model


data class ItemDomain (

    val id: Int ,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int,

)