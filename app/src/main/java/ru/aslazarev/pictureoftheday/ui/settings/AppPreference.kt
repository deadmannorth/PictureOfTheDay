package ru.aslazarev.pictureoftheday.ui.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.aslazarev.pictureoftheday.R

const val APP_PREFS = "pod.themes.prefs"
const val SAVED_PREFS = "get.saved.theme.toApp"

const val ClassicThemeStyle = 0
const val MarsThemeStyle = 1
const val LunarThemeStyle = 2

open class AppPreference: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSavedTheme(getCodeStyle())
    }

    fun getCodeStyle(): Int {
        val sharedPref =
            getSharedPreferences(APP_PREFS, MODE_PRIVATE)
        return sharedPref.getInt(SAVED_PREFS, 0)
    }

    fun getSavedTheme(themeCode: Int) {
        when (themeCode) {
            ClassicThemeStyle -> setTheme(R.style.AppThemeClassic)
            MarsThemeStyle -> setTheme(R.style.MarsTheme)
            LunarThemeStyle -> setTheme(R.style.LunarTheme)
        }
    }
}