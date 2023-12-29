package com.example.composepractice.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composepractice.States.MyScreenState

class MyViewModel: ViewModel() {

    val state = mutableStateOf(MyScreenState())

    fun updateText(newText: String) {
        state.value = state.value.copy(text = newText)
    }

    fun updateName(newName: String) {
       val currentList = state.value.newNameList
        currentList.add(newName)
        state.value = state.value.copy(newNameList = currentList)

}
}