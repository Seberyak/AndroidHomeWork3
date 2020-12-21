package com.cst.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private val url = "https://my-json-server.typicode.com/nikoloz14/movies-db/db";
//    private val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerViewMain: RecyclerView = findViewById(R.id.recyclerViewMain)
        recyclerViewMain.layoutManager = LinearLayoutManager(this)
//        val recyclerViewMain: RecyclerView = findViewById(R.id.recyclerViewMain)
//        recyclerViewMain.layoutManager = LinearLayoutManager(this)
//        recyclerViewMain.adapter = adapter

        this.fetchJson(this)
    }


    private fun fetchJson(mainActivity: MainActivity) {
        val client: OkHttpClient = OkHttpClient()
        val request = Request.Builder().url(this.url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute!")
            }

            override fun onResponse(call: Call, response: Response) {
                val bodyAsString = response.body?.string() ?: return
                val responseObject: HelperSchemas.IRGETMovies =
                    Gson().fromJson(bodyAsString, HelperSchemas.IRGETMovies::class.java);
                runOnUiThread {
                    val recyclerViewMain: RecyclerView = findViewById(R.id.recyclerViewMain)
                    recyclerViewMain.adapter = MainAdapter(responseObject)
                }


            }
        })
    }

}