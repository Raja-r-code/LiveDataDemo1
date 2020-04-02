package com.sm.main.livedatademo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeDao {

    private val quoteList = mutableListOf<Quotes>()
    private val quotes= MutableLiveData<List<Quotes>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quotes) {
        quoteList.add(quote)
        // After adding a quote to the "database",
        // update the value of MutableLiveData
        // which will notify its active observers
        quotes.value = quoteList
    }
    fun getQuotes() = quotes as LiveData<List<Quotes>>
}