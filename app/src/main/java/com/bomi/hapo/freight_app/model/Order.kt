package com.bomi.hapo.freight_app.model

import java.time.LocalDate
import java.time.LocalTime
import java.util.*

/**
 *
 * Created by JWHAPO
 * -19. 4. 18 오후 6:25
 */
data class Order(
        var orderId: Long
        , var description: String
        , var carId: Long
        , var car: Car
        , var departureAddress: String
        , var arrivalAddress: String
        , var distance: Long
        , var hopeDate: LocalDate
        , var hopeTime: LocalTime
        , var hopePrice: Long
        , var isMixed: String
        , var remark: String
        , var status: String
        , var cancelRemark: String
        , var orderResponses: List<OrderResponse>
) : Observable()