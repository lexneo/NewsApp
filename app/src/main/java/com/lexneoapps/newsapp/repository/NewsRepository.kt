package com.lexneoapps.newsapp.repository

import com.lexneoapps.newsapp.api.RetrofitInstance
import com.lexneoapps.newsapp.db.ArticleDao
import com.lexneoapps.newsapp.db.ArticleDatabase

class NewsRepository(
    private val articleDao: ArticleDao
){

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

}