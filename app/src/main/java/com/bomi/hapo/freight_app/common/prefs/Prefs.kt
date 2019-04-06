package com.bomi.hapo.freight_app.common.prefs

import android.content.Context
import android.content.SharedPreferences

/**
 *
 * Created by JWHAPO
 * -19. 4. 6 오후 1:45
 */

class Prefs(context: Context) {
    var PREFS_FILENAME = "com.bomi.hapo.freight_app.prefs"
    var prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    //저장 객체 KEY
    var LOGIN_ID = "LOGIN_ID"
    var API_TOKEN = "API_TOKEN"
    var API_REFRESH_TOKEN = "API_REFRESH_TOKEN"

    //저장 객체
    var loginId: String
        get() = prefs.getString(LOGIN_ID, "")
        set(value) = prefs.edit().putString(LOGIN_ID, value).apply()

    var apiToken: String
        get() = prefs.getString(API_TOKEN, "")
        set(value) = prefs.edit().putString(API_TOKEN, value).apply()

    var apiRefreshToken: String
        get() = prefs.getString(API_REFRESH_TOKEN, "")
        set(value) = prefs.edit().putString(API_REFRESH_TOKEN, value).apply()
}