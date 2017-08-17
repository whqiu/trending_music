package danielqiu.trendingmusic.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import danielqiu.trendingmusic.data.Song

/**
 * Created by danielqiu on 15/8/2017.
 */
@Database(entities = arrayOf(Song::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun songsDao() : SongsDao
}