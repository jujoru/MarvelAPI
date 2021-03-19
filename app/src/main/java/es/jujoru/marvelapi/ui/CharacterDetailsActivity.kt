package es.jujoru.marvelapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.jujoru.marvelapi.R

class CharacterDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)
    }
}