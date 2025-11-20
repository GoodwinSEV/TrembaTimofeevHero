package com.example.trembatimofeevhero.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.trembatimofeevhero.R

data class Hero (
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
)
 val heros = listOf(
     Hero(R.drawable.m1, R.string.m1, R.string.description_m1),
     Hero(R.drawable.m2, R.string.m2, R.string.description_m2),
     Hero(R.drawable.m3, R.string.m3, R.string.description_m3),
     Hero(R.drawable.m4, R.string.m4, R.string.description_m4),
     Hero(R.drawable.m5, R.string.m5, R.string.description_m5),
     Hero(R.drawable.m6, R.string.m6, R.string.description_m6),
     Hero(R.drawable.m7, R.string.m7, R.string.description_m7),
     Hero(R.drawable.m8, R.string.m8, R.string.description_m8),
     Hero(R.drawable.m9, R.string.m9, R.string.description_m9)
)
