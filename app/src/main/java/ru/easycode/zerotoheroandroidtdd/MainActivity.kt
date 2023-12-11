package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var uiState: UiState
    private val count = Count.Base(1, 5, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            uiState = count.initial(binding.countTextView.text.toString())
            updateUi()
        }

        binding.incrementButton.setOnClickListener {
            uiState = count.increment(binding.countTextView.text.toString())
            updateUi()
        }

        binding.decrementButton.setOnClickListener {
            uiState = count.decrement(binding.countTextView.text.toString())
            updateUi()
        }

    }

    private fun updateUi() {
        uiState.apply(binding.incrementButton, binding.decrementButton, binding.countTextView)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        else
            savedInstanceState.getSerializable(KEY) as UiState
        updateUi()
    }

    private companion object {
        const val KEY = "key"
    }
}