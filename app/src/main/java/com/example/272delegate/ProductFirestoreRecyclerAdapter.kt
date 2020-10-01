package com.example.a272delegate
import android.view.LayoutInflater
import android.view.ViewGroup
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.firebase.ui.firestore.FirestoreRecyclerAdapter



//    override fun onBindViewHolder(productViewHolder: ProductViewHolder, position: Int, productItem: Item) {
//        productViewHolder.setItemName(productItem.itemName)
//        productViewHolder.set
 class ProductFirestoreRecyclerAdapter internal constructor(options: FirestoreRecyclerOptions<Item>) : FirestoreRecyclerAdapter<Item, ProductViewHolder>(options) {


    //var item = options
    override fun onBindViewHolder(productViewHolder:  ProductViewHolder, postion: Int, item: Item) {
//        productViewHolder.setItemName(item.itemName)
//        productViewHolder.setItemPrice(item.itemPrice)
//        productViewHolder.setItemImg(item.itemImg)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return ProductViewHolder(view)
    }
}