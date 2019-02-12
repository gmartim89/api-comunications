package es.gmm.callexample.network.message

import android.content.Context
import es.gmm.callexample.R

class Message(private val context: Context) : IMessage {

    override fun getMessage450(): String {
        return context.getString(R.string.message_code_450)
    }

}