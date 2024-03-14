package com.example.jetpack

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack.models.Items
import com.example.jetpack.ui.theme.JetpackTheme

import com.example.jetpack.network.Retrofitclient
import com.example.jetpack.protocols.retrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("welcome to my retrofit service")
                    getInfo()
                }
            }
        }
    }


    fun getInfo() {

        val retro = Retrofitclient.api.getInfo()

        retro.enqueue(object : Callback<List<Items>>{
            override fun onResponse(call: Call<List<Items>>, response: Response<List<Items>>) {
                Toast.makeText(this@MainActivity,"OK", Toast.LENGTH_LONG).show()

                Log.d("Json_response",response.body().toString())
            }

            override fun onFailure(call: Call<List<Items>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_LONG).show()
            }

        })
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackTheme {
        Greeting("Android")
    }
}