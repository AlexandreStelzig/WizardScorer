package alexstelzig.wizardscorer.data.game


class GameRepository private constructor(private val gameDao: GameDao) {


    suspend fun insertGame(game: Game): Long {
        return gameDao.insert(game)
    }

    companion object {

        @Volatile private var instance: GameRepository? = null

        fun getInstance(gameDao: GameDao) =
            instance ?: synchronized(this) {
                instance ?: GameRepository(gameDao).also { instance = it }
            }
    }
}
