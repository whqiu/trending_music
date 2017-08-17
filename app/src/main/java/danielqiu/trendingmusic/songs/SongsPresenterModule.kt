package danielqiu.trendingmusic.songs

import dagger.Module
import dagger.Provides
import danielqiu.trendingmusic.data.source.ActivityScoped
import danielqiu.trendingmusic.data.source.SongsRepository

/**
 * Created by danielqiu on 16/8/2017.
 */
@Module
class SongsPresenterModule(var view: SongsContract.View) {

    @ActivityScoped
    @Provides
    fun providesPresenter(songsRepository: SongsRepository) : SongsContract.Presenter = SongsPresenter(songsRepository, view)
}