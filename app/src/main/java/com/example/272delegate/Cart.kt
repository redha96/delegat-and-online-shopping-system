package com.example.a272delegate

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldValue
import io.opencensus.tags.Tag
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.cart_item.*
import kotlin.math.log

var totalPriceOfCart =0.0



class Cart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        supportActionBar?.title = "عربة التسوق"

        //supportActionBar?.setDisplayHomeAsUpEnabled(true)



        //val itemsOfOrder = orderItems

        calculateTotalPriceOfCart()





        val order = Order(totalPriceOfCart , orderItems , itemNotesTextView.text.toString())
        cartItemsList.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL, false)

        if(order.productsOfOrder.isEmpty()){
            val alertBuilder = AlertDialog.Builder(this)
            alertBuilder.setTitle("لا توجد منتجات في العربة")
            alertBuilder.setMessage(" قم بأضافة بعض المنتجات اولا ")
            alertBuilder.setPositiveButton(" حسناً ", DialogInterface.OnClickListener{ dialog , which ->
                finish()
            } )


            val alertDialog = alertBuilder.create()
            alertDialog.show()

        }
        val ad = CartItemAdapter(order)
        cartItemsList.adapter=ad


        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0 , ItemTouchHelper.LEFT //or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                ad.removeItem(viewHolder)
                calculateTotalPriceOfCart()
            }


        }


        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(cartItemsList)



        requestSendBtn.setOnClickListener {
            var user = FirebaseAuth.getInstance().currentUser!!
            var userId = user.uid
            var userEmail = user.email
            var time = System.currentTimeMillis()
            db.collection("users").document("$userId").get().addOnSuccessListener {



                var supervisorId = it.getString("supervisor")
                var orderToSend = OrderToSend(itemNotesTextView.text.toString(), order.productsOfOrder, supervisorId!! , time , userEmail!!)
                    if (itemNotesTextView.text.isNotEmpty() && order.productsOfOrder.size != 0) {
                        order.message = itemNotesTextView.text.toString()


//                if (e != null) {
//                    Log.w("Listen failed", e)
//                    return@addSnapshotListener
//                }



//                db.collection("message").document("order $newDocumentId").


                                    //var orderToSend = OrderToSend(order.message , order.orderItemsList)
                                    //orderToSend.productsOfOrder = order.orderItemsList

                                    db.collection("message").document().set(orderToSend)

                                        //.add(order)
                                        .addOnSuccessListener {
                                            var contextView =
                                                findViewById<View>(android.R.id.content)
                                            Snackbar.make(
                                                contextView,
                                                " تم ارسال الطلب ",
                                                Snackbar.LENGTH_LONG
                                            )
                                                .show()

                                            order.productsOfOrder.clear()
                                            Log.d(
                                                "cart activity",
                                                "order product list size is : ${order.productsOfOrder.size}"
                                            )
                                            finish()
                                        }



                            .addOnFailureListener {
                                var contextView = findViewById<View>(android.R.id.content)
                                Snackbar.make(
                                    contextView,
                                    " لم يتم ارسال الطلب ",
                                    Snackbar.LENGTH_LONG
                                )
                                    .show()
                            }


                        //order.productsOfOrder.clear()


                    }

                }
                .addOnFailureListener{
                    var contextView = findViewById<View>(android.R.id.content)
                    Snackbar.make(
                        contextView,
                        " هناك مشكلة بالاتصال بالسيرفر ",
                        Snackbar.LENGTH_LONG
                    )
                        .show()
                }
        }


//        deleteItemBtn.setOnClickListener{
//            val alertBuilder = AlertDialog.Builder(this)
//            alertBuilder.setTitle(" كيفية حذف المنتج ")
//            alertBuilder.setMessage(" مرر الى اليسار لحذف المنتج ")
//            alertBuilder.setPositiveButton(" حسناً ", DialogInterface.OnClickListener { dialog, which ->
//
//                dialog.dismiss()
//            })
//
//            val alertDialog = alertBuilder.create()
//            alertDialog.show()
//        }




        //totalPriceTextView.addTextChangedListener()

    }


    fun calculateTotalPriceOfCart(){
        totalPriceOfCart =0.0
        for( i in 0 until  orderItems.size ){
            totalPriceOfCart += orderItems[i].price
            totalPriceTextView.text = "سعر الطلبية الكلي "+"$totalPriceOfCart $"
        }
    }


}
