package alexstelzig.wizardscorer.playerselection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlayerSelectionViewModelFactory() : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = PlayerSelectionViewModel() as T
}