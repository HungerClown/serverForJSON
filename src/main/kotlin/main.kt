import com.google.gson.Gson
import okhttp3.Response
import java.net.URL

fun main() {
    //val url = "https://jsonplaceholder.typicode.com/todos/1"

    val urls = URL("http://jsonplaceholder.typicode.com/posts").readText()
    var gson = Gson()
    val data = gson.fromJson(urls, Array<PostsItem>::class.java)

   // val jsonCreateor = JsonCreator()
   // val json = jsonCreateor.GetChangedDictionaryItems()
    println("____________________________________________________________________________")
    val restClient = HttpClient()
   // val request =  restClient.PostData(url, json)
    //print(request)

//    for(x in 0 until data.size){
//        println("[" + data[x].title)
//        println(data[x].id)
//        println("${data[x].views}]")
//    }

    println(JsonCreator().modelToJson())
}


//http://192.168.100.125:8000/api/spravochnik/