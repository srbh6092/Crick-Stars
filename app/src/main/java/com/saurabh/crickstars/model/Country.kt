package com.saurabh.crickstars.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class Country(
    @ColumnInfo(name = "list")val list: List<Player>,
    @ColumnInfo(name = "country")val country: String
){
    @PrimaryKey(autoGenerate=true) var id=0
}
