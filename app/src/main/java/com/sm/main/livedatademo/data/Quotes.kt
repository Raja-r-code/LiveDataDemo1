package com.sm.main.livedatademo.data

class Quotes(val quotes_txt: String, val author: String ) {
    override fun toString(): String {
        return "$quotes_txt - $author"
    }
}