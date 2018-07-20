package com.edgedevstudio.androidlifecycletutorial

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.ShareCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    var text = "Empty!"
    val TEXT_KEY = "text.key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d(TAG, "onCreate")
        Log.d(TAG, text)

        text = "This Text is no longer empty, it has been preserved by onSavedInstanceState"
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState")
        if (savedInstanceState != null) {
            text = intent.getStringExtra(TEXT_KEY)
            Log.d(TAG, "onRestoreInstanceState. text = $text")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
        outState?.putString(TEXT_KEY, text)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    fun click(view: View){
        ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setSubject(getString(R.string.app_name))
                .setText("Some Freaky Text")
                .startChooser()
        Log.d(TAG, "Showed a Share Dialog")
    }
}
