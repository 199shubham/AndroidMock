package com.mock.sample.mock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mock.sample.databinding.MockListItemBinding


import com.mock.sample.mock.data.MockListResponse

class MockAdapter: RecyclerView.Adapter<MockAdapter.VH>() {
    private val mockDetails = ArrayList<MockListResponse>()
    fun updateData(list: List<MockListResponse>){
        mockDetails.clear()
        mockDetails.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            MockListItemBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setData(mockDetails[position])
    }

    override fun getItemCount(): Int {
        return mockDetails.size
    }

    inner class VH(private val homeListItem: MockListItemBinding):
        RecyclerView.ViewHolder(homeListItem.root) {
        fun setData(data: MockListResponse){
            homeListItem.item = data
            homeListItem.txtApiName.text = "Api Name : "+data.API
            homeListItem.txtApiCategory.text = "Api Category : "+data.Category
            homeListItem.txtApiDescription.text = "Api Description : "+data.Description
        }
    }
}