package yodgorbekkomilov.edgar.footballapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import yodgorbekkomilov.edgar.footballapp.FootballResponse

@Dao
interface FootballDao {
    @get:Query("SELECT * FROM football")
    val all: List<FootballResponse>

    @Insert
    fun insertAll(vararg users: FootballResponse)
}