package alexstelzig.wizardscorer.utils

import alexstelzig.wizardscorer.playerselection.NewGameViewModelFactory
import android.content.Context

object InjectorUtils {

    fun providePlayerSelectionViewModelFactory(context: Context): NewGameViewModelFactory {
        return NewGameViewModelFactory()
    }

}
