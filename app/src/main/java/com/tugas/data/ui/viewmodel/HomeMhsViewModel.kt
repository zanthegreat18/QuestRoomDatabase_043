package com.tugas.data.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tugas.data.data.entity.Mahasiswa
import com.tugas.data.data.repositori.RepositoriMhs
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow


data class HomeUIState (
    val listMhs: List<Mahasiswa> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)

class HomeMhsViewModel(
    private val repositoriMhs: RepositoriMhs
) : ViewModel(){

    val homeUiState: StateFlow<HomeUIState> = repositoriMhs.getAllMhs()
        .filterNotNull()
        .map {
            HomeUIState(
                listMhs = it.toList(),
                isLoading = false,
            )
        }
        .onStart {
            emit(HomeUIState(isLoading = true))
            delay(900)
        }
        .catch {
            emit(
                HomeUIState(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi Kesalahan"
                )
            )
        }
        .statein(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeUIState(
                isLoading = true)
        )
}