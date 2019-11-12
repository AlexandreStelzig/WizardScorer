package alexstelzig.wizardscorer.playerselection

import alexstelzig.wizardscorer.data.game.GameRepository
import alexstelzig.wizardscorer.data.player.PlayerRepository
import alexstelzig.wizardscorer.data.playerround.PlayerRoundRepository
import alexstelzig.wizardscorer.data.round.RoundRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewGameViewModelFactory(
    private val gameRepository: GameRepository,
    private val playerRepository: PlayerRepository,
    private val roundRepository: RoundRepository,
    private val playerRoundRepository: PlayerRoundRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        NewGameViewModel(gameRepository, playerRepository, roundRepository, playerRoundRepository) as T
}
