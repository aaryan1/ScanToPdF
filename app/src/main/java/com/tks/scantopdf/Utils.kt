package com.tks.scantopdf

import android.content.Context
import android.widget.Toast

class Utils {


    companion object {
        /** extended function to  show long toast*/
        fun String.longToast(context: Context) {
            Toast.makeText(context, this, Toast.LENGTH_LONG).show()
        }

        fun String.shortToast(context: Context) {
            Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
        }
    }

}