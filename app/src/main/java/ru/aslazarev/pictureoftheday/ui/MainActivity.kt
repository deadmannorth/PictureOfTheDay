package ru.aslazarev.pictureoftheday.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.aslazarev.pictureoftheday.R
import ru.aslazarev.pictureoftheday.databinding.ActivityMainBinding
import ru.aslazarev.pictureoftheday.ui.picture.PictureOfTheDayFragment
import ru.aslazarev.pictureoftheday.ui.settings.AppPreference

class MainActivity : AppPreference() {
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