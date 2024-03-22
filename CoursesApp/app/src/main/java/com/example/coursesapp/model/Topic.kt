package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(

    @DrawableRes
    val imageResourceId: Int,

    @StringRes
    val topicName: Int,

    val numOfCourses: Int
)
