package es.jujoru.marvelapi.ui.model
import es.jujoru.marvelapi.model.Character
sealed class UiModelStates
{
    object Loading: UiModelStates()
    class Fill(val characters: List<Character>): UiModelStates()
}
