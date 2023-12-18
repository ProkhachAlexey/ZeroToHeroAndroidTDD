package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    fun save(bundleWrapper: BundleWrapper.Save)

    fun update(state: UiState)

    fun liveData(): LiveData<UiState>

    class Base(
        private val liveData: MutableLiveData<UiState> = SingleLiveEvent()
    ) : LiveDataWrapper {
        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
        }

        override fun update(state: UiState) {
            liveData.value = state
        }

        override fun liveData() = liveData
    }
}