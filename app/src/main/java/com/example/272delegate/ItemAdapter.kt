package com.example.a272delegate

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_item.view.*
import java.text.ParsePosition
import kotlin.properties.Delegates

class ItemAdapter(val itemList :  ArrayList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){



    //var itemPosition by Delegates.notNull<Int>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vHolder : View = LayoutInflater.from(parent.context).inflate(R.layout.activity_item , parent , false)
        return ViewHolder(vHolder)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item : Item = itemList[position]
        holder.title.text = item.title
        holder.price.text = item.price.toString() + "$"
        holder.itemPositionView.text = item.itemPosition.toString()



        //itemPosition = position
        //image Glide

        val imgV = holder.image
        Glide.with(imgV).load(item.image).into(imgV)


        //holder.itemView.setOnClickListener()

//        fun onItemClicked (){
//            val context=holder.title.context
//            val intent = Intent( context, ItemView::class.java)
//            intent.putExtra("position" , position)
//            context.startActivity(intent)
//        }


    }



    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val image = view.itemImage as ImageView
        val title = view.itemTitle as TextView
        val price = view .itemPrice as TextView
        val itemPositionView = view.itemRowId

        init {
            view.setOnClickListener{
                val intent = Intent(view.context , ItemView::class.java)
                intent.putExtra("position", view.itemRowId.text)
                view.context.startActivity(intent)
            }
        }
    }

}