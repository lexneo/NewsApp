package com.lexneoapps.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lexneoapps.newsapp.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM article_table")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}