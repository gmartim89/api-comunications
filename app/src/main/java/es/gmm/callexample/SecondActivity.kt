package es.gmm.callexample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import es.gmm.callexample.network.ApiUser
import es.gmm.callexample.network.retrofit.ApiFactory
import es.gmm.callexample.network.retrofit.Callback
import es.gmm.callexample.network.ui.BaseProgress

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        App.serverManager.linkProgress(BaseProgress(findViewById<View>(R.id.progress)))

        val api = ApiFactory().create<ApiUser>()
        val callUnauthorized = api.getUnauthorized()

        findViewById<Button>(R.id.unaithorized).setOnClickListener {
            callUnauthorized.enqueue(Callback(App.serverManager) {
                Log.w("DOONAMIS_CALL", "" + it);
            })
        }

    }
}
