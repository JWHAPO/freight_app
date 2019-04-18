package com.bomi.hapo.freight_app.model

import android.text.TextUtils
import android.util.Patterns
import java.util.*

/**
 *
 * Created by JWHAPO
 * -19. 4. 3 오후 10:06
 */

data class User(var userId:Long
                ,var userNo:Long
                ,var email: String
                ,var password: String
                ,var name: String
                ,var phone: String
                ,var imagePath: String
                ,var experienceValue: Long
                ,var levelId: Long
) : Observable() {

    fun isEmailValid(): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(): Boolean {
        return password.length > 4
    }

}