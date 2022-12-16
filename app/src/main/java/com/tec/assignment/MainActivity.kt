package com.tec.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service=service.create()
         val button=findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val text=findViewById<EditText>(R.id.editTextTextPersonName)
            val name=text.text.toString()
            if(name.isEmpty())
                Toast.makeText(this,"Enter name ",Toast.LENGTH_SHORT).show()
            else
            {
                val search=service.getdetails(name)
                search.enqueue(object:Callback<List<country>>{
                    override fun onResponse(
                        call: Call<List<country>>,
                        response: Response<List<country>>
                    ) {
                       val list=response.body()
                        Toast.makeText(this@MainActivity,"hi",Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<List<country>>, t: Throwable) {

                    }

                })
            }
        }
    }
}