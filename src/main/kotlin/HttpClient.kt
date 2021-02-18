import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.serialization.json.JsonBuilder
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class HttpClient {
    private val client = OkHttpClient()
    private val JSON_TYPE: MediaType = "application/json; charset=utf-8".toMediaType()

    fun PostData(url: String, postJson: String): String {
        val req = Request.Builder()
        val request = req.url(url).post(postJson.toRequestBody(JSON_TYPE)).build()
        val response = client.newCall(request).execute()

        return response.body!!.string()
    }
}