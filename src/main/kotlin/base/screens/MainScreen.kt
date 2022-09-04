package base.screens

import base.element.TextField
import base.screen.BaseScreen
import base.waits.TypeWait
import io.appium.java_client.AppiumBy

class MainScreen: BaseScreen(TextField(AppiumBy.id("com.zdv.secretcloset:id/rlTop"), "main screen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)) {

    private var city = getIFactory().getButton(AppiumBy.id("com.zdv.secretcloset:id/tvToolbarCity"), "city choice", TypeWait.TO_BE_CLICKABLE)
    private val currentProductLocator =
        "//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvDiscount']//ancestor::android.widget.RelativeLayout[@resource-id='com.zdv.secretcloset:id/rlBanner']"

    fun openCityChoice() {
        city.click()
    }

    fun getCityName(currentCity: String): Boolean {
        return getIFactory().getTextField(
            AppiumBy.androidUIAutomator("resourceId(\"com.zdv.secretcloset:id/tvToolbarCity\").text(\"$currentCity\")"),
            "city choice", TypeWait.PRESENCE_OF_ELEMENT_LOCATED).isEnabled()
    }

    fun getSumm(): String {
        return getIFactory().getTextFields(
            AppiumBy.xpath("$currentProductLocator//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvSumm']"),
            "summ", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED)[0].getText()
    }

    fun getPrice(): String {
        return getIFactory().getTextFields(
            AppiumBy.xpath("$currentProductLocator//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvPrice']"),
            "price", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED)[0].getText()
    }

    fun clickOnProduct() {
        getIFactory().getTextFields(
            AppiumBy.xpath(currentProductLocator),
            "current product", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED)[0].click()
    }
}