//package by.it_academy.ad02_09_2018_class
//
//import android.app.Activity
//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import android.content.IntentFilter
//import android.net.ConnectivityManager
//import android.os.Bundle
//import android.support.v4.content.LocalBroadcastManager
//import android.util.Log
//
//class Lesson5Activity : Activity() {
//    var test1: Int = 0
//    val test2: Int = 0 // final
//
//    companion object {
//        //static
//        //or @JVMStatic
////        fun show(activity: Activity) {
//
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.lesson2second)
//        savedInstanceState?.toString()
//    }
//
//    override fun onStart() {
//        super.onStart()
//        val intentFilter = IntentFilter()
//        intentFilter.addAction(ConnectivityManager.EXTRA_NETWORK_REQUEST)//название события, которое ловим
//        //для получения локального сообщения (в рамках приложения)
//        LocalBroadcastManager.getInstance(this).registerReceiver(wifiReceiver, intentFilter)// для глобального просто: .registerReceiver(wifiReceiver, intentFilter)
//
//
//    }
//
//    override fun onStop() {
//        super.onStop()
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(wifiReceiver)
//    }
//
//    private val wifiReceiver = object : BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent?) {
//            Log.e("AAA", "onReceive" + intent?.action)
//        }
//
//    }
//}