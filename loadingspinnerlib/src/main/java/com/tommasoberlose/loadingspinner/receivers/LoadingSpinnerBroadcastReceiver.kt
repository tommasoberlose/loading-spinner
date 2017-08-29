package com.tommasoberlose.loadingspinner.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.tommasoberlose.loadingspinner.activity.LoadingSpinnerActivity

class LoadingSpinnerBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action.equals(LoadingSpinnerActivity.BROADCAST_ACTION_START)) {
            context.startActivity(Intent(context, LoadingSpinnerActivity::class.java))
        }
    }
}
