package com.sm.main.livedatademo.ui.quotes

import androidx.lifecycle.ViewModel
import com.sm.main.livedatademo.data.QuoteRepository
import com.sm.main.livedatademo.data.Quotes

class QuotesViewModel(private val quotesRepository: QuoteRepository) : ViewModel (){
    fun getQuotes() = quotesRepository.getQuotes()
    fun addQuotes(quotes : Quotes)= quotesRepository.addQuote(quotes)

}