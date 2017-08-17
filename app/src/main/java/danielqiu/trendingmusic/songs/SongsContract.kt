package danielqiu.trendingmusic.songs

import danielqiu.trendingmusic.data.Song

/**
 * Created by danielqiu on 15/8/2017.
 */
interface SongsContract {

    interface View {
        fun setPresenter(presenter: Presenter)
        fun setRefreshButton(active: Boolean)
        fun setLoadingProgress(active: Boolean)
        fun setConnectionIndicator(active: Boolean)
        fun setEmptyView(active: Boolean)
        fun showSongs(songs: List<Song>)
    }

    interface Presenter {
        fun start()
        fun loadMusics(forceUpdate: Boolean)
    }
}