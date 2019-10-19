package alexstelzig.wizardscorer.data.playerround

import alexstelzig.wizardscorer.data.player.Player
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "playerround")
data class PlayerRound(
    @Relation(parentColumn = "id", entityColumn = "player") val player: Player
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val playerRoundId: Int = 0

    var bids: ArrayList<Int> = arrayListOf()
    var scores: ArrayList<Int> = arrayListOf()

}