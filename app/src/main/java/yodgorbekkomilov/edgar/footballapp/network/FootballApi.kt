package yodgorbekkomilov.edgar.footballapp.network

import io.reactivex.Observable
import retrofit2.http.GET
import yodgorbekkomilov.edgar.footballapp.FootballResponseItem

interface FootballApi {
    @GET("/hiring/clubs.json")
    fun getPosts(): Observable<FootballResponseItem>
}
