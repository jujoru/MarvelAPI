package es.jujoru.marvelapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.jujoru.marvelapi.model.Character
import es.jujoru.marvelapi.utils.Scope

class CharacterDetailsViewModel(private val characterValue: Character): ViewModel(),
    Scope by  Scope.Implementation() {

    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character>
        get() {
            if (_character.value == null) _character.value = characterValue
            return _character
        }

}