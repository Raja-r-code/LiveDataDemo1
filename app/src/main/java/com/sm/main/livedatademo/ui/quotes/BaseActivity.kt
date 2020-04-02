package com.sm.main.livedatademo.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sm.main.livedatademo.R
import com.sm.main.livedatademo.data.Quotes
import com.sm.main.livedatademo.utilities.InjectorUnite
import kotlinx.android.synthetic.main.activity_main.*

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUnite.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener{
            val quotes = Quotes(editText_author.text.toString(), editText_quote.text.toString())
            viewModel.addQuotes(quotes)
            editText_author.setText("")
            editText_quote.setText("")
        }

    }


}
