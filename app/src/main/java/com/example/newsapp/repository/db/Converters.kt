package com.example.newsapp.repository.db

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromSource(source: com.example.newsapp.model.Source): String?{
        return source.name
    }
    @TypeConverter
    fun toSource(name: String): com.example.newsapp.model.Source{
        return com.example.newsapp.model.Source(name,name)
    }
}