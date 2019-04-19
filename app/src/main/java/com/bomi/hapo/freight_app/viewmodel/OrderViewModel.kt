package com.bomi.hapo.freight_app.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import com.bomi.hapo.freight_app.common.network.ApiService
import io.reactivex.disposables.CompositeDisposable

/**
 *
 * Created by JWHAPO
 * -19. 4. 20 오전 12:21
 */
class OrderViewModel(private val application: Application) : BaseObservable() {
    private lateinit var apiService: ApiService
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()


}