package es.jujoru.marvelapi.repository

import es.jujoru.marvelapi.ui.model.md5
import es.jujoru.marvelapi.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object APIMarvel {
    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().
        addInterceptor(this).
                addInterceptor { chain ->
                    val original = chain.request()
                    val originalHttpUrl = original.url

                    val ts = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
                    val url = originalHttpUrl.newBuilder()
                            .addQueryParameter("apikey", Constants.PARAMS_API_PUBLIC)
                            .addQueryParameter("ts", ts)
                            .addQueryParameter("hash", "$ts${es.jujoru.marvelapi.BuildConfig.API_KEY_PRIVATE}${Constants.PARAMS_API_PUBLIC}".md5())
                            .build()
                    val requestBuilder = original.newBuilder().url(url)

                    val request = requestBuilder.build()
                    chain.proceed(request)
                }
                .build()


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