package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.actionButton.setOnClickListener {
            with(binding) {
                actionButton.isEnabled = false
                progressBar.visibility = View.VISIBLE
                actionButton.postDelayed({
                    with(binding) {
                        titleTextView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        actionButton.isEnabled = true
                    }
                }, 3000)
            }
        }
    }
}