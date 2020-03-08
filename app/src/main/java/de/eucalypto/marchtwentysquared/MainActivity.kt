package de.eucalypto.marchtwentysquared

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterView.text = counter.toString()

        incrementButton.setOnClickListener {
            counter += 1
            counterView.text = counter.toString()
        }

    }
}
