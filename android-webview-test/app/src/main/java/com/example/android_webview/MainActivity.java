package com.example.android_webview;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "## onCreate");

        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                Log.i(TAG, "## onCreateWindow: 팝업창 열림");

                WebView webViewChild = new WebView(view.getContext());
                webViewChild.getSettings().setJavaScriptEnabled(true);

                Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(webViewChild);

                WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
                params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                params.height = ViewGroup.LayoutParams.MATCH_PARENT;

                dialog.getWindow().setAttributes(params);
                dialog.show();

                webViewChild.setWebViewClient(new WebViewClient());
                webViewChild.setWebChromeClient(new WebChromeClient() {
                    @Override
                    public void onCloseWindow(WebView window) {
                        Log.i(TAG, "## onCloseWindow: 팝업창 닫힘");
                        dialog.dismiss();
                    }
                });

                WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) resultMsg.obj;
                Log.i(TAG, "## webViewTransport: " + webViewTransport);
                webViewTransport.setWebView(webViewChild);
                resultMsg.sendToTarget();

                return true;
            }
        });

        webView.loadUrl("http://192.168.1.218:5500");
    }

}
