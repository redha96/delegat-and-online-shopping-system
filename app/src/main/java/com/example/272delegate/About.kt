package com.example.a272delegate

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.about_layout.*
import kotlinx.android.synthetic.main.activity_about.*
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat


class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_layout)




        facebook_image_272_btn.setOnClickListener{
            var link = Intent(Intent.ACTION_VIEW , Uri.parse("https://www.facebook.com/TwoSevenTwoIraq/"))
            startActivity(link)
        }

        email_image_272_btn.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("mustafa@nadheer272.net"))
            intent.putExtra(Intent.EXTRA_SUBJECT , "A message from android project 272Delegate ")
            intent.putExtra(Intent.EXTRA_TEXT , " ")

            intent.setType("message/rfc822")
            startActivity(intent)
        }

        phone_call_272_btn.setOnClickListener {
            makePhoneCall("+9647704848127")
        }

        facebook_image_odevs_btn.setOnClickListener{
            var link = Intent(Intent.ACTION_VIEW , Uri.parse("https://www.facebook.com/ODevs-116136240074230/"))
            startActivity(link)
        }

        phone_call_odevs_btn.setOnClickListener {
            makePhoneCall("+9647712758802")
        }

        email_image_odevs_btn.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("odevs.iq@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT , "A message from android project 272Delegate ")
            intent.putExtra(Intent.EXTRA_TEXT , " ")

            intent.setType("message/rfc822")
            startActivity(intent)
//            startActivity(Intent.createChooser(intent , " اختر تطبيق لارسال الايميل "))

        }

        instagram_image_odevs_btn.setOnClickListener {
            var link = Intent(Intent.ACTION_VIEW , Uri.parse("https://www.instagram.com/odevs25/"))
            startActivity(link)
        }
    }



    private fun makePhoneCall(number: String){
        try {
            var makeCallPermission = ContextCompat.checkSelfPermission(this ,
                Manifest.permission.CALL_PHONE)
            if(makeCallPermission != PackageManager.PERMISSION_GRANTED)
                ActivityCompat.requestPermissions(this , arrayOf(Manifest.permission.CALL_PHONE) , 1 )
            val intent = Intent(Intent.ACTION_CALL , Uri.parse("tel:$number"))
//            intent.setData(Uri.parse("tel:$number"))
            startActivity(intent)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
