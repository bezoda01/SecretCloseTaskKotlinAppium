package base.driver

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.remote.DesiredCapabilities
import settings.Settings
import utils.JsonUtils
import java.net.URL
import java.time.Duration

class Driver {

    companion object {
        var driver: AndroidDriver? = null
        
        internal fun getDriver(): AndroidDriver {
            if (driver == null) {
                driver = getInstance()
                if (Settings.timeouts!!["timeoutImplicit"] as Long > 0) {
                    driver!!.manage().timeouts()
                        .implicitlyWait(Duration.ofSeconds((Settings.timeouts["timeoutImplicit"] as Long?)!!))
                }
            }
            return driver as AndroidDriver
        }

        fun getInstance(): AndroidDriver {
            val capabilities = DesiredCapabilities()
            val map: HashMap<String, String> = JsonUtils.convertCapsToMap()
            for (st in map.keys) {
                capabilities.setCapability(st, map.get(st))
            }
            return AndroidDriver(URL(Settings.config!!.get("urlAppium").toString()), capabilities)
        }
    }
}