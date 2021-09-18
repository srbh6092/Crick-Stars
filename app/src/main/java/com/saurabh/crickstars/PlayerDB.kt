package com.saurabh.crickstars

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saurabh.crickstars.model.Player
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = arrayOf(Player::class), version=1, exportSchema=false)
abstract class PlayerDB : RoomDatabase(){

    abstract fun getPlayerDao(): PlayerDao

    //to avoid multi instances
    companion object{

        @Volatile
        private var INSTANCE: PlayerDB?= null

        @InternalCoroutinesApi
        fun getDB(context: Context): PlayerDB{
            return INSTANCE
                ?: synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        PlayerDB::class.java,
                        "player_DB"
                    ).build()
                    INSTANCE=instance

                    instance
                }
        }
    }

}