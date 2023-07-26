package com.mock.sample


import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mock.sample.mock.adapter.MockAdapter
import com.mock.sample.mock.data.MockListResponse

object Extension {
    @JvmStatic
    @BindingAdapter("mock_list_item")
    fun mockListItem(view: RecyclerView?,list: List<MockListResponse>?) {
        view?.adapter?.let { adapter ->
            adapter as MockAdapter
            adapter.updateData(list?.toList() ?: emptyList())
        }
    }
}