package com.medvedomg.instabugtest

import android.app.Application
import android.util.Log
import com.instabug.library.Instabug
import com.instabug.library.invocation.InstabugInvocationEvent
import com.instabug.library.ui.onboarding.WelcomeMessage
import com.instabug.survey.Surveys

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initInstabug()
    }

    private fun initInstabug() {
        Instabug.Builder(this, "2892f7d4d81b8a821946e8ab96c0042b")
            /**
             * [Instabug.Builder.setInvocationEvents] in charges for triggering action for instabug dialog to save bugs,
             * App doesn't need this feature
             */
            .setInvocationEvents(InstabugInvocationEvent.NONE)
            .build()

        /**
         * SETUP DEBUG MODE
         */
        Instabug.setDebugEnabled(true)
        /**
         * SDK show welcome dialog by default,
         * [Instabug.showWelcomeMessage] will disable auto showing welcome dialog
         */
        /**
         * [Surveys.setThresholdForReshowingSurveyAfterDismiss] will trigger showing survey,
         * if user dismiss it,
         * and doesn't respond for it
         */
        Surveys.setThresholdForReshowingSurveyAfterDismiss(3, 0)
        /**
         * SDK show survey after 10 seconds, when was initialised,
         * [Surveys.setAutoShowingEnabled] will disable auto showing feature
         */
        Surveys.setAutoShowingEnabled(false)
        Surveys.setOnShowCallback {
            Log.d("OTP", "show survey callback")
        }
        Surveys.setOnDismissCallback {
            Log.d("OTP", "dismiss survey callba ck")
        }
    }
}