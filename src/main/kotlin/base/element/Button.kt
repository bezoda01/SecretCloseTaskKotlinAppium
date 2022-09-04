package base.element

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class Button(locator: By, name: String) : BaseElement(locator, name) {

    constructor(locator: By, name: String, _element: WebElement) : this(locator, name)
}