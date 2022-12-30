package com.example.calmsleepwalpapers.util

import androidx.annotation.DrawableRes
import com.example.calmsleepwalpapers.R

sealed class OnBoardingPage(
    @DrawableRes
    val image : Int,
    val description : String,
){
    object First : OnBoardingPage(
        image = R.drawable.ic_image1,
        description = "Yoga is the journey of the self, through the self, to the self."
    )

    object Second : OnBoardingPage(
        image = R.drawable.ic_image2,
        description = "The quieter you become the more you are able to hear"
    )

    object Third : OnBoardingPage(
        image = R.drawable.ic_image3,
        description = "In the midst of movement and chaos, keep stillness inside of you."
    )
}
