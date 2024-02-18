package com.adamsmolik.dailypulse.domain.article.repository

//import com.adamsmolik.dailypulse.core.base.arch.Result
import com.adamsmolik.dailypulse.domain.article.model.ArticleModel

interface ArticleRepository {
    suspend fun listArticles(forceRefresh: Boolean): List<ArticleModel>
//    suspend fun listArticles(forceRefresh: Boolean): Result<List<Article>>
}
