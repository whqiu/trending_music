package danielqiu.trendingmusic.network

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by danielqiu on 16/8/2017.
 */
@Singleton
@Component(modules = arrayOf(WebServiceModule::class))
interface WebServiceComponent {
    fun retrofit() : Retrofit
}