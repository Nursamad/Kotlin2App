package com.example.kotlin2l1.domain

class AddShopItemUseCase(private val repository: ShopListRepository) {
    fun addShopItem(shopItem: ShopItem) {
        repository.addShopItem(shopItem)
    }
}