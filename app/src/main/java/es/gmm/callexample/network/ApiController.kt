package es.gmm.callexample.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiUser {

    @GET("v1/restrooms.json")
    fun getUser(
        @Query("page") pages: Int,
        @Query("per_page") perPage: Int
    ): Call<String>

    @GET("api/test")
    fun getUnauthorized(): Call<String>

}

interface ApiTest{
    @GET("api/test")
    fun <T : Any>callTest(test: Any): Call<String>
}

interface ApiAccount {

    @GET
    fun getAccountInfo(@Query("account") account: String): Call<String>

}

interface ApiJobs {

    @GET
    fun getJobs(@Query("jobs") jobs: String): Call<String>

}