package com.example.g5.ui.features.two

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.g5.di.app.dispatcher.DefaultDispatcher
import com.example.g5.di.app.dispatcher.IODispatcher
import com.example.g5.domain.common.ClientApiResult
import com.example.g5.domain.usecases.GetGitUseCase
import com.example.g5.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "G5-VM : "

/**
 * VM
 */
@HiltViewModel
class VM @Inject constructor(
    private val getGitUseCase: GetGitUseCase,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel<ClientApiResult<*>>() {

    /**
     * Fetch the git trending repositories
     */
    fun fetchGitTrendingRepoList() {
        Log.d(TAG, "fetchGitTrendingRepoList: ||")
        viewModelScope.launch {
            when (val clientApiResult = getGitUseCase.invoke()) {
                is ClientApiResult.Loading -> {
                    uiState.value = ClientApiResult.Loading
                }

                is ClientApiResult.Success -> {
                    uiState.value = ClientApiResult.Success(data = clientApiResult.data)
                }

                is ClientApiResult.Error -> {
                    uiState.value = ClientApiResult.Error(
                        code = clientApiResult.code,
                        errorMessage = clientApiResult.errorMessage
                    )
                }

                is ClientApiResult.Exception -> {
                    uiState.value = ClientApiResult.Exception(throwable = clientApiResult.throwable)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared: ")
    }

}