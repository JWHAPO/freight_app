package com.bomi.hapo.freight_app.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bomi.hapo.freight_app.BR
import com.bomi.hapo.freight_app.R
import com.bomi.hapo.freight_app.model.User
import kotlinx.android.synthetic.main.main_layout.view.*

/**
 *
 * Created by JWHAPO
 * -19. 4. 3 오후 10:12
 */

class UserViewModel(val application: Application) : BaseObservable() {

    @Bindable
    var user: User = User()

    @Bindable
    var emailValid: Boolean = false

    @Bindable
    var passwordValid: Boolean = false

    fun afterEmailTextChanged(s: CharSequence) {
        user.email = s.toString()
        emailValid = user.isEmailValid()
        notifyPropertyChanged(BR.emailValid)
    }

    fun afterPasswordTextChanged(s: CharSequence) {
        user.password = s.toString()
        passwordValid = user.isPasswordValid()
        notifyPropertyChanged(BR.passwordValid)
    }

    fun onSignInBtnClick() {
        if (emailValid && passwordValid) {
            Toast.makeText(application, "SUCCESS VALID", Toast.LENGTH_LONG).show()
        }
    }
}

@BindingAdapter("email_valid")
fun checkEmailValid(view: View, isValid: Boolean) {
    view.main_email_valid_iv.let { if (isValid) it.setImageResource(R.drawable.green_check) else it.setImageResource(R.drawable.uncheck) }
}

@BindingAdapter("password_valid")
fun focusPasswordValid(view: View, isValid: Boolean) {
    view.main_password_valid_iv.let {
        if (isValid) it.setImageResource(R.drawable.green_check) else it.setImageResource(
            R.drawable.uncheck
        )
    }
}