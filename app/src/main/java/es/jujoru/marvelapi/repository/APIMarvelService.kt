package es.jujoru.marvelapi.repository

import es.jujoru.marvelapi.model.CharactersResponse
import es.jujoru.marvelapi.model.DataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface APIMarvelService {
    @GET("characters?&limit=100")
    suspend fun listCharacters():CharactersResponse
}