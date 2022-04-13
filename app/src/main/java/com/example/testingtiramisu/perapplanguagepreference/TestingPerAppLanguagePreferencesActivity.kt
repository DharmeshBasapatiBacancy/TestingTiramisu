package com.example.testingtiramisu.perapplanguagepreference

import android.annotation.SuppressLint
import android.app.LocaleManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.testingtiramisu.R
import java.util.*

@SuppressLint("InlinedApi")
class TestingPerAppLanguagePreferencesActivity : AppCompatActivity() {
    private lateinit var localeManager: LocaleManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_per_app_language_preferences)

        if (Build.VERSION.CODENAME == "Tiramisu") {
            localeManager =
                getSystemService(Context.LOCALE_SERVICE) as LocaleManager
        }

        findViewById<Button>(R.id.button_lang_en).setOnClickListener {
            localeManager.applicationLocales = LocaleList(Locale.forLanguageTag("en"))
        }
        findViewById<Button>(R.id.button_lang_id).setOnClickListener {
            localeManager.applicationLocales = LocaleList(Locale.forLanguageTag("hi-IN"))
        }
        findViewById<Button>(R.id.button_lang_reset).setOnClickListener {
            localeManager.applicationLocales = LocaleList.getEmptyLocaleList()
        }
    }

    override fun onResume() {
        super.onResume()

        if (Build.VERSION.CODENAME == "Tiramisu") {
            val language = when (localeManager.applicationLocales.toLanguageTags()) {
                "en" -> "English"
                "hi-IN" -> "Hindi"
                else -> "Not Set"
            }
            Log.wtf("LANG", localeManager.applicationLocales.toLanguageTags())
            findViewById<TextView>(R.id.text_current_language).text =
                "Current In-App Language: $language"
        }
    }
}