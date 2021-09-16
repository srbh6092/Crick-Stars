package com.saurabh.crickstars

import androidx.lifecycle.LiveData
import androidx.room.*
import com.saurabh.crickstars.model.Player

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(player: Player)

    @Delete
    suspend fun delete(player:Player)

    @Query("SELECT * from player order by id ASC")
    fun getAllPlayer(): LiveData<List<Player>>


}