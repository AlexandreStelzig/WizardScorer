package alexstelzig.wizardscorer.playerselection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewGameViewModelFactory() : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = NewGameViewModel() as T
}
