package base.screens

import base.element.TextField
import base.screen.BaseScreen
import base.waits.TypeWait
import io.appium.java_client.AppiumBy

class ProductScreen: BaseScreen(TextField(AppiumBy.id("com.zdv.secretcloset:id/rlBasicInfo"), "product screen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)) {

    private val seller = getIFactory().getTextField(AppiumBy.id("com.zdv.secretcloset:id/tvItemSellerName"), "seller", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)
    private val city = getIFactory().getTextField(AppiumBy.id("com.zdv.secretcloset:id/tvItemSellerCity"), "seller city", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)

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