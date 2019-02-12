package es.gmm.callexample

import android.app.Application
import es.gmm.callexample.network.ServerManager

class App : Application() {

    companion object {
        lateinit var serverManager : ServerManager
    }

    override fun onCreate() {
        super.onCreate()
        serverManager = ServerManager(this)

    }


}