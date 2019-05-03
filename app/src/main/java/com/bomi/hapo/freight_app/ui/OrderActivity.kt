package com.bomi.hapo.freight_app.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bomi.hapo.freight_app.R
import com.bomi.hapo.freight_app.databinding.OrderLayoutBinding
import com.bomi.hapo.freight_app.viewmodel.OrderViewModel

/**
 * freight_app
 * Class: OrderActivity
 * Created by JEONGWOOKIM on 2019-04-16.
 * Description:
 */
class OrderActivity:AppCompatActivity(){

    private lateinit var orderLayoutBindinding:OrderLayoutBinding
    private lateinit var orderViewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        orderViewModel = OrderViewModel(application)
        initDataBinding()

        orderViewModel.onCreate()
    }

    /**
     * initial initDataBinding
     */
    private fun initDataBinding(){
        orderLayoutBindinding = DataBindingUtil.setContentView(this, R.layout.order_layout)
        orderLayoutBindinding.orderViewModel = orderViewModel
        orderLayoutBindinding.executePendingBindings()
    }

    override fun onResume() {
        super.onResume()
        orderViewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        orderViewModel.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        orderViewModel.onDestroy()
    }



}