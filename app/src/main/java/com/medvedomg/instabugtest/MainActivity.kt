package com.medvedomg.instabugtest

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.instabug.library.Instabug
import com.instabug.survey.Surveys
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Instabug.identifyUser("vadim", "vadim@upgames.ltd")
        Instabug.setUserAttribute("user_id", Random().nextInt().toString())
        Instabug.setUserAttribute("prize_earnings", Random().nextInt().toString())
        Instabug.setUserAttribute("language", Locale.getDefault().language)

        Handler().postDelayed({
            Log.d("OTP","Surveys.getAvailableSurveys(): ${Surveys.getAvailableSurveys()}")
            if (Surveys.getAvailableSurveys().isNotEmpty()) {
                Surveys.showSurveyIfAvailable()
//                Surveys.getAvailableSurveys().forEach {
//                    it.show()
//                }
            }
        }, 3000)
    }
}
