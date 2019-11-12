package alexstelzig.wizardscorer.data.round

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "round")
data class Round(
    @ColumnInfo(name = "game_id") val gameId: Long,
    @ColumnInfo(name = "round_number")var roundNumber: Int,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val roundId: Int = 0
)