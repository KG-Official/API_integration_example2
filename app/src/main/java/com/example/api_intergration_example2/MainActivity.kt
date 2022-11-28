package com.example.api_intergration_example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_intergration_example2.databinding.ActivityMainBinding
import com.example.api_intergration_example2.models.Adapter
import com.example.api_intergration_example2.models.ApiData
import com.example.api_intergration_example2.models.Post1
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await

class MainActivity : AppCompatActivity() {

    lateinit var adapter: Adapter
    lateinit var binding: ActivityMainBinding
    private var data = MutableLiveData<List<Post1>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()


        data.observe(this, Observer {
            adapter = Adapter(this@MainActivity, it)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        })


    }

    fun getData() {

        CoroutineScope(IO).launch {
            var responce = DataService.Instance.getData()
            var body = responce.body()

            if (body != null) {
                data.postValue(body.data.post1s)
            }

//             var data = DataService.Instance.getData()
//             data.enqueue(object : Callback<ApiData> {
//                 override fun onResponse(call: Call<ApiData>, response: Response<ApiData>) {
//                     var body = response.body()
//
//                     if (body != null) {
//
//                         adapter = Adapter(this@MainActivity, body.data.post1s)
//                         binding.recyclerView.adapter = adapter
//                         binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//                     } else {
//                         Toast.makeText(
//                             this@MainActivity,
//                             "Error in Fetching News $body",
//                             Toast.LENGTH_SHORT
//                         ).show()
//                     }
//
//                 }
//
//                 override fun onFailure(call: Call<ApiData>, t: Throwable) {
//                     Log.d("error", "total data " + t)
//                 }
//
//             })

        }


    }
}