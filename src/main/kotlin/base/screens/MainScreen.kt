package base.screens

import base.element.Button
import base.element.TextField
import base.screen.BaseScreen
import io.appium.java_client.AppiumBy

class MainScreen: BaseScreen(TextField(AppiumBy.id("com.zdv.secretcloset:id/rlTop"), "main screen")) {

    private var city = getIFactory().getButton(AppiumBy.id("com.zdv.secretcloset:id/tvToolbarCity"), "city choice")
    private val currentProductLocator =
        "//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvDiscount']//ancestor::android.widget.RelativeLayout[@resource-id='com.zdv.secretcloset:id/rlBanner']"

    fun openCityChoice() {
        city.click()
    }

    fun getCityName(currentCity: String): Boolean {
        return getIFactory().getTextField(
            AppiumBy.androidUIAutomator("resourceId(\"com.zdv.secretcloset:id/tvToolbarCity\").text(\"$currentCity\")"),
            "city choice"
        ).isEnabled()
    }

    fun getSumm(): String {
        return getIFactory().getTextFields(
            AppiumBy.xpath("$currentProductLocator//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvSumm']"),
            "summ")[0].getText()
    }

    fun getPrice(): String {
        return getIFactory().getTextFields(
            AppiumBy.xpath("$currentProductLocator//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvPrice']"),
            "price")[0].getText()
    }

    fun clickOnProduct() {
        getIFactory().getTextFields(
            AppiumBy.xpath(currentProductLocator),
            "current product")[0].click()
    }
}