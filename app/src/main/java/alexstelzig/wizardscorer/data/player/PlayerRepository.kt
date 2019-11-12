package alexstelzig.wizardscorer.data.player

class PlayerRepository private constructor(private val playerDao: PlayerDao) {


    suspend fun insertAllPlayers(players: List<Player>): List<Long> {
        return playerDao.insertAll(players)
    }

    companion object {

        @Volatile private var instance: PlayerRepository? = null

        fun getInstance(playerDao: PlayerDao) =
            instance ?: synchronized(this) {
                instance ?: PlayerRepository(playerDao).also { instance = it }
            }
    }
}
