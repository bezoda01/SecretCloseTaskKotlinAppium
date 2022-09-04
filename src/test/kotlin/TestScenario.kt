import base.driver.Driver
import base.screens.CityChoiceScreen
import base.screens.MainScreen
import base.screens.ProductScreen
import base.screens.SellerScreen
import org.testng.Assert
import org.testng.annotations.Test
import utils.StringUtils
import java.time.Duration
import kotlin.test.assertEquals

class TestScenario {

    @Test
    fun test() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25))
        val mainScreen = MainScreen()
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
        val productData: List<String> = productScreen.getSellerNameAndCity()
        productScreen.clickOnSeller()
        val sellerScreen = SellerScreen()
        assertEquals(sellerScreen.getNameAndCity(), productData, "seller name and city not correct")
    }
}