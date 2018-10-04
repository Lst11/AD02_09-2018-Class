package by.it_academy.ad02_09_2018_class.cw6

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("processName") {
    companion object {
        const val LINK_EXTRA = "LINK_EXTRA"
    }

    override fun onHandleIntent(intent: Intent) {
        val link = intent.getStringExtra(LINK_EXTRA)
        Log.e("AAA", "link =$link start")

        Thread.sleep(3000)
        Log.e("AAA", "link =$link stop")

    }
}