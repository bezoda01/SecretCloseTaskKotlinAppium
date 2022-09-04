package base.waits

import base.driver.Driver
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import settings.Settings
import java.time.Duration

class ExplicitWait(private var locator: By) {

    private val wait = WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Settings.timeouts!!.get("timeoutCondition") as Long))

    fun presenceOfElementLocated() = wait.until(ExpectedConditions.presenceOfElementLocated(locator))

    fun elementToBeClickable() = wait.until(ExpectedConditions.elementToBeClickable(locator))

    fun listPresenceOfElementLocated() = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator))

    fun visibilityOfAllElements() = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator))
}