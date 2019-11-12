package alexstelzig.wizardscorer.utils

import alexstelzig.wizardscorer.data.AppDatabase
import alexstelzig.wizardscorer.data.game.GameRepository
import alexstelzig.wizardscorer.data.player.PlayerRepository
import alexstelzig.wizardscorer.data.playerround.PlayerRoundRepository
import alexstelzig.wizardscorer.data.round.RoundRepository
import alexstelzig.wizardscorer.playerselection.NewGameViewModelFactory
import android.content.Context

object InjectorUtils {

    fun providePlayerSelectionViewModelFactory(context: Context): NewGameViewModelFactory {
        return NewGameViewModelFactory(
            getGameRepository(context),
            getPlayerRepository(context),
            getRoundRepository(context),
            getPlayerRoundRepository(context)
        )
    }

    private fun getGameRepository(context: Context): GameRepository {
        return GameRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).gameDao()
        )
    }

    private fun getPlayerRepository(context: Context): PlayerRepository {
        return PlayerRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).playerDao()
        )
    }

    private fun getRoundRepository(context: Context): RoundRepository {
        return RoundRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).roundDao()
        )
    }

    private fun getPlayerRoundRepository(context: Context): PlayerRoundRepository {
        return PlayerRoundRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).playerRoundDao()
        )
    }

}
