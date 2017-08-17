package danielqiu.trendingmusic.data.source.remote

import danielqiu.trendingmusic.data.Song
import danielqiu.trendingmusic.data.source.SongsDataSource
import danielqiu.trendingmusic.network.WebService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

/**
 * Created by danielqiu on 15/8/2017.
 */
class SongsRemoteDataSource(val mRetrofit: Retrofit) : SongsDataSource {

    private val mWebService by lazy { mRetrofit.create(WebService::class.java) }

    override fun deleteAllTopSongs() {
    }

    override fun saveTopSongs(songs: List<Song>) {

    }

    override fun getTopSongs(callback: SongsDataSource.LoadSongsCallback) {
        mWebService.getTopSongs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { (feed) ->
                            if (feed.songs.isNotEmpty()) {
                                callback.onSongsLoaded(feed.songs)
                            } else {
                                callback.onDataNotAvailable()
                            }
                        },
                        {_: Throwable -> callback.onDataNotAvailable()})
    }

    override fun refreshSongs() {

    }
}