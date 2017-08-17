package danielqiu.trendingmusic.songs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import danielqiu.trendingmusic.R
import danielqiu.trendingmusic.data.Song

/**
 * Created by danielqiu on 17/8/2017.
 */
class SongsAdapter(var songs: List<Song>) : RecyclerView.Adapter<SongsViewHolder>() {

    fun setData(songs : List<Song>) {
        this.songs = songs
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SongsViewHolder?, position: Int) {
        holder?.bindData(songs[position])
    }

    override fun getItemCount(): Int = songs.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SongsViewHolder =
            SongsViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.cell_song, parent, false))
}