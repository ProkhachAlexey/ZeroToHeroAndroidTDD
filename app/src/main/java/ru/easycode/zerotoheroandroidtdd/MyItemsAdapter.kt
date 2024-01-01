package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.ItemLayoutBinding

class MyItemsAdapter : RecyclerView.Adapter<MyItemsViewHolder>() {

    private val itemsList = ArrayList<String>()

    fun add(source: String) {
        itemsList.add(source)
        notifyItemInserted(itemsList.size - 1)
    }

    fun save(bundle: Bundle) {
        bundle.putStringArrayList(KEY, itemsList)
    }

    fun restore(bundle: Bundle) {
        itemsList.addAll(bundle.getStringArrayList(KEY) ?: ArrayList())
        notifyItemRangeInserted(0, itemsList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemsViewHolder {
        return MyItemsViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyItemsViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size

    private companion object {
        const val KEY = "key"
    }
}

class MyItemsViewHolder(private val binding: ItemLayoutBinding) : ViewHolder(binding.root) {
    fun bind(source: String) {
        binding.elementTextView.text = source
    }
}