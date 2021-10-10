package com.alamin.kotlin_recyclerview_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alamin.kotlin_recyclerview_retrofit.model.PostItem
import com.alamin.kotlin_recyclerview_retrofit.R

class PostAdapter(private var list:List<PostItem>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val textView : TextView =itemView.findViewById(R.id.textView);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = list[position];
        holder.textView.text=item.title;
    }

    override fun getItemCount(): Int {
        return list.size;
    }
}