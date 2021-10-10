package com.alamin.kotlin_recyclerview_retrofit.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.alamin.kotlin_recyclerview_retrofit.R
import com.alamin.kotlinrecyclerviewretrofit.model.ItemViewMode

class PostActivity : AppCompatActivity() {
    @BindView(R.id.recycler_view)
    lateinit var recyclerView:RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        ButterKnife.bind(this);
        recyclerView.layoutManager = LinearLayoutManager(this);
        val data = arrayListOf<ItemViewMode>();
        for (i in 1..20){
            data.add(ItemViewMode(R.drawable.ic_launcher_foreground,"Item : $i"));
        }
        val adapter = PostAdapter(data);
        recyclerView.adapter = adapter;
    }
}