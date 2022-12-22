package com.didi.dimina.container.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.p106ui.refresh.AbsOverView;
import com.didi.dimina.container.p106ui.refresh.IRefresh;
import com.didi.dimina.container.p106ui.refresh.RefreshLayout;
import com.didi.dimina.container.p106ui.refresh.TextOverView;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.taxis99.R;

public class PageRefreshHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RefreshLayout f17037a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f17038b;

    /* renamed from: c */
    private final DMMina f17039c;

    /* renamed from: d */
    private final DMPage f17040d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f17041e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f17042f;

    public PageRefreshHelper(DMMina dMMina, DMPage dMPage) {
        boolean z = false;
        this.f17039c = dMMina;
        this.f17040d = dMPage;
        JSAppConfig jSAppConfig = dMMina.getJSAppConfig();
        JSAppConfig.PageConfig pageConfig = jSAppConfig.getPageConfig(this.f17040d.getUrl());
        if (pageConfig != null) {
            z = pageConfig.enablePullDownRefresh();
        } else if (jSAppConfig.globalConfig != null && jSAppConfig.globalConfig.enablePullDownRefresh()) {
            z = true;
        }
        this.f17038b = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55314a() {
        if (!this.f17038b) {
            LogUtil.m13411i("the target page can't pull down to refresh");
            return;
        }
        View findViewById = this.f17040d.findViewById(R.id.webview_container);
        if (findViewById == null) {
            LogUtil.m13411i("the target view is empty");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
        if (viewGroup == null) {
            LogUtil.m13411i("the target view's parent is empty");
            return;
        }
        int indexOfChild = viewGroup.indexOfChild(findViewById);
        viewGroup.removeView(findViewById);
        RefreshLayout refreshLayout = new RefreshLayout(this.f17040d.getContext());
        this.f17037a = refreshLayout;
        refreshLayout.addView(findViewById);
        viewGroup.addView(this.f17037a, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
        AbsOverView absOverView = null;
        try {
            Class<? extends AbsOverView> refreshOverViewClass = this.f17039c.getConfig().getUIConfig().getRefreshOverViewClass();
            Class[] clsArr = {Context.class};
            absOverView = (AbsOverView) refreshOverViewClass.getConstructor(clsArr).newInstance(new Object[]{this.f17040d.getContext()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (absOverView != null) {
            this.f17037a.setRefreshOverView(absOverView);
        } else {
            this.f17037a.setRefreshOverView(new TextOverView(this.f17040d.getContext()));
        }
        this.f17037a.setRefreshListener(new IRefresh.RefreshListener() {
            public boolean enableRefresh() {
                return true;
            }

            public void onRefresh() {
                if (!PageRefreshHelper.this.f17041e) {
                    UIHandlerUtil.postDelayed(new Runnable() {
                        public void run() {
                            PageRefreshHelper.this.stopPullDownRefresh();
                        }
                    }, 1000);
                }
            }
        });
        this.f17040d.getWebViewContainer().getWebView().addScrollChangedCallback(new WebViewEngine.OnScrollChangedCallback() {
            public void onScroll(int i, int i2) {
                int unused = PageRefreshHelper.this.f17042f = i2;
                PageRefreshHelper.this.f17037a.setEnablePullDownToRefresh(PageRefreshHelper.this.f17038b && PageRefreshHelper.this.f17042f <= 0);
            }
        });
    }

    public void startPullDownRefresh() {
        RefreshLayout refreshLayout;
        if (this.f17038b && (refreshLayout = this.f17037a) != null) {
            this.f17041e = true;
            refreshLayout.refreshAuto();
        }
    }

    public void stopPullDownRefresh() {
        RefreshLayout refreshLayout;
        if (this.f17038b && (refreshLayout = this.f17037a) != null) {
            refreshLayout.refreshFinished();
        }
    }

    public void setEnablePullRefresh(boolean z) {
        this.f17038b = z;
        if (this.f17037a == null && z) {
            mo55314a();
        }
        RefreshLayout refreshLayout = this.f17037a;
        if (refreshLayout != null) {
            refreshLayout.setEnablePullDownToRefresh(z && this.f17042f <= 0);
        }
    }
}
