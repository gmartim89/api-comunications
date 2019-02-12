package es.gmm.callexample

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.ContentLoadingProgressBar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import es.gmm.callexample.network.ApiUser
import es.gmm.callexample.network.retrofit.ApiFactory
import es.gmm.callexample.network.retrofit.Callback
import es.gmm.callexample.network.ui.BaseProgress

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.serverManager.linkProgress(BaseProgress(findViewById(R.id.progress)))

        val api = ApiFactory().create<ApiUser>()
        val callUser = api.getUser(1, 1)

        callUser.enqueue(Callback(App.serverManager) {
            findViewById<TextView>(R.id.text).text = it
        })

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }

    }



}
