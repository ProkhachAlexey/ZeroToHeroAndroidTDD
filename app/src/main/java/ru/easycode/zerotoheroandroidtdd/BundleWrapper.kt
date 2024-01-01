package ru.easycode.zerotoheroandroidtdd

interface BundleWrapper {


    interface Save {
        fun save(list: ArrayList<CharSequence>)
    }

    interface Restore {
        fun restore(): List<CharSequence>
    }

    interface Mutable : Save, Restore

    class Base : Mutable {

        override fun save(list: ArrayList<CharSequence>) {
            TODO("Not yet implemented")
        }

        override fun restore(): List<CharSequence> {
            TODO("Not yet implemented")
        }
    }
}