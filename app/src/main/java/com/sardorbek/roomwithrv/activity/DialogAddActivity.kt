package com.sardorbek.roomwithrv.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sardorbek.roomwithrv.database.SportDataBase
import com.sardorbek.roomwithrv.databinding.ActivityMainBinding
import com.sardorbek.roomwithrv.databinding.DialogAddActivityBinding
import com.sardorbek.roomwithrv.model.Sport

class DialogAddActivity : AppCompatActivity() {
    private lateinit var dataBase: SportDataBase
    private lateinit var binding: DialogAddActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        dataBase = SportDataBase.invoke(this)
        binding.btnSave.setOnClickListener {
            saveToDataBase()
        }
    }

    private fun saveToDataBase() {
        val distance = binding.distance.text.toString().trim()
        val duration = binding.duration.text.toString().trim()


        if (distance.isNotEmpty() && duration.isNotEmpty()) {
            val sport = Sport(0, "name", distance, duration)
            dataBase.sportDao().addSport(sport)
            finish()
        } else {
            Toast.makeText(this, "please entre data", Toast.LENGTH_SHORT).show()
        }
    }

}