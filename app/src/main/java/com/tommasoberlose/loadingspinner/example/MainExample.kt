package com.tommasoberlose.loadingspinner.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tommasoberlose.loadingspinner.activity.LoadingSpinnerActivity

class MainExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_example)

        LoadingSpinnerActivity.showLoader(this, visible = true)
    }
}
