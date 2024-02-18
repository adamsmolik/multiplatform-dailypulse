package com.adamsmolik.dailypulse.data.article.repository

import com.adamsmolik.dailypulse.data.article.api.ArticleApi
import com.adamsmolik.dailypulse.data.article.datasource.ArticleDataSource
import com.adamsmolik.dailypulse.data.article.model.toModel
import com.adamsmolik.dailypulse.domain.article.model.ArticleModel
import com.adamsmolik.dailypulse.domain.article.repository.ArticleRepository
import com.adamsmolik.dailypulse.core.base.arch.Result
import com.adamsmolik.dailypulse.core.base.arch.map
import com.adamsmolik.dailypulse.core.base.arch.resultData

class ArticleRepositoryImpl(
    private val dataSource: ArticleDataSource,
    private val articleApi: ArticleApi,
) : ArticleRepository {
    override suspend fun listArticles(forceRefresh: Boolean): Result<List<ArticleModel>> {
        if (forceRefresh) {
            dataSource.clearArticles()
            return fetchArticles()
        }

        val articlesDb = dataSource.getAllArticles()

        return if (articlesDb.isEmpty()) {
            fetchArticles()
        } else {
            resultData(articlesDb)
        }
    }

    private suspend fun fetchArticles(): Result<List<ArticleModel>> {
        val fetchedArticles = articleApi.fetchArticles().map {
            val articles = it.articles.map { item -> item.toModel() }
            dataSource.insertArticles(articles)
            articles
        }
        return fetchedArticles
    }
}
