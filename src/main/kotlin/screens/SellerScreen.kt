package screens

import base.element.TextField
import base.screen.BaseScreen
import base.waits.TypeWait
import io.appium.java_client.AppiumBy

class SellerScreen: BaseScreen(TextField(AppiumBy.id("com.zdv.secretcloset:id/textMemberTitle"), "seller screen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)) {

    private val name = getIFactory().getTextField(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.zdv.secretcloset:id/toolbar']//android.widget.TextView"), "seller name", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)
    private val city = getIFactory().getTextField(AppiumBy.id("com.zdv.secretcloset:id/tvItemSellerCity"), "seller city", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)

    fun getNameAndCity(): List<String> {
        val data: MutableList<String> = ArrayList()
        data.add(name.getText())
        data.add(city.getText())
        return data
    }
}