package alexstelzig.wizardscorer.data.playerround

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playerround")
data class PlayerRound(
    @ColumnInfo(name = "player_id") val playerId: Long,
    @ColumnInfo(name = "round_id") val roundId: Long,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val playerRoundId: Int = 0,
    var bids: Int = 0,
    var scores: Int = 0
)