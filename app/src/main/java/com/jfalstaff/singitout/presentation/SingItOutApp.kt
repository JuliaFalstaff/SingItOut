package com.jfalstaff.singitout.presentation

import android.app.Application
import com.jfalstaff.singitout.di.DaggerApplicationComponent

class SingItOutApp: Application() {
    val component by lazy {
        DaggerApplicationComponent.builder().build()
    }
}