package com.adamsmolik.dailypulse.data.article.datasource

import com.adamsmolik.dailypulse.core.db.DailyPulseDatabase
import com.adamsmolik.dailypulse.domain.article.model.ArticleModel

class ArticleDataSource(
    private val database: DailyPulseDatabase,
) {

    fun getAllArticles(): List<ArticleModel> = database.dailyPulseDatabaseQueries
        .selectAllArticles(::mapToArticle)
        .executeAsList()

    fun insertArticles(articles: List<ArticleModel>) {
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }
    }

    fun clearArticles() = database.dailyPulseDatabaseQueries.removeAllArticles()

    private fun insertArticle(article: ArticleModel) {
        database.dailyPulseDatabaseQueries.insertArticle(
            title = article.title,
            desc = article.desc,
            date = article.date,
            imageUrl = article.imageUrl,
        )
    }

    private fun mapToArticle(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ): ArticleModel = ArticleModel(
        title = title,
        desc = desc,
        date = date,
        imageUrl = url,
    )
}
