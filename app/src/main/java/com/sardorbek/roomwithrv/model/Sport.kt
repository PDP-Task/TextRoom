package com.sardorbek.roomwithrv.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sport")
data class Sport(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var spinner:String,
    val step : String,
    val time :String
)
