package com.sm.main.livedatademo.data

class FakeDb private constructor(){

    var quoteDao = FakeDao()
        private set
    companion object{
        @Volatile private var instance : FakeDb?=null
        fun getInstance()=
            instance ?: synchronized(this){
                instance
                    ?: FakeDb().also { instance = it }
            }
    }

    /*companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile private var instance: FakeDatabase? = null

        // The only way to get hold of the FakeDatabase object
        fun getInstance() =
        // Already instantiated? - return the instance
            // Otherwise instantiate in a thread-safe manner
            instance ?: synchronized(this) {
                // If it's still not instantiated, finally create an object
                // also set the "instance" property to be the currently created one
                instance ?: FakeDatabase().also { instance = it }
            }
    }*/

}