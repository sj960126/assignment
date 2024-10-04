package com.shs.domain.top_headlines.usecase

import com.shs.domain.top_headlines.model.TopNewsModel
import com.shs.domain.top_headlines.repository.ITopHeadlinesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchTopHeadlinesUseCase @Inject constructor(
    private val repository: ITopHeadlinesRepository
) {
    operator fun invoke(country : String): Flow<List<TopNewsModel>> = repository.fetchTopHeadlinesForCountry(country = country)
}