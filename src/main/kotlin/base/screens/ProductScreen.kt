package base.screens

import base.element.TextField
import base.screen.BaseScreen
import io.appium.java_client.AppiumBy

class ProductScreen: BaseScreen(TextField(AppiumBy.id("com.zdv.secretcloset:id/rlBasicInfo"), "product screen")) {

    private val seller = getIFactory().getTextField(AppiumBy.id("com.zdv.secretcloset:id/tvItemSellerName"), "seller")
    private val city = getIFactory().getTextField(AppiumBy.id("com.zdv.secretcloset:id/tvItemSellerCity"), "seller city")

    fun getSellerNameAndCity(): List<String> {
        val data: MutableList<String> = ArrayList()
        data.add(seller.getText())
        data.add(city.getText())
        return data
    }

    fun clickOnSeller() {
        seller.click()
    }
}