package danielqiu.trendingmusic.data.source.local

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by danielqiu on 16/8/2017.
 */
@Module
class DatabaseModule (var context: Context) {
    @Provides
    @Singleton
    fun providesAppDatabase() : AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "song_db").build()
}