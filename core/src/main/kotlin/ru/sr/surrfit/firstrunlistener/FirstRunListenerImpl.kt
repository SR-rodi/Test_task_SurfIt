package ru.sr.surrfit.firstrunlistener

import android.content.Context

class FirstRunListenerImpl(context: Context): FirstRunListener {
    private val preferenceFirstRun =
        context.getSharedPreferences(FirstRun, Context.MODE_PRIVATE)

    override fun putFirstRun() {
        preferenceFirstRun.edit().putBoolean(IS_FIRST_RUN, true).apply()
    }


    override fun getFirstRun(): Boolean {
       return preferenceFirstRun.getBoolean(IS_FIRST_RUN,false)
    }

    companion object {
        private const val FirstRun = "FirstRun"
        private const val IS_FIRST_RUN = "IS_FIRST_RUN"
    }
}