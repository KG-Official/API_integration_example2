package com.example.api_intergration_example2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_intergration_example2.databinding.ActivityMainBinding
import com.example.api_intergration_example2.models.Adapter
import com.example.api_intergration_example2.models.ApiData
import com.example.api_intergration_example2.models.Post1
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var adapter: Adapter
    lateinit var binding: ActivityMainBinding
    private var data = mutableListOf <Post1>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        binding.btnChangeActivity.setOnClickListener{
            intent = Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
            finish()
        }


    }


    fun getData() {

     CoroutineScope(IO).launch {
            delay(3000)

            Log.d("MainActivity","Coroutine is running")
            var responce = DataService.Instance.getData()
            var body = responce.body()

            if (body != null) {
                data.addAll(body.data.post1s)

                withContext(Main) {
                    Log.d("MainActivity","Coroutine is still running")
                    adapter = Adapter(this@MainActivity, data)
                    binding.recyclerView.adapter = adapter
                    binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }

  }




}