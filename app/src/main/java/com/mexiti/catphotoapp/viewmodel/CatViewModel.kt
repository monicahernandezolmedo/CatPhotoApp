package com.mexiti.catphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.catphotoapp.network.CatApi
import kotlinx.coroutines.launch
import okio.IOException

class CatViewModel:ViewModel() {
    var catUiState by mutableStateOf("")
        private set

    init {
        getCatPhotos()
    }

    fun getCatPhotos() {
        viewModelScope.launch {
            try {

                val listResult = CatApi.retrofitService.getPhotos()
                catUiState = listResult
            }
            catch (e:IOException){

            }
        }
    }
}