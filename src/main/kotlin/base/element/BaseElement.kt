package base.element

import base.driver.Driver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

open class BaseElement(private var locator: By, private var name: String) {

    lateinit var element: WebElement

    constructor(locator: By, name: String, _element: WebElement) : this(locator, name) {
        element = _element
    }

    fun getWElement(): WebElement {
        if(!::element.isInitialized) {
          element = findElement()
        }
        return element
    }

    fun findElement() = Driver.getDriver().findElement(locator)

    fun findElements() = Driver.getDriver().findElements(locator)

    fun click() {
        getWElement().click()
    }

    fun getText(): String {
        return getWElement().text
    }

    fun isEnabled(): Boolean {
        return getWElement().isEnabled
    }

    fun <T> getElements(clazz: Class<T>): List<BaseElement> {
        val list: ArrayList<BaseElement> = arrayListOf()
        for (element: WebElement in findElements()) {
            if (clazz.equals(TextField::class.java)) {
                list.add(TextField(locator, name, element))
            } else if (clazz.equals(Button::class.java)) {
                list.add(Button(locator, name, element))
            }
        }
        for(e: Any in list) {
            println(e.toString())
        }
        return list
    }
}