package com.bomi.hapo.freight_app.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bomi.hapo.freight_app.R
import com.bomi.hapo.freight_app.databinding.LoginLayoutBinding
import com.bomi.hapo.freight_app.viewmodel.UserViewModel

/**
 *
 * Created by JWHAPO
 * -19. 4. 2 오후 10:13
 */

class LoginActivity : AppCompatActivity() {

    private lateinit var loginLayoutBinding: LoginLayoutBinding
    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel = UserViewModel(application)
        initDataBinding()

        userViewModel.onCreate()
    }

    /**
     * initial initDataBinding
     */
    private fun initDataBinding() {
        loginLayoutBinding = DataBindingUtil.setContentView(this, R.layout.login_layout)
        loginLayoutBinding.userViewModel = userViewModel
        loginLayoutBinding.executePendingBindings()
    }

    override fun onResume() {
        super.onResume()
        userViewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        userViewModel.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        userViewModel.onDestroy()
    }
}