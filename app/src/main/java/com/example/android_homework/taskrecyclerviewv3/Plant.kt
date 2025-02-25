package com.example.android_homework.taskrecyclerviewv3

import java.io.Serializable

data class Plant(
    val imageId: Int,
    val title: String,
    val description: String
) : Serializable
