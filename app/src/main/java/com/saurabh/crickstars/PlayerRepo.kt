package com.saurabh.crickstars

import androidx.lifecycle.LiveData
import com.saurabh.crickstars.model.Player

class PlayerRepo(private val playerDao: PlayerDao) {

    val allPlayer:LiveData<List<Player>> = playerDao.getAllPlayer()

    val allPlayerFNameAsc:LiveData<List<Player>> = playerDao.getAllPlayerFNameAscOrder()

    val allPlayerLNameAsc:LiveData<List<Player>> = playerDao.getAllPlayerLNameAscOrder()

    val afghanPlayer:LiveData<List<Player>> = playerDao.getAfghanPlayers()

    val ausPlayer:LiveData<List<Player>> = playerDao.getAusPlayers()

    val banPlayer:LiveData<List<Player>> = playerDao.getBanPlayers()

    val engPlayer:LiveData<List<Player>> = playerDao.getEngPlayers()

    val indPlayer:LiveData<List<Player>> = playerDao.getIndPlayers()

    val newZPlayer:LiveData<List<Player>> = playerDao.getNewZPlayers()

    val pakPlayer:LiveData<List<Player>> = playerDao.getPakPlayers()

    val saPlayer:LiveData<List<Player>> = playerDao.getSAPlayers()

    val sriLPlayer:LiveData<List<Player>> = playerDao.getSriLPlayers()

    val wiPlayer:LiveData<List<Player>> = playerDao.getWIPlayers()

    suspend fun insert(player:Player)=playerDao.insert(player)

    suspend fun delete(player:Player)=playerDao.delete(player)

}