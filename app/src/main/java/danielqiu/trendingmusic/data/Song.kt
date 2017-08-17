package danielqiu.trendingmusic.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json

/**
 * Created by danielqiu on 15/8/2017.
 */
@Entity(tableName = "topSongs")
data class Song (
        @PrimaryKey var id: String? = "",
        var artistName: String? = "",
        @Json(name = "name") var songName: String? = "",
        @Json(name = "artworkUrl100") var artworkUrl: String? = ""
)