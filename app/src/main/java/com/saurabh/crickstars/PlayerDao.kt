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

    @Query("SELECT  * FROM player order by first_name ASC")
    fun getAllPlayerFNameAscOrder(): LiveData<List<Player>>

    @Query("SELECT  * FROM player order by last_name ASC")
    fun getAllPlayerLNameAscOrder(): LiveData<List<Player>>

    @Query("SELECT* from player where country like 'Afghanistan'")
    fun getAfghanPlayers():LiveData<List<Player>>

    @Query("SELECT* from player where country like 'Australia'")
    fun getAusPlayers():LiveData<List<Player>>

    @Query("SELECT* from player where country like 'Bangladesh'")
    fun getBanPlayers():LiveData<List<Player>>

    @Query("SELECT* from player where country like 'England'")
    fun getEngPlayers():LiveData<List<Player>>

    @Query("SELECT* from player where country like 'India'")
    fun getIndPlayers():LiveData<List<Player>>

    @Query("SELECT* from player where country like 'New Zealand'")
    fun getNewZPlayers():LiveData<List<Player>>

    @Query("SELECT* from player where country like 'Pakistan'")
    fun getPakPlayers():LiveData<List<Player>>

    @Query("SELECT* from player where country like 'South Africa'")
    fun getSAPlayers():LiveData<List<Player>>

    @Query("SELECT* from player where country like 'Sri Lanka'")
    fun getSriLPlayers():LiveData<List<Player>>

    @Query("SELECT* from player where country like 'West Indies'")
    fun getWIPlayers():LiveData<List<Player>>


}