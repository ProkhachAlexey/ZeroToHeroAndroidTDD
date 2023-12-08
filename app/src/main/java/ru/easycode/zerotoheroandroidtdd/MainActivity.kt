package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isTextViewVisible = true
    private var isEnabledButton = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        binding.removeButton.setOnClickListener {
            changeState()
            isTextViewVisible = false
            isEnabledButton = false
        }
    }

    private fun changeState() {
        val parentLayout = binding.titleTextView.parent as ViewGroup
        parentLayout.removeView(binding.titleTextView)
        binding.removeButton.isEnabled = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(VISIBLE_KEY, isTextViewVisible)
        outState.putBoolean(ENABLED_BUTTON, isEnabledButton)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        isTextViewVisible = savedInstanceState.getBoolean(VISIBLE_KEY)
        isEnabledButton = savedInstanceState.getBoolean(ENABLED_BUTTON)
        if (!isTextViewVisible && !isEnabledButton) {
            changeState()
        }
    }

    private companion object {
        const val VISIBLE_KEY = "visibleKey"
        const val ENABLED_BUTTON = "enabledButton"
    }
}