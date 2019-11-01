package com.arioki.latihan2angkolayout

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SecondaryUi().setContentView(this)
    }
    class SecondaryUi:AnkoComponent<Activity>{
        override fun createView(ui: AnkoContext<Activity>) = with(ui){
             verticalLayout {
                 padding = dip(10)
                 textView(text = "selamat datang")
             }
        }
    }
}
