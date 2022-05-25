package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.lifecycle.viewModelScope
import com.crossdevelop.cryptocoincompose.common.base.BaseViewModel
import com.crossdevelop.cryptocoincompose.common.di.ActivitySnack
import com.crossdevelop.cryptocoincompose.common.domain.models.CoinList
import com.crossdevelop.cryptocoincompose.common.domain.usecase.FavoriteCoinUseCase
import com.crossdevelop.cryptocoincompose.common.domain.usecase.GetCoinListUseCase
import com.crossdevelop.cryptocoincompose.common.domain.usecase.UnFavoriteCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoinDashboardViewModel @Inject constructor(
    @ActivitySnack private val activitySnack: MutableStateFlow<String?>,
    private val getCoinListUseCase: GetCoinListUseCase,
    private val favoriteCoinUseCase: FavoriteCoinUseCase,
    private val unFavoriteCoinUseCase: UnFavoriteCoinUseCase
) : BaseViewModel(activitySnack) {

    private var _viewState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val viewState: StateFlow<ViewState> = _viewState

    private var _viewEvent = MutableStateFlow<ViewEvent>(ViewEvent.Nothing)
    val viewEvent: StateFlow<ViewEvent> = _viewEvent

    private var coins: List<CoinList> = emptyList()
    private var currentQuery: String = ""

    init {
        getCoinList()
    }

    fun getCoinList() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                getCoinListUseCase.getCoinList()
            }.onSuccess {
                coins = it
                queryCoins(currentQuery)
            }.onFailure {
                handleError(it)
            }
        }
    }

    fun queryCoins(query: String) {
        viewModelScope.launch {
            currentQuery = query
            val filteredCoins = if (query.isNotEmpty()) {
                coins.filter { it.symbol.contains(query) }
            } else {
                coins
            }
            _viewState.tryEmit(
                ViewState.CoinListResult(
                    _query = currentQuery,
                    coins = filteredCoins
                )
            )
        }
    }

    fun favoriteCoin(coin: CoinList) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteCoinUseCase.favoriteCoin(coinId = coin.id)
            getCoinList()
            _viewEvent.value = ViewEvent.FavoriteChanged(true, coin.name)
        }
    }

    fun deleteFavoriteCoin(coin: CoinList) {
        viewModelScope.launch(Dispatchers.IO) {
            unFavoriteCoinUseCase.unFavoriteCoin(coinId = coin.id)
            getCoinList()
            _viewEvent.value = ViewEvent.FavoriteChanged(false, coin.name)
        }
    }

    fun goToCoinDetail(coinId: String) {
        _viewEvent.tryEmit(ViewEvent.GoToCoinDetail(coinId))
    }

    fun consumedEvent() {
        _viewEvent.value = ViewEvent.Nothing
    }

    sealed class ViewEvent {
        object Nothing : ViewEvent()
        data class GoToCoinDetail(val coinId: String) : ViewEvent()
        data class FavoriteChanged(val favorited: Boolean, val coinName: String) : ViewEvent()
    }

    sealed class ViewState(val query: String) {
        object Loading : ViewState("")
        data class CoinListResult(private val _query: String, val coins: List<CoinList>) : ViewState(_query)
    }

}