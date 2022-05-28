package com.sardorbek.roomwithrv.database

import androidx.room.*
import com.sardorbek.roomwithrv.model.Sport

@Dao
interface  SportDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSport(sport: Sport)


    @Query("SELECT * FROM Sport ORDER BY id DESC")
    fun getAllSports():List<Sport>

    @Update
    fun upDateSport(sport: Sport)

    @Delete
    fun deleteSport(sport: Sport)


    @Query("DELETE FROM Sport")
    fun deleteAllSports()

}