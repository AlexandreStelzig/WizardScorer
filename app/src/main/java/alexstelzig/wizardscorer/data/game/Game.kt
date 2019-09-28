package alexstelzig.wizardscorer.data.game

import alexstelzig.wizardscorer.data.player.Player
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "plants")
data class Game(
    @Relation(parentColumn = "id", entityColumn = "players") val players: List<Player>
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val playerId: Int = 0
}