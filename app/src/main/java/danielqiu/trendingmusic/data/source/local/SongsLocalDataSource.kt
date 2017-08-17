package danielqiu.trendingmusic.data.source.local

import danielqiu.trendingmusic.data.Song
import danielqiu.trendingmusic.data.source.SongsDataSource
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by danielqiu on 15/8/2017.
 */
class SongsLocalDataSource(val mDataBase : AppDatabase) : SongsDataSource {

    private val mSongsDao : SongsDao by lazy { mDataBase.songsDao() }

    override fun deleteAllTopSongs() {
        Single.fromCallable{mSongsDao.deleteAllTopSongs()}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    override fun getTopSongs(callback: SongsDataSource.LoadSongsCallback) {
        mSongsDao.getTopSongs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {songs ->
                            if (songs.isNotEmpty()) {
                                callback.onSongsLoaded(songs)
                            } else {
                                callback.onDataNotAvailable()
                            }
                        },
                        {_ -> callback.onDataNotAvailable()})
    }

    override fun saveTopSongs(songs: List<Song>) {
        Single.fromCallable{mSongsDao.saveTopSongs(songs)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    override fun refreshSongs() {

    }
}