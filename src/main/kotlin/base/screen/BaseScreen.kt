package base.screen

import base.element.BaseElement
import base.element.IFactory

open class BaseScreen(protected var uniqueElement: BaseElement) {

    fun getIFactory(): IFactory = IFactory()

    fun isEnabled() = uniqueElement.isEnabled()

    fun isDisplayed() = uniqueElement.isDisplayed()
}