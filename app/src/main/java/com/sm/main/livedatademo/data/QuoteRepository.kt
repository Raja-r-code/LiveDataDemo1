package com.sm.main.livedatademo.data

class QuoteRepository private constructor(private val fakeDao: FakeDao){

    fun addQuote(quotes : Quotes){
        fakeDao.addQuote(quotes)
    }

    fun getQuotes() = fakeDao.getQuotes()

    companion object{
        @Volatile private var instance : QuoteRepository?=null
        fun getInstance(quoateDao: FakeDao) = instance
            ?: synchronized(this){
            instance
                ?: QuoteRepository(quoateDao).also { instance = it }

        }
    }
}