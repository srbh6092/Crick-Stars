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
    val allPlayer: LiveData<List<Player>>
    val allPlayerFNameAsc: LiveData<List<Player>>
    val allPlayerLNameAsc: LiveData<List<Player>>
    private val allAfghanPlayer: LiveData<List<Player>>
    private val allAusPlayer: LiveData<List<Player>>
    private val allBanPlayer: LiveData<List<Player>>
    private val allEngPlayer: LiveData<List<Player>>
    private val allIndPlayer: LiveData<List<Player>>
    private val allPakPlayer: LiveData<List<Player>>
    private val allNewZPlayer: LiveData<List<Player>>
    private val allSAPlayer: LiveData<List<Player>>
    private val allSriLPlayer: LiveData<List<Player>>
    private val allWIPlayer: LiveData<List<Player>>

    init {
        val dao = PlayerDB.getDB(application).getPlayerDao()
        repo = PlayerRepo(dao)
        allPlayer=repo.allPlayer
        allPlayerFNameAsc=repo.allPlayerFNameAsc
        allPlayerLNameAsc=repo.allPlayerLNameAsc
        allAfghanPlayer=repo.afghanPlayer
        allAusPlayer=repo.ausPlayer
        allBanPlayer=repo.banPlayer
        allEngPlayer=repo.engPlayer
        allIndPlayer=repo.indPlayer
        allPakPlayer=repo.pakPlayer
        allNewZPlayer=repo.newZPlayer
        allSAPlayer=repo.saPlayer
        allSriLPlayer=repo.sriLPlayer
        allWIPlayer=repo.wiPlayer
    }

    fun insertPlayer(player:Player)= viewModelScope.launch(Dispatchers.IO){
        repo.insert(player)
    }

}