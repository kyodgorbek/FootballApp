package yodgorbekkomilov.edgar.footballapp.model

import androidx.room.Database
import androidx.room.RoomDatabase
import yodgorbekkomilov.edgar.footballapp.FootballResponse

@Database(entities = [FootballResponse::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun footballDao(): FootballDao
}