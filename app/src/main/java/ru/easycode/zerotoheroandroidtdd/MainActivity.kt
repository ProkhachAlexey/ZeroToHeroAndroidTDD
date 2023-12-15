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
            binding.actionButton.isEnabled = false
            binding.progressBar.visibility = View.VISIBLE
            binding.actionButton.postDelayed({
                binding.titleTextView.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
                binding.actionButton.isEnabled = true
            }, 3000)
        }
    }
}