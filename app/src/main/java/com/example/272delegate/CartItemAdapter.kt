package com.example.a272delegate

import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.cart_item.*
import kotlinx.android.synthetic.main.cart_item.view.*
import kotlinx.android.synthetic.main.cart_item.view.deleteItemBtn

class CartItemAdapter (val order : Order):RecyclerView.Adapter<CartViewHolder>(){



    private var removedItemPosision =0
    lateinit private var removedItem : OrderItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val cartViewHolder : View = LayoutInflater.from(parent.context).inflate(R.layout.cart_item , parent , false)

//        parent.deleteItemBtn.setOnClickListener{
//                val alertBuilder = AlertDialog.Builder(parent.context)
//                alertBuilder.setTitle(" كيفية حذف المنتج ")
//                alertBuilder.setMessage(" مرر الى اليسار لحذف المنتج ")
//                alertBuilder.setPositiveButton(" حسناً ", DialogInterface.OnClickListener { dialog, which ->
//
//                    dialog.dismiss()
//                })
//
//            val alertDialog = alertBuilder.create()
//            alertDialog.show()
//        }

        return CartViewHolder(cartViewHolder)
    }

    override fun getItemCount(): Int {

        return order.productsOfOrder.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {

        var orderItem : OrderItem = order.productsOfOrder[position]
//        holder.cartItemImage = orderItem.getImage()
//        val imgV = holder.image
//        Glide.with(imgV).load(item.image).into(imgV)

        Glide.with(holder.cartItemImage).load(orderItem.image).into(holder.cartItemImage)
        holder.cartItemTitle.text = orderItem.title
        holder.numberOfPackages.text = orderItem.quantity.toString()
        holder.totalPriceOfPackages.text = orderItem.price.toString() + "$"
        holder.messageOFCartItem.text = orderItem.text

    }

    fun removeItem(viewHolder : RecyclerView.ViewHolder){
        removedItemPosision = viewHolder.adapterPosition
        removedItem = orderItems[removedItemPosision]

        orderItems.removeAt(removedItemPosision)
        notifyItemRemoved(removedItemPosision)


//        Snackbar.make(viewHolder.itemView , " تم حذف ${removedItem.title} " , Snackbar.LENGTH_LONG ).setAction(" الغاء "){
//            orderItems.add(removedItemPosision , removedItem)
//            notifyItemInserted(removedItemPosision)
//        }.show()

    }



}






class CartViewHolder(view: View): RecyclerView.ViewHolder(view){

    val cartItemImage = view.cartItemImage as ImageView
    val cartItemTitle = view.cartItemTitle as TextView
    val numberOfPackages = view.cartItemNumberOfPackages as TextView
    val totalPriceOfPackages = view.totalPriceOfPackages as TextView
    val messageOFCartItem = view.cartItemMessageTextView



    //use to delete with delete button
//    init {
//        view.deleteItemBtn.setOnClickListener{
//            orderItems.removeAt(adapterPosition)
//            val intent = Intent(view.context , Cart::class.java)
//            view.context.startActivity(intent)
//        }
//    }
}