package com.tks.scantopdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tks.scantopdf.Utils.Companion.longToast
import com.tks.scantopdf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initiateView(binding)

    }

    private fun initiateView(binding: ActivityMainBinding) {

        binding.fabGallery.setOnClickListener {

           "Hello".longToast(applicationContext)
        }
    }
}