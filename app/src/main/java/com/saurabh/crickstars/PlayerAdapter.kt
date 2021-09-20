package com.saurabh.crickstars

import android.content.Context
import android.graphics.Typeface
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saurabh.crickstars.model.Player
import com.saurabh.crickstars.ui.sortByName.SortByNameFragment

class PlayerAdapter(
    private val context: Context
    ): RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>(){

    private val allPlayers =ArrayList<Player>()

    inner class PlayerViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val name: TextView = itemview.findViewById(R.id.name)
        val country:TextView = itemview.findViewById(R.id.country)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerAdapter.PlayerViewHolder = PlayerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_player_name_wise, parent, false)
        )

    override fun onBindViewHolder(holder: PlayerAdapter.PlayerViewHolder, position: Int) {
        val player = allPlayers[position]
        holder.name.text = player.first_name+" "+player.last_name
        holder.country.text = player.country
        if (player.captain) {
            holder.name.setTypeface(null, Typeface.BOLD)
            holder.country.setTypeface(null, Typeface.BOLD)
        }
    }

    override fun getItemCount(): Int = allPlayers.size

    fun updateList(newList: List<Player>){
        allPlayers.clear()
        allPlayers.addAll(newList)
        notifyDataSetChanged()
    }
}
