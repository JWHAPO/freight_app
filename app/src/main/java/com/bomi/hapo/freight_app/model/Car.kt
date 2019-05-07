package com.bomi.hapo.freight_app.model

import java.util.*

/**
 *
 * Created by JWHAPO
 * -19. 4. 18 오후 10:36
 */
data class Car(
    var carId: Long
    , var carNo: Long
    , var description: String
    , var width: Long
    , var widthUom: String
    , var length: Long
    , var lengthUom: String
    , var loadableHeight: Long
    , var loadableHeightUom: String
    , var loadableWeight: Long
    , var loadableWeightUom: String
    , var carImgUrl: String
) : Observable()