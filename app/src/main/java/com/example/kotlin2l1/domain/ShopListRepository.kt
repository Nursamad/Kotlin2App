package com.example.kotlin2l1.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun getShopList(): LiveData<List<ShopItem>>

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopList(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem
}