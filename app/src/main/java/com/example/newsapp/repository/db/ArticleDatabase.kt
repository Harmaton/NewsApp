package com.example.newsapp.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.model.Article
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [Article::class],
    version = 3
)

@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun getArticleDao() : ArticleDAO

    companion object{
        @Volatile
        private var articledbInstance: ArticleDatabase? =null
        private val LOCK = Any()

        @OptIn(InternalCoroutinesApi::class)
        operator fun invoke (context: Context) = articledbInstance ?: synchronized(LOCK){

            articledbInstance ?: createDatabaseInstance(context).also {
                articledbInstance = it
            }
        }
        private fun createDatabaseInstance(context: Context) = Room.databaseBuilder(
            context,ArticleDatabase::class.java,"articles_db.db").fallbackToDestructiveMigration().build()
    }

}