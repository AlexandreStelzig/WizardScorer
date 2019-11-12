package alexstelzig.wizardscorer.data.game

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
interface GameDao {
//    @Query("SELECT * FROM game WHERE id = :gameId")
//    suspend fun getGame(gameId: Int): LiveData<Game>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(game: Game): Long
}
