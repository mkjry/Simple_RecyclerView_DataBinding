package com.example.viewbinding_recyclerview_udtype

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding_recyclerview_udtype.data.CustomDataModel

class RecyclerAdapter(
    private var dataList : List<CustomDataModel>
) : RecyclerView.Adapter<RecyclerAdapter.AdapterViewHolder>() {

    inner class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.iv_Image)
        val itemTitle: TextView = itemView.findViewById(R.id.tv_Title)
        val itemDescription: TextView = itemView.findViewById(R.id.tv_Description)

        init {
            itemView.setOnClickListener { v: View ->
                Toast.makeText(itemView.context, "${adapterPosition + 1} Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return AdapterViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.itemImage.setImageResource(dataList[position].image)
        holder.itemTitle.text = dataList[position].title
        holder.itemDescription.text = dataList[position].description
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}

