package danielqiu.trendingmusic

import android.app.Application
import danielqiu.trendingmusic.data.source.DaggerSongsRepositoryComponent
import danielqiu.trendingmusic.data.source.SongsRepositoryComponent
import danielqiu.trendingmusic.data.source.SongsRepositoryModule
import danielqiu.trendingmusic.data.source.local.DatabaseModule
import danielqiu.trendingmusic.network.WebServiceModule

/**
 * Created by danielqiu on 16/8/2017.
 */
class TrendingMusicApp : Application() {

    val songsRepositoryComponent: SongsRepositoryComponent by lazy {
        DaggerSongsRepositoryComponent.builder()
                .databaseModule(DatabaseModule(this.applicationContext))
                .webServiceModule(WebServiceModule("https://rss.itunes.apple.com/api/v1/hk/apple-music/"))
                .songsRepositoryModule(SongsRepositoryModule())
                .build()
    }
}