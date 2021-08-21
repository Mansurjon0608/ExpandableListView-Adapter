package com.example.expandablelistview

import Adapters.MyExpandableAdapter
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_child.*

class MainActivity : AppCompatActivity() {
    lateinit var map : HashMap<String, List<String>>
    lateinit var titleList:ArrayList<String>
    lateinit var myExpandableListAdapter: MyExpandableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleList = ArrayList()
        map = HashMap()

        titleList.add("Samsung")
        titleList.add("iPhone")
        titleList.add("LG")
        titleList.add("Acer")
        titleList.add("Honor")

        map[titleList[0]] = listOf("Galaxy", "Due", "Galaxy11", "Galaxy Pro")
        map[titleList[1]] = listOf("iPhone 6", "iPhone Gold", "iPhone 12 Pro", "iPhone Pro ", "iPhone ProMax")
        map[titleList[2]] = listOf("LG 2004", "LG 2009", "LG 2020", "LG Beta", "Beta Pro 9.0")
        map[titleList[3]] = listOf("Acer BigMag", "Acer 2.2", "Acer Mini 7.8")
        map[titleList[4]] = listOf("Honor Digit", "Honor Digit 6", "Honor Pro Neuih", "Beta Triple Max Duo")


        myExpandableListAdapter = MyExpandableAdapter(titleList, map)
        expanded_menu.setAdapter(myExpandableListAdapter)



        expanded_menu.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
             Toast.makeText(this, "${map[titleList[groupPosition]]?.get(childPosition)}", Toast.LENGTH_SHORT).show()
                val mediaPlayer = MediaPlayer.create(this, R.raw.mixkit)
                mediaPlayer.start()
            startActivity(Intent(this, Info::class.java))

            true
        }





    }
}

