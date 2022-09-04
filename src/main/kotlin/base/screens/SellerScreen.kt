package base.screens

import base.element.TextField
import base.screen.BaseScreen
import io.appium.java_client.AppiumBy

class SellerScreen: BaseScreen(TextField(AppiumBy.id("com.zdv.secretcloset:id/textMemberTitle"), "seller screen")) {

    private val name = getIFactory().getTextField(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.zdv.secretcloset:id/toolbar']//android.widget.TextView"), "seller name")
    private val city = getIFactory().getTextField(AppiumBy.id("com.zdv.secretcloset:id/tvItemSellerCity"), "seller city")

    fun getNameAndCity(): List<String> {
        val data: MutableList<String> = ArrayList()
        data.add(name.getText())
        data.add(city.getText())
        return data
    }
}