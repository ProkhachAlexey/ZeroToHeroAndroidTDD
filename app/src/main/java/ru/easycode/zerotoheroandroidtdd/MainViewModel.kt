package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val repository: Repository
) : LiveDataWrapper.Observe {

    override fun liveData() = liveDataWrapper.liveData()

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)


    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            repository.load().show(liveDataWrapper)
        }
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        liveDataWrapper.update(bundleWrapper.restore())
    }
}