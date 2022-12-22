package com.didi.universal.pay.sdk.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.commoninterfacelib.ServiceProviderManager;
import com.didi.commoninterfacelib.web.AbsPlatformWebPageProxy;
import com.didi.commoninterfacelib.web.IPlatformWebPageProxy;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.view.webview.PayFusionWebActivity;
import com.didi.payment.base.view.webview.WebModel;
import com.didi.payment.base.view.webview.fusion.model.FusionBridgeModule;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class WebProxyActivity extends PayFusionWebActivity implements IPlatformWebPageProxy {

    /* renamed from: a */
    private AbsPlatformWebPageProxy f45131a;

    public HashMap<String, IPlatformWebPageProxy.JsExeCallBack> getJsFunctions() {
        return new HashMap<>();
    }

    public void onCreate(Bundle bundle) {
        HashMap<String, IPlatformWebPageProxy.JsExeCallBack> jsFunctions;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m32412b();
        m32411a();
        onAttach(this);
        super.onCreate(bundle);
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null && (jsFunctions = absPlatformWebPageProxy.getJsFunctions()) != null) {
            for (String next : jsFunctions.keySet()) {
                IPlatformWebPageProxy.JsExeCallBack jsExeCallBack = jsFunctions.get(next);
                if (getFusionBridge() != null) {
                    getFusionBridge().addFunction(next, new ProxyFunction(next, jsExeCallBack));
                }
            }
        }
    }

    /* renamed from: a */
    private void m32411a() {
        if (this.f45131a != null) {
            WebModel webModel = new WebModel();
            try {
                webModel.url = getIntent().getStringExtra("url");
                webModel.title = getIntent().getStringExtra("title");
            } catch (Exception e) {
                e.printStackTrace();
            }
            getIntent().putExtra(PayBaseWebActivity.EXTRA_WEB_MODEL, webModel);
        }
    }

    /* renamed from: b */
    private void m32412b() {
        Iterator<AbsPlatformWebPageProxy> c;
        if (this.f45131a == null && (c = m32413c()) != null) {
            while (c.hasNext()) {
                AbsPlatformWebPageProxy next = c.next();
                String str = null;
                try {
                    str = getIntent().getStringExtra(AbsPlatformWebPageProxy.KEY_PROXYCLASS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TextUtils.equals(str, next.getClass().getName())) {
                    this.f45131a = next;
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private Iterator<AbsPlatformWebPageProxy> m32413c() {
        return ServiceProviderManager.getInstance().getComponentIterator(AbsPlatformWebPageProxy.class);
    }

    public void onAttach(Activity activity) {
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onAttach(activity);
        }
    }

    public void onStart() {
        super.onStart();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onStart();
        }
    }

    public void onReStart() {
        super.onRestart();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onReStart();
        }
    }

    public void onResume() {
        super.onResume();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onSaveInstanceState(bundle);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onActivityResult(i, i2, intent);
        }
    }

    public void onPause() {
        super.onPause();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onPause();
        }
    }

    public void onStop() {
        super.onStop();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onStop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onDestroy();
        }
    }

    public void onFinish() {
        super.finish();
        AbsPlatformWebPageProxy absPlatformWebPageProxy = this.f45131a;
        if (absPlatformWebPageProxy != null) {
            absPlatformWebPageProxy.onFinish();
        }
    }

    class ProxyFunction extends FusionBridgeModule.Function {
        private IPlatformWebPageProxy.JsExeCallBack jsExeCallBack;
        private String key;

        public ProxyFunction(String str, IPlatformWebPageProxy.JsExeCallBack jsExeCallBack2) {
            this.key = str;
            this.jsExeCallBack = jsExeCallBack2;
        }

        public JSONObject execute(JSONObject jSONObject) {
            IPlatformWebPageProxy.JsExeCallBack jsExeCallBack2 = this.jsExeCallBack;
            if (jsExeCallBack2 == null) {
                return null;
            }
            jsExeCallBack2.callback(this.key, jSONObject);
            return null;
        }
    }
}
