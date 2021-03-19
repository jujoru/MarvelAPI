package es.jujoru.marvelapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import es.jujoru.marvelapi.R
import es.jujoru.marvelapi.databinding.ActivityCharacterDetailsBinding
import es.jujoru.marvelapi.ui.model.StructViewData
import es.jujoru.marvelapi.ui.model.getViewModel
import es.jujoru.marvelapi.utils.Constants
import es.jujoru.marvelapi.model.Character
import es.jujoru.marvelapi.ui.model.loadImageFromUrl
import es.jujoru.marvelapi.viewmodels.CharacterDetailsViewModel
import java.lang.IllegalStateException

class CharacterDetailsActivity : AppCompatActivity(), StructViewData {
    private lateinit var binding: ActivityCharacterDetailsBinding
    private lateinit var viewModel: CharacterDetailsViewModel
    private lateinit var character: Character
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()

        val bundle = intent.extras
        if (bundle!=null){
            character = bundle.getParcelable(Constants.EXTRA_CHARACTER)!!
            initViewModel()
        }


    }


    override fun initViewModel() {
        viewModel = getViewModel {   CharacterDetailsViewModel(character) }
        viewModel.character.observe(this, {
            character = it
            updateUI()
        })
    }

    override fun initBinding() {
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_character_details)
    }

      private fun updateUI() {
        binding.character = character
       // binding.ivCharactersDetailsImage.loadImageFromUrl(character.thumbnail.path, character.thumbnail.extension)
          Glide.with(this).
          load("http://via.placeholder.com/150").
          into(binding.ivCharactersDetailsImage)

      }
}