package es.gmm.callexample.network.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class ApiFactory {

    inline fun <reified T : Any> create(): T {
        val client = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.refugerestrooms.org/api/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(client.build())
            .build()
        return retrofit.create<T>(T::class.java)
    }

}