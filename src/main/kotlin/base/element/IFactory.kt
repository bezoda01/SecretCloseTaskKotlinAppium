package base.element

import base.waits.TypeWait
import org.openqa.selenium.By

class IFactory {

    fun getTextField(locator: By, name: String) = TextField(locator, name)

    fun getTextField(locator: By, name: String, typeWait: TypeWait) = TextField(locator, name, typeWait)

    fun getButton(locator: By, name: String) = Button(locator, name)

    fun getButton(locator: By, name: String, typeWait: TypeWait) = Button(locator, name, typeWait)

    fun getTextFields(locator: By, name: String) = TextField(locator, name).getElements(TextField::class.java) as List<TextField>

    fun getButtons(locator: By, name: String) = Button(locator, name).getElements(Button::class.java) as List<Button>

    fun getTextFields(locator: By, name: String, typeWait: TypeWait) = TextField(locator, name, typeWait).getElements(TextField::class.java) as List<TextField>

    fun getButtons(locator: By, name: String, typeWait: TypeWait) = Button(locator, name, typeWait).getElements(Button::class.java) as List<Button>
}