package com.interpark.mvvmapplication.extension

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.interpark.mvvmapplication.data.db.entity.Address
import com.interpark.mvvmapplication.ui.main.AddressViewModel
import com.interpark.mvvmapplication.ui.main.MainAdapter

/**
 * 현재 정의되지 않은 Binding Attribute를 정의하고 내부 로직을 작성할 때 사용
 */
// xml 상에서 value 값으로 정의한 'items' 호출이 가능
//@BindingAdapter("items")
//fun bindItem(recyclerView: RecyclerView, list: ObservableArrayList<AddressData>) {
//    recyclerView.adapter = MainAdapter(list)
//}

@BindingAdapter(value = ["address", "viewModel"])
fun setAddress(view: RecyclerView, items: PagedList<Address>?, vm: AddressViewModel) {
    view.adapter?.run {
        if (this is MainAdapter) this.submitList(items)
    } ?: run {
        MainAdapter(vm).apply {
            view.adapter = this
            this.submitList(items)
        }
    }
}

@BindingAdapter("visibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

/**
 * xml에 설정된 특정 형식 간 자동 변환을 이루어지게 하기 위함
 *  -> Boolean 값이 설정되면 자동으로 Int 형으로 변환시킴
 */
@BindingConversion
fun convertBooleanToVisibility(isVisible: Boolean): Int {
    return if (isVisible) View.VISIBLE else View.GONE
}