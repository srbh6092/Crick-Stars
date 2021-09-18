package com.saurabh.crickstars.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class Player(
    @ColumnInfo(name = "captain")var captain: Boolean=false,
    @ColumnInfo(name = "first_name")var first_name: String="",
    @ColumnInfo(name = "last_name")var last_name: String="",
    @ColumnInfo(name = "country")var country: String=""
){
    @PrimaryKey(autoGenerate=true) var id=0
}