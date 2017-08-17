package danielqiu.trendingmusic.data.source

import dagger.Component
import danielqiu.trendingmusic.data.source.local.DatabaseModule
import danielqiu.trendingmusic.network.WebServiceModule
import javax.inject.Singleton

/**
 * Created by danielqiu on 16/8/2017.
 */
@Singleton
@Component(modules = arrayOf(SongsRepositoryModule::class, DatabaseModule::class, WebServiceModule::class))
interface SongsRepositoryComponent {
    fun songsRepository() : SongsRepository
}