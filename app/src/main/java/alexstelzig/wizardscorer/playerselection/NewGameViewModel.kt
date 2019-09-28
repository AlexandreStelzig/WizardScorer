package alexstelzig.wizardscorer.playerselection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewGameViewModel : ViewModel() {

    private var numberPlayerLiveData = MutableLiveData<Int>(MIN_NUM_PLAYERS)
    private var firstDealerLiveData = MutableLiveData<Int>(0)

    val currentNumberOfPlayers: LiveData<Int> = numberPlayerLiveData
    val firstDealer: LiveData<Int> = firstDealerLiveData

    val canDecrementNumberOfPlayers: Boolean
        get() = numberPlayerLiveData.value ?: 0 > MIN_NUM_PLAYERS

    val canIncrementNumberOfPlayers: Boolean
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
            if(firstDealer.value ?: 0 >= newNumberOfPlayers ?: 0){
                changeSelectedDealer(0)
            }
        }
    }

    fun changeSelectedDealer(position: Int) {
        firstDealerLiveData.postValue(if (position == firstDealerLiveData.value) 0 else position)
    }

    companion object {
        private const val MAX_NUM_PLAYERS = 6
        private const val MIN_NUM_PLAYERS = 3
    }
}