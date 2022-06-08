package com.codingurkan.ag_store.util


import com.codingurkan.ag_store.R
import com.codingurkan.ag_store.model.DataItem

object PageLists {

    val introSlides = arrayListOf(
        DataItem(R.drawable.clothing,"Clothes","For Clothing"),
        DataItem(R.drawable.diet,"Foods","For Foods")
    )


    val clothes = arrayListOf(
        DataItem(R.drawable.jeans,"Jeans",null),
        DataItem(R.drawable.blazer,"Blazer",null),
        DataItem(R.drawable.highheels,"Highheels",null),
        DataItem(R.drawable.jacket,"Jacket",null)
    )

    val foods = arrayListOf(
        DataItem(R.drawable.diet,"Diet Food",null),
        DataItem(R.drawable.hamburger,"Hamburger",null),
        DataItem(R.drawable.bibimbap,"Bibimbap",null),
        DataItem(R.drawable.pizza,"Pizza",null)
    )
}