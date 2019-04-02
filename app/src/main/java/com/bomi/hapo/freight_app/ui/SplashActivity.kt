package com.bomi.hapo.freight_app.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 *
 * Created by JWHAPO
 * -19. 4. 2 오후 10:00
 */

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var intent:Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

        finish()
    }
}