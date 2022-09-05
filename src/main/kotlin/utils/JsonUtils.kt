package utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import base.settings.Settings

class JsonUtils {

    companion object {
        fun readJson(data: String): JSONObject? = JSONParser().parse(data) as JSONObject?
        fun convertCapsToMap(): HashMap<String, String> = ObjectMapper().readValue(Settings.caps!!.get("caps").toString())
    }
}