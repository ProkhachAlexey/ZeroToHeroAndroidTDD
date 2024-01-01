package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.ListItemBinding

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val list = ArrayList<CharSequence>()

    fun update(newList: List<CharSequence>) {
        val diffUtil = DiffUtilCallback(list, newList)
        val diff = DiffUtil.calculateDiff(diffUtil)
        list.clear()
        list.addAll(newList)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}

class MyViewHolder(private val binding: ListItemBinding) : ViewHolder(binding.root) {

    fun bind(source: CharSequence) {
        binding.elementTextView.text = source
    }
}

private class DiffUtilCallback(
    private val old: List<CharSequence>,
    private val new: List<CharSequence>
) : DiffUtil.Callback() {

    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }
}