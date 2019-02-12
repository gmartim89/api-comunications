package es.gmm.callexample.network.retrofit

import es.gmm.callexample.network.action.IResponseManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Callback<T>(val reps: IResponseManager, val callback: (T) -> Unit) : Callback<T> {

    init {
        reps.initCall()
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        reps.onResponseCode(500)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.code() == 200) {
            val body = response.body()
            if (body != null)
                callback(body)
            reps.endCall()
        } else {
            reps.onResponseCode(response.code())
        }
    }

}