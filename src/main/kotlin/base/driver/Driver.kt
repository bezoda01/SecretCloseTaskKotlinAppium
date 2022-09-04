package base.driver

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.remote.DesiredCapabilities
import settings.Settings
import utils.JsonUtils
import java.net.URL

class Driver {

    companion object {
        var driver: AndroidDriver? = null
        
        internal fun getDriver(): AndroidDriver {
            val capabilities = DesiredCapabilities()
            val map: HashMap<String, String> = JsonUtils.convertCapsToMap()
            for (st in map.keys) {
                capabilities.setCapability(st, map.get(st))
            }
            if (driver == null) {
                driver = AndroidDriver(URL(Settings.config!!.get("urlAppium").toString()), capabilities)
            }
            return driver as AndroidDriver
        }
    }
}