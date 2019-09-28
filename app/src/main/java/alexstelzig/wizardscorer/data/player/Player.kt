package alexstelzig.wizardscorer.data.player

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class Player(
    @ColumnInfo(name = "name") val playerName: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val playerId: Int = 0

}
