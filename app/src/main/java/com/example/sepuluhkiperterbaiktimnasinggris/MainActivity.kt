package com.example.sepuluhkiperterbaiktimnasinggris

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvKipers: RecyclerView
    private var list: ArrayList<Kiper> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKipers = findViewById(R.id.rv_heroes)
        rvKipers.setHasFixedSize(true)

        list.addAll(KiperData.listData)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvKipers.layoutManager = LinearLayoutManager(this)
        val listKiperAdapter = ListKiperAdapter(list)
        rvKipers.adapter = listKiperAdapter
        listKiperAdapter.setOnItemClickCallback(object : ListKiperAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Kiper) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(kiper: Kiper) {
        //Toast.makeText(this, "Kamu memilih " + kiper.name + " " + kiper.photo, Toast.LENGTH_SHORT).show()
        val moveWithDataIntent = Intent(this@MainActivity, KiperActivity::class.java)
        moveWithDataIntent.putExtra(KiperActivity.EXTRA_NAME, kiper.name)
        moveWithDataIntent.putExtra(KiperActivity.EXTRA_DETAIL, kiper.detail)
        moveWithDataIntent.putExtra(KiperActivity.EXTRA_IMAGE, kiper.photo)
        startActivity(moveWithDataIntent)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_About -> {
                val moveIntentAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntentAbout)
            }
        }
    }
}
