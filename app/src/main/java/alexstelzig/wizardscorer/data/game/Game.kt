package alexstelzig.wizardscorer.data.game

import alexstelzig.wizardscorer.data.player.Player
import alexstelzig.wizardscorer.data.round.Round
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "game")
data class Game(
    @Relation(parentColumn = "id", entityColumn = "players") val players: ArrayList<Player>,
    @Relation(parentColumn = "id", entityColumn = "player") val firstDealer: Player,
    @Relation(parentColumn = "id", entityColumn = "rounds") val rounds: ArrayList<Round>

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val gameId: Int = 0
}