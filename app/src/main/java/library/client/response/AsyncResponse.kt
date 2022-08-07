package library.client.response

import org.json.JSONObject
import android.graphics.Bitmap

interface AsyncResponse {
    fun returnJSONObject(jsonObject: JSONObject?)
}