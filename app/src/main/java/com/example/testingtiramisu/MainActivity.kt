package com.example.testingtiramisu

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.testingtiramisu.databinding.ActivityMainBinding
import com.example.testingtiramisu.downgradablepermissions.TestingDowngradablePermissionActivity
import com.example.testingtiramisu.nearbywifidevicespermission.TestingNearbyWifiDevicesPermissionActivity
import com.example.testingtiramisu.notificationruntimepermission.TestingNotificationRuntimePermissionActivity
import com.example.testingtiramisu.perapplanguagepreference.TestingPerAppLanguagePreferencesActivity
import com.example.testingtiramisu.photopicker.TestingPhotoPickerActivity
import com.example.testingtiramisu.quicksettingstile.TestingQuickSettingsTileActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            btnQuickSettingsTile.setOnClickListener {
                startActivity(Intent(this@MainActivity,TestingQuickSettingsTileActivity::class.java))
            }

            btnPhotoPicker.setOnClickListener {
                startActivity(Intent(this@MainActivity,TestingPhotoPickerActivity::class.java))
            }

            btnPerAppLanguage.setOnClickListener {
                startActivity(Intent(this@MainActivity,TestingPerAppLanguagePreferencesActivity::class.java))
            }

            btnNotificationRuntimePermission.setOnClickListener {
                startActivity(Intent(this@MainActivity,TestingNotificationRuntimePermissionActivity::class.java))
            }

            btnNearByWifiDevicePermission.setOnClickListener {
                startActivity(Intent(this@MainActivity,TestingNearbyWifiDevicesPermissionActivity::class.java))
            }

            btnDowngradablePermission.setOnClickListener {
                startActivity(Intent(this@MainActivity,TestingDowngradablePermissionActivity::class.java))
            }

        }
    }
}