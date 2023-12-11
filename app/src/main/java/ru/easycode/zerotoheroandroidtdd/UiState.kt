package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(incrementButton: Button, decrementButton: Button, textView: TextView)

    data class Base(private val text: String) : UiState {
        override fun apply(incrementButton: Button, decrementButton: Button, textView: TextView) {
            textView.text = text
            decrementButton.isEnabled = true
            incrementButton.isEnabled = true
        }
    }

    data class Min(private val text: String) : UiState {
        override fun apply(incrementButton: Button, decrementButton: Button, textView: TextView) {
            textView.text = text
            decrementButton.isEnabled = false
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(incrementButton: Button, decrementButton: Button, textView: TextView) {
            textView.text = text
            incrementButton.isEnabled = false
        }
    }
}