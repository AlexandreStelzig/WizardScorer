package alexstelzig.wizardscorer.data.round

import alexstelzig.wizardscorer.data.playerround.PlayerRound
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "round")
data class Round(
    @Relation(parentColumn = "id", entityColumn = "playerRounds") val playerRounds: List<PlayerRound>
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val roundId: Int = 0

    var roundNumber: Int = 0

}