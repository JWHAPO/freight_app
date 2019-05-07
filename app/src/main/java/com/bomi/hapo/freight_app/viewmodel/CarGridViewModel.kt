package com.bomi.hapo.freight_app.viewmodel

import android.app.Activity
import android.content.Context
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bomi.hapo.freight_app.common.network.ApiClient
import com.bomi.hapo.freight_app.common.network.ApiService
import com.bomi.hapo.freight_app.model.Car
import com.bomi.hapo.freight_app.ui.adapter.CarGridAdapter
import com.bomi.hapo.freight_app.viewmodel.common.BaseViewModel
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.car_grid_layout.view.*

/**
 *
 * Created by JWHAPO
 * -19. 5. 7 오후 10:36
 */

class CarGridViewModel(private val context: Context) : BaseViewModel() {
    private lateinit var apiService: ApiService
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    @Bindable
    var cars: List<Car> = listOf(Car(0L, 0L, "", 0L, "", 0L, "", 0L, "", 0L, "", ""))

    init {
        getCars()
    }


    private fun getCars() {
        apiService = ApiClient.getClient(context).create(ApiService::class.java)

        mCompositeDisposable.add(
            apiService.getCars()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setCarGridView, this::failGetCars)
        )
    }

    private fun setCarGridView(cars: List<Car>) {
        this.cars = cars
    }

    private fun failGetCars(error: Throwable) {
        println("error: $error")
        Toast.makeText(context.applicationContext, "$error !", Toast.LENGTH_LONG).show()
    }
}

@BindingAdapter("car_grid_items")
fun setCarsToGridView(view: View, cars: List<Car>) {
    var adapter: CarGridAdapter

    if(view.car_grid_gv.adapter == null){
        adapter = CarGridAdapter(cars, view.context as Activity)
        view.car_grid_gv.adapter = adapter
    }else{
        adapter = view.car_grid_gv.adapter as CarGridAdapter
    }

    adapter.notifyDataSetChanged()
}
