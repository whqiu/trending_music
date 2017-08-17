package danielqiu.trendingmusic.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import danielqiu.trendingmusic.data.Song
import io.reactivex.Flowable


/**
 * Created by danielqiu on 15/8/2017.
 */
@Dao
interface SongsDao {

    @Query("SELECT * FROM topSongs")
    fun getTopSongs(): Flowable<List<Song>>

    @Query("DELETE FROM topSongs")
    fun deleteAllTopSongs()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTopSongs(songs: List<Song>)
}