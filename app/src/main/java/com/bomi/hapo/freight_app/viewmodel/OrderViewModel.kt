package com.bomi.hapo.freight_app.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import android.databinding.Bindable
import com.bomi.hapo.freight_app.common.network.ApiService
import com.bomi.hapo.freight_app.model.Order
import com.bomi.hapo.freight_app.model.OrderResponse
import io.reactivex.disposables.CompositeDisposable
import java.time.LocalDate
import java.time.LocalTime

/**
 *
 * Created by JWHAPO
 * -19. 4. 20 오전 12:21
 */
class OrderViewModel(private val application: Application) : BaseObservable() {
    private lateinit var apiService: ApiService
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    var orderResponse: OrderResponse = OrderResponse(0L,0L, LocalDate.now(),LocalTime.now(),0L,0L,"","",0L,"N")
    var orderResponses : List<OrderResponse> = listOf(orderResponse)
    @Bindable
    var order: Order = Order(0L,"",0L,"","",0L, LocalDate.now(), LocalTime.now(),0L,"N","","","",orderResponses)


    fun onRequestBtnClick(){

    }

}