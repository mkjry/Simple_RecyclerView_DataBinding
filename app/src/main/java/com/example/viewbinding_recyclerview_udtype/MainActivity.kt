package com.example.viewbinding_recyclerview_udtype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding_recyclerview_udtype.data.CustomDataModel
import com.example.viewbinding_recyclerview_udtype.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

//        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val recyclerView: RecyclerView = viewBinding.rv
        recyclerView.layoutManager = LinearLayoutManager(this)

//        recyclerView.adapter = RecyclerAdapter(
//        recyclerView.adapter = RecyclerVbAdapter(
        recyclerView.adapter = RecyclerVbDbAdapter(
            loadDummyDataList(mutableListOf())
        )

    }

    private fun loadDummyDataList(dataList: MutableList<CustomDataModel>) : MutableList<CustomDataModel>{
        for (i in 1..20) {
            dataList.add(
                CustomDataModel(R.mipmap.ic_launcher, "Title $i", "Description $i")
            )
        }
        return dataList
    }

}