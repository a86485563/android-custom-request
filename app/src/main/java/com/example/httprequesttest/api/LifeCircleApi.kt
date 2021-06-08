package com.example.httprequesttest.api

import android.content.Context
import android.util.Base64
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class LifeCircleApi(val context: Context) {
    private val queue = Volley.newRequestQueue(context)
    private val url =
        "http://10.0.2.2:4502/bin/cbu/lifecirclequerypage?0&6&cbu%3Alifecircle%2Fsmart-technology"

    fun sendRequest() {
        // Request a string response from the provided URL.
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            { response ->
//                // Display the first 500 characters of the response string.
//                Toast.makeText(context, "request success", Toast.LENGTH_SHORT).show();
//            },
//            { Toast.makeText(context, "request failed", Toast.LENGTH_SHORT).show(); }
//        )

        val customRequest = CustomRequest(url,getHeaders(), { response ->
            // Display the first 500 characters of the response string.
            Toast.makeText(context, "request success", Toast.LENGTH_SHORT).show();
        }, { Toast.makeText(context, "request failed", Toast.LENGTH_SHORT).show(); });



        // Add the request to the RequestQueue.
        queue.add(customRequest)

    }
    fun getHeaders(): Map<String, String> {
        val headers = HashMap<String, String>()
        val creds = String.format("%s:%s", "admin", "admin")
        val auth = "Basic " + Base64.encodeToString(creds.toByteArray(), Base64.DEFAULT)
        headers.put("Authorization", auth)

        return headers
    }
}