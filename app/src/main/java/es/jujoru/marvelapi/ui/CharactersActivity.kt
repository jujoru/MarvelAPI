package es.jujoru.marvelapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import es.jujoru.marvelapi.R
import es.jujoru.marvelapi.repository.APIMarvelRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CharactersActivity : AppCompatActivity() {

    private val marvelRepository: APIMarvelRepository by lazy { APIMarvelRepository(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        GlobalScope.launch {
val dataResponse = marvelRepository.getCharacters()
            Log.i("adas","Adas")
        }
    }
}