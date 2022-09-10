package com.example.simple_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var factLabel: TextView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button

    private var facts = arrayOf(
        "Message one",
        "Message two",
        "Message THREEEEEEEEE"
    )
    private var factIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        // the usual system stuff
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // connect our views
        this.connectViews()

        // setup our callbacks
        this.setupCallbacks()
    }


    private fun connectViews() {

        //
        this.factLabel = this.findViewById(R.id.factLabel)
        this.previousButton = this.findViewById(R.id.previousButton)
        this.nextButton = this.findViewById(R.id.nextButton)
    }

    private fun setupCallbacks() {

        //
        this.previousButton.setOnClickListener { view: View ->

            this.adjustFactIndex(adjustment = -1)
            this.factLabel.text = this.facts[this.factIndex]
            println("Previous button was clicked")
        }

        this.nextButton.setOnClickListener { view: View ->

            this.adjustFactIndex(adjustment = 1)
            this.factLabel.text = this.facts[this.factIndex]
            println("Next button was clicked")
        }
    }

    private fun adjustFactIndex(adjustment: Int) {

        //
        this.factIndex += adjustment

        if ( this.factIndex < 0 ) {
            this.factIndex = this.facts.size - 1
        }
        else if ( this.factIndex >= this.facts.size) {
            this.factIndex = 0
        }
    }
}