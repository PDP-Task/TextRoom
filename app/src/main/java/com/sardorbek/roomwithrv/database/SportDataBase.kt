package com.sardorbek.roomwithrv.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sardorbek.roomwithrv.model.Sport

@Database(entities = [Sport::class], version = 2, exportSchema = false)
abstract class SportDataBase : RoomDatabase() {


    abstract fun sportDao(): SportDao

    companion object {
        @Volatile
        private var instance: SportDataBase? = null

        operator fun invoke(context: Context) = instance ?: synchronized(Any()) {
            instance ?: createDataBase(context).also {
                instance = it
            }
        }

        private fun createDataBase(context: Context) = Room.databaseBuilder(
            context,
            SportDataBase::class.java,
            "sport.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }


}