package com.crossdevelop.cryptocoincompose.feature

import androidx.lifecycle.ViewModel
import com.crossdevelop.cryptocoincompose.common.di.ActivitySnack
import com.crossdevelop.cryptocoincompose.common.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class CryptoCoinAppViewModel @Inject constructor(
    @ActivitySnack _activitySnack: MutableStateFlow<String>,
    private val coinRepository: CoinRepository
) : ViewModel() {

    val activitySnack: MutableStateFlow<String> = _activitySnack

}