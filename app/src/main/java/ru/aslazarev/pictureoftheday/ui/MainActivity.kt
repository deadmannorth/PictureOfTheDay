package ru.aslazarev.pictureoftheday.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.aslazarev.pictureoftheday.R
import ru.aslazarev.pictureoftheday.databinding.ActivityMainBinding
import ru.aslazarev.pictureoftheday.ui.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commitNow()
        }
    }
}