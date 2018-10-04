package by.it_academy.ad02_09_2018_class.cw6

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {


    override fun onCreate() {
        super.onCreate()
        Log.e("AAA", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("AAA", "onDestroy")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("AAA", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.e("AAA", "onBind")
        return null
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("AAA", "onUnbind")
        return super.onUnbind(intent)
    }
}