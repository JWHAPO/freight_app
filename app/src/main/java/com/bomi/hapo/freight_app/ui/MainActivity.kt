package com.bomi.hapo.freight_app.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import com.bomi.hapo.freight_app.R
import com.bomi.hapo.freight_app.common.animator.AnimateCounter
import com.bomi.hapo.freight_app.databinding.MainLayoutBinding
import com.bomi.hapo.freight_app.viewmodel.MainViewModel

/**
 * freight_app
 * Class: MainActivity
 * Created by JEONGWOOKIM on 2019-04-08.
 * Description:
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mainLayoutBinding: MainLayoutBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = MainViewModel(application)
        initDataBinding()
    }

    /**
     * initial initDataBinding
     */
    private fun initDataBinding() {
        mainLayoutBinding = DataBindingUtil.setContentView(this, R.layout.main_layout)
        mainLayoutBinding.mainViewModel = mainViewModel
        mainLayoutBinding.executePendingBindings()
    }

}