package com.saurabh.crickstars

import android.content.Context
import android.graphics.Typeface
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
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
        if (player.captain) { //if the player is a captain
            //making the texts
            holder.name.text = buildSpannedString {
                bold { append("${player.first_name + " " + player.last_name}") }
            }
            holder.country.text = buildSpannedString {
                bold { append("${player.country}") }
            }
        }
        else { //else
            //putting default style text
            holder.name.text=player.first_name+" "+player.last_name
            holder.country.text=player.country
        }
    }

    override fun getItemCount(): Int = allPlayers.size

    fun updateList(newList: List<Player>){
        allPlayers.clear()
        allPlayers.addAll(newList)
        notifyDataSetChanged()
    }
}
