package by.it_academy.ad02_09_2018_class.cw6

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.ProgressBar
import by.it_academy.ad02_09_2018_class.R

class Lesson6Activity : Activity() {
    private val adapter = PersonListAdapter()
    private lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson6)

        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)

        val listData = listOf<Person>(
                Person("111", "222"),
                Person("111", "222"),
                Person("111", "222"),
                Person("111", "222"))
        recycleView.layoutManager = LinearLayoutManager(this) //setLayoutManager - java
        //(this, LinearLayout.HORIZONTAL, false) - слева-направо
        //GradeLayoutManager (this,4) - колонки
        recycleView.setHasFixedSize(true) // одинаковый ли размер ячеек?
        recycleView.adapter


//        bindService(Intent(this,MyService::class.java),serviceConnection, Context.BIND_AUTO_CREATE)
//        val intent = Intent (this,MyIntentService::class.java)
//        intent.putExtra(MyIntentService.LINK_EXTRA, "url/11111")
//        startService(intent)
//        val intent2 = Intent (this,MyIntentService::class.java)
//        intent2.putExtra(MyIntentService.LINK_EXTRA, "url/11111")
//        startService(intent2)
//        val intent3 = Intent (this,MyIntentService::class.java)
//        intent3.putExtra(MyIntentService.LINK_EXTRA, "url/11111")
//        startService(intent3)
    }

    override fun onResume() {
        super.onResume()
//        startService(Intent(this,MyService::class.java))
//        stopSelf() - остановить сервис
//        service?.onCreate() - вызовет, если не null
        bindService(Intent(this, MyService::class.java), serviceConnection, Context.BIND_AUTO_CREATE)

    }

    override fun onPause() {
        super.onPause()
//        stopService(Intent(this, MyService::class.java))

    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.e("AAA", "onServiceDisconnected")

            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.e("AAA", "onServiceConnected")
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}