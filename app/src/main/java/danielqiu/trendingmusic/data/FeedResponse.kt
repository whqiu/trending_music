package danielqiu.trendingmusic.data

import com.squareup.moshi.Json

/**
 * Created by danielqiu on 16/8/2017.
 */
data class FeedResponse(@Json(name = "feed") val feed : Feed)