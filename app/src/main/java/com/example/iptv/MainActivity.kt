package com.example.iptv

import android.app.Activity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val webView = WebView(this)
        
        webView.settings.javaScriptEnabled = true
        webView.settings.mediaPlaybackRequiresUserGesture = false 
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient() 
        
        val videoUrl = "https://m3uextractor.indexiptv212.workers.dev/download/0241cbac-61a4-4b8e-9973-1c289d2232fc/Live_AR%20_%20ALWAN%20VIP.m3u8"
        
        val htmlData = """
            <html>
            <body style="margin:0;padding:0;background-color:black;display:flex;justify-content:center;align-items:center;">
                <video width="100%" height="100%" controls autoplay>
                    <source src="$videoUrl" type="application/x-mpegURL">
                    عذراً، جهازك لا يدعم تشغيل هذا الفيديو.
                </video>
            </body>
            </html>
        """.trimIndent()
        
        webView.loadData(htmlData, "text/html", "UTF-8")
        
        setContentView(webView)
    }
}
