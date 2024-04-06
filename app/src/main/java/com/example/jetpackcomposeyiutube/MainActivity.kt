package com.example.jetpackcomposeyiutube

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jetpackcomposeyiutube.screens.ListItem
import com.example.jetpackcomposeyiutube.screens.MainCard
import com.example.jetpackcomposeyiutube.screens.TabLayout
import com.example.jetpackcomposeyiutube.ui.theme.JetpackComposeYiuTubeTheme
import org.json.JSONObject

const val API_KEY = "e5b8b9621b064a22833112600240304"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeYiuTubeTheme {
                getData("Tashkent", this)
                Image(
                    painter = painterResource(
                        id = R.drawable.asosi
                    ),
                    contentDescription = "im1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.5f),
                    contentScale = ContentScale.FillBounds,
                )
                Column {
                    MainCard()
                    TabLayout()
                }
            }
        }
    }
}

private fun getData(city: String, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY" +
            "&q=$city" +
            "&days=" +
            "1" +
            "&aqi=no&alerts=no"

    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        {
          response ->
            Log.d("MyLog", "Response: $response")

        },
        {
            Log.d("MyLog", "VolleyError: $it")
        }
    )
    queue.add(sRequest)
//    val queue = Volley.newRequestQueue(context)
//    val stringRequest = StringRequest(
//        Request.Method.GET,
//        url,
//        {
//                response->
//            val obj = JSONObject(response)
//            state.value = obj.getJSONObject("current").getString("temp_c")
//        },
//        {
//                error->
//            Log.d("Mylog", "Error $error")
//        }
//    )
//    queue.add(stringRequest)
}

