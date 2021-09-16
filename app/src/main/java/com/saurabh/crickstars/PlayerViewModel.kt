package com.saurabh.crickstars

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.saurabh.crickstars.model.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class PlayerViewModel(application:Application):AndroidViewModel(application) {

    private val repo:PlayerRepo
    private val allPlayer: LiveData<List<Player>>

    init {
        val dao = PlayerDB.getDB(application).getPlayerDao()
        repo = PlayerRepo(dao)
        allPlayer=repo.allPlayer
    }

    fun insertPlayer(player:Player)= viewModelScope.launch(Dispatchers.IO){
        repo.insert(player)
    }

    fun deleteNote(player:Player)= viewModelScope.launch(Dispatchers.IO){
        repo.delete(player)
    }
}