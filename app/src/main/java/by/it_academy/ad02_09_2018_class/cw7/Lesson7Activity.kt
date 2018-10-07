package by.it_academy.ad02_09_2018_class.cw7

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import by.it_academy.ad02_09_2018_class.R
import by.it_academy.ad02_09_2018_class.cw7.fragments.OneFragment
import by.it_academy.ad02_09_2018_class.cw7.fragments.SecondFragment

//or extends by AppCompatActivity

class Lesson7Activity : FragmentActivity() {

    //ViewPager & ViewPagerAdapter + TapLayout

    private lateinit var sharedPrefs: SharedPreferences
    private var isFirstFragment = false

    companion object {
        const val SHARED_PREFS_NAME = "djdjd"
        const val HELLO_KEY = "fgfjkc"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson7)

        val isTablet = if (findViewById<FrameLayout>(R.id.container2) != null) true else false


        sharedPrefs = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

        val textView = findViewById<TextView>(R.id.titleTextView)
        textView.setOnClickListener() {
            changeFragment()
        }
    }

    private fun changeFragment() {
        val fragmentManager = supportFragmentManager

        val transactionFragment = fragmentManager.beginTransaction()


        if (isFirstFragment) {
            transactionFragment.replace(R.id.container, OneFragment.getInstance("Hello"), "OneFragment")
            //fragmentManager.findFragmentByTag() - например, проверить, есть ли фрагмент на экране
            isFirstFragment = false
        } else {
            transactionFragment.replace(R.id.container, SecondFragment.getInstance(), "SecondFragment")
            isFirstFragment = true

        }
        transactionFragment.addToBackStack(null)

        transactionFragment.commit()

    }

    override fun onStart() {
        super.onStart()
        val text = sharedPrefs.getString(HELLO_KEY, "Hello")
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


    override fun onStop() {
        super.onStop()
        sharedPrefs.edit()
                .putString(HELLO_KEY, "Hello")
                .apply()
    }
}
