package com.sardorbek.roomwithrv.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sardorbek.roomwithrv.R
import com.sardorbek.roomwithrv.adapter.SportAdapter
import com.sardorbek.roomwithrv.database.SportDataBase
import com.sardorbek.roomwithrv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var sportDataBase: SportDataBase
    private lateinit var sportAdapter: SportAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        sportDataBase = SportDataBase.invoke(this,)
        sportAdapter= SportAdapter()
        binding.add.setOnClickListener {
            val intent = Intent(this,DialogAddActivity::class.java)
            startActivity(intent)
        }
        setAppRv()
    }
    private fun setAppRv()= binding.rvActivity.apply {
        adapter  =  sportAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
        val list = sportDataBase.sportDao().getAllSports()
        sportAdapter.submitList(list)
    }

    override fun onResume() {
        super.onResume()
        setAppRv()
    }
}