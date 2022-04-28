package and5.abrar.tugasasyncfilm.api

import and5.abrar.tugasasyncfilm.model.ResponseFilmItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("apifilm.php")
    fun getAllFilm(): Call<List<ResponseFilmItem>>
}