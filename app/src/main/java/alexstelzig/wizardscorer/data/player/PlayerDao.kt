package alexstelzig.wizardscorer.data.player

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
interface PlayerDao {

//    @Query("SELECT * FROM player ORDER BY name")
//    fun getPlayers(): LiveData<List<Player>>
//
//    @Query("SELECT * FROM player WHERE id = :playerId")
//    fun getPlayer(playerId: Int): LiveData<Player>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(players: List<Player>): List<Long>
}
