import base.screens.CityChoiceScreen
import base.screens.MainScreen
import base.screens.ProductScreen
import base.screens.SellerScreen
import org.testng.Assert
import org.testng.annotations.Test
import utils.StringUtils

class TestScenario {

    @Test
    fun test() {
        val mainScreen = MainScreen()
        Assert.assertTrue(mainScreen.isDisplayed(), "Main screen didn't open")
        mainScreen.openCityChoice()
        val cityChoiceScreen = CityChoiceScreen()
        cityChoiceScreen.allowAlert()
        val city: String = cityChoiceScreen.getCitiesAndGetRandom()
        cityChoiceScreen.clickOnCurrentCity()
        Assert.assertTrue(mainScreen.getCityName(city), "City didn't choice")
        Assert.assertTrue(
            StringUtils.splitString(mainScreen.getSumm(), " ").toInt() > StringUtils.splitString(
                mainScreen.getPrice(),
                " "
            ).toInt(), "price and discount didn't correct"
        )
        mainScreen.clickOnProduct()
        val productScreen = ProductScreen()
        Assert.assertTrue(productScreen.isDisplayed(), "product screen didn't open")
        val productData: List<String> = productScreen.getSellerNameAndCity()
        productScreen.clickOnSeller()
        val sellerScreen = SellerScreen()
        Assert.assertTrue(sellerScreen.isDisplayed(), "Seller screen didn't open")
        Assert.assertEquals(sellerScreen.getNameAndCity(), productData, "seller name and city not correct")
    }
}