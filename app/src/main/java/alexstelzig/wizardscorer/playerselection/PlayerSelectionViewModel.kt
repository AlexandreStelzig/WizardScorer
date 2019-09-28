package alexstelzig.wizardscorer.playerselection

import androidx.lifecycle.ViewModel

class PlayerSelectionViewModel : ViewModel() {

    var currentPlayerCount = MIN_NUM_PLAYERS

    val canDecrementNumberOfPlayers: Boolean
        get() = currentPlayerCount > MIN_NUM_PLAYERS

    val canIncrementNumberOfPlayers: Boolean
        get() = currentPlayerCount < MAX_NUM_PLAYERS

    fun incrementNumberOfPlayers() {
        currentPlayerCount++
    }

    fun decrementNumberOfPlayers() {
        currentPlayerCount--
    }

    companion object {
        private const val MAX_NUM_PLAYERS = 6
        private const val MIN_NUM_PLAYERS = 3
    }
}