package com.alamin.kotlin_recyclerview_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alamin.kotlin_recyclerview_retrofit.R
import com.alamin.kotlinrecyclerviewretrofit.model.ItemViewMode

class PostAdapter(private val list:List<ItemViewMode>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageview);
        val textView : TextView =itemView.findViewById(R.id.textView);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = list[position];
        holder.imageView.setImageResource(item.image);
        holder.textView.text=item.text;
    }

    override fun getItemCount(): Int {
        return list.size;
    }
}