package screens

import base.element.Button
import base.element.TextField
import base.screen.BaseScreen
import base.waits.TypeWait
import io.appium.java_client.AppiumBy

class CityChoiceScreen: BaseScreen(TextField(AppiumBy.id("com.zdv.secretcloset:id/lvSearchList"), "city choice sceen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)) {

    private var ok = getIFactory().getButton(AppiumBy.id("android:id/button1"), "allow", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)
    private lateinit var currentCity: Button

    fun allowAlert() {
        ok.click()
    }

    fun getCitiesAndGetRandom(): String {
        val cities = getIFactory().getButtons(AppiumBy.id("com.zdv.secretcloset:id/tvCityItemName"),
            "all cities", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED)
        currentCity = cities.random()
        return currentCity.getText()
    }

    fun clickOnCurrentCity() {
        currentCity.click()
    }
}