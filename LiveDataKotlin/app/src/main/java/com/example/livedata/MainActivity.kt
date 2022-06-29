package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    /**
     * Instiate View Model
     */
    lateinit var viewModel: IncrementNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_click_me = findViewById(R.id.buttonNumber_id) as Button
        val number = findViewById(R.id.textviewNumber_id) as TextView
        val numberOddEven = findViewById(R.id.textviewOddEvenNumber_id) as TextView
        /**
         * view model instatiation.
         */
        viewModel=ViewModelProvider(this).get(IncrementNumberViewModel::class.java)
        viewModel.CurrentnumberType.observe(this, Observer {
            numberOddEven.text=it.toString()
        })
        viewModel.currentNumber.observe(this, Observer {
            number.text=it.toString()
        })
        btn_click_me.setOnClickListener {
            viewModel.incrementNumber()
        }
    }
}