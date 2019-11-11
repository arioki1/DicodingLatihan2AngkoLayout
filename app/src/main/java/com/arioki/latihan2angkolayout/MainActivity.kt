package com.arioki.latihan2angkolayout

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)
                val name = editText {
                    hint = "What's your name?"
                }
                button("Say Hello") {
                    backgroundColor = Color.BLUE
                    textColor = Color.WHITE
                    setOnClickListener { toast("Hello, ${name.text}!") }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
                button("Show alert") {
                    backgroundColor = Color.BLUE
                    textColor = Color.WHITE
                    setOnClickListener {
                        alert("Happy coding !", "Hello ,  ${name.text}!") {
                            yesButton { toast("oh") }
                            noButton { toast("yes") }
                        }.show()
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show Selector") {
                    backgroundColor = Color.BLUE
                    textColor = Color.WHITE
                    val club = listOf("Barcelona", "Real Madrid", "Bayern Munchen", "Liverpool")
                    selector(
                        "\"Hello, ${name.text}! What's football club do you love? ",
                        club
                    ) { _, i ->
                        toast(club[i])
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show Snackbar") {
                    backgroundColor = Color.BLUE
                    textColor = Color.WHITE
                    setOnClickListener {
                        snackbar("Hello, ${name.text}!")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Go to second activity") {
                    backgroundColor = Color.BLUE
                    textColor = Color.WHITE
                    setOnClickListener {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
            }

        }

    }
}
