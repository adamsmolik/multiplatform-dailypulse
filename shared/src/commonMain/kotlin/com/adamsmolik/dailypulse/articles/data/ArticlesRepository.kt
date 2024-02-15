package com.adamsmolik.dailypulse.articles.data

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService,
) {

    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {
        if(forceFetch) {
            dataSource.clearArticles()
            return fetchArticles()
        }

        val articlesDb = dataSource.getAllArticles()

        return articlesDb.ifEmpty {
            return fetchArticles()
        }
    }

    private suspend fun fetchArticles() :List<ArticleRaw> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}
