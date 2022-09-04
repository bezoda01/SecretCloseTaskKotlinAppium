package base.element

import base.driver.Driver
import base.waits.ExplicitWait
import base.waits.TypeWait
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

open class BaseElement(private var locator: By, private var name: String) {

    protected lateinit var element: WebElement
    protected lateinit var typeWait: TypeWait

    @JvmName("getElement1")
    fun getElement(): WebElement {
        if (::element.isInitialized) {
            return element
        } else {
            return findElement()
        }
    }

    fun findElement(): WebElement {
        if (::typeWait.isInitialized) {
            if (typeWait.name.equals(TypeWait.PRESENCE_OF_ELEMENT_LOCATED.name)) {
                return wait().presenceOfElementLocated()
            } else {
                return wait().elementToBeClickable()
            }
        } else {
            return Driver.getDriver().findElement(locator)
        }
    }

    fun findElements(): List<WebElement> {
        if (::typeWait.isInitialized) {
            if (typeWait.name.equals(TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED.name)) {
                return wait().listPresenceOfElementLocated()
            } else {
                return wait().visibilityOfAllElements()
            }
        } else {
            return Driver.getDriver().findElements(locator)
        }
    }

    fun click() {
        getElement().click()
    }

    fun getText() = getElement().text

    fun isEnabled() = getElement().isEnabled

    fun isDisplayed() = getElement().isDisplayed

    fun <T> getElements(clazz: Class<T>): List<BaseElement> {
        val list: ArrayList<BaseElement> = arrayListOf()
        for (element: WebElement in findElements()) {
            if (clazz.equals(TextField::class.java)) {
                list.add(TextField(locator, name, element))
            } else if (clazz.equals(Button::class.java)) {
                list.add(Button(locator, name, element))
            }
        }
        return list
    }

    private fun wait() = ExplicitWait(locator)
}