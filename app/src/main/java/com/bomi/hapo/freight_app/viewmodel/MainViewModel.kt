package com.bomi.hapo.freight_app.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.view.View
import android.widget.Toast
import com.bomi.hapo.freight_app.BR
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

    @Bindable
    var orderCarCount: Int = 0

    init {
        getOrderCarCount()
    }

    private fun returnOrderCarCount(): Int {
        return 10000
    }

    private fun getOrderCarCount() {
        orderCarCount = returnOrderCarCount()
        notifyPropertyChanged(BR.orderCarCount)
    }

}

@BindingAdapter("order_car_count")
fun animateOrderCarCount(view: View, carCount: Int) {
    Toast.makeText(view.context, "car count:$carCount!!!", Toast.LENGTH_LONG).show()
}
