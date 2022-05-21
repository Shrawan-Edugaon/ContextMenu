package com.example.contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listColor = findViewById<ListView>(R.id.list) as ListView
        val color = arrayOf("Red","Blue","Green","Black","Orange","Magenta","White","Violet","Yellow")

        val coloAdap:ArrayAdapter<String> = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,color)

        listColor.adapter = coloAdap

        registerForContextMenu(listColor)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu!!.setHeaderTitle("Select below option")

        menu.add(0,v!!.id,0,"Item1")
        menu.add(0,v!!.id,0,"Item2")
        menu.add(0,v!!.id,0,"Item3")
        menu.add(0,v!!.id,0,"Item4")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item!!.title == "Item 1")
        {
            Toast.makeText(this@MainActivity,"Item 1 was selected",Toast.LENGTH_SHORT).show()
        }
        else if (item.title == "Item 2")
        {
            Toast.makeText(this@MainActivity,"Item 2 was selected",Toast.LENGTH_SHORT).show()
        }
        else if (item.title == "Item 3")
        {
            Toast.makeText(this@MainActivity,"Item 3 was selected",Toast.LENGTH_SHORT).show()
        }
        else if (item.title == "Item 4")
        {
            Toast.makeText(this@MainActivity,"Item 4 was selected",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}