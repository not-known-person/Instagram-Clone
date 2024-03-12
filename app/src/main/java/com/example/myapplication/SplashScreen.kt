package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startHeavyTask()
    }

    private fun startHeavyTask() {
        LongOperation().execute()
    }

    private open inner class LongOperation : AsyncTask<String?, Void?, String?>() {
        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg p0: String?): String? {
            for (i in 0..10) {
                try {
                    Thread.sleep(1000)
                } catch (e: Exception) {
                    Thread.interrupted()
                }
            }
            return "result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
