package base.screens

import base.element.Button
import base.element.TextField
import base.screen.BaseScreen
import base.waits.TypeWait
import io.appium.java_client.AppiumBy
import utils.RandomUtils

class CityChoiceScreen: BaseScreen(TextField(AppiumBy.id("com.zdv.secretcloset:id/lvSearchList"), "city choice sceen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)) {

    private var ok: Button = getIFactory().getButton(AppiumBy.id("android:id/button1"), "allow", TypeWait.PRESENCE_OF_ELEMENT_LOCATED)
    private lateinit var currentCity: Button

    fun allowAlert() {
        ok.click()
    }

    fun getCitiesAndGetRandom(): String {
        val cities: List<Button> = getIFactory().getButtons(AppiumBy.id("com.zdv.secretcloset:id/tvCityItemName"),
            "all cities", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED)
        currentCity = cities.get(RandomUtils.getRandomNumber(cities.size))
        return currentCity.getText()
    }

    fun clickOnCurrentCity() {
        currentCity.click()
    }
}