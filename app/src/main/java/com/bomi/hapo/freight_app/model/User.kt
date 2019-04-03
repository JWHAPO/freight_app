package com.bomi.hapo.freight_app.model

import android.text.TextUtils
import android.util.Patterns
import java.util.*

/**
 *
 * Created by JWHAPO
 * -19. 4. 3 오후 10:06
 */

class User : Observable() {
    var userId: Long = 0L
    var userNo: Long = 0L
    var email: String = ""
    var password: String = ""
    var name: String = ""
    var phone: String = ""
    var imagePath: String = ""
    var experienceValue: Long = 0L
    var levelId: Long = 0L


    fun isEmailValid(): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(): Boolean {
        return password.length > 4
    }

}