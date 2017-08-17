package danielqiu.trendingmusic.data.source.local

import dagger.Component
import danielqiu.trendingmusic.ApplicationModule
import javax.inject.Singleton

/**
 * Created by danielqiu on 16/8/2017.
 */
@Singleton
@Component(modules = arrayOf(DatabaseModule::class, ApplicationModule::class))
interface DatabaseComponent {
    fun appDatabase() : AppDatabase
}