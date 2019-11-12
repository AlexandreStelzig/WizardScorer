package alexstelzig.wizardscorer.data.round

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
interface RoundDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(rounds: List<Round>): List<Long>
}
