package com.alamin.kotlin_recyclerview_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.alamin.kotlin_recyclerview_retrofit.network.ApiInterface
import com.alamin.kotlin_recyclerview_retrofit.model.PostItem
import com.alamin.kotlin_recyclerview_retrofit.R
import com.alamin.kotlin_recyclerview_retrofit.adapter.PostAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostActivity : AppCompatActivity() {
    private val TAG = "PostActivity"
    //UI
    @BindView(R.id.recycler_view)
    lateinit var recyclerView:RecyclerView;

    //Data
    val postList = arrayListOf<PostItem>();
    val adapter: PostAdapter?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        ButterKnife.bind(this);
        recyclerView.layoutManager = LinearLayoutManager(this);
        loadData();

    }
      fun loadData() {

         val BASE_URL : String = "https://jsonplaceholder.typicode.com/";

        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData();

        retrofitData.enqueue(object : Callback<List<PostItem>?> {
            override fun onResponse(
                    call: Call<List<PostItem>?>,
                    response: Response<List<PostItem>?>
            ) {
                if (response.isSuccessful) {
                    val dataItems = response.body();
                    if (dataItems != null) {
                        for (data in dataItems) {
                            postList.add(data);
                            Log.d(TAG, "onResponse:"+data.toString())
                        }
                    }
                    val adapter = PostAdapter(postList);
                    recyclerView.adapter = adapter;
                }
            }

            override fun onFailure(call: Call<List<PostItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}