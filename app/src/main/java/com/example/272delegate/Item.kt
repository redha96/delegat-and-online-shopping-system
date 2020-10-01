package com.example.a272delegate

//import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot


 data class Item (val categoryTitle : String, val title: String, val price : Double,
                        val quantity : Int, val image : String, val itemPosition : Int,
                        var itemRef : QueryDocumentSnapshot)




class ProductViewHolder internal constructor(private val view: View) : RecyclerView.ViewHolder(view) {
     fun setItemName(itemName: String) {

        val textView = view.findViewById<TextView>(R.id.itemTitle)
        textView.text = itemName
    }

    internal fun setItemPrice(itemPrice: Double){
        val title = view.findViewById<TextView>(R.id.itemPrice)
        title.text = itemPrice.toString()
    }

    internal fun setItemImg(imgURL : String){
        val imgV = view.findViewById<ImageView>(R.id.itemImage)
        Glide.with(imgV).load(imgURL).into(imgV)
    }
}

