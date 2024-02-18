package com.adamsmolik.dailypulse.domain.article.usecase

//import com.adamsmolik.dailypulse.core.base.arch.Result
import com.adamsmolik.dailypulse.core.base.arch.UseCase
import com.adamsmolik.dailypulse.core.base.arch.UseCaseInput
import com.adamsmolik.dailypulse.domain.article.model.ArticleModel
import com.adamsmolik.dailypulse.domain.article.repository.ArticleRepository

data class ListArticlesUseCaseInput(
    val forceRefresh: Boolean,
) : UseCaseInput

class ListArticlesUseCase(
    private val articleRepository: ArticleRepository,
) : UseCase<ListArticlesUseCaseInput, List<ArticleModel>> {
    override suspend fun execute(input: ListArticlesUseCaseInput): List<ArticleModel> = with(input) {
        articleRepository.listArticles(forceRefresh)
    }
//    override suspend fun execute(input: ListArticlesUseCaseInput): Result<List<Article>> = with(input) {
//        articleRepository.listArticles(forceRefresh)
//    }
}
