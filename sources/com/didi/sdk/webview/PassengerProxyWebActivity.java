package com.didi.sdk.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.didi.commoninterfacelib.ServiceProviderManager;
import com.didi.commoninterfacelib.web.AbsPlatformWebPageProxy;
import com.didi.commoninterfacelib.web.IPlatformWebPageProxy;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class PassengerProxyWebActivity extends AbsLoadingWebActivity implements IPlatformWebPageProxy {

    /* renamed from: a */
    private AbsPlatformWebPageProxy f38391a;

    /* access modifiers changed from: protected */
    public void onCreateAfter(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onCreateBefore(Bundle bundle) {
    }

    public HashMap<String, IPlatformWebPageProxy.JsExeCallBack> getJsFunctions() {
        return new HashMap<>();
    }

    public void onAttach(Activity activity) {
        m27161b();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onAttach(activity);
        }
    }

    /* renamed from: b */
    private void m27161b() {
        Iterator<AbsPlatformWebPageProxy> c;
        if (this.f38391a == null && (c = m27162c()) != null) {
            while (c.hasNext()) {
                AbsPlatformWebPageProxy next = c.next();
                if (TextUtils.equals(getIntent().getStringExtra(AbsPlatformWebPageProxy.KEY_PROXYCLASS), next.getClass().getName())) {
                    this.f38391a = next;
                    return;
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        onCreateBefore(bundle);
        try {
            super.onCreate(bundle);
            onAttach(this);
            m27161b();
            AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
            if (absPlatformWebPageProxy != null) {
                HashMap<String, IPlatformWebPageProxy.JsExeCallBack> jsFunctions = absPlatformWebPageProxy.getJsFunctions();
                if (jsFunctions != null) {
                    for (String next : jsFunctions.keySet()) {
                        getFusionBridge().addFunction(next, new MyFunction(next, jsFunctions.get(next)));
                    }
                }
                addOverrideUrlLoader(new BankOverrideUrlLoader());
            }
            onCreateAfter(bundle);
        } catch (Exception e) {
            if (workaroundException(e)) {
                finish();
                return;
            }
            throw e;
        }
    }

    /* renamed from: c */
    private Iterator<AbsPlatformWebPageProxy> m27162c() {
        return ServiceProviderManager.getInstance().getComponentIterator(AbsPlatformWebPageProxy.class);
    }

    public void onStart() {
        super.onStart();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onStart();
        }
    }

    public void onReStart() {
        super.onRestart();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onReStart();
        }
    }

    public void onResume() {
        super.onResume();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onSaveInstanceState(bundle);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onActivityResult(i, i2, intent);
        }
    }

    public void onPause() {
        super.onPause();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onPause();
        }
    }

    public void onStop() {
        super.onStop();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onStop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onDestroy();
        }
    }

    class BankOverrideUrlLoader implements OverrideUrlLoader {
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }

        BankOverrideUrlLoader() {
        }
    }

    private class MyFunction extends FusionBridgeModule.Function {
        IPlatformWebPageProxy.JsExeCallBack callback;
        String key;

        public MyFunction(String str, IPlatformWebPageProxy.JsExeCallBack jsExeCallBack) {
            this.key = str;
            this.callback = jsExeCallBack;
        }

        public JSONObject execute(JSONObject jSONObject) {
            IPlatformWebPageProxy.JsExeCallBack jsExeCallBack = this.callback;
            if (jsExeCallBack == null) {
                return null;
            }
            jsExeCallBack.callback(this.key, jSONObject);
            return null;
        }
    }

    public void onFinish() {
        super.finish();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f38391a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onFinish();
        }
    }

    /* access modifiers changed from: protected */
    public FusionBridgeModule getFusionBridge() {
        if (this.mWebView == null) {
            return null;
        }
        return (ExtendFusionBridgeModule) this.mWebView.getExportModuleInstance(ExtendFusionBridgeModule.class);
    }
}
