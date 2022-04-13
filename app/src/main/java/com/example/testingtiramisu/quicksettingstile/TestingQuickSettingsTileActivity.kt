package com.example.testingtiramisu.quicksettingstile

import android.annotation.SuppressLint
import android.app.StatusBarManager
import android.content.ComponentName
import android.content.Context
import android.graphics.drawable.Icon
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.testingtiramisu.R

class TestingQuickSettingsTileActivity : AppCompatActivity() {

    @SuppressLint("NewApi", "WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_quick_settings_tile)

        findViewById<Button>(R.id.button_add_quick_settings).setOnClickListener {
            if (Build.VERSION.CODENAME == "Tiramisu") {
                val statusBarManager =
                    getSystemService(Context.STATUS_BAR_SERVICE) as StatusBarManager
                /**
                 * Important: Change the package name accordingly to your own package name!
                 */
                statusBarManager.requestAddTileService(
                    ComponentName(
                        "com.example.testingtiramisu",
                        "com.example.testingtiramisu.quicksettingstile.StartAppTileService",
                    ),
                    getString(R.string.app_name),
                    Icon.createWithResource(this, R.drawable.ic_launcher_foreground),
                    {},
                    {}
                )
            } else {
                Toast.makeText(
                    this,
                    "`requestAddTileService` can only be called in Android 13/Tiramisu.",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }

    }
}