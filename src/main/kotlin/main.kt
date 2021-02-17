fun main(args: Array<String>) {
    val url = "http://192.168.100.125:8000/api/spravochnik/"
    val jsonCreateor = JsonCreator()
    val json = jsonCreateor.GetChangedDictionaryItems()
    println("____________________________________________________________________________")
    val restClient = HttpClient()
    val request =  restClient.PostData(url, json)
    val name = "testName"
    val id = 21
    val date = "21.01.2001"
    jsonCreateor.jsonArrayParams(name, id, date)
    //print(request)
}