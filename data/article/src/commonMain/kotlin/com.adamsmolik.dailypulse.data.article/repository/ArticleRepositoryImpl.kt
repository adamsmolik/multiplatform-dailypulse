package com.adamsmolik.dailypulse.data.article.repository

import com.adamsmolik.dailypulse.data.article.api.ArticleApi
import com.adamsmolik.dailypulse.data.article.datasource.ArticleDataSource
import com.adamsmolik.dailypulse.data.article.model.toModel
import com.adamsmolik.dailypulse.domain.article.model.ArticleModel
import com.adamsmolik.dailypulse.domain.article.repository.ArticleRepository

class ArticleRepositoryImpl(
    private val dataSource: ArticleDataSource,
    private val articleApi: ArticleApi,
) : ArticleRepository {
    override suspend fun listArticles(forceRefresh: Boolean): List<ArticleModel> {
        if (forceRefresh) {
            dataSource.clearArticles()
            return fetchArticles()
        }

        val articlesDb = dataSource.getAllArticles()

        return articlesDb.ifEmpty {
            return fetchArticles()
        }
    }

    private suspend fun fetchArticles(): List<ArticleModel> {
        val fetchedArticles = articleApi.fetchArticles().map { it.toModel() }
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}
