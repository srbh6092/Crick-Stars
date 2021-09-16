package com.saurabh.crickstars.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class Player(
    @ColumnInfo(name = "captain")val captain: Boolean,
    @ColumnInfo(name = "first_name")val first_name: String,
    @ColumnInfo(name = "last_name")val last_name: String,
    @ColumnInfo(name = "country")val country: String
){
    @PrimaryKey(autoGenerate=true) var id=0
}