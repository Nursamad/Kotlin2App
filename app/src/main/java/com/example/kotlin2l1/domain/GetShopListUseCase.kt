package com.example.kotlin2l1.domain

class GetShopListUseCase(private val repository: ShopListRepository) {
    fun getShopList() = repository.getShopList()
}