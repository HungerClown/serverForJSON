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
//Вложенность, нижний уровень
@Serializable
data class Root(
    val result: Result
)

@Serializable
data class Result(

    @Serializable(with = dataListSerializer::class)
    val datas: List<data> = arrayListOf()
)

@Serializable
data class data(val ElementName: String, val ElementID: String, val ChangeDate: String)

object dataListSerializer: JsonTransformingSerializer<List<data>>(ListSerializer(data.serializer())) {
    // If response is not an array, then it is a single object that should be wrapped into the array
    override fun transformDeserialize(element: JsonElement): JsonElement =
        if (element !is JsonArray) JsonArray(listOf(element)) else element
}



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

//работа с вложенностью
    fun modelToJson(): String{
        var otvet = Result()

        otvet.datas.plus(data("Barsik", "eee", "2023.30.39"))
        otvet.datas.plus(data("Murka", "eee", "2023.12.39"))
        var root = Root( otvet)

        return Json.encodeToString(root)
    }

}
