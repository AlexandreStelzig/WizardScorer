package alexstelzig.wizardscorer.data.playerround

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
interface PlayerRoundDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(playerRounds: List<PlayerRound>): List<Long>
}
