package alexstelzig.wizardscorer.data

import alexstelzig.wizardscorer.data.game.Game
import alexstelzig.wizardscorer.data.game.GameDao
import alexstelzig.wizardscorer.data.player.Player
import alexstelzig.wizardscorer.data.player.PlayerDao
import alexstelzig.wizardscorer.data.playerround.PlayerRound
import alexstelzig.wizardscorer.data.playerround.PlayerRoundDao
import alexstelzig.wizardscorer.data.round.Round
import alexstelzig.wizardscorer.data.round.RoundDao
import alexstelzig.wizardscorer.utils.DATABASE_NAME
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Game::class, Player::class, PlayerRound::class, Round::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
    abstract fun playerDao(): PlayerDao
    abstract fun roundDao(): RoundDao
    abstract fun playerRoundDao(): PlayerRoundDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}