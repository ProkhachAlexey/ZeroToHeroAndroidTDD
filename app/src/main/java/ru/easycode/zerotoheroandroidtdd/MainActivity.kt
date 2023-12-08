package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isTextViewVisible = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.removeButton.setOnClickListener {
            val parentLayout = binding.titleTextView.parent as ViewGroup
            parentLayout.removeView(binding.titleTextView)
            isTextViewVisible = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY, isTextViewVisible)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        isTextViewVisible = savedInstanceState.getBoolean(KEY)
        if (!isTextViewVisible) {
            val parentLayout = binding.titleTextView.parent as ViewGroup
            parentLayout.removeView(binding.titleTextView)
        }
    }

    private companion object {
        const val KEY = "key"
    }
}