package danielqiu.trendingmusic.songs

import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import danielqiu.trendingmusic.data.Song
import danielqiu.trendingmusic.data.source.SongsDataSource
import danielqiu.trendingmusic.data.source.SongsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by danielqiu on 15/8/2017.
 */
class SongsPresenter(private val mRepository: SongsRepository, private val mView: SongsContract.View) : SongsContract.Presenter {

    init {
        mView.setPresenter(this)
    }

    override fun start() {
        loadMusics(false)

        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({isConnectedToInternet ->
                    if (isConnectedToInternet) {
                        mView.setRefreshButton(true)
                        mView.setConnectionIndicator(true)
                    } else {
                        mView.setRefreshButton(false)
                        mView.setConnectionIndicator(false)
                    }
                })
    }

    override fun loadMusics(forceUpdate: Boolean) {
        if (forceUpdate) {
            mRepository.refreshSongs()
        }

        mView.setLoadingProgress(true)

        mRepository.getTopSongs(object : SongsDataSource.LoadSongsCallback {
            override fun onSongsLoaded(songs: List<Song>) {
                mView.setEmptyView(false)
                mView.setLoadingProgress(false)

                mView.showSongs(songs)
            }

            override fun onDataNotAvailable() {
                mView.setEmptyView(true)
                mView.setLoadingProgress(false)
            }
        })
    }

}