package com.shs.detail

import androidx.lifecycle.viewModelScope
import com.shs.domain.top_headlines.usecase.FetchTopHeadlinesByPkUseCase
import com.shs.ui.base.mvi.BaseMviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    val fetchTopHeadlinesByPkUseCase: FetchTopHeadlinesByPkUseCase
): BaseMviViewModel<DetailContract.DetailEvent, DetailContract.DetailUiState, DetailContract.DetailSideEffect>(){

    override fun createInitialState(): DetailContract.DetailUiState = DetailContract.DetailUiState(detailTopNews = null)

    override fun handleEvent(event: DetailContract.DetailEvent) {

    }

    fun fetchDetailInfo(pk : String){
        viewModelScope.launch {
            fetchTopHeadlinesByPkUseCase(pk = pk).collect {
                setState {
                    copy(detailTopNews = it)
                }
            }
        }
    }
}
