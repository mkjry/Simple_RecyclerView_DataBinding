package com.example.viewbinding_recyclerview_udtype

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding_recyclerview_udtype.data.CustomDataModel
import com.example.viewbinding_recyclerview_udtype.databinding.RecyclerViewItemDbBinding

class RecyclerVbDbAdapter (
    private var dataList : List<CustomDataModel>
) : RecyclerView.Adapter<RecyclerVbDbAdapter.AdapterViewHolder>() {

    inner class AdapterViewHolder(val viewBinding: RecyclerViewItemDbBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: CustomDataModel) {
            viewBinding.dataItem = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemDbBinding.inflate(layoutInflater, parent, false)
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {

        holder.bind(dataList[position])
        holder.viewBinding.executePendingBindings()
        holder.viewBinding.root.setOnClickListener {
            Toast.makeText(holder.viewBinding.root.context, "${position + 1} Clicked", Toast.LENGTH_SHORT).show()
        }

//        with(holder) {
//            bind(dataList[position])
//            viewBinding.root.setOnClickListener {
//                Toast.makeText(viewBinding.root.context, "${adapterPosition + 1} Clicked", Toast.LENGTH_SHORT).show()
//            }
//        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}