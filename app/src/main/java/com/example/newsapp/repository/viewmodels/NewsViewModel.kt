package com.example.newsapp.repository.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.example.newsapp.model.Article
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.launch
import okhttp3.Response

class NewsViewModel(val newsRepository: NewsRepository): ViewModel(){
    //for breaking news
    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingPageNumber = 1
    var breakingNewsResponse: NewsResponse? = null

    //for searching news
    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchPageNumber = 1
    var searchNewsResponse: NewsResponse? = null

    lateinit var articles: LiveData<PagedList<Article>>

init {
    getBreakingNews("in")
}

    private fun getBreakingNews(countrycode: String)= viewModelScope.launch {
      breakingNews.postValue(Resource.Loading())
        val response= newsRepository.getBreakingNews(countrycode,breakingPageNumber)
        breakingNews.postValue(handleBreakingNewsResponse(response) )

    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse>? {

        if (response.isSuccessful){

        }
    }



}