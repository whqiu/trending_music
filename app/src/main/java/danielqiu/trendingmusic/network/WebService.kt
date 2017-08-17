package danielqiu.trendingmusic.network

import danielqiu.trendingmusic.data.FeedResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by danielqiu on 16/8/2017.
 */
interface WebService {
    @GET("top-songs/100/explicit.json")
    fun getTopSongs() : Observable<FeedResponse>
}