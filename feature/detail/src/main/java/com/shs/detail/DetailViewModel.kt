package com.shs.detail

import com.shs.domain.top_headlines.usecase.FetchTopHeadlinesUseCase
import com.shs.ui.base.mvi.BaseMviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    val fetchTopHeadlinesUseCase: FetchTopHeadlinesUseCase
): BaseMviViewModel<DetailContract.DetailEvent, DetailContract.DetailUiState, DetailContract.DetailSideEffect>(){

    override fun createInitialState(): DetailContract.DetailUiState = DetailContract.DetailUiState(detailTopNews = null)

    init {
    }

    override fun handleEvent(event: DetailContract.DetailEvent) {

    }

}
