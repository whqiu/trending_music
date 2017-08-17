package danielqiu.trendingmusic.data.source

import danielqiu.trendingmusic.data.Song
import java.util.*

/**
 * Created by danielqiu on 15/8/2017.
 */
class SongsRepository(val mSongsLocalDataSource: SongsDataSource,
                      val mSongsRemoteDataSource: SongsDataSource
) : SongsDataSource {

    private var mNeedRefresh = false
    private var mCachedSongs : List<Song> = ArrayList()

    override fun getTopSongs(callback: SongsDataSource.LoadSongsCallback) {
        if (!mNeedRefresh && mCachedSongs.isNotEmpty()) {
            callback.onSongsLoaded(mCachedSongs)
            return
        }

        if (mNeedRefresh) {
            mNeedRefresh = false
            getSongsFromRemoteDataSource(callback)
        } else {
            mSongsLocalDataSource.getTopSongs(object : SongsDataSource.LoadSongsCallback {
                override fun onSongsLoaded(songs: List<Song>) {
                    refreshCache(songs)

                    callback.onSongsLoaded(songs)
                }

                override fun onDataNotAvailable() {
                    getSongsFromRemoteDataSource(callback)
                }
            })
        }
    }

    private fun getSongsFromRemoteDataSource(callback: SongsDataSource.LoadSongsCallback) {
        mSongsRemoteDataSource.getTopSongs(object : SongsDataSource.LoadSongsCallback {
            override fun onSongsLoaded(songs: List<Song>) {
                refreshCache(songs)
                refreshLocalDataSource(songs)

                callback.onSongsLoaded(songs)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun refreshSongs() {
        mNeedRefresh = true
    }

    private fun refreshCache(songs : List<Song>) {
        mCachedSongs = songs
    }

    private fun refreshLocalDataSource(songs: List<Song>) {
//        mSongsLocalDataSource.deleteAllTopSongs()
        mSongsLocalDataSource.saveTopSongs(songs)
    }

    override fun deleteAllTopSongs() {
        mSongsLocalDataSource.deleteAllTopSongs()
        mSongsRemoteDataSource.deleteAllTopSongs()
    }

    override fun saveTopSongs(songs: List<Song>) {
    }
}