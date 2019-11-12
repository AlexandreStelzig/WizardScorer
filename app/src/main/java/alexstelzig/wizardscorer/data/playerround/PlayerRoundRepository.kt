package alexstelzig.wizardscorer.data.playerround

class PlayerRoundRepository private constructor(private val playerRoundDao: PlayerRoundDao) {


    suspend fun insertAllPlayerRounds(playerRounds: List<PlayerRound>): List<Long> {
        return playerRoundDao.insertAll(playerRounds)
    }

    companion object {

        @Volatile
        private var instance: PlayerRoundRepository? = null

        fun getInstance(playerRoundDao: PlayerRoundDao) =
            instance ?: synchronized(this) {
                instance ?: PlayerRoundRepository(playerRoundDao).also { instance = it }
            }
    }
}
