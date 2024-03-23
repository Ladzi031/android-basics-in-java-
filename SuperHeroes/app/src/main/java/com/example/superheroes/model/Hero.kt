package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @StringRes
    val nameId: Int,
    @StringRes
    val descriptionId: Int,
    @DrawableRes
    val imageResourceId: Int
)
