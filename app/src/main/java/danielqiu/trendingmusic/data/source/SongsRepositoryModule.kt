package danielqiu.trendingmusic.data.source

import dagger.Module
import dagger.Provides
import danielqiu.trendingmusic.data.source.local.AppDatabase
import danielqiu.trendingmusic.data.source.local.SongsLocalDataSource
import danielqiu.trendingmusic.data.source.remote.SongsRemoteDataSource
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by danielqiu on 16/8/2017.
 */
@Module
class SongsRepositoryModule {
    @Singleton
    @Provides
    @Named("Local")
    fun providesSongsLocalDataSource(appDatabase: AppDatabase) : SongsDataSource = SongsLocalDataSource(appDatabase)

    @Singleton
    @Provides
    @Named("Remote")
    fun providesSongsRemoteDataSource(retrofit: Retrofit) : SongsDataSource = SongsRemoteDataSource(retrofit)

    @Singleton
    @Provides
    fun providesSongsRepository(@Named("Local") localDataSource: SongsDataSource,
                                @Named("Remote") remoteDataSource: SongsDataSource) : SongsRepository =
            SongsRepository(localDataSource, remoteDataSource)
}