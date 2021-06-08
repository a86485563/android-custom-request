package com.example.httprequesttest.api

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.HttpHeaderParser
import java.nio.charset.Charset

class CustomRequest(url: String, private val headers: Map<String, String>?  , private val listener: Response.Listener<String>,errorListener: Response.ErrorListener) : Request<String>(Method.GET, url, errorListener) {

    override fun getHeaders(): Map<String, String> = headers ?: super.getHeaders()

    override fun parseNetworkResponse(response: NetworkResponse?): Response<String> {
        val json = String(
            response?.data ?: ByteArray(0),
            Charset.forName(HttpHeaderParser.parseCharset(response?.headers)))

        return Response.success(
            json,
            HttpHeaderParser.parseCacheHeaders(response));
    }

    override fun deliverResponse(response: String) = listener.onResponse(response)
}