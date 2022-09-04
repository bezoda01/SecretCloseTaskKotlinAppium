package base.element

import org.openqa.selenium.By

class IFactory {

    fun getTextField(locator: By, name: String): TextField {
        return TextField(locator, name)
    }

    fun getButton(locator: By, name: String): Button {
        return Button(locator, name)
    }

    fun getTextFields(locator: By, name: String): List<TextField> {
        return TextField(locator, name).getElements(TextField::class.java) as List<TextField>
    }

    fun getButtons(locator: By, name: String): List<Button> {
        return Button(locator, name).getElements(Button::class.java) as List<Button>
    }
}