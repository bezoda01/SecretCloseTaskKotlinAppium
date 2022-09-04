package utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import settings.Settings

class JsonUtils {

    companion object {

        fun readJson(data: String): JSONObject? {
            var objects: JSONObject? = null
            val parser: JSONParser = JSONParser()
            return parser.parse(data) as JSONObject?
        }

        fun convertCapsToMap(): HashMap<String, String> {
            val mapper: ObjectMapper = ObjectMapper()
            return mapper.readValue(Settings.caps!!.get("caps").toString())
        }
    }
}