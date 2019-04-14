package com.bomi.hapo.freight_app.common.animator

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.animation.Interpolator
import android.widget.TextView
import kotlin.math.abs

/**
 *
 * Created by JWHAPO
 * -19. 4. 11 오후 10:58
 */
class AnimateCounter(builder: Builder) {
    var mView: TextView
    var mDuration: Long
    var mStartValue: Float
    var mEndValue: Float
    var mPrecision: Int
    var mInterpolator: Interpolator
    lateinit var mValueAnmator: ValueAnimator
    lateinit var mListener: AnimateCounterListener

    init {
        mView = builder.mView
        mDuration = builder.mDuration
        mStartValue = builder.mStartValue
        mEndValue = builder.mEndValue
        mPrecision = builder.mPrecision
        mInterpolator = builder.mInterpolator
        mListener = builder.mListener
    }

    fun execute() {
        mValueAnmator = ValueAnimator.ofFloat(mStartValue, mEndValue)
        mValueAnmator.duration = mDuration
        mValueAnmator.interpolator = mInterpolator
        mValueAnmator.addUpdateListener { animation ->
            mView.text = String.format("%." + mPrecision + "f", animation.animatedValue as Float)
        }
        mValueAnmator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }
            override fun onAnimationEnd(animation: Animator?) {
                mListener?.let { it.onAnimateCounterEnd() }
            }
        })
        mValueAnmator.start()
    }

    class Builder(view: TextView) {
        var mDuration: Long = 2000L
        var mStartValue: Float = 0F
        var mEndValue: Float = 10F
        var mPrecision: Int = 0
        lateinit var mListener: AnimateCounterListener
        lateinit var mInterpolator: Interpolator
        var mView: TextView = view

        fun setCount(start: Float, end: Float): Builder {
            if (start == end) {
                throw IllegalArgumentException("Start and End must be different")
            }
            mStartValue = start
            mEndValue = end
            mPrecision = 0
            return this
        }

        fun setCount(start: Float, end: Float, precision: Int): Builder {
            if (abs(start - end) < 0.001) {
                throw IllegalArgumentException("Start and End must be different")
            }
            if (precision < 0) {
                throw IllegalArgumentException("Precision can't be negative")
            }
            mStartValue = start
            mEndValue = end
            mPrecision = precision
            return this
        }

        fun setDuration(duration: Long): Builder {
            if (duration <= 0) {
                throw IllegalArgumentException("Duration can't be negative")
            }
            mDuration = duration
            return this
        }

        fun setInterpolator(interpolator: Interpolator): Builder {
            mInterpolator = interpolator
            return this
        }

        fun setAnimationCounterListener(listener: AnimateCounterListener): Builder {
            mListener = listener

            return this
        }

        fun build(): AnimateCounter {
            return AnimateCounter(this)
        }
    }


    fun stop() {
        if (mValueAnmator.isRunning) mValueAnmator.cancel()
    }

    interface AnimateCounterListener {
        fun onAnimateCounterEnd()
    }

}