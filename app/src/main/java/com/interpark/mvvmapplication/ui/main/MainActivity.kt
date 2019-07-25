package com.interpark.mvvmapplication.ui.main

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import com.interpark.mvvmapplication.R
import com.interpark.mvvmapplication.core.BindingActivity
import com.interpark.mvvmapplication.data.remote.domain.AddressData
import com.interpark.mvvmapplication.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * MVVM은 Model-View-ViewModel의 약자
 * Model : UI에 표시될 데이터와 비즈니스 로직
 * View : UI
 * ViewModel : 이벤트 처리나 Model과의 인터랙션
 *
 * MVVM의 중요 핵심은 Data Binding 기술!!
 *
 * AAC에서 제공하는 LiveData, ViewModel, Room, Paging 또한 같이 사용 */
class MainActivity : BindingActivity<ActivityMainBinding>() {

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = getViewModel()
        binding.lifecycleOwner = this

        val data1 = AddressData("ㅁㅁㅁ", "서울 강남구 삼성동", 20190509)
        val data2 = AddressData("ㄷㄷㄷ", "서울 용산구 이태원동", 19941220)
        val data3 = AddressData("ㅍㅍㅍ", "서울 종로구 익선동", 20100723)
        val data4 = AddressData("ㄱㄱㄱ", "서울 동대문구 회기동", 20160914)
        val data5 = AddressData("ㅊㅊㅊ", "서울 강남구 대치동", 19981130)

        (binding.vm as AddressViewModel).saveToBookmark(data1)
        (binding.vm as AddressViewModel).saveToBookmark(data2)
        (binding.vm as AddressViewModel).saveToBookmark(data3)
        (binding.vm as AddressViewModel).saveToBookmark(data4)
        (binding.vm as AddressViewModel).saveToBookmark(data5)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.cl_main_layout, MainFragment(getViewModel()), "MainHomeFragment")
            .disallowAddToBackStack()
            .commit()
    }
}
