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


    //declaring
    private val repo:PlayerRepo
    val allPlayer: LiveData<List<Player>>
    val allPlayerFNameAsc: LiveData<List<Player>>
    val allPlayerLNameAsc: LiveData<List<Player>>
    val allAfghanPlayer: LiveData<List<Player>>
    val allAusPlayer: LiveData<List<Player>>
    val allBanPlayer: LiveData<List<Player>>
    val allEngPlayer: LiveData<List<Player>>
    val allIndPlayer: LiveData<List<Player>>
    val allPakPlayer: LiveData<List<Player>>
    val allNewZPlayer: LiveData<List<Player>>
    val allSAPlayer: LiveData<List<Player>>
    val allSriLPlayer: LiveData<List<Player>>
    val allWIPlayer: LiveData<List<Player>>


    //initialising
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