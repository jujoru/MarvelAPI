package es.jujoru.marvelapi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import es.jujoru.marvelapi.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun clickAccess(view: View) {
        startActivity(Intent(this, CharactersActivity::class.java))
        finish()
    }


}