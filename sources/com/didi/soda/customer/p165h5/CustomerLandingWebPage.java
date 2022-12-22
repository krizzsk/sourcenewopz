package com.didi.soda.customer.p165h5;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.WebTitlebarConfigEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.p165h5.CustomerWebTitleBar;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridModule;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.didi.soda.web.p168ui.IErrorLayout;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.json.JSONObject;

@Route({"landingWebPage"})
/* renamed from: com.didi.soda.customer.h5.CustomerLandingWebPage */
public class CustomerLandingWebPage extends CustomerWebPage {

    /* renamed from: a */
    private static final String f41271a = "CustomerLandingWebPage";

    /* renamed from: b */
    private static final String f41272b = "{\"sysStatusBar\":1,\"backBtn\":{\"alpha\":1,\"color\":\"#FFFFFF\"},\"title\":{\"color\":\"#FFFFFF\",\"alpha\":1},\"nav\":{\"color\":\"#FFFFFF\",\"alpha\":0},\"rightBtns\":[{\"name\":\"shareBtn\",\"alpha\":1,\"currentIcon\":\"https:\\/\\/img0.didiglobal.com\\/static\\/gstar\\/img\\/tL1DaeQPI21594006849775.png\",\"preloadIcon\":\"https:\\/\\/img0.didiglobal.com\\/static\\/gstar\\/img\\/Annre94mLo1594006833498.png\",\"action\":\"triggerShareButtonEvent\"}]}";

    /* renamed from: c */
    private CustomerWebTitleBar f41273c;

    /* renamed from: d */
    private WebTitlebarConfigEntity f41274d;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public CustomerLandingWebPage() {
        DiRouter.registerHub(RoutePath.LANDING_WEB_PAGE, this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        m29230a((FusionWebView) getWebView());
        if (getScopeContext() != null) {
            DialogUtil.showLoadingDialog(getScopeContext(), false);
        }
        if (this.mFromTab) {
            this.f41273c.setBackVisible(false);
            this.f41273c.setTitleSize(24);
            this.f41273c.setTitleFontStyle(IToolsService.FontType.BOLD);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        DialogUtil.hideLoadingDialog();
    }

    public IErrorLayout getCustomerErrorLayout() {
        if (this.mFromTab) {
            return new CustomerWebErrorLayoutImp(this, new ErrorCallback() {
                public void onShowError() {
                    UiHandlerUtil.post($$Lambda$CustomerLandingWebPage$1$89Uc9QeaajcgtdgGj_cvIvHszbw.INSTANCE);
                }

                public void onRetryEvent() {
                    if (CustomerLandingWebPage.this.getScopeContext() != null) {
                        DialogUtil.showLoadingDialog(CustomerLandingWebPage.this.getScopeContext(), false);
                    }
                }
            }, false);
        }
        return null;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (getWebView() != null) {
            getWebView().hiddenLoadProgress();
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        DialogUtil.hideLoadingDialog();
    }

    public void updateNav(JSONObject jSONObject, CallbackFunction callbackFunction) {
        super.updateNav(jSONObject, callbackFunction);
        m29232a(jSONObject);
    }

    /* access modifiers changed from: protected */
    public View inflateTitleBar() {
        this.f41273c = new CustomerWebTitleBar(getBaseContext());
        m29228a();
        return this.f41273c;
    }

    /* renamed from: a */
    private void m29228a() {
        this.f41273c.setBackOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerLandingWebPage.this.m29229a(view);
            }
        });
        this.f41273c.setRightBtnsClick(new CustomerWebTitleBar.OnRightBtnsClickListener() {
            public final void onRightRtnsClick(String str) {
                CustomerLandingWebPage.this.m29231a(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29229a(View view) {
        onHandleBack();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29231a(String str) {
        invokeJSMethod(CustomerHybridModule.NAME_SPACE, str, new Object[0]);
    }

    /* renamed from: a */
    private void m29230a(FusionWebView fusionWebView) {
        if (fusionWebView != null) {
            fusionWebView.setHorizontalScrollBarEnabled(false);
            fusionWebView.setVerticalScrollBarEnabled(false);
            fusionWebView.hiddenLoadProgress();
        }
    }

    /* renamed from: a */
    private void m29232a(JSONObject jSONObject) {
        WebTitlebarConfigEntity webTitlebarConfigEntity;
        try {
            webTitlebarConfigEntity = (WebTitlebarConfigEntity) new Gson().fromJson(jSONObject.toString(), WebTitlebarConfigEntity.class);
        } catch (JsonSyntaxException unused) {
            webTitlebarConfigEntity = (WebTitlebarConfigEntity) new Gson().fromJson(f41272b, WebTitlebarConfigEntity.class);
        }
        WebTitlebarConfigEntity webTitlebarConfigEntity2 = this.f41274d;
        if (webTitlebarConfigEntity2 == null || !webTitlebarConfigEntity2.equals(webTitlebarConfigEntity)) {
            if (CustomerSystemUtil.getCurrentBarStatus() == (webTitlebarConfigEntity.sysStatusBar == 0)) {
                CustomerSystemUtil.setStatusBarBgLightning(!CustomerSystemUtil.getCurrentBarStatus());
            }
            if (webTitlebarConfigEntity.nav != null) {
                this.f41273c.setTitleBarBg(webTitlebarConfigEntity.nav.color);
                this.f41273c.setTitleBarAlp(webTitlebarConfigEntity.nav.alpha);
                this.f41273c.hiddenOrShowTitleBar(Integer.valueOf(webTitlebarConfigEntity.nav.hidden));
            }
            if (webTitlebarConfigEntity.title != null) {
                this.f41273c.setTitle(webTitlebarConfigEntity.title.content);
                this.f41273c.setTitleColor(webTitlebarConfigEntity.title.color);
                this.f41273c.setTitleAlp(webTitlebarConfigEntity.title.alpha);
                if (TextUtils.equals(webTitlebarConfigEntity.title.position, "left")) {
                    this.f41273c.setTitlePosition(16);
                } else {
                    this.f41273c.setTitlePosition(17);
                }
            }
            if (webTitlebarConfigEntity.backBtn != null) {
                this.f41273c.setBackBtnColor(webTitlebarConfigEntity.backBtn.color);
                this.f41273c.setBackBtnAlp(webTitlebarConfigEntity.backBtn.alpha);
            }
            if (!CollectionsUtil.isEmpty(webTitlebarConfigEntity.rightBtns)) {
                this.f41273c.setRightBtns(webTitlebarConfigEntity.rightBtns);
            }
            this.f41274d = webTitlebarConfigEntity;
        }
    }
}
