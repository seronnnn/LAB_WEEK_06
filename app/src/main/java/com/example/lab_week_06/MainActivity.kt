package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var catAdapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        catAdapter = CatAdapter(layoutInflater, GlideImageLoader(this), object :
            CatViewHolder.OnClickListener {
            override fun onClick(cat: CatModel) = showSelectionDialog(cat)
        })


        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Tom", "Always chasing Jerry", "https://cdn2.thecatapi.com/images/c9f.jpg"),
                CatModel(Gender.Female, CatBreed.BalineseJavanese, "Luna", "Loves moonlight naps", "https://cdn2.thecatapi.com/images/8sd.jpg"),
                CatModel(Gender.Male, CatBreed.AmericanCurl, "Max", "Cool and calm", "https://cdn2.thecatapi.com/images/bpc.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Chloe", "Elegant and quiet", "https://cdn2.thecatapi.com/images/d8n.jpg"),
                CatModel(Gender.Unknown, CatBreed.BalineseJavanese, "Shadow", "Mysterious presence", "https://cdn2.thecatapi.com/images/ae3.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Leo", "King of the house", "https://cdn2.thecatapi.com/images/5ln.jpg"),
                CatModel(Gender.Female, CatBreed.AmericanCurl, "Misty", "Soft and sweet", "https://cdn2.thecatapi.com/images/9g3.jpg")
            )
        )

    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK", null)
            .show()
    }
}
