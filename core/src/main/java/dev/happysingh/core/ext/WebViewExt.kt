package dev.happysingh.core.ext

import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * returns lambda if [WebView] is successfully loaded.
 */
private const val MAX_PROGRESS = 100
fun WebView.doOnPageLoad(onWebPageLoad: () -> Unit) {
    webChromeClient = object : WebChromeClient() {

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            if (progress == MAX_PROGRESS) {
                onWebPageLoad.invoke()
            }
        }
    }
}

/**
 * returns lambda if [WebView] is gets an error while loading loaded.
 */
fun WebView.doOnPageLoadError(onError: () -> Unit) {
    webViewClient = object : WebViewClient() {

        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)
            onError.invoke()
        }
    }
}
