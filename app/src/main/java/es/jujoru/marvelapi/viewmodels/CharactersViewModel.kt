package es.jujoru.marvelapi.viewmodels

import androidx.annotation.RestrictTo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.jujoru.marvelapi.model.Character
import es.jujoru.marvelapi.repository.APIMarvelRepository
import es.jujoru.marvelapi.ui.model.UiModelStates
import es.jujoru.marvelapi.utils.Scope
import kotlinx.coroutines.launch

class CharactersViewModel(private val repository: APIMarvelRepository): ViewModel(),
        Scope by  Scope.Implementation(){


    private val _model = MutableLiveData<UiModelStates>()
    val model: LiveData<UiModelStates>
    get(){
        if (_model.value== null) callCharacters()
        return _model
    }

        init {
            initScope()
        }

      fun callCharacters(){
          launch {
              _model.value = UiModelStates.Loading
              _model.value = UiModelStates.Fill(repository.getCharacters().data.result)
          }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}