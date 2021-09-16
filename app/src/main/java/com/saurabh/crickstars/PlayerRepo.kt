package com.saurabh.crickstars

import androidx.lifecycle.LiveData
import com.saurabh.crickstars.model.Player

class PlayerRepo(private val playerDao: PlayerDao) {

    val allPlayer:LiveData<List<Player>> = playerDao.getAllPlayer()

    suspend fun insert(player:Player)=playerDao.insert(player)

    suspend fun delete(player:Player)=playerDao.delete(player)

}