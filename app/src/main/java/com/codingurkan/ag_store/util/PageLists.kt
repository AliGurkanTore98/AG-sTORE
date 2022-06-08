package com.codingurkan.ag_store.util


import com.codingurkan.ag_store.R
import com.codingurkan.ag_store.model.DataItem

object PageLists {

    val introSlides = arrayListOf(
        DataItem(R.drawable.clothing,"Clothes","For Clothing",null),
        DataItem(R.drawable.diet,"Foods","For Foods",null)
    )


    val clothes = arrayListOf(
        DataItem(R.drawable.jeans,"Jeans",null,"30 TL"),
        DataItem(R.drawable.blazer,"Blazer",null,"30 TL"),
        DataItem(R.drawable.highheels,"Highheels",null,"30 TL"),
        DataItem(R.drawable.jacket,"Jacket",null,"30 TL")
    )

    val foods = arrayListOf(
        DataItem(R.drawable.diet,"Diet Food",null,"30 TL"),
        DataItem(R.drawable.hamburger,"Hamburger",null,"30 TL"),
        DataItem(R.drawable.bibimbap,"Bibimbap",null,"30 TL"),
        DataItem(R.drawable.pizza,"Pizza",null,"30 TL")
    )
}