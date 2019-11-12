package alexstelzig.wizardscorer.data.round

class RoundRepository private constructor(private val roundDao: RoundDao) {


    suspend fun insertAllRounds(rounds: List<Round>): List<Long> {
        return roundDao.insertAll(rounds)
    }

    companion object {

        @Volatile
        private var instance: RoundRepository? = null

        fun getInstance(roundDao: RoundDao) =
            instance ?: synchronized(this) {
                instance ?: RoundRepository(roundDao).also { instance = it }
            }
    }
}
