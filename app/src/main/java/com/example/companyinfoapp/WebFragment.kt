package com.example.companyinfoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment

class WebFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_web, container, false)
        val myWebView = v.findViewById(R.id.home_page) as WebView
        myWebView.loadUrl("https://www.ericsson.com")

        myWebView.settings.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()

        return v

    }
}