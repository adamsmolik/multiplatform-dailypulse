package com.adamsmolik.dailypulse.domain.article.usecase

import com.adamsmolik.dailypulse.core.base.arch.UseCase
import com.adamsmolik.dailypulse.core.base.arch.UseCaseInput
import com.adamsmolik.dailypulse.domain.article.model.ArticleModel
import com.adamsmolik.dailypulse.domain.article.repository.ArticleRepository
import com.adamsmolik.dailypulse.core.base.arch.Result

data class ListArticlesUseCaseInput(
    val forceRefresh: Boolean,
) : UseCaseInput

class ListArticlesUseCase(
    private val articleRepository: ArticleRepository,
) : UseCase<ListArticlesUseCaseInput, List<ArticleModel>> {
    override suspend fun execute(input: ListArticlesUseCaseInput): Result<List<ArticleModel>> = with(input) {
        articleRepository.listArticles(forceRefresh)
    }
}
