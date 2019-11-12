package alexstelzig.wizardscorer.playerselection

import alexstelzig.wizardscorer.data.game.GameRepository
import alexstelzig.wizardscorer.data.player.PlayerRepository
import alexstelzig.wizardscorer.data.playerround.PlayerRoundRepository
import alexstelzig.wizardscorer.data.round.RoundRepository
import alexstelzig.wizardscorer.usecase.CreateNewGameUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewGameViewModel(
    private val gameRepository: GameRepository,
    private val playerRepository: PlayerRepository,
    private val roundRepository: RoundRepository,
    private val playerRoundRepository: PlayerRoundRepository
) : ViewModel() {

    private var numberPlayerLiveData = MutableLiveData<Int>(MIN_NUM_PLAYERS)
    private var firstDealerLiveData = MutableLiveData<Int>(0)

    val currentNumberOfPlayers: LiveData<Int> = numberPlayerLiveData
    val firstDealer: LiveData<Int> = firstDealerLiveData

    private val canDecrementNumberOfPlayers: Boolean
        get() = numberPlayerLiveData.value ?: 0 > MIN_NUM_PLAYERS

    private val canIncrementNumberOfPlayers: Boolean
        get() = numberPlayerLiveData.value ?: 0 < MAX_NUM_PLAYERS

    fun incrementNumberOfPlayers() {
        if (canIncrementNumberOfPlayers) {
            numberPlayerLiveData.postValue(numberPlayerLiveData.value?.plus(1))
        }
    }

    fun decrementNumberOfPlayers() {
        if (canDecrementNumberOfPlayers) {
            val newNumberOfPlayers = numberPlayerLiveData.value?.minus(1)
            numberPlayerLiveData.postValue(newNumberOfPlayers)
            if (firstDealer.value ?: 0 >= newNumberOfPlayers ?: 0) {
                changeSelectedDealer(0)
            }
        }
    }

    fun changeSelectedDealer(position: Int) {
        firstDealerLiveData.postValue(if (position == firstDealerLiveData.value) 0 else position)
    }

    fun onStartClicked() {
        viewModelScope.launch {
            CreateNewGameUseCase(
                gameRepository,
                playerRepository,
                roundRepository,
                playerRoundRepository
            ).perform(listOf("Player1", "Player2", "Player3"), 0)
        }
    }

    companion object {
        private const val MAX_NUM_PLAYERS = 6
        private const val MIN_NUM_PLAYERS = 3
    }
}