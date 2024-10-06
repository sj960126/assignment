package com.shs.news

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.shs.domain.top_headlines.model.TopNewsModel
import com.shs.ui.base.mvi.UiEvent
import com.shs.ui.base.mvi.UiSideEffect
import com.shs.ui.base.mvi.UiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class NewsContract {

    sealed interface NewsEvent : UiEvent{
        data class ItemClick(val pk: String) : NewsEvent
    }

    @Stable
    data class NewsUiState(
        val newsUiState : NewsContentUiState
    ): UiState


    @Stable
    sealed interface NewsContentUiState {

        @Immutable
        object Loading : NewsContentUiState

        @Immutable
        object Empty : NewsContentUiState

        @Immutable
        object Error : NewsContentUiState

        @Immutable
        data class Success(
            val news : ImmutableList<TopNewsModel> = persistentListOf(),
        ) : NewsContentUiState
    }

    sealed interface NewsSideEffect : UiSideEffect {
        data class NavigateToDetail(val pk: String) : NewsSideEffect
    }

}