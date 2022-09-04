package utils

import java.lang.StringBuffer
import java.util.*

class StringUtils {
    companion object {
        fun randomText(): String {
            val r = Random()
            val length = 20
            val sb = StringBuffer()
            while (sb.length < length) {
                sb.append(Integer.toHexString(r.nextInt()))
            }
            return sb.toString().substring(0, length)
        }

        fun splitString(str: String, delimeter: String?): String {
            val temp = str.split(delimeter!!).toTypedArray()
            return temp[0]
        }
    }
}