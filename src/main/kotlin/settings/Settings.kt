package settings

import org.json.simple.JSONObject
import utils.FilesUtils
import utils.JsonUtils

class Settings {
    companion object {
        val caps: JSONObject? = JsonUtils.readJson(FilesUtils.readFile("src/main/resources/caps.json"))
        val config: JSONObject? = JsonUtils.readJson(FilesUtils.readFile("src/main/resources/config.json"))
        val timeouts: JSONObject? = config!!.get("timeouts") as JSONObject
    }
}