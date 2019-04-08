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
    }

    /**
     * initial initDataBinding
     */
    private fun initDataBinding() {
        loginLayoutBinding = DataBindingUtil.setContentView(this, R.layout.login_layout)
        loginLayoutBinding.userViewModel = userViewModel
        loginLayoutBinding.executePendingBindings()
    }
}