package utils

class StringUtils {
    companion object {
        fun splitString(str: String, delimeter: String?) = str.split(delimeter!!).toTypedArray()[0]
    }
}