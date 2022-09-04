package base.screen

import base.element.BaseElement
import base.element.IFactory

open class BaseScreen(var uniqueElement: BaseElement) {

    fun getIFactory(): IFactory = IFactory()
}