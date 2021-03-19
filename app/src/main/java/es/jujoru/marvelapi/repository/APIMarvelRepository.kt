package es.jujoru.marvelapi.repository

import android.app.Activity
import es.jujoru.marvelapi.utils.Constants

class APIMarvelRepository (activity: Activity) {

    private val apiKey = Constants.PARAMS_API_PUBLIC
    private val ts = Constants.PARAMS_TS
    private val hash = Constants.PARAMS_HASH

    suspend fun getCharacters() =
        APIMarvel.service
            .listCharacters(
                Constants.PARAMS_TS,
                Constants.PARAMS_API_PUBLIC,
                Constants.PARAMS_HASH

            )
}