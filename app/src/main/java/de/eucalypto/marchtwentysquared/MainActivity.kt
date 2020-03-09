package de.eucalypto.marchtwentysquared

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = CountFragment()

        supportFragmentManager.beginTransaction().add(R.id.mainActivity, fragment).commit()
    }

}
