package es.jujoru.marvelapi.model

import com.google.gson.annotations.SerializedName


data class CharactersResponse (
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: DataResponse
)