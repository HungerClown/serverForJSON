import kotlinx.serialization.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.*


val format = Json { prettyPrint = true }

// Параметры
@Serializable
data class Params(val ObjectUIN: String, val ChangeDate: String,val UserName: String, val Password:String)
// Запрос к серверу
@Serializable
data class RequestToServer(val id: Int, val jsonRpc: String="2.0", val method: String,val params: Params, val version: Int)
@Serializable
data class ItemsForList(val ElementName: String, val ElementID: Int, val ChangeDateTime: String)

class JsonCreator {
    private fun createTestJson(): String{
        val params = Params("34343", "11.02.2021", "Salevat", "erererds323223")
        return Json.encodeToString(params)
    }

    private fun createRequestToServer(): String{
        val params = Params("34343", "11.02.2021", "Salevat", "erererds323223")
        val request = RequestToServer(1, "2.0" ,"GetChangedDictionaryItems",params, 1)
        return Json.encodeToString(request)
    }

    fun JsonToParams(jsonParams: String): Params{
        return  Json.decodeFromString(jsonParams)
    }

    fun GetChangedDictionaryItems(): String {
        return  createRequestToServer()
    }

    fun jsonArrayParams() {
        val itemsForList = ItemsForList()
        val element = buildJsonObject {
            putJsonArray("data") {
                addJsonObject {
                    put("ElementName", itemsForList.ElementName)
                }
                addJsonObject {
                    put("ElementID", itemsForList.ElementID)
                }
                addJsonObject {
                    put("ChangeDateTime", itemsForList.ChangeDateTime)
                }
            }
        }
        print(element)
        //return Json.decodeFromString(element.toString())
    }

}
