package com.example.a272delegate

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot


import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_item.*


import kotlinx.android.synthetic.main.activity_products_items.*
import java.lang.Error
import com.google.firebase.firestore.DocumentReference as FirestoreDocumentReference



var itemsList = ArrayList<Item>()
var orderItems = mutableListOf<OrderItem>()
//var orderItems = ArrayList<OrderItem>()
//var orderItemsMutableList : MutableList<Item> = orderItems
class ProductsItems(
    //categoryName : String , productsRef : DocumentReference
)
    : AppCompatActivity(){


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu , menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_cart_btn -> {
                intent = Intent(this , Cart::class.java)
                intent.putExtra("categoryTitle" , supportActionBar?.title.toString())
                startActivity(intent)
            }

            R.id.menu_logout_btn -> {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this , LoginActivity::class.java)
                intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }





//    var adapter : ProductFirestoreRecyclerAdapter? = null


    //var nameOfCategory = intent!!.getStringExtra("categoryTitle")!!// categoryName
    //var itemsRef = intent!!.getStringExtra("itemsRef") as DocumentReference//productsRef//FirebaseFirestore.getInstance().collection("categories").document()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_items)

        itemListRecyclerView.layoutManager = LinearLayoutManager(this)


        //itemListRecyclerView.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL , false)



        var nameOfCategory : String
        //var itemsRef : com.google.firebase.firestore.DocumentReference
        var i = intent
        if(i != null){
            //var bundleItemsRef = intent.getBundleExtra("itemsRefBundle")//intent!!.getSerializableExtra("itemsRef").toString() //as DocumentReference // DocumentReference//productsRef//FirebaseFirestore.getInstance().collection("categories").document()
            //itemsRef = bundleItemsRef.getParcelable<Parcelable>("itemsref")!! as FirestoreDocumentReference


            nameOfCategory = intent!!.getStringExtra("categoryTitle")
            //this is fixed path for text
            //var itemsRef = intent.getSerializableExtra("itemsRef")  as? DocumentReference

            // we'll change the title of the nav bar
            supportActionBar?.title = nameOfCategory



//            var adapter = ItemAdapter(itemsList)
//
//            var query : Query //= itemsRef!!.collection("products").orderBy("id", Query.Direction.ASCENDING)
//
//
//            if(isLastDoc != null)
//                query = itemsRef!!.collection("products").orderBy("id", Query.Direction.ASCENDING).startAfter(
//                    isLastDoc)
//
//            else
//                query = itemsRef!!.collection("products").orderBy("id", Query.Direction.ASCENDING)
////        val options = FirestoreRecyclerOptions.Builder<Item>().setQuery(query , Item::class.java).build()
//
//            query.get().addOnSuccessListener{ result ->
//                for(document in result){
//
//
//                    val tempTitle = document.get("title") as String
//                    var tempPrice = document.get("price")
//                    //if(tempPrice is Int || tempPrice is Long){ tempPrice.toString().toDouble()}
//                    val tempImage = document.get("image") as String
//                    val tempQuantity = document.get("quantity")
//
//                    val tempItem : Item = Item(nameOfCategory,
//                        tempTitle,
//                        tempPrice.toString().toDouble() ,
//                        tempQuantity.toString().toInt() ,
//                        tempImage ,
//                        itemsList.size)
//
//                    itemsList.add(tempItem)
//
//                    Log.d("TAG", "test loop $tempItem")
//
//                }
//
//                adapter.notifyDataSetChanged()
//
//                Log.d("TAG", "test")
//
//
//                if (!result.isEmpty){
//                    isLastDoc=result.last()
//                }
//
//            }.addOnFailureListener { exception ->
//                Log.e("TAG", "get failed with ", exception)
//
//            }
//            Log.i("TAG", itemsList.toString())
//
//
//            itemListRecyclerView.adapter = adapter
//
//
////        adapter = ProductFirestoreRecyclerAdapter(options)
////        itemList.adapter = adapter
//

        }



//
//        db.collectionGroup("landmarks").whereEqualTo("type", "museum").get()
//            .addOnSuccessListener { queryDocumentSnapshots ->
//                // ...
//            }



        //val rootRef = FirebaseFirestore.getInstance()

        //var itemsRef :DocumentReference



        //tropicanaClicked()
        //itemsRef = FirebaseFirestore.getInstance().collection("categories").document("tropicana")



    }



//        itemsRef.collection("cities")
//            .whereEqualTo("capital", true)
//            .get()
//            .addOnSuccessListener { documents ->
//                for (document in documents) {
//                    //Log.d(TAG, "${document.id} => ${document.data}")
//                    itemsList.get(document.id).itemImg = document.data.getValue("image")
//
//                }
//            }
//            .addOnFailureListener { exception ->
//                //Log.w(TAG, "Error getting documents: ", exception)
//            }









    override fun onStart() {
        super.onStart()

        var arrayListOfItem = ArrayList<Item>()
        var adapter = ItemAdapter(arrayListOfItem)

        var query : Query //= itemsRef!!.collection("products").orderBy("id", Query.Direction.ASCENDING)



        //query = itemsRef.collection("products").startAfter(lastDoc)
        //query.orderBy("id", Query.Direction.ASCENDING)

        query = itemsRef.collection("products").orderBy("id", Query.Direction.ASCENDING)

//        val options = FirestoreRecyclerOptions.Builder<Item>().setQuery(query , Item::class.java).build()

        query.get().addOnSuccessListener{ result ->
            for(document in result){


                val tempData = document.data

                var tempTitle = tempData.get("title").toString()
                //val tempTitle = document.get("title") as String
                var tempPrice = tempData.get("price")
                //if(tempPrice is Int || tempPrice is Long){ tempPrice.toString().toDouble()}
                val tempImage = tempData.get("image") as String
                val tempQuantity = tempData.get("quantity")

                var nameOfCategory = intent.getStringExtra("categoryTitle")

                val tempItem : Item = Item(nameOfCategory,
                    tempTitle,
                    tempPrice.toString().toDouble() ,
                    tempQuantity.toString().toInt() ,
                    tempImage ,
                    arrayListOfItem.size ,
                    document)

                arrayListOfItem.add(tempItem)

                Log.d("TAG", "test loop $tempItem")

            }

            adapter.notifyDataSetChanged()

            Log.d("TAG", "test")


//            if (!result.isEmpty){
//                isLastDoc= itemsList.get(itemsList.lastIndex).itemRef
//                // isLastDoc= itemsList.get(itemsList.lastIndex).//result.last()
//            }

            itemsList = arrayListOfItem

        }.addOnFailureListener { exception ->
            Log.e("TAG", "get failed with ", exception)

        }
        Log.i("TAG", itemsList.toString())


        itemListRecyclerView.adapter = adapter


//        adapter = ProductFirestoreRecyclerAdapter(options)
//        itemList.adapter = adapter


//        adapter!!.startListening()
    }
//
//    override fun onStop() {
//        super.onStop()
//
//        if (adapter != null) {
//            adapter!!.stopListening()
//        }
//    }


//    fun tropicanaClicked() {
//        itemsRef = FirebaseFirestore.getInstance().collection("categories").document("tropicana")
//    }
//
//    fun riceOnClick (){
//        itemsRef = FirebaseFirestore.getInstance().collection("categories").document("rice")
//    }
//
//    fun teaOnClick (){
//        itemsRef = FirebaseFirestore.getInstance().collection("categories").document("tea")
//
//    }
//
//    fun coffeeOnClick (){
//        itemsRef = FirebaseFirestore.getInstance().collection("categories").document("coffee")
//    }
//    fun corn_flakesOnClick (){
//        itemsRef = FirebaseFirestore.getInstance().collection("categories").document("corn flakes")
//    }
//
//    fun cansOnClick (){
//        itemsRef = FirebaseFirestore.getInstance().collection("categories").document("cans")
//    }
//
//    fun othersOnClick (){
//        itemsRef = FirebaseFirestore.getInstance().collection("categories").document("corn flakes")
//    }



}






