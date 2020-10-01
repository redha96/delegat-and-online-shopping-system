package com.example.a272delegate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.firebase.firestore.DocumentReference
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.android.synthetic.main.activity_item_view.*

class ItemView(//itemRef : DocumentReference
) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_view)



        //var itemPosition = intent.getIntExtra("position" , 0)


//        val imgV = holder.image
//        Glide.with(imgV).load(item.image).into(imgV)




        var bundle : Bundle? = intent.extras
        var itemPosition = bundle!!.getString("position")
        var item = itemsList[itemPosition!!.toInt() ]
        Glide.with(this).load(item.image).into(itemViewImg)
        itemViewTitle.setText("${item.title} : ${item.categoryTitle}")

        itemViewPrice.setText(item.price.toString() + "$")

        itemViewQuantity.setText("${item.quantity}" + "عدد المنتجات داخل العلبة ")

        sendToCardBtn.setOnClickListener{
            var packagesNumber : Int
            if(numberOfPackages.text.isNotEmpty())
                packagesNumber = numberOfPackages.text.toString().toInt()
            else
                packagesNumber = 1

            var totalPrice : Double = packagesNumber*item.price
            var itemMessage : String = itemNotesTextView.text.toString()
            var orderItem = OrderItem(item.title , item.image , packagesNumber , itemMessage , totalPrice )
            orderItems.add(orderItem)
            finish()
        }

    }
}
