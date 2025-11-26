package com.example.launcher

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val gridView = findViewById<GridView>(R.id.appsGrid)
        val apps = getInstalledApps()
        gridView.adapter = AppAdapter(this, apps)
    }
    
    private fun getInstalledApps(): List<AppInfo> {
        val mainIntent = Intent(Intent.ACTION_MAIN, null)
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        val packages = packageManager.queryIntentActivities(mainIntent, 0)
        
        return packages.map {
            AppInfo(
                it.loadLabel(packageManager).toString(),
                it.activityInfo.packageName,
                it.loadIcon(packageManager)
            )
        }
    }
}

data class AppInfo(
    val name: String,
    val packageName: String,
    val icon: android.graphics.drawable.Drawable
)
