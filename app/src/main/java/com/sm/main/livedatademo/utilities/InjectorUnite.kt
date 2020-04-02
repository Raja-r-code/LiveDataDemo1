package com.sm.main.livedatademo.utilities

import com.sm.main.livedatademo.data.FakeDb
import com.sm.main.livedatademo.data.QuoteRepository
import com.sm.main.livedatademo.ui.quotes.QuotesViewModelFactory

object InjectorUnite {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDb.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}