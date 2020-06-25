
import com.google.gson.annotations.SerializedName

data class FootballResponseItem(
    @SerializedName("country")
    val country: String,
    @SerializedName("european_titles")
    val europeanTitles: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: Int
)