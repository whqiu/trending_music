package danielqiu.trendingmusic.songs

import dagger.Component
import danielqiu.trendingmusic.data.source.ActivityScoped
import danielqiu.trendingmusic.data.source.SongsRepositoryComponent

/**
 * Created by danielqiu on 16/8/2017.
 */
@ActivityScoped
@Component(dependencies = arrayOf(SongsRepositoryComponent::class), modules = arrayOf(SongsPresenterModule::class))
interface SongsComponent {
    fun inject(target: SongsActivity)
}