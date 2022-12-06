package com.example.youtube.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.model.Playlists

class PlaylistAdapter: RecyclerView.Adapter<PlaylistsAdapter.PlayListsHolder> {

    inner class PlayListsHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(playLists: Playlists)
    }

}
