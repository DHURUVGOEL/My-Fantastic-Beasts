package com.example.myfantasticbeasts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var animal_name: TextView
    private lateinit var sci_name: TextView
    private lateinit var location: TextView
    private lateinit var kingdom: TextView
    private lateinit var phylum: TextView
    private lateinit var clas: TextView
    private lateinit var order: TextView
    private lateinit var family: TextView
    private lateinit var genus: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        imageView = findViewById(R.id.imageView)
        animal_name = findViewById(R.id.animal_name)
        sci_name = findViewById(R.id.sci_name)
        location = findViewById(R.id.location)
        kingdom = findViewById(R.id.kingdom)
        phylum = findViewById(R.id.phylum)
        clas = findViewById(R.id.clas)
        order = findViewById(R.id.order)
        family = findViewById(R.id.family)
        genus = findViewById(R.id.genus)

       val intent = intent
         val image = intent?.getStringExtra("image")
         val animalName = intent?.getStringExtra("animalName")
         val sciName = intent?.getStringExtra("SciName")

    }
}