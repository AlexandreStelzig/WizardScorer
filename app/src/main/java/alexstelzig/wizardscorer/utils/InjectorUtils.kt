package alexstelzig.wizardscorer.utils

import alexstelzig.wizardscorer.playerselection.PlayerSelectionViewModelFactory
import android.content.Context

object InjectorUtils {

    fun providePlayerSelectionViewModelFactory(): PlayerSelectionViewModelFactory {
        return PlayerSelectionViewModelFactory()
    }

}
