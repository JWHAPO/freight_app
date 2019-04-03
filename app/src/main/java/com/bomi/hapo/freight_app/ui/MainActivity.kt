package com.bomi.hapo.freight_app.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bomi.hapo.freight_app.R
import com.bomi.hapo.freight_app.databinding.MainLayoutBinding
import com.bomi.hapo.freight_app.viewmodel.UserViewModel

/**
 *
 * Created by JWHAPO
 * -19. 4. 2 오후 10:13
 */

class MainActivity : AppCompatActivity() {

    lateinit var mainLayoutBinding: MainLayoutBinding
    lateinit var userviewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userviewModel = UserViewModel(application)
        initDatabinding()

    }

    /**
     * initial Databinding
     */
    private fun initDatabinding() {
        mainLayoutBinding = DataBindingUtil.setContentView(this, R.layout.main_layout)
        mainLayoutBinding.userViewModel = userviewModel
        mainLayoutBinding.executePendingBindings()
    }
}