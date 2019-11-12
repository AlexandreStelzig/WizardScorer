package alexstelzig.wizardscorer.data.game

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class Game(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val gameId: Int = 0
)