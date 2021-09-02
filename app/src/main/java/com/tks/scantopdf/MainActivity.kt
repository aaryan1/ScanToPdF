package com.tks.scantopdf

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tks.scantopdf.Utils.Companion.longToast
import com.tks.scantopdf.databinding.ActivityMainBinding
import androidx.core.app.ActivityCompat.startActivityForResult

import com.scanlibrary.ScanConstants

import com.scanlibrary.ScanActivity

import android.content.Intent
import android.provider.MediaStore

import android.graphics.Bitmap

import android.R.attr.data

import android.app.Activity
import android.net.Uri
import java.io.IOException


class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 99
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initiateView(binding)


        val preference: Int = ScanConstants.OPEN_CAMERA
        val intent = Intent(this, ScanActivity::class.java)
        intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, preference)
        startActivityForResult(intent, REQUEST_CODE)

    }

    private fun initiateView(binding: ActivityMainBinding) {

        binding.fabGallery.setOnClickListener {

           "Hello".longToast(applicationContext)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode === REQUEST_CODE ) {
            val uri: Uri? = data!!.extras!!.getParcelable(ScanConstants.SCANNED_RESULT)
            var bitmap: Bitmap? = null
            try {
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
                contentResolver.delete(uri!!, null, null)
                ActivityMainBinding.inflate(layoutInflater).previewImage.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}