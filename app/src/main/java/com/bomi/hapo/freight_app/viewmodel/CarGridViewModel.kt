package com.bomi.hapo.freight_app.viewmodel

import android.content.Context
import android.widget.Toast
import com.bomi.hapo.freight_app.common.network.ApiClient
import com.bomi.hapo.freight_app.common.network.ApiService
import com.bomi.hapo.freight_app.model.Car
import com.bomi.hapo.freight_app.viewmodel.common.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 *
 * Created by JWHAPO
 * -19. 5. 7 오후 10:36
 */

class CarGridViewModel(private val context: Context) : BaseViewModel() {
    private lateinit var apiService: ApiService
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()


    private fun getCars(){
        apiService = ApiClient.getClient(context).create(ApiService::class.java)

        mCompositeDisposable.add(
            apiService.getCars()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setCarGridView, this::failGetCars)
        )
    }

    private fun setCarGridView(cars:List<Car>){

    }

    private fun failGetCars(error: Throwable) {
        println("error: $error")
        Toast.makeText(context.applicationContext, "$error !", Toast.LENGTH_LONG).show()
    }
}