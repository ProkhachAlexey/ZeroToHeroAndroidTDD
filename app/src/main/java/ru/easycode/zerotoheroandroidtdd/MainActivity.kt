package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var textViewContent = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.changeButton.setOnClickListener {
            binding.titleTextView.text = getString(R.string.i_am_an_android_developer)
        }

        savedInstanceState?.let {
            textViewContent = it.getString(KEY, HELLO)
            binding.titleTextView.text = textViewContent
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        textViewContent = binding.titleTextView.text.toString()
        outState.putString(KEY, textViewContent)
    }

    private companion object {
        const val KEY = "key"
        const val HELLO = "Hello, world!"
    }
}