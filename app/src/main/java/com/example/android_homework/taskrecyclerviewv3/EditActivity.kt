package com.example.android_homework.taskrecyclerviewv3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_homework.taskrecyclerviewv3.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.plant1
    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
    }

    private fun initButton() = with(binding) {
        buttonEdit.setOnClickListener {
            indexImage++
            if (indexImage > imageIdList.size - 1) indexImage = 0
            Log.d("MyLog", "Index: $indexImage")
            imageId = imageIdList[indexImage]
            imageViewEdit.setImageResource(imageId)
        }

        buttonEditTextDone.setOnClickListener {
            val plant = Plant(
                imageId,
                editTextTitle.text.toString(),
                editTextDescription.text.toString()
            )
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}