package com.example.a272delegate

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.multidex.MultiDex
import com.bumptech.glide.Glide
import com.google.firebase.firestore.DocumentReference
//import android.util.Log
//import android.widget.LinearLayout
//import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
//import com.xwray.groupie.GroupAdapter
//import com.xwray.groupie.Item
//import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_categories.*
val db = FirebaseFirestore.getInstance()
lateinit var itemsRef :DocumentReference//= db.collection("ERROR").document()
open class Categories : AppCompatActivity() {

//    override fun attachBaseContext(base : Context ) {
//        super.attachBaseContext(base)
//        MultiDex.install(this)
//    }

    // Access a Cloud Firestore instance from your Activity
    //public val db = FirebaseFirestore.getInstance()


    private val categoriesRef = db.collection("categories")
    private val tropicanaRef = categoriesRef.document("tropicana")
    private val riceRef = categoriesRef.document("rice")
    private val teaRef = categoriesRef.document("tea")
    private val glassRef = categoriesRef.document("glass")
    private val corn_flakesdRef = categoriesRef.document("corn flakes")
    private val cansRef = categoriesRef.document("cans")
    private val othersRef = categoriesRef.document("others")
    private val pritaniaRef = categoriesRef.document("pritania")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        supportActionBar?.title = "Categories"

        //.get()
        tropicanaRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot != null) {
                val tropicanaTitle = documentSnapshot.getString("title")
                val tropicanaImageUrl = documentSnapshot.getString("image")

                textView_category1_title.setText(tropicanaTitle)

                Glide.with(this).load(tropicanaImageUrl).into(category_1_image)
//                category_1_image.clipToOutline
            }
        }
//        fun onClick() :Intent {
////        LinearLayout_category1.setOnClickListener() {
//            val intent = Intent(this,ProductsItems::class.java)
//            intent.putExtra("itemsRef",tropicanaRef.toString())
//            intent.putExtra("categoryTitle",textView_category1_title.toString())
//            startActivity(intent)
//            return intent
//        }


        riceRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot != null) {
                val title = documentSnapshot.getString("title")
                val imageUrl = documentSnapshot.getString("image")

                textView_category2_title.setText(title)

                Glide.with(this).load(imageUrl).into(category_2_image)
            }

        }
        teaRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot != null) {
                val title = documentSnapshot.getString("title")
                val imageUrl = documentSnapshot.getString("image")

                textView_category3_title.setText(title)

                Glide.with(this).load(imageUrl).into(category_3_image)
            }

        }
        glassRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot != null) {
                val title = documentSnapshot.getString("title")
                val imageUrl = documentSnapshot.getString("image")

                textView_category4_title.setText(title)

                Glide.with(this).load(imageUrl).into(category_4_image)
            }
        }

        corn_flakesdRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot != null) {
                val title = documentSnapshot.getString("title")
                val imageUrl = documentSnapshot.getString("image")

                textView_category5_title.setText(title)

                Glide.with(this).load(imageUrl).into(category_5_image)
            }
        }


        cansRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot != null) {
                val title = documentSnapshot.getString("title")
                val imageUrl = documentSnapshot.getString("image")

                textView_category6_title.setText(title)

                Glide.with(this).load(imageUrl).into(category_6_image)
            }
        }


        othersRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot != null) {
                val title = documentSnapshot.getString("title")
                val imageUrl = documentSnapshot.getString("image")

                textView_category7_title.setText(title)

                Glide.with(this).load(imageUrl).into(category_7_image)
            }
        }


        pritaniaRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot != null) {
                val title = documentSnapshot.getString("title")
                val imageUrl = documentSnapshot.getString("image")

                textView_category8_title.setText(title)

                Glide.with(this).load(imageUrl).into(category_8_image)
            }
        }

    }

    fun tropicanaOnClick(view: View) :Intent {
//        LinearLayout_category1.setOnClickListener() {
        val intent = Intent(this,ProductsItems::class.java)
        //intent.putExtra("itemsRef",tropicanaRef.collection("products").toString())
        itemsRef = db.collection("categories").document("tropicana")
        intent.putExtra("categoryTitle",textView_category1_title.text)
        startActivity(intent)
        return intent
    }

    fun riceOnClick(view: View) :Intent {
//        LinearLayout_category1.setOnClickListener() {
        val intent = Intent(this,ProductsItems::class.java)
        //intent.putExtra("itemsRef",tropicanaRef.collection("products").toString())
        itemsRef = db.collection("categories").document("rice")
        intent.putExtra("categoryTitle",textView_category2_title.text)
        startActivity(intent)
        return intent
    }


    fun teaOnClick(view: View) :Intent {
//        LinearLayout_category1.setOnClickListener() {
        val intent = Intent(this,ProductsItems::class.java)
        //intent.putExtra("itemsRef",tropicanaRef.collection("products").toString())
        itemsRef = db.collection("categories").document("tea")
        intent.putExtra("categoryTitle",textView_category3_title.text)
        startActivity(intent)
        return intent
    }

    fun glassOnClick(view: View) :Intent {
//        LinearLayout_category1.setOnClickListener() {
        val intent = Intent(this,ProductsItems::class.java)
        //intent.putExtra("itemsRef",tropicanaRef.collection("products").toString())
        itemsRef = db.collection("categories").document("glass")
        intent.putExtra("categoryTitle",textView_category4_title.text)
        startActivity(intent)
        return intent
    }

    fun corn_flakesOnClick(view: View) :Intent {
//        LinearLayout_category1.setOnClickListener() {
        val intent = Intent(this,ProductsItems::class.java)
        //intent.putExtra("itemsRef",tropicanaRef.collection("products").toString())
        itemsRef = db.collection("categories").document("corn flakes")
        intent.putExtra("categoryTitle",textView_category5_title.text)
        startActivity(intent)
        return intent
    }

    fun cansOnClick(view: View) :Intent {
//        LinearLayout_category1.setOnClickListener() {
        val intent = Intent(this,ProductsItems::class.java)
        //intent.putExtra("itemsRef",tropicanaRef.collection("products").toString())
        itemsRef = db.collection("categories").document("cans")
        intent.putExtra("categoryTitle",textView_category6_title.text)
        startActivity(intent)
        return intent
    }

    fun othersOnClick(view: View) :Intent {
//        LinearLayout_category1.setOnClickListener() {
        val intent = Intent(this,ProductsItems::class.java)
        //intent.putExtra("itemsRef",tropicanaRef.collection("products").toString())
        itemsRef = db.collection("categories").document("others")
        intent.putExtra("categoryTitle",textView_category7_title.text)
        startActivity(intent)
        return intent
    }


    fun pritaniaOnClick(view: View) :Intent {
//        LinearLayout_category1.setOnClickListener() {
        val intent = Intent(this,ProductsItems::class.java)
        //intent.putExtra("itemsRef",tropicanaRef.collection("products").toString())
        itemsRef = db.collection("categories").document("pritania")
        intent.putExtra("categoryTitle",textView_category8_title.text)
        startActivity(intent)
        return intent
    }


}





