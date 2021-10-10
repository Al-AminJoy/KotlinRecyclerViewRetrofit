package com.alamin.kotlin_recyclerview_retrofit.adapter


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.alamin.kotlin_recyclerview_retrofit.R


class MainActivity : AppCompatActivity() {
    @BindView(R.id.btnStart)
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        btn.setOnClickListener{
            val intent = Intent(this@MainActivity, PostActivity::class.java)
            startActivity(intent)
        }
    }


}