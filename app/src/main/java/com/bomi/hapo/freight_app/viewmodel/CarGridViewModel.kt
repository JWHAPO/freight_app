package com.bomi.hapo.freight_app.viewmodel

import android.content.Context
import com.bomi.hapo.freight_app.common.network.ApiService
import com.bomi.hapo.freight_app.viewmodel.common.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 *
 * Created by JWHAPO
 * -19. 5. 7 오후 10:36
 */

class CarGridViewModel(private val context: Context) : BaseViewModel() {
    private lateinit var apiService: ApiService
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

}