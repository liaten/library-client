package library.client.response

import org.json.JSONObject

interface AsyncResponse {
    fun returnJSONObject(jsonObject: JSONObject?)
}