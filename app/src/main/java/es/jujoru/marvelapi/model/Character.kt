package es.jujoru.marvelapi.model


import com.google.gson.annotations.SerializedName

data class Character (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String?,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("resourceURI") val resourceUri: String

        )