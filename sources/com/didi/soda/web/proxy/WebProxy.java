package com.didi.soda.web.proxy;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.title.IconAttr;
import com.didi.app.nova.skeleton.title.TitleAttr;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.util.C10393Util;
import com.didi.soda.web.BizAgent;
import com.didi.soda.web.GlobalJsBridge;
import com.didi.soda.web.SodaFusionEngine;
import com.didi.soda.web.UpdateUIHandlerImp;
import com.didi.soda.web.WebInitializer;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.soda.web.overriders.IUrlOverriders;
import com.didi.soda.web.p168ui.IErrorLayout;
import com.didi.soda.web.tools.UrlWriter;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didi.soda.web.widgets.SodaWebView;
import com.didi.soda.web.widgets.WebPageTitleBar;
import com.didi.sofa.utils.SystemUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class WebProxy {

    /* renamed from: a */
    FrameLayout f43910a;

    /* renamed from: b */
    SodaWebView f43911b;

    /* renamed from: c */
    LinearLayout f43912c;

    /* renamed from: d */
    FrameLayout f43913d;

    /* renamed from: e */
    TextView f43914e;

    /* renamed from: f */
    ImageView f43915f;

    /* renamed from: g */
    TextView f43916g;

    /* renamed from: h */
    WebPageTitleBar f43917h;

    /* renamed from: i */
    View f43918i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WebConfig f43919j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Context f43920k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<ShareToolModel> f43921l;

    /* renamed from: m */
    private FrameLayout f43922m;

    /* renamed from: n */
    private IErrorLayout f43923n;

    /* renamed from: o */
    private View.OnClickListener f43924o = new View.OnClickListener() {
        public void onClick(View view) {
            if (!WebProxy.this.m31255b()) {
                boolean unused = WebProxy.this.m31257c();
            }
        }
    };

    /* renamed from: p */
    private View.OnClickListener f43925p = new View.OnClickListener() {
        public void onClick(View view) {
            if (WebProxy.this.f43920k != null) {
                ((UpdateUIHandlerImp) WebProxy.this.f43920k).finishPage();
            }
        }
    };

    /* renamed from: q */
    private View.OnClickListener f43926q = new View.OnClickListener() {
        public void onClick(View view) {
            WebProxy webProxy = WebProxy.this;
            webProxy.reLoadUrl(webProxy.f43919j.url);
        }
    };

    public WebProxy(Context context, SodaWebView sodaWebView, View view, View view2, IErrorLayout iErrorLayout, WebConfig webConfig) {
        this.f43920k = context;
        this.f43923n = iErrorLayout;
        m31251a(sodaWebView, view, view2);
        m31249a(webConfig);
    }

    /* renamed from: a */
    private void m31251a(SodaWebView sodaWebView, View view, View view2) {
        this.f43911b = sodaWebView;
        if (sodaWebView == null) {
            this.f43911b = new SodaWebView(view2.getContext());
        }
        this.f43911b.setBackgroundColor(0);
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.web_page_fl_container);
        this.f43910a = frameLayout;
        frameLayout.addView(this.f43911b);
        if (view != null) {
            FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.web_page_title_container);
            this.f43922m = frameLayout2;
            frameLayout2.addView(view);
            this.f43922m.setVisibility(0);
        }
        this.f43912c = (LinearLayout) view2.findViewById(R.id.web_page_ll_error);
        this.f43914e = (TextView) view2.findViewById(R.id.web_page_tv_error);
        this.f43915f = (ImageView) view2.findViewById(R.id.soda_web_page_error);
        this.f43916g = (TextView) view2.findViewById(R.id.web_page_tv_error_msg);
        this.f43917h = (WebPageTitleBar) view2.findViewById(R.id.web_title_bar);
        this.f43918i = view2.findViewById(R.id.common_title_bar_line);
        this.f43913d = (FrameLayout) view2.findViewById(R.id.soda_web_customer_error_layout);
        m31247a();
    }

    /* renamed from: a */
    private void m31247a() {
        if (this.f43923n != null) {
            this.f43913d.setVisibility(0);
            this.f43923n.inflateErrorLayout(this.f43920k, this.f43913d);
            return;
        }
        this.f43913d.setVisibility(8);
    }

    public void reloadSelf() {
        reLoadUrl(this.f43919j.url);
    }

    /* renamed from: a */
    private void m31249a(WebConfig webConfig) {
        if (webConfig != null) {
            this.f43919j = webConfig;
            if (!webConfig.needPreload) {
                m31252a(this.f43919j.url);
            }
            if (this.f43919j.isUseNativeTitltBar) {
                this.f43917h.setVisibility(0);
                if (!TextUtils.isEmpty(this.f43919j.title) && this.f43919j.isUseNativeTitltBar) {
                    this.f43917h.setTitleName(this.f43919j.title);
                }
            }
            this.f43912c.setOnClickListener(this.f43926q);
            if (this.f43919j.isUseNativeTitltBar) {
                this.f43917h.setOnBackClickListener(this.f43924o);
            }
            this.f43911b.setWebViewSetting(this.f43919j);
            this.f43911b.setUpdateUIHandler((UpdateUIHandler) this.f43920k);
            Iterator<S> it = ServiceLoader.load(IUrlOverriders.class).iterator();
            while (it.hasNext()) {
                this.f43911b.addUrlOverriders((IUrlOverriders) it.next());
            }
            this.f43911b.setWebPageStateListener((SodaWebView.WebPageStateListener) this.f43920k);
        }
    }

    public void updateUI(final String str, final Object... objArr) {
        SodaWebView sodaWebView;
        if (!TextUtils.isEmpty(str) && (sodaWebView = this.f43911b) != null) {
            sodaWebView.post(new Runnable() {
                public void run() {
                    Object[] objArr;
                    Object[] objArr2;
                    if (!WebConstant.UI_TARGET_WEB_TITLE.equals(str) || (objArr2 = objArr) == null || !(objArr2[0] instanceof String)) {
                        if (WebConstant.UI_TARGET_INIT_ENTRANCE.equals(str) && (objArr = objArr) != null && (objArr[0] instanceof List)) {
                            List unused = WebProxy.this.f43921l = (List) objArr[0];
                        } else if (WebConstant.UI_TARGET_SHOW_ENTRANCE.equals(str)) {
                            Object[] objArr3 = objArr;
                            WebProxy.this.m31248a((CallbackFunction) objArr3[0], (String) objArr3[1]);
                        } else if (WebConstant.UI_TARGET_INVOKE_ENTRANCE.equals(str)) {
                            CallbackFunction callbackFunction = (CallbackFunction) objArr[0];
                            if (WebProxy.this.f43920k instanceof UpdateUIHandlerImp) {
                                ((UpdateUIHandlerImp) WebProxy.this.f43920k).invokeEntrance(WebProxy.this.f43921l, callbackFunction);
                            }
                        } else if (WebConstant.UI_TARGET_HIDE_ENTRANCE.equals(str)) {
                            WebProxy.this.m31258d();
                        } else if (WebConstant.UI_TARGET_SHOW_SYSTEM_ENTRANCE.equals(str)) {
                            if (WebProxy.this.f43920k instanceof UpdateUIHandlerImp) {
                                Object[] objArr4 = objArr;
                                ((UpdateUIHandlerImp) WebProxy.this.f43920k).showSystemEntrance((ShareToolModel) objArr4[0], (CallbackFunction) objArr4[1]);
                            }
                        } else if (WebConstant.UI_TARGET_UPDATA_NAV.equals(str) && (WebProxy.this.f43920k instanceof UpdateUIHandlerImp)) {
                            Object[] objArr5 = objArr;
                            ((UpdateUIHandlerImp) WebProxy.this.f43920k).updateNav((JSONObject) objArr5[0], (CallbackFunction) objArr5[1]);
                        }
                    } else if (!WebProxy.this.f43919j.canChangeTitle && !TextUtils.isEmpty(WebProxy.this.f43919j.title)) {
                    } else {
                        if (WebProxy.this.f43919j.isUseNativeTitltBar) {
                            if (WebProxy.this.f43917h != null) {
                                WebProxy.this.f43917h.setTitleName((String) objArr[0]);
                            }
                        } else if (WebProxy.this.f43920k != null && (WebProxy.this.f43920k instanceof Page)) {
                            ((Page) WebProxy.this.f43920k).getTitleBar().setTitle(new TitleAttr.Builder((String) objArr[0]).build());
                        }
                    }
                }
            });
        }
    }

    public WebPageTitleBar getWebTitleBar() {
        return this.f43917h;
    }

    public SodaWebView getWebView() {
        return this.f43911b;
    }

    public void reLoadUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f43919j.url = str;
            m31252a(this.f43919j.url);
        }
    }

    /* renamed from: a */
    private void m31252a(String str) {
        BusinessAgent businessAgent = SodaFusionEngine.getBusinessAgent();
        if ((businessAgent instanceof BizAgent) && !C10393Util.isApkDebug(WebInitializer.getInitializer().mApplication) && UrlWriter.isInHostList(str, ((BizAgent) businessAgent).getBlackList())) {
            m31253a(true, -12);
        } else if (SystemUtils.isNetWorkAvailable(this.f43920k)) {
            try {
                m31253a(false, 0);
                String builder = UrlWriter.executeAppend(Uri.parse(str), this.f43919j.mCustomerParameters).toString();
                if (this.f43911b != null) {
                    this.f43911b.loadUrl(builder);
                }
            } catch (Exception unused) {
                m31253a(true, -12);
            }
        } else {
            m31253a(true, -6);
        }
    }

    public void cancelProgressDialog() {
        SodaWebView sodaWebView = this.f43911b;
        if (sodaWebView != null) {
            sodaWebView.hiddenLoadProgress();
        }
    }

    /* renamed from: a */
    private void m31253a(boolean z, int i) {
        LinearLayout linearLayout = this.f43912c;
        if (linearLayout != null && this.f43911b != null && this.f43914e != null) {
            if (z) {
                linearLayout.setVisibility(0);
                this.f43911b.setVisibility(8);
                if (this.f43923n != null) {
                    this.f43915f.setVisibility(8);
                    this.f43914e.setVisibility(8);
                    this.f43916g.setVisibility(8);
                    this.f43912c.setOnClickListener((View.OnClickListener) null);
                    this.f43923n.showCustomerErrorView(i, this.f43919j.isUseNativeTitltBar, this.f43917h, this.f43918i);
                    return;
                }
                if (this.f43919j.isUseNativeTitltBar) {
                    this.f43917h.setTitleName(this.f43920k.getResources().getString(R.string.soda_web_page_load_fail));
                }
                this.f43915f.setVisibility(0);
                this.f43914e.setVisibility(0);
                this.f43916g.setVisibility(0);
                if (i == -12) {
                    this.f43915f.setImageResource(R.drawable.soda_web_page_load_fail);
                    this.f43914e.setText(R.string.nova_web_error_badurl);
                } else if (i == -8) {
                    this.f43915f.setImageResource(R.drawable.soda_web_page_load_fail);
                    this.f43914e.setText(R.string.nova_web_error_timeout);
                } else if (i == -2 || i == -6 || i == -5) {
                    this.f43915f.setImageResource(R.drawable.soda_web_page_net_error);
                    this.f43914e.setText(R.string.nova_web_error_connectfail);
                }
            } else {
                IErrorLayout iErrorLayout = this.f43923n;
                if (iErrorLayout != null) {
                    iErrorLayout.onHideEvent(this.f43919j.isUseNativeTitltBar, this.f43917h, this.f43918i);
                }
                this.f43912c.setVisibility(8);
                this.f43911b.setVisibility(0);
            }
        }
    }

    public void onWebPageStarted() {
        if (TextUtils.isEmpty(this.f43919j.title)) {
            return;
        }
        if (this.f43919j.isUseNativeTitltBar) {
            this.f43917h.setTitleName(this.f43919j.title);
            return;
        }
        Context context = this.f43920k;
        if (context != null && (context instanceof Page)) {
            ((Page) context).getTitleBar().setTitle(new TitleAttr.Builder(this.f43919j.title).build());
        }
    }

    public void onWebPageFinished(WebView webView, String str) {
        SodaWebView sodaWebView = this.f43911b;
        if (sodaWebView == null || !sodaWebView.canGoBack()) {
            this.f43917h.setCloseBtnVisibility(8);
            this.f43917h.setCloseBtnListener((View.OnClickListener) null);
        } else {
            IconAttr build = new IconAttr.Builder((int) R.drawable.nova_assembly_web_close).click(this.f43925p).build();
            if (this.f43919j.isUseNativeTitltBar) {
                this.f43917h.setCloseBtnVisibility(0);
                this.f43917h.setCloseBtnListener(this.f43925p);
            } else {
                Context context = this.f43920k;
                if (context != null && (context instanceof Page)) {
                    ((Page) context).getTitleBar().setLeft(build);
                }
            }
        }
        if (this.f43919j.canChangeTitle) {
            String title = webView.getTitle();
            if (TextUtils.isEmpty(title) || title.contains("http") || title.contains("https") || title.contains(".com") || title.contains("/") || !str.contains("http")) {
                if (this.f43919j.isUseNativeTitltBar) {
                    this.f43917h.setTitleName("");
                    return;
                }
                Context context2 = this.f43920k;
                if (context2 != null && (context2 instanceof Page)) {
                    ((Page) context2).getTitleBar().setTitle(new TitleAttr.Builder("").build());
                }
            } else if (this.f43919j.isUseNativeTitltBar) {
                this.f43917h.setTitleName(title);
            } else {
                Context context3 = this.f43920k;
                if (context3 != null && (context3 instanceof Page)) {
                    ((Page) context3).getTitleBar().setTitle(new TitleAttr.Builder(title).build());
                }
            }
        }
    }

    public void onWebPageReceivedError(int i, String str) {
        if (!TextUtils.isEmpty(str) && str.contains("http")) {
            m31253a(true, i);
        }
    }

    public boolean onBack() {
        if (m31255b()) {
            return true;
        }
        return m31257c();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m31255b() {
        if (this.f43911b == null) {
            return false;
        }
        GlobalJsBridge globalJsBridge = (GlobalJsBridge) this.f43911b.getExportModuleInstance(SodaFusionEngine.getGlobalJsBridge());
        if (globalJsBridge == null) {
            Log.d("WebTitleModule", "set  webTitleModule is null");
            return false;
        } else if (globalJsBridge.getCallbackFunction() == null) {
            Log.d("WebTitleModule", "getCallbackFunction is null");
            return false;
        } else {
            globalJsBridge.getCallbackFunction().onCallBack(WebJsBridgeTool.buildResponse(0));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m31257c() {
        Context context;
        IErrorLayout iErrorLayout = this.f43923n;
        boolean z = false;
        if (iErrorLayout == null) {
            m31253a(false, 0);
        } else if (iErrorLayout.backNeedHideIt()) {
            m31253a(false, 0);
        }
        SodaWebView sodaWebView = this.f43911b;
        if (sodaWebView != null && sodaWebView.doBack()) {
            z = true;
        }
        if (!z && (context = this.f43920k) != null) {
            ((UpdateUIHandlerImp) context).finishPage();
        }
        return z;
    }

    public void destory() {
        SodaWebView sodaWebView = this.f43911b;
        if (sodaWebView != null) {
            if (sodaWebView.getParent() != null) {
                ((ViewGroup) this.f43911b.getParent()).removeView(this.f43911b);
            }
            this.f43911b.destroy();
            this.f43911b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31248a(final CallbackFunction callbackFunction, String str) {
        List<ShareToolModel> list = this.f43921l;
        if (list == null || list.isEmpty()) {
            if (callbackFunction != null) {
                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, "param[buttons] is Empty", (JSONObject) null)));
            }
        } else if (this.f43919j.isUseNativeTitltBar) {
            this.f43917h.setMoreBtnVisibility(0);
            this.f43917h.setOnMoreClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (WebProxy.this.f43920k instanceof UpdateUIHandlerImp) {
                        ((UpdateUIHandlerImp) WebProxy.this.f43920k).onEntranceClick(WebProxy.this.f43921l, callbackFunction);
                    }
                }
            });
        } else {
            Context context = this.f43920k;
            if (context instanceof UpdateUIHandlerImp) {
                ((UpdateUIHandlerImp) context).showEntrance(callbackFunction, str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m31258d() {
        if (this.f43919j.isUseNativeTitltBar) {
            this.f43917h.setMoreBtnVisibility(8);
            return;
        }
        Context context = this.f43920k;
        if (context instanceof UpdateUIHandlerImp) {
            ((UpdateUIHandlerImp) context).hideEntrance();
        }
    }
}
