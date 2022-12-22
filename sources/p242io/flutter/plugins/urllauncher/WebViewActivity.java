package p242io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.flutter.plugins.urllauncher.WebViewActivity */
public class WebViewActivity extends Activity {
    public static String ACTION_CLOSE = "close action";

    /* renamed from: e */
    private static String f57915e = "url";

    /* renamed from: f */
    private static String f57916f = "enableJavaScript";

    /* renamed from: g */
    private static String f57917g = "enableDomStorage";

    /* renamed from: a */
    private final BroadcastReceiver f57918a = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (WebViewActivity.ACTION_CLOSE.equals(intent.getAction())) {
                WebViewActivity.this.finish();
            }
        }
    };

    /* renamed from: b */
    private final WebViewClient f57919b = new WebViewClient() {
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (Build.VERSION.SDK_INT >= 21) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            webView.loadUrl(str);
            return false;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT < 21) {
                return false;
            }
            webView.loadUrl(webResourceRequest.getUrl().toString());
            return false;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WebView f57920c;

    /* renamed from: d */
    private IntentFilter f57921d = new IntentFilter(ACTION_CLOSE);

    /* renamed from: io.flutter.plugins.urllauncher.WebViewActivity$FlutterWebChromeClient */
    private class FlutterWebChromeClient extends WebChromeClient {
        private FlutterWebChromeClient() {
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            C211711 r1 = new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                    WebViewActivity.this.f57920c.loadUrl(webResourceRequest.getUrl().toString());
                    return true;
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    WebViewActivity.this.f57920c.loadUrl(str);
                    return true;
                }
            };
            WebView webView2 = new WebView(WebViewActivity.this.f57920c.getContext());
            webView2.setWebViewClient(r1);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.f57920c = webView;
        setContentView(webView);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(f57915e);
        boolean booleanExtra = intent.getBooleanExtra(f57916f, false);
        boolean booleanExtra2 = intent.getBooleanExtra(f57917g, false);
        this.f57920c.loadUrl(stringExtra, m41697a(intent.getBundleExtra("com.android.browser.headers")));
        this.f57920c.getSettings().setJavaScriptEnabled(booleanExtra);
        this.f57920c.getSettings().setDomStorageEnabled(booleanExtra2);
        this.f57920c.setWebViewClient(this.f57919b);
        this.f57920c.getSettings().setSupportMultipleWindows(true);
        this.f57920c.setWebChromeClient(new FlutterWebChromeClient());
        try {
            registerReceiver(this.f57918a, this.f57921d);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: a */
    private Map<String, String> m41697a(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.f57918a);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f57920c.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.f57920c.goBack();
        return true;
    }

    public static Intent createIntent(Context context, String str, boolean z, boolean z2, Bundle bundle) {
        return new Intent(context, WebViewActivity.class).putExtra(f57915e, str).putExtra(f57916f, z).putExtra(f57917g, z2).putExtra("com.android.browser.headers", bundle);
    }
}
