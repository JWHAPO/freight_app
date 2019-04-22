package com.bomi.hapo.freight_app.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator
import android.widget.Toast
import com.bomi.hapo.freight_app.BR
import com.bomi.hapo.freight_app.common.animator.AnimateCounter
import com.bomi.hapo.freight_app.common.network.ApiClient
import com.bomi.hapo.freight_app.common.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.main_layout.view.*

/**
 *
 * Created by JWHAPO
 * -19. 4. 10 오후 10:49
 */
class MainViewModel(private val application: Application) : BaseObservable() {

    private lateinit var apiService: ApiService
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    @Bindable
    var orderCarCount: Int = 0

    init {
        getOrderCarCount()
    }

    private fun getOrderCarCount() {

        apiService = ApiClient.getClient(application).create(ApiService::class.java)

        mCompositeDisposable.add(
            apiService.getOrderCountByStatus("IN_PROGRESS")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setCurrentOrderCarCount, this::failGetCount)
        )
    }

    private fun setCurrentOrderCarCount(count: Int) {
        orderCarCount = count
        notifyPropertyChanged(BR.orderCarCount)
    }

    private fun failGetCount(error: Throwable) {
        println("error: $error")
        Toast.makeText(application.applicationContext, "$error !", Toast.LENGTH_LONG).show()
    }

}

@BindingAdapter("order_car_count")
fun animateOrderCarCount(view: View, carCount: Int) {
    var start: Int = 0
    var end: Int = carCount

    if (end == 0) {
        view.main_current_car_count_tv.text = end.toString()
        return
    }

    var animateCounter: AnimateCounter =
        AnimateCounter.Builder(view.main_current_car_count_tv)
            .setCount(start, end)
            .setDuration(1000)
            .setInterpolator(AnimationUtils.loadInterpolator(view.context, android.R.anim.decelerate_interpolator))
            .setAnimationCounterListener(object : AnimateCounter.AnimateCounterListener {
                override fun onAnimateCounterEnd() {
                }
            })
            .build()
    animateCounter.execute()

}
