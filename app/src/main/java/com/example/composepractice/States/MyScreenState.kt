package com.example.composepractice.States

import androidx.compose.runtime.mutableStateOf

data class MyScreenState(
    val text: String = "",
    val newNameList: MutableList<String> = mutableListOf(),
)
