package ru.leadersofdigital.rosedu.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel<T>(private val initState: T) : ViewModel() {

    val state: LiveData<T>
        get() = action

    protected val currentState
        get() = action.value ?: initState

    protected open val isStartActionState = true

    protected val action = MutableLiveData<T>()

    init {
        if (isStartActionState) {
            updateState(state = initState)
        }
    }

    protected fun launch(start: suspend () -> Unit) = viewModelScope.launch {
        start.invoke()
    }

    protected fun updateState(state: T) {
        action.value = state
    }
}