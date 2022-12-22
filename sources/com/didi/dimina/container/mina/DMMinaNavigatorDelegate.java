package com.didi.dimina.container.mina;

import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bean.NavigateConfig;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.page.ITabBarPageHost;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

public class DMMinaNavigatorDelegate implements IDMNavigator {
    public static final String NAVIGATOR = "Navigator";

    /* renamed from: f */
    private static int f16887f = 1;

    /* renamed from: a */
    private final IDMNavigator f16888a;

    /* renamed from: b */
    private IPageHost f16889b;

    /* renamed from: c */
    private List<IPageHost> f16890c;

    /* renamed from: d */
    private final int f16891d = 1;

    /* renamed from: e */
    private final int f16892e;

    /* renamed from: g */
    private JSONObject f16893g = new JSONObject();

    /* renamed from: h */
    private JSONObject f16894h = new JSONObject();

    /* renamed from: i */
    private boolean f16895i;

    public DMMinaNavigatorDelegate(IDMNavigator iDMNavigator) {
        int i = f16887f;
        this.f16892e = i;
        f16887f = i + 1;
        this.f16888a = iDMNavigator;
    }

    public int getIndex() {
        return this.f16892e;
    }

    public IDMNavigator getNavigator() {
        return this.f16888a;
    }

    public JSONObject getExtraOptions() {
        return this.f16893g;
    }

    public void setExtraOptions(JSONObject jSONObject) {
        this.f16893g = jSONObject;
    }

    public JSONObject getExtraShowOptions() {
        return this.f16894h;
    }

    public void setExtraShowOptions(JSONObject jSONObject) {
        this.f16894h = jSONObject;
    }

    public boolean isStackShow() {
        return this.f16895i;
    }

    public void setIsStackShow(boolean z) {
        this.f16895i = z;
    }

    public boolean showLaunchView(int i) {
        return this.f16888a.showLaunchView(i);
    }

    public boolean hideLaunchView(int i) {
        return this.f16888a.hideLaunchView(i);
    }

    public boolean launch(int i, int i2, NavigateConfig navigateConfig) {
        LogUtil.iRelease(NAVIGATOR, "launch minaIndex:" + i + " stackIndex:" + i2 + " " + navigateConfig.toString());
        if (DMMinaPool.get(i) != null) {
            return this.f16888a.launch(i, i2, navigateConfig);
        }
        LogUtil.iRelease(NAVIGATOR, "DMMinaPool.get(minaIndex) is null");
        return false;
    }

    public boolean reLaunch(int i, int i2, NavigateConfig navigateConfig) {
        LogUtil.iRelease(NAVIGATOR, "reLaunch minaIndex:" + i + " stackIndex:" + i2 + " " + navigateConfig.toString());
        return this.f16888a.reLaunch(i, i2, navigateConfig);
    }

    public boolean redirectTo(int i, int i2, NavigateConfig navigateConfig) {
        LogUtil.iRelease(NAVIGATOR, "redirectTo minaIndex:" + i + " stackIndex:" + i2 + " " + navigateConfig.toString());
        return this.f16888a.redirectTo(i, i2, navigateConfig);
    }

    public boolean navigateTo(int i, int i2, NavigateConfig navigateConfig) {
        IPageHost currentPage = getCurrentPage();
        if (currentPage instanceof ITabBarPageHost) {
            ITabBarPageHost iTabBarPageHost = (ITabBarPageHost) currentPage;
            this.f16889b = iTabBarPageHost.getCurrentPage();
            this.f16890c = iTabBarPageHost.getCurrentPages();
        }
        int size = getCurrentPages().size();
        if (this.f16890c != null && size == 1) {
            for (int i3 = 0; i3 < this.f16890c.size(); i3++) {
                if (!this.f16890c.get(i3).equals(this.f16889b)) {
                    DMPage page = this.f16890c.get(i3).getPage();
                    int webViewId = page.getWebViewId();
                    LogUtil.iRelease(NAVIGATOR, "webView操作onPause() TAB webViewId：" + webViewId);
                    UIHandlerUtil.post(new Runnable() {
                        public final void run() {
                            DMPage.this.getWebViewContainer().onPause();
                        }
                    });
                }
            }
        } else if (size > 1) {
            DMPage page2 = getCurrentPages().get(size - 1).getPage();
            int webViewId2 = page2.getWebViewId();
            LogUtil.iRelease(NAVIGATOR, "webView操作onPause() webViewId：" + webViewId2);
            UIHandlerUtil.post(new Runnable() {
                public final void run() {
                    DMPage.this.getWebViewContainer().onPause();
                }
            });
        }
        if (!CollectionsUtil.isEmpty((Collection) this.f16888a.getCurrentPages())) {
            DMMemoryManager.getInstance().handleMemory(this.f16888a.getCurrentPages());
        }
        LogUtil.iRelease(NAVIGATOR, "navigateTo  minaIndex:" + i + " stackIndex:" + i2 + " " + navigateConfig.toString());
        return this.f16888a.navigateTo(i, i2, navigateConfig);
    }

    public boolean navigateBack(int i, int i2, int i3) {
        if (getCurrentPages().size() == 1) {
            IPageHost currentPage = getCurrentPage();
            if (!(currentPage.getPage() == null || currentPage.getPage().getDMMina() == null)) {
                LogUtil.iRelease(NAVIGATOR, "退出小程序通知");
                JSONObject build = new MessageWrapperBuilder().build();
                currentPage.getPage().getDMMina().getMessageTransfer().sendMessageToServiceFromNative("onCloseMiniProgram", build);
                TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.NAVIGATE_ON_CLOSE_MINI_PROGRAM, "msg: " + build);
            }
        }
        LogUtil.iRelease(NAVIGATOR, "navigateBack  minaIndex:" + i + " stackIndex:" + i2 + " popCount:" + i3);
        boolean navigateBack = this.f16888a.navigateBack(i, i2, i3);
        DMMemoryManager.getInstance().checkPageMemory(this.f16888a.getCurrentPage());
        int size = getCurrentPages().size();
        if (size > 1) {
            DMPage page = getCurrentPages().get(size - 1).getPage();
            int webViewId = page.getWebViewId();
            LogUtil.iRelease(NAVIGATOR, "navigateBack webView操作onResume(); webViewId：" + webViewId);
            UIHandlerUtil.post(new Runnable() {
                public final void run() {
                    DMPage.this.getWebViewContainer().onResume();
                }
            });
        }
        if (size == 1) {
            IPageHost currentPage2 = getCurrentPage();
            if (!(currentPage2.getPage() == null || currentPage2.getPage().getDMMina() == null)) {
                DMMemoryManager.getInstance().notifyDiminaResumeMainPage(currentPage2.getPage().getDMMina());
            }
        }
        return navigateBack;
    }

    public boolean switchTab(int i, int i2, NavigateConfig navigateConfig) {
        LogUtil.iRelease(NAVIGATOR, "switchTab minaIndex:" + i + " stackIndex:" + i2 + " " + navigateConfig.toString());
        boolean switchTab = this.f16888a.switchTab(i, i2, navigateConfig);
        IPageHost currentPage = getCurrentPage();
        if (currentPage instanceof ITabBarPageHost) {
            IPageHost currentPage2 = ((ITabBarPageHost) currentPage).getCurrentPage();
            this.f16889b = currentPage2;
            int webViewId = currentPage2.getPage().getWebViewId();
            LogUtil.iRelease(NAVIGATOR, "switchTab webView操作onResume() from：TAB_非首页 webViewId：" + webViewId);
            UIHandlerUtil.post(new Runnable() {
                public final void run() {
                    DMMinaNavigatorDelegate.this.m12504a();
                }
            });
        }
        return switchTab;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12504a() {
        this.f16889b.getPage().getWebViewContainer().onResume();
    }

    public boolean closeDimina() {
        LogUtil.iRelease(NAVIGATOR, InternalJSMethod.CLOSE_DIMINA);
        return this.f16888a.closeDimina();
    }

    public List<IPageHost> getCurrentPages() {
        return this.f16888a.getCurrentPages();
    }

    public IPageHost getCurrentPage() {
        return this.f16888a.getCurrentPage();
    }

    public IPageHost getPage(int i) {
        return this.f16888a.getPage(i);
    }

    public IPageHost getPage(String str) {
        return this.f16888a.getPage(str);
    }

    public IDMNavigator clone() {
        LogUtil.m13409e("don't clone this object");
        return null;
    }
}
