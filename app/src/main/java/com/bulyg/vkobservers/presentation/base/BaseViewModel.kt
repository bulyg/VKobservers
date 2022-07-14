package com.bulyg.vkobservers.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<D : Any, E : Any> : ViewModel() {
    private val _uiState: MutableStateFlow<AppState<D, E>> = MutableStateFlow(AppState.Init)
    val uiState: StateFlow<AppState<D, E>> = _uiState.asStateFlow()

    open fun setLoading(progress: Float? = null) {
        _uiState.tryEmit(AppState.Loading(progress))
    }

    open fun setSuccessful(data: D) {
        _uiState.tryEmit(AppState.Success(data))
    }

    open fun setError(error: E) {
        _uiState.tryEmit(AppState.Error(error))
    }
}
