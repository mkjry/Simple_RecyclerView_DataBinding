package com.example.viewbinding_recyclerview_udtype

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding_recyclerview_udtype.data.CustomDataModel
import com.example.viewbinding_recyclerview_udtype.databinding.RecyclerViewItemBinding

class RecyclerVbAdapter (
    private var dataList : List<CustomDataModel>
) : RecyclerView.Adapter<RecyclerVbAdapter.AdapterViewHolder>() {

    inner class AdapterViewHolder(val viewBinding: RecyclerViewItemBinding): RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemBinding.inflate(layoutInflater, parent, false)
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {

        with(holder) {
            with(dataList[position]) {
                viewBinding.ivImage.setImageResource(dataList[position].image)
                viewBinding.tvTitle.text = dataList[position].title
                viewBinding.tvDescription.text = dataList[position].description
                viewBinding.root.setOnClickListener {
                    Toast.makeText(viewBinding.root.context, "${adapterPosition + 1} Clicked", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}