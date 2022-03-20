package com.example.kotlin2l1.domain

class EditShopItemUseCase(private val repository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem) {
        repository.editShopList(shopItem)
    }
}