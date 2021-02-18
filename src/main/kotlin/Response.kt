import com.google.gson.annotations.SerializedName

data class SomeClass(

	@field:SerializedName("data")
	val data: Data? = null
)

data class PostsItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("views")
	val views: Int? = null
)

data class Data(

	@field:SerializedName("posts")
	val posts: List<PostsItem?>? = null
)

