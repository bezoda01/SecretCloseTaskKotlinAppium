package base.element

import base.driver.Driver
import base.waits.ExplicitWait
import base.waits.TypeWait
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

open class BaseElement(private var locator: By, private var name: String) {

    protected lateinit var element: WebElement
    protected lateinit var typeWait: TypeWait

    private fun getIElement() = if (::element.isInitialized) element else findElement()

    fun <T> getElements(clazz: Class<T>): List<BaseElement> {
        val list: ArrayList<BaseElement> = arrayListOf()
        for (element: WebElement in findElements()) {
            if (clazz == TextField::class.java) {
                list.add(TextField(locator, name, element))
            } else if (clazz == Button::class.java) {
                list.add(Button(locator, name, element))
            }
        }
        return list
    }

    private fun findElement(): WebElement {
        return if (::typeWait.isInitialized) {
            return when (typeWait) {
                TypeWait.PRESENCE_OF_ELEMENT_LOCATED -> wait().presenceOfElementLocated()
                else -> wait().elementToBeClickable()
            }
        } else {
            Driver.getDriver().findElement(locator)
        }
    }

    private fun findElements(): List<WebElement> {
        return if (::typeWait.isInitialized) {
            return when (typeWait) {
                TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED -> wait().listPresenceOfElementLocated()
                else -> wait().visibilityOfAllElements()
            }
        } else {
            Driver.getDriver().findElements(locator)
        }
    }

    private fun wait() = ExplicitWait(locator)

    fun click() {
        getIElement().click()
    }

    fun getText() = getIElement().text

    fun isEnabled() = getIElement().isEnabled

    fun isDisplayed() = getIElement().isDisplayed
}