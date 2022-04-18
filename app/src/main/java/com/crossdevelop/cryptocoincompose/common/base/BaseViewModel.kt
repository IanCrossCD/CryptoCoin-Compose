package com.crossdevelop.cryptocoincompose.common.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.HttpException
import timber.log.Timber

abstract class BaseViewModel(private val activityViewState: MutableStateFlow<String?>) : ViewModel() {

    fun handleError(error: String?) {
        Timber.e(error)
        activityViewState.tryEmit(error)
    }

    fun handleError(error: Throwable) {
        Timber.e(error)
        handleError(getErrorString(error))
    }
//
//    fun setActivityLoading() {
//        activityViewState.postValue(ActivityViewState.Loading)
//    }

    private fun getErrorString(error: Throwable): String? {
        return when (error) {
            is HttpException -> error.message()
            else -> error.message
        }
    }
//
//    open val isLoading : Boolean
//        get() = activityViewState.value == ActivityViewState.Loading
}
