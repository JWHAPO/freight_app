package com.bomi.hapo.freight_app.common

import android.app.Application
import com.bomi.hapo.freight_app.common.prefs.Prefs

/**
 *
 * Created by JWHAPO
 * -19. 4. 6 오후 2:24
 */
class App : Application() {
    companion object {
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}