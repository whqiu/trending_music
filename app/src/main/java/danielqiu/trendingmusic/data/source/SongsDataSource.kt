package danielqiu.trendingmusic.data.source

import danielqiu.trendingmusic.data.Song

/**
 * Created by danielqiu on 15/8/2017.
 */
interface SongsDataSource {
    interface LoadSongsCallback {
        fun onSongsLoaded(songs : List<Song>)
        fun onDataNotAvailable()
    }

    fun getTopSongs(callback: LoadSongsCallback)
    fun saveTopSongs(songs : List<Song>)
    fun deleteAllTopSongs()
    fun refreshSongs()
}