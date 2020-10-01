package com.example.a272delegate

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties

data class OrderToSend(var message: String , var productsOfOrder : MutableList<OrderItem> , var supervisorId : String , var time : Long , var email :String)//this class is used to send the data to fireBase Firestore database
data class Order(val totalPrice : Double , val productsOfOrder : MutableList<OrderItem> , var message : String )