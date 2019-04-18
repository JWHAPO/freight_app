package com.bomi.hapo.freight_app.model

import java.time.LocalDate
import java.util.*

/**
 *
 * Created by JWHAPO
 * -19. 4. 18 오후 6:25
 */
class Order : Observable() {
    var orderId: Long = 0L
    var description: String = ""
    var carId: Long = 0L
    var departureAddress: String = ""
    var arrivalAddress: String = ""
    var distance: Long = 0L
    var hopeDate: String = ""
    var hopeTime: String = ""
    var hopePrice:Long=0L
    var isMixed:String=""
    var remark:String=""
    var status:String=""
    var cancelRemark:String=""



}