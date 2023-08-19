package com.example.bookstoreapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.bookstoreapp.MainApplication
import com.example.bookstoreapp.R
import com.example.bookstoreapp.common.viewBinding
import com.example.bookstoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window.statusBarColor  = ContextCompat.getColor(this,R.color.bck)

        MainApplication.provideRetrofit(this)
    }
}
