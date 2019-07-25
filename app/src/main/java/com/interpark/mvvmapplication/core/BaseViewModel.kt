package com.interpark.mvvmapplication.core

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * ViewModel은 View와의 생명주기를 공유하기 때문에
 * View가 제거될 때 ViewModel의 onCleared()가 호출되게 되며, 그에 따라 옵저버블들이 전부 클리어 됨
 */
open class BaseViewModel : ViewModel() {

    // CompositeDisposable 클래스를 이용하면 생성된 모든 Observable 을 안드로이드 라이프사이클에 맞춰 한번에 모두 해제
    private val disposables: CompositeDisposable = CompositeDisposable()

    fun addToDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}