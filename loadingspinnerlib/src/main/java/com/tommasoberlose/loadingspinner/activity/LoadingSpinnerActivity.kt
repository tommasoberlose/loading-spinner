package com.tommasoberlose.loadingspinner.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.tommasoberlose.loadingspinner.R


class LoadingSpinnerActivity : AppCompatActivity() {

    var loader: ProgressBar? = null
    var broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when(intent?.action) {
                BROADCAST_ACTION_FINISH -> finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_spinner)

        loader = findViewById(R.id.loader)
        findViewById<View>(android.R.id.content).setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                LoadingSpinnerActivity.showLoader(view!!.context, visible = false)
            }
        })
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(broadcastReceiver, IntentFilter(BROADCAST_ACTION_FINISH))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }

    companion object {

        val BROADCAST_ACTION_START: String = "com.tommasoberlose.loadingspinner.action.broadcast.start"
        val BROADCAST_ACTION_FINISH: String = "com.tommasoberlose.loadingspinner.action.broadcast.finish"

        fun showLoader(context: Context, visible: Boolean) {
            context.sendBroadcast(if (visible) Intent(BROADCAST_ACTION_START) else Intent(BROADCAST_ACTION_FINISH))
        }
    }
}
