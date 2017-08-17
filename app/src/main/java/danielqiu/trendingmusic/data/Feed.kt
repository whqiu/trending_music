package danielqiu.trendingmusic.data

import com.squareup.moshi.Json

/**
 * Created by danielqiu on 16/8/2017.
 */
data class Feed(@Json(name = "results") val songs: List<Song>)