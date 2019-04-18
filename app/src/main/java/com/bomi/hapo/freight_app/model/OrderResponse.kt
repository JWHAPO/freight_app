package com.bomi.hapo.freight_app.model

import java.time.LocalDate
import java.time.LocalTime
import java.util.*

/**
 *
 * Created by JWHAPO
 * -19. 4. 18 오후 10:36
 */
data class OrderResponse(var orderResponseId:Long
                        ,var orderId:Long
                        ,var pickupDate:LocalDate
                        ,var pickupTime:LocalTime
                        ,var suggestedPrice:Long
                        ,var currentAvgPrice:Long
                        ,var sellerMessage:String
                        ,var buyerMessage:String
                        ,var resultPoint:Long
                        ,var isSelected:String
):Observable()