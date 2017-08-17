package danielqiu.trendingmusic

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by danielqiu on 16/8/2017.
 */
@Module
class ApplicationModule(val context: Context) {

    @Provides fun providesContext() : Context = context

}