package es.jujoru.marvelapi.repository

import es.jujoru.marvelapi.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIMarvel {
    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    val service: APIMarvelService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL_MARVEL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .run {
            create<APIMarvelService>(APIMarvelService::class.java)
        }
}