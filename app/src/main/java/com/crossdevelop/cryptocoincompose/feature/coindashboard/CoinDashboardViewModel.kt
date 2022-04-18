package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crossdevelop.cryptocoincompose.common.base.BaseViewModel
import com.crossdevelop.cryptocoincompose.common.di.ActivitySnack
import com.crossdevelop.cryptocoincompose.common.models.CoinList
import com.crossdevelop.cryptocoincompose.common.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class CoinDashboardViewModel @Inject constructor(
    @ActivitySnack private val activitySnack: MutableStateFlow<String?>,
    private val coinRepository: CoinRepository
) : BaseViewModel(activitySnack) {

    private var _viewState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val viewState: StateFlow<ViewState> = _viewState

    private var _coinDashboardEvent = MutableStateFlow<CoinDashboardEvent>(CoinDashboardEvent.Nothing)
    val coinDashboardEvent: StateFlow<CoinDashboardEvent> = _coinDashboardEvent

    init {
        getCoinList()
    }

    fun getCoinList() {
        viewModelScope.launch {
            kotlin.runCatching {
                coinRepository.getCoinList()
            }.onSuccess {
                _viewState.value = ViewState.CoinListResult(it)
            }.onFailure {
                handleError(it)
            }
        }
    }

    fun goToCoinDetail(coinId: String) {
        _coinDashboardEvent.value = CoinDashboardEvent.GoToCoinDetail(coinId)
    }

    sealed class CoinDashboardEvent {
        object Nothing : CoinDashboardEvent()
        data class GoToCoinDetail(val coinId: String) : CoinDashboardEvent()
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class CoinListResult(val coins: List<CoinList>) : ViewState()
    }

}