package com.lexneoapps.newsapp.repository

import com.lexneoapps.newsapp.api.RetrofitInstance
import com.lexneoapps.newsapp.db.ArticleDao
import com.lexneoapps.newsapp.db.ArticleDatabase
import com.lexneoapps.newsapp.models.Article

class NewsRepository(
    private val articleDao: ArticleDao
){

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery : String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = articleDao.upsert(article)

    fun getSavedNews() = articleDao.getAllArticles()

    suspend fun deleteArticle(article: Article) = articleDao.deleteArticle(article)

  /*  suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)*/

}