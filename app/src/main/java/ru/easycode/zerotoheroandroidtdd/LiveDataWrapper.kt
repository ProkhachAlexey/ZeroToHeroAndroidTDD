package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper : ProvideLiveData {

    fun update(state: UiState)

    class Base(
        private val liveData: MutableLiveData<UiState> = MutableLiveData()
    ) : LiveDataWrapper {

        override fun update(state: UiState) {
            liveData.value = state
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }
    }
}

interface ProvideLiveData {
   fun liveData(): LiveData<UiState>
}