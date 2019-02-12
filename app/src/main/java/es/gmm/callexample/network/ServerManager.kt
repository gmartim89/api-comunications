package es.gmm.callexample.network

import android.app.Application
import android.content.Intent
import android.widget.Toast
import es.gmm.callexample.LoginActivity
import es.gmm.callexample.network.action.IActions
import es.gmm.callexample.network.action.IResponseManager
import es.gmm.callexample.network.message.IMessage
import es.gmm.callexample.network.message.Message
import es.gmm.callexample.network.ui.BaseProgress

class ServerManager(private val app: Application) : IResponseManager, IActions {

    private val messageManager: IMessage = Message(app.applicationContext)
    private var progress : BaseProgress? = null

    override fun onResponseCode(code: Int) {
        when (code) {
            401 -> onUnauthorized()
            404 -> onUnauthorized()
            420 -> showMessage(messageManager.getMessage420())
            430 -> showMessage(messageManager.getMessage430())
            440 -> showMessage(messageManager.getMessage440())
            450 -> showMessage(messageManager.getMessage450())
            500 -> onFailConnection()
        }
        endCall()
    }

    fun linkProgress(progress : BaseProgress){
        this.progress = progress
    }

    override fun initCall() {
        progress?.showProgress()
    }

    override fun endCall() {
        progress?.hideProgress()
    }

    private fun showMessage(message: String) {
        Toast.makeText(app, message, Toast.LENGTH_LONG).show()
    }

    override fun onUnauthorized() {
        showMessage("UNAUTHORIZED")
        val intent = Intent(app, LoginActivity::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        app.startActivity(intent)
    }

    override fun onFailConnection() {
        showMessage("Server Error")
    }

}