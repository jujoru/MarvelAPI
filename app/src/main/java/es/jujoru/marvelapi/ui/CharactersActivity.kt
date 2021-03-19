package es.jujoru.marvelapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import es.jujoru.marvelapi.R
import es.jujoru.marvelapi.databinding.ActivityCharactersBinding
import es.jujoru.marvelapi.repository.APIMarvelRepository
import es.jujoru.marvelapi.ui.adapters.CharactersAdapter
import es.jujoru.marvelapi.ui.adapters.CharactersListener
import es.jujoru.marvelapi.ui.model.StructViewData
import es.jujoru.marvelapi.ui.model.UiModelStates
import es.jujoru.marvelapi.ui.model.getViewModel
import es.jujoru.marvelapi.ui.model.startActivity
import es.jujoru.marvelapi.utils.Constants
import es.jujoru.marvelapi.viewmodels.CharactersViewModel

class CharactersActivity : AppCompatActivity(), StructViewData {

    private val marvelRepository: APIMarvelRepository by lazy { APIMarvelRepository(this) }
    private lateinit var binding: ActivityCharactersBinding
    private lateinit var viewModel: CharactersViewModel
    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initViewModel()
//        GlobalScope.launch {
//            val dataResponse = marvelRepository.getCharacters()
//        }
    }

    override fun initViewModel() {
        viewModel = getViewModel {
            CharactersViewModel(APIMarvelRepository(this))
        }
        viewModel.callCharacters()
        adapter = CharactersAdapter( CharactersListener{
            startActivity<CharacterDetailsActivity>{
                putExtra(Constants.EXTRA_CHARACTER, it)
            }
        })
        viewModel.model.observe(this, {
            updateUI(it)
        })
        binding.rvCharacters.adapter = adapter
    }

    override fun initBinding() {
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_characters)

    }

      fun updateUI(model: UiModelStates) {
          binding.progress.visibility = if(model is UiModelStates.Loading) View.VISIBLE else View.GONE

            if(model is UiModelStates.Fill){
                adapter.submitList(model.characters)
            }


    }
}