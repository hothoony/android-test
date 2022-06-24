package com.example.android_webview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "## onCreate");

        webView = findViewById(R.id.webView);
        setWebViewSettings(webView);
        setWebViewClient(webView);
        setWebChromeClient(webView);
        setWebViewListeners(webView);
        webView.loadUrl("http://192.168.1.218:5500");
    }

    private void setWebViewSettings(WebView webView) {
        Log.i(TAG, "## setWebViewSettings");

        WebSettings webSettings = webView.getSettings();

//        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setUseWideViewPort(true);

//        webSettings.setSupportZoom(false);
//        webSettings.setBuiltInZoomControls(false);

        webSettings.setJavaScriptEnabled(true); // true 로 해줘야 javascript 이 동작함
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // true 로 설정시
        // WebChromeClient.onCreateWindow 가 호출된다
        // 앱이 아닌 브라우저로 팝업창이 열린다
//        webSettings.setSupportMultipleWindows(true);

        // false 로 설정시
        // WebChromeClient.onCreateWindow 가 호출되지 않는다
        // 앱 내에서 팝업창이 열린다
        webSettings.setSupportMultipleWindows(false);
    }

    private void setWebViewClient(WebView webView) {
        Log.i(TAG, "## setWebViewClient");

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i(TAG, "## WebViewClient.onPageStarted");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i(TAG, "## WebViewClient.onPageFinished");
            }

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                Log.i(TAG, "## WebViewClient.shouldInterceptRequest, " + request.getUrl());
                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.i(TAG, "## WebViewClient.shouldOverrideUrlLoading, " + request.getUrl());
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

    }

    private void setWebChromeClient(WebView webView) {
        // WebChromeClient 를 추가해줘야 아래 기능이 동작함
        // - javascript confirm()
        // - window.open()
        // - window.close() 는 아직 안됨
        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                Log.i(TAG, "## WebChromeClient.onCreateWindow");
                Log.i(TAG, "- view=" + view);
                Log.i(TAG, "- isDialog=" + isDialog);
                Log.i(TAG, "- isUserGesture=" + isUserGesture);
                Log.i(TAG, "- resultMsg=" + resultMsg);

                WebView newWebView = new WebView(MainActivity.this);
                newWebView.getSettings().setJavaScriptEnabled(true);

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(newWebView);
                dialog.show();

                newWebView.setWebChromeClient(new WebChromeClient() {
                    @Override
                    public void onCloseWindow(WebView window) {
                        Log.i(TAG, "## newWebView.onCloseWindow");
                        dialog.dismiss();
                    }
                });

                ((WebView.WebViewTransport)resultMsg.obj).setWebView(newWebView);
                resultMsg.sendToTarget();
                return true;
            }

            @Override
            public void onCloseWindow(WebView window) {
                Log.i(TAG, "## WebChromeClient.onCloseWindow");
                super.onCloseWindow(window);
                webView.removeView(window);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                Log.i(TAG, "## WebChromeClient.onJsAlert");
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                Log.i(TAG, "## WebChromeClient.onJsConfirm");
                return super.onJsConfirm(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                Log.i(TAG, "## WebChromeClient.onJsPrompt");
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override
            public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
                Log.i(TAG, "## WebChromeClient.onJsBeforeUnload");
                return super.onJsBeforeUnload(view, url, message, result);
            }
        });
    }

    private void setWebViewListeners(WebView webView) {
        Log.i(TAG, "## setWebViewListeners");

        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i(TAG, "setOnKeyListener.onKey, " + keyCode);
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    Log.i(TAG, "onKey: 백 버튼 클릭");
//                    webView.loadUrl("javascript:self.close();"); // Scripts may close only the windows that were opened by them.
//                    webView.loadUrl("javascript:window.close();"); // Scripts may close only the windows that were opened by them.
//                    webView.loadUrl("javascript:this.close();");
                    webView.loadUrl("javascript:top.close();");
//                    webView.loadUrl("javascript:alert('alert');");
//                    webView.loadUrl("javascript:confirm('confirm');");
//                    webView.loadUrl("javascript:prompt('prompt');");
                    return true;
                }
                return false;
            }
        });

//        webView.setDownloadListener(new DownloadListener() {
//            @Override
//            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
//
//            }
//        });
    }

}
