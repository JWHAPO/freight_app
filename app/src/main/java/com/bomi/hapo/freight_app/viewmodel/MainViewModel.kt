package com.bomi.hapo.freight_app.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import com.bomi.hapo.freight_app.common.network.ApiService
import io.reactivex.disposables.CompositeDisposable

/**
 *
 * Created by JWHAPO
 * -19. 4. 10 오후 10:49
 */
class MainViewModel(private val application: Application) : BaseObservable() {

    private lateinit var apiService: ApiService
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()
}