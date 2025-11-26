package com.example.launcher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AppAdapter(private val context: android.content.Context, private val apps: List<AppInfo>) : BaseAdapter() {
    override fun getCount(): Int = apps.size
    override fun getItem(position: Int): Any = apps[position]
    override fun getItemId(position: Int): Long = position.toLong()
    
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_app, parent, false)
        val app = apps[position]
        
        view.findViewById<ImageView>(R.id.appIcon).setImageDrawable(app.icon)
        view.findViewById<TextView>(R.id.appName).text = app.name
        
        return view
    }
}
