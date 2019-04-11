package com.bomi.hapo.freight_app.common.animator

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.view.animation.Interpolator
import android.widget.TextView
import java.time.Duration

/**
 *
 * Created by JWHAPO
 * -19. 4. 11 오후 10:58
 */
class AnimateCounter {
    lateinit var mView: TextView
    var mDuration: Long = 0L
    var mStartValue: Float = 0F
    var mEndValue: Float = 0F
    var mPrecision: Int = 0
    lateinit var mInterpolator: Interpolator
    lateinit var mValueAnmator: ValueAnimator
    lateinit var mListener: AnimateCounterListener

    fun execute() {
        mValueAnmator = ValueAnimator.ofFloat(mStartValue, mEndValue)
        mValueAnmator.duration = mDuration
        mValueAnmator.interpolator = mInterpolator
        mValueAnmator.addUpdateListener { animation ->
            mView.text = String.format("%. " + mPrecision + "f", animation.animatedValue as Float)
        }
        mValueAnmator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationEnd(animation: Animator?) {
                mListener?.let { it.onAnimateCounterEnd() }
            }
        })
        mValueAnmator.start()
    }

    class Builder {
        var mDuration: Long = 2000L
        var mStartValue: Float = 0F
        var mEndValue: Float = 10F
        var mPrecision: Int = 0
        lateinit var mInterpolator: Interpolator
        lateinit var mView: TextView
    }

    interface AnimateCounterListener {
        fun onAnimateCounterEnd()
    }

}