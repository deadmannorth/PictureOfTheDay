package ru.aslazarev.pictureoftheday.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import ru.aslazarev.pictureoftheday.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        classic.setOnClickListener { view: View? ->
            setAppTheme(ClassicThemeStyle)
            activity?.recreate()
        }
        mars.setOnClickListener(View.OnClickListener { view: View? ->
            setAppTheme(MarsThemeStyle)
            activity?.recreate()
        })
        lunar.setOnClickListener(View.OnClickListener { view: View? ->
            setAppTheme(LunarThemeStyle)
            activity?.recreate()
        })
    }

    fun setAppTheme(themeCode: Int) {
        activity?.let {
            val sharedPref =
                it.getSharedPreferences(APP_PREFS, AppCompatActivity.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putInt(SAVED_PREFS, themeCode)
            editor.apply()
        }
    }
}