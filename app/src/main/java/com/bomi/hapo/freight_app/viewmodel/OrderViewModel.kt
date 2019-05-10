package com.bomi.hapo.freight_app.viewmodel

import android.app.Application
import android.databinding.Bindable
import com.bomi.hapo.freight_app.common.network.ApiClient
import com.bomi.hapo.freight_app.common.network.ApiService
import com.bomi.hapo.freight_app.model.Car
import com.bomi.hapo.freight_app.model.Order
import com.bomi.hapo.freight_app.model.OrderResponse
import com.bomi.hapo.freight_app.viewmodel.common.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.time.LocalDate
import java.time.LocalTime

/**
 *
 * Created by JWHAPO
 * -19. 4. 20 오전 12:21
 */
class OrderViewModel(private val application: Application) : BaseViewModel() {
    private lateinit var apiService: ApiService
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    private var orderResponse: OrderResponse = OrderResponse(0L, 0L, LocalDate.now(), LocalTime.now(), 0L, 0L, "", "", 0L, "N")
    private var orderResponses: List<OrderResponse> = listOf(orderResponse)
    private var car: Car = Car(0L,0L,"",0L,"",0L,"",0L,"",0L,"","")

    @Bindable
    var order: Order =
        Order(0L, "", car, "", "", 0L, LocalDate.now(), LocalTime.now(), 0L, "N", "", "", "", orderResponses)

    init{
//        getOrder(order)
    }

    fun onCarTvClick(){

    }

    fun onRequestBtnClick() {
        apiService = ApiClient.getClient(application).create(ApiService::class.java)

        mCompositeDisposable.add(
            apiService.newOrder(order)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successGetOrder, this::failGetOrder)
        )
    }

    private fun getOrder(order: Order) {
        apiService = ApiClient.getClient(application).create(ApiService::class.java)

        mCompositeDisposable.add(
            apiService.getOrder(order.orderId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successGetOrder, this::failGetOrder)
        )
    }

    private fun successNewOrder(order: Order){

    }

    private fun failNewOrder(error: Throwable){
        println("error: $error")
    }

    private fun successGetOrder(order: Order) {

    }
    private fun failGetOrder(error: Throwable) {
        println("error: $error")
    }

}