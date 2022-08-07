package library.client.response

import org.json.JSONObject

interface JSONResponse {
    fun returnJSONObject(jsonObject: JSONObject?)
}