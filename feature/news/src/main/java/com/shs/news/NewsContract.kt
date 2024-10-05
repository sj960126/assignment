package com.shs.news

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.shs.domain.top_headlines.model.TopNewsModel
import com.shs.ui.base.mvi.UiEvent
import com.shs.ui.base.mvi.UiSideEffect
import com.shs.ui.base.mvi.UiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal class NewsContract {

    internal sealed interface NewsEvent : UiEvent{

    }

    @Stable
    internal data class NewsUiState(
        val newsUiState : NewsContentUiState
    ): UiState


    @Stable
    internal sealed interface NewsContentUiState {

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

    internal sealed interface NewsSideEffect : UiSideEffect{

    }

}