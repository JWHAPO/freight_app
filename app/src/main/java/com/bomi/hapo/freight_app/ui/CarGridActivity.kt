package com.bomi.hapo.freight_app.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bomi.hapo.freight_app.R
import com.bomi.hapo.freight_app.databinding.CarGridLayoutBinding
import com.bomi.hapo.freight_app.databinding.LoginLayoutBinding
import com.bomi.hapo.freight_app.viewmodel.CarGridViewModel

/**
 *
 * Created by JWHAPO
 * -19. 5. 7 오후 9:23
 */
class CarGridActivity : AppCompatActivity(){

    private lateinit var carGridLayoutBinding: CarGridLayoutBinding
    private lateinit var carGridViewModel: CarGridViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        carGridViewModel = CarGridViewModel(application)
        initDataBinding()
    }

    /**
     * initial initDataBinding
     */
    private fun initDataBinding() {
        carGridLayoutBinding = DataBindingUtil.setContentView(this, R.layout.car_grid_layout)
        carGridLayoutBinding.carGridViewModel = carGridViewModel
        carGridLayoutBinding.executePendingBindings()
    }
}