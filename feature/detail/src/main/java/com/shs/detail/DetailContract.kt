package com.shs.detail

import androidx.compose.runtime.Immutable
import com.shs.domain.top_headlines.model.TopNewsModel
import com.shs.ui.base.mvi.UiEvent
import com.shs.ui.base.mvi.UiSideEffect
import com.shs.ui.base.mvi.UiState

class DetailContract {

    sealed interface DetailEvent : UiEvent{
    }

    @Immutable
    data class DetailUiState(
        val detailTopNews : TopNewsModel? = null
    ): UiState


    sealed interface DetailSideEffect : UiSideEffect {
    }

}