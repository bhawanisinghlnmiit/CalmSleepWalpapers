package com.example.calmsleepwalpapers.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calmsleepwalpapers.data.DataStoreRepository
import com.example.calmsleepwalpapers.presentation.ui.screens.UiScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _isLoading : MutableState<Boolean> = mutableStateOf(true)
    val isLoading : State<Boolean> = _isLoading

    private val _startDestination : MutableState<String> = mutableStateOf(UiScreens.Welcome.route)
    val startDestination : State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect{ completed ->
                if(completed){
                    _startDestination.value = UiScreens.Home.route
                }else{
                    _startDestination.value = UiScreens.Welcome.route
                }
            }
            _isLoading.value = false
        }
    }

}