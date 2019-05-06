package com.bomi.hapo.freight_app.viewmodel

import android.content.Context
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.view.View
import android.widget.Toast
import com.bomi.hapo.freight_app.BR
import com.bomi.hapo.freight_app.R
import com.bomi.hapo.freight_app.common.App
import com.bomi.hapo.freight_app.common.network.ApiClient
import com.bomi.hapo.freight_app.common.network.ApiService
import com.bomi.hapo.freight_app.model.User
import com.bomi.hapo.freight_app.ui.navigator.LoginActivityNavigator
import com.bomi.hapo.freight_app.viewmodel.common.BaseViewModel
import com.google.gson.JsonElement
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.login_layout.view.*


/**
 *
 * Created by JWHAPO
 * -19. 4. 3 오후 10:12
 */

class UserViewModel(private val context: Context) : BaseViewModel() {

    private lateinit var apiService: ApiService
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()
    private var navigator : LoginActivityNavigator = context as LoginActivityNavigator

    @Bindable
    var user: User = User(0L,0L,"","","","","",0L,0L)

    @Bindable
    var emailValid: Boolean = false

    @Bindable
    var passwordValid: Boolean = false

    init {
        user.email = App.prefs.loginId
    }


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
            Toast.makeText(context.applicationContext, "SUCCESS VALID", Toast.LENGTH_LONG).show()
            App.prefs.loginId = user.email
            loginUser(user)

        } else {
            Toast.makeText(context.applicationContext, context.applicationContext.resources.getString(R.string.check_account), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun loginUser(user: User) {
        apiService = ApiClient.getClient(context).create(ApiService::class.java)

        val accountInfo: HashMap<String, String> = hashMapOf("email" to user.email, "password" to user.password)

        mCompositeDisposable.add(
            apiService.getToken(accountInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::moveMain, this::failLogin)
        )
    }

    private fun failLogin(error: Throwable) {
        println("error: $error")
        Toast.makeText(context.applicationContext, "$error !", Toast.LENGTH_LONG).show()
    }

    private fun moveMain(token: JsonElement) {
        saveToken(token.asJsonObject.get("token").asString, token.asJsonObject.get("refreshToken").asString)
        callMainActivity()
    }

    private fun callMainActivity(){
        navigator.callMainActivity()
    }

    private fun saveToken(token:String, refreshToken:String){
        App.prefs.apiToken = token
        App.prefs.apiRefreshToken = refreshToken
    }

    fun clearCompositeDisposable() {
        mCompositeDisposable.clear()
    }
}

@BindingAdapter("email_valid")
fun checkEmailValid(view: View, isValid: Boolean) {
    view.login_email_valid_iv.let { if (isValid) it.setImageResource(R.drawable.green_check) else it.setImageResource(R.drawable.uncheck) }
}

@BindingAdapter("password_valid")
fun focusPasswordValid(view: View, isValid: Boolean) {
    view.login_password_valid_iv.let {
        if (isValid) it.setImageResource(R.drawable.green_check) else it.setImageResource(
            R.drawable.uncheck
        )
    }
}