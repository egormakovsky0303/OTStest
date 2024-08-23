package com.makovsky.otstest.presentation.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makovsky.otstest.domain.entities.Boot
import com.makovsky.otstest.domain.usecase.BaseUseCase
import com.makovsky.otstest.domain.usecase.GetLastBootUseCase
import com.makovsky.otstest.domain.usecase.SaveBootUseCase

class HomeViewModel(
    private val getLastBootUseCase: GetLastBootUseCase,
    private val saveBootUseCase: SaveBootUseCase,
): ViewModel() {

    private val _state = MutableLiveData<Boot?>()
    val state: LiveData<Boot?> = _state

    init {
        getLastBootUseCase.invoke(viewModelScope, BaseUseCase.None()){
            it.either({}, { ::updateState })
        }
    }

    private fun updateState(boot: Boot) {
        _state.value = boot
    }
}