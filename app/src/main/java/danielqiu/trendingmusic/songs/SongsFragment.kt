package danielqiu.trendingmusic.songs

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import danielqiu.trendingmusic.R
import danielqiu.trendingmusic.data.Song
import kotlinx.android.synthetic.main.fragment_songs.*

/**
 * Created by danielqiu on 15/8/2017.
 */
class SongsFragment : Fragment(), SongsContract.View {

    companion object {
        fun newInstance() = SongsFragment()
    }

    private lateinit var mPresenter : SongsContract.Presenter
    private lateinit var mAdapter : SongsAdapter

    override fun setPresenter(presenter: SongsContract.Presenter) {
        mPresenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_songs, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = SongsAdapter(ArrayList())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = mAdapter

        btnRefresh.setOnClickListener({mPresenter.loadMusics(true)})
    }

    override fun onResume() {
        super.onResume()

        mPresenter.start()
    }

    override fun setRefreshButton(active: Boolean) {
        btnRefresh?.isEnabled = active
    }

    override fun showSongs(songs: List<Song>) {
        mAdapter.setData(songs)
    }

    override fun setLoadingProgress(active: Boolean) {
        loadingView?.visibility = if (active) View.VISIBLE else View.GONE
    }

    override fun setEmptyView(active: Boolean) {
        emptyView?.visibility = if (active) View.VISIBLE else View.GONE
    }

    override fun setConnectionIndicator(active: Boolean) {
        view?.let {
            if (active) {
                Snackbar.make(view!!, R.string.snack_bar_msg_internet_connected, Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(view!!, R.string.snack_bar_msg_internet_disconnected, Snackbar.LENGTH_INDEFINITE).show()
            }
        }
    }
}