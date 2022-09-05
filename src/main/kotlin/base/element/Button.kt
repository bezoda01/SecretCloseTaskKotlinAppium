package base.element

import base.waits.TypeWait
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class Button(locator: By, name: String) : BaseElement(locator, name) {

    constructor(locator: By, name: String, element: WebElement) : this(locator, name) {
        super.element = element
    }

    constructor(locator: By, name: String, typeWait: TypeWait) : this(locator, name) {
        super.typeWait = typeWait
    }
}