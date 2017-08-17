package danielqiu.trendingmusic.songs

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import danielqiu.trendingmusic.data.Song
import kotlinx.android.synthetic.main.cell_song.view.*

/**
 * Created by danielqiu on 17/8/2017.
 */
class SongsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(song : Song) {
        if (song.artistName.isNullOrEmpty()) {
            itemView.imgArtwork.setImageBitmap(null)
        } else {
            Picasso.with(itemView.context).load(song.artworkUrl).into(itemView.imgArtwork)
        }

        itemView.tvSongName.text = song.songName
        itemView.tvArtistName.text = song.artistName
    }
}