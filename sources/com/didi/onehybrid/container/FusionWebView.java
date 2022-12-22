package com.didi.onehybrid.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.Constants;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.devmode.DevHomeActivity;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.onehybrid.log.shake.ShakeUtils;
import com.didi.onehybrid.util.C10393Util;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class FusionWebView extends WebView implements HybridableContainer, ShakeUtils.OnShakeListener {

    /* renamed from: a */
    private static final String f29511a = "FusionWebView";

    /* renamed from: b */
    private HashMap<Class, Object> f29512b = new HashMap<>();

    /* renamed from: c */
    private WebViewJavascriptBridge f29513c;

    /* renamed from: d */
    private BusinessAgent f29514d;

    /* renamed from: e */
    private Activity f29515e;

    /* renamed from: f */
    private UpdateUIHandler f29516f;

    /* renamed from: g */
    private boolean f29517g = true;

    /* renamed from: h */
    private ProgressBar f29518h;

    /* renamed from: i */
    private boolean f29519i = false;

    /* renamed from: j */
    private boolean f29520j = false;

    /* renamed from: k */
    private ShakeUtils f29521k = null;

    /* renamed from: l */
    private FusionRuntimeInfo f29522l;

    public FusionWebView getWebView() {
        return this;
    }

    public FusionWebView(Context context) {
        super(context);
        m20787a(context);
    }

    public FusionWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20787a(context);
    }

    public FusionWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20787a(context);
    }

    /* renamed from: a */
    private void m20787a(Context context) {
        if (context instanceof Activity) {
            this.f29515e = (Activity) context;
            this.f29522l = new FusionRuntimeInfo();
            this.f29514d = FusionEngine.getBusinessAgent();
            WebSettings settings = getSettings();
            settings.setPluginState(WebSettings.PluginState.ON);
            boolean z = true;
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setLoadsImagesAutomatically(true);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(false);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setDomStorageEnabled(true);
            settings.setCacheMode(-1);
            settings.setJavaScriptCanOpenWindowsAutomatically(false);
            StringBuilder sb = new StringBuilder(settings.getUserAgentString());
            String businessUA = FusionEngine.getBusinessAgent().getBusinessUA();
            if (!TextUtils.isEmpty(businessUA)) {
                sb.append(" ");
                sb.append(businessUA);
            }
            sb.append(" ");
            sb.append(Constants.FUSION_UA);
            settings.setUserAgentString(sb.toString());
            if (Build.VERSION.SDK_INT < 18) {
                settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            }
            if (Build.VERSION.SDK_INT >= 19 && m20788b(context)) {
                setWebContentsDebuggingEnabled(true);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 17) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibilityTraversal");
                removeJavascriptInterface("accessibility");
            }
            setWebViewClient(new FusionWebViewClient(this));
            setWebChromeClient(new FusionWebChromeClient(this));
            if (Build.VERSION.SDK_INT >= 24) {
                FusionEngine.getBusinessAgent().refreshAppLocale(this.f29515e);
            }
            m20786a();
            IToggle toggle = Apollo.getToggle("webview_debug_monitor_enable");
            if (toggle == null || !toggle.allow()) {
                z = false;
            }
            this.f29520j = z;
            if (z) {
                this.f29522l.switchOn();
                return;
            }
            return;
        }
        throw new RuntimeException("FusionWebView only support Activity context");
    }

    /* renamed from: b */
    private boolean m20788b(Context context) {
        IToggle toggle = Apollo.getToggle("webview_contents_debugging_enabled");
        this.f29520j = toggle != null && toggle.allow();
        if (C10393Util.isApkDebug(context) || this.f29520j) {
            return true;
        }
        return false;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof FusionWebViewClient) {
            this.f29513c = ((FusionWebViewClient) webViewClient).getJavascriptBridge();
            super.setWebViewClient(webViewClient);
            return;
        }
        throw new RuntimeException("FusionWebView only support FusionWebViewClient or its subclass");
    }

    public void loadUrl(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("javascript:")) {
            super.loadUrl(str);
            return;
        }
        this.f29519i = this.f29514d.shouldIntercept(getContext(), str);
        String addCommonQuery = this.f29514d.addCommonQuery(str);
        Map<String, String> commonHeaders = this.f29514d.getCommonHeaders();
        if (commonHeaders == null || commonHeaders.isEmpty()) {
            super.loadUrl(addCommonQuery);
        } else {
            super.loadUrl(addCommonQuery, commonHeaders);
        }
        this.f29522l.recordReqUrl(addCommonQuery);
    }

    public void appendUserAgent(String str) {
        WebSettings settings = getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + "; " + str);
    }

    public Activity getActivity() {
        return this.f29515e;
    }

    public FusionRuntimeInfo getFusionRuntimeInfo() {
        return this.f29522l;
    }

    public boolean shouldInterceptRequest() {
        return this.f29519i;
    }

    public void setUpdateUIHandler(UpdateUIHandler updateUIHandler) {
        this.f29516f = updateUIHandler;
    }

    public void onStart() {
        if (this.f29520j) {
            if (this.f29521k == null) {
                ShakeUtils shakeUtils = new ShakeUtils(getContext());
                this.f29521k = shakeUtils;
                shakeUtils.setOnShakeListener(this);
            }
            this.f29521k.onStart();
        }
    }

    public void onStop() {
        ShakeUtils shakeUtils = this.f29521k;
        if (shakeUtils != null) {
            shakeUtils.onStop();
        }
    }

    public UpdateUIHandler getUpdateUIHandler() {
        if (this.f29516f == null) {
            Activity activity = this.f29515e;
            if (activity instanceof UpdateUIHandler) {
                this.f29516f = (UpdateUIHandler) activity;
            }
        }
        return this.f29516f;
    }

    public Object getExportModuleInstance(Class cls) {
        Object obj = this.f29512b.get(cls);
        if (obj == null) {
            try {
                obj = cls.getConstructor(new Class[]{HybridableContainer.class}).newInstance(new Object[]{this});
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            }
            if (obj != null) {
                this.f29512b.put(cls, obj);
            }
        }
        return obj;
    }

    /* renamed from: a */
    private void m20786a() {
        try {
            ProgressBar progressBar = new ProgressBar(getContext(), (AttributeSet) null, 16842872);
            this.f29518h = progressBar;
            progressBar.setLayoutParams(new ViewGroup.LayoutParams(-1, 6));
            Integer num = (Integer) FusionEngine.getAttr("progressbar_color");
            if (num == null) {
                num = -224941;
            }
            this.f29518h.setProgressDrawable(new ClipDrawable(new ColorDrawable(num.intValue()), 3, 1));
            this.f29518h.setVisibility(8);
            addView(this.f29518h);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNeedShowProgressBar(boolean z) {
        ProgressBar progressBar;
        this.f29517g = z;
        if (!z && (progressBar = this.f29518h) != null) {
            removeView(progressBar);
            this.f29518h = null;
        }
    }

    public void showLoadProgress(int i) {
        ProgressBar progressBar;
        if (this.f29517g && (progressBar = this.f29518h) != null) {
            if (progressBar.getVisibility() == 8) {
                this.f29518h.setVisibility(0);
            }
            this.f29518h.setProgress(i);
        }
    }

    public void hiddenLoadProgress() {
        ProgressBar progressBar = this.f29518h;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public WebViewJavascriptBridge getJavascriptBridge() {
        return this.f29513c;
    }

    public void onShake() {
        Intent intent = new Intent(getContext(), DevHomeActivity.class);
        intent.putExtra("fusionRuntimeInfo", this.f29522l);
        getContext().startActivity(intent);
    }

    public void onDestory() {
        this.f29512b.clear();
        this.f29519i = false;
        this.f29515e = null;
        destroy();
    }
}
