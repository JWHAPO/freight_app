package com.bomi.hapo.freight_app.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.bomi.hapo.freight_app.BR

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
) : BaseObservable(){

    var _carImgUrl : String
    @Bindable get() = carImgUrl
    set(value) {
        carImgUrl = value
        notifyPropertyChanged(BR._carImgUrl)
    }
}