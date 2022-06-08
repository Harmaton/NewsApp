package com.example.newsapp.repository

import com.example.newsapp.model.Article
import com.example.newsapp.repository.db.ArticleDatabase
import com.example.newsapp.repository.service.RetrofitClient

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getBreakingNews(countrycode: String , pageNumber: Int){
        RetrofitClient.api.getBreakingNews(countrycode,pageNumber)
    }
    suspend fun searchNews(q: String , pageNumber: Int){
        RetrofitClient.api.getSearchNews(q,pageNumber)
    }
    suspend fun insert(article: Article) = db.getArticleDao().insert(article)
    suspend fun delete(article: Article) = db.getArticleDao().deleteArticle(article)
    suspend fun getAllArticles()=db.getArticleDao().getAllArticles()


}