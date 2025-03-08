package com.example.android_homework.taskrecyclerviewv3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_homework.taskrecyclerviewv3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
//    private var index = 0
//    private val imageIdList = listOf(
//        R.drawable.plant1,
//        R.drawable.plant2,
//        R.drawable.plant3,
//        R.drawable.plant4,
//        R.drawable.plant5,
//    )
    private var editLauncher: ActivityResultLauncher<Intent>? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
            Log.d("MyLog", "Added change 1")
        }
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
//                if (index > 4) index = 0
////                val plant = Plant(imageIdList[index], "Plant $index")
//                adapter.addPlant(Plant(imageIdList[index], "Plant $index"))
//                index++
                editLauncher?.launch(
                    Intent(
                        this@MainActivity,
                        EditActivity::class.java
                    )
                )
            }
        }
    }
}