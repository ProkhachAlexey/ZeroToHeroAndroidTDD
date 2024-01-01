package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.ListItemBinding

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val items = ArrayList<CharSequence>()

    fun add(source: CharSequence) {
        items.add(source)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class MyViewHolder(private val binding: ListItemBinding) : ViewHolder(binding.root) {

    fun bind(source: CharSequence) {
        binding.elementTextView.text = source
    }
}