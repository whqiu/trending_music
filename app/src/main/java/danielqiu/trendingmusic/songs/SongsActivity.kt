package danielqiu.trendingmusic.songs

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import danielqiu.trendingmusic.R
import danielqiu.trendingmusic.TrendingMusicApp
import javax.inject.Inject

class SongsActivity : AppCompatActivity() {

    @Inject lateinit var mPresenter : SongsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)

        var songsFragment = supportFragmentManager.findFragmentById(R.id.content) as? SongsFragment
        if (songsFragment == null) {
            songsFragment = SongsFragment.newInstance()
            supportFragmentManager.beginTransaction()
                    .add(R.id.content, songsFragment)
                    .commit()
        }

        DaggerSongsComponent.builder()
                .songsRepositoryComponent((application as TrendingMusicApp).songsRepositoryComponent)
                .songsPresenterModule(SongsPresenterModule(songsFragment))
                .build()
                .inject(this)

    }
}
