package com.didi.dimina.container.page;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.bean.NavigateConfig;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.bridge.blankscreen.CheckBlankScreenManager;
import com.didi.dimina.container.bridge.loading.CustomLoadingManager;
import com.didi.dimina.container.bridge.loading.DefaultLoadingManager;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.monitor.DeviceMonitor;
import com.didi.dimina.container.monitor.DeviceTraceEvent;
import com.didi.dimina.container.monitor.PageProcessStat;
import com.didi.dimina.container.monitor.PerformanceDotType;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.dimina.container.p106ui.loadpage.AbsLoadingManager;
import com.didi.dimina.container.p106ui.loadpage.DMBaseLoadingView;
import com.didi.dimina.container.p106ui.statusbar.ImmersionBar;
import com.didi.dimina.container.p106ui.statusbar.OnKeyboardListener;
import com.didi.dimina.container.p106ui.title.WebTitleBar;
import com.didi.dimina.container.p106ui.webview.DMWebViewContainer;
import com.didi.dimina.container.service.CapsuleButtonService;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.CoreDottingExtra;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.KeyboardUtils;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PathUtil;
import com.didi.dimina.container.util.SnapShotUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.taxis99.R;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

public class DMPage extends FrameLayout {
    public static final String METHOD_PULL_REFRESH = "onPullDownRefresh";
    public static final String ON_APP_ROUTE = "onAppRoute";
    public static final String PROPERTY_CURRENT_PATH = "currentPath";
    public static final String TAG_PAGE_FRAME = "PAGE_FRAME";

    /* renamed from: a */
    private static final String f16986a = "mapv2";

    /* renamed from: b */
    private static final String f16987b = "DMPage";

    /* renamed from: p */
    private static final long f16988p = 200;

    /* renamed from: A */
    private Boolean f16989A;

    /* renamed from: B */
    private PageProcessStat f16990B;

    /* renamed from: C */
    private Boolean f16991C = false;

    /* renamed from: D */
    private CheckBlankScreenManager f16992D = null;

    /* renamed from: E */
    private List<DMPageLifecycleListener> f16993E = new ArrayList();

    /* renamed from: F */
    private long f16994F = 0;

    /* renamed from: G */
    private long f16995G = 0;

    /* renamed from: H */
    private final DMWebViewContainer.OnTitleChangeListener f16996H = new DMWebViewContainer.OnTitleChangeListener() {
        public void onTitleChanged(String str) {
            DMPage.this.f17001g.setTitle(str);
        }
    };

    /* renamed from: c */
    private FrameLayout f16997c;

    /* renamed from: d */
    private NavigateConfig f16998d;

    /* renamed from: e */
    private DMMina f16999e;

    /* renamed from: f */
    private int f17000f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WebTitleBar f17001g;

    /* renamed from: h */
    private View f17002h;
    protected ObjectAnimator hideAnimation;

    /* renamed from: i */
    private View f17003i;
    public boolean isWebViewRelease = false;

    /* renamed from: j */
    private DMWebViewContainer f17004j;

    /* renamed from: k */
    private DMMinaNavigatorDelegate f17005k;

    /* renamed from: l */
    private AbsLoadingManager f17006l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public NavigationBarStatus f17007m = NavigationBarStatus.VISIBLE;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public float f17008n;

    /* renamed from: o */
    private Fragment f17009o;
    public int poolMark = 1;

    /* renamed from: q */
    private PageRefreshHelper f17010q;

    /* renamed from: r */
    private View f17011r;

    /* renamed from: s */
    private boolean f17012s = false;
    protected ObjectAnimator showAnimation;

    /* renamed from: t */
    private DMWebViewContainer f17013t;

    /* renamed from: u */
    private boolean f17014u = false;

    /* renamed from: v */
    private boolean f17015v = false;

    /* renamed from: w */
    private long f17016w = -1;

    /* renamed from: x */
    private String f17017x = "";

    /* renamed from: y */
    private JSAppConfig.DidiPageFrameItem f17018y;

    /* renamed from: z */
    private boolean f17019z = false;

    enum NavigationBarStatus {
        SCROLLING_DOWN,
        SCROLLING_UP,
        GONE,
        VISIBLE
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m12526a(String str) {
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ boolean m12528b(String str) {
        return true;
    }

    public DMPage(Context context) {
        super(context);
    }

    public DMPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMPage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void preLoadView(DMMina dMMina) {
        this.f16994F = System.currentTimeMillis();
        String transformUrl = BundleManager.getInstance().transformUrl(dMMina, Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_WEB_VIEW.PAGE_FRAME);
        if (FileUtil.isFileProtocolExists(transformUrl)) {
            m12524a(dMMina, transformUrl);
            return;
        }
        try {
            String path = new URL(BundleManager.getInstance().transformUrl(dMMina, Constant.BundleConstant.SDK_MODULE_NAME, "/")).getPath();
            List<String> list = FileUtil.list($$Lambda$DMPage$5qeWwmtdDTy0U4kgSDdqcL1_YaY.INSTANCE, path);
            List<String> list2 = FileUtil.list($$Lambda$DMPage$sKyQ4EyIDOQC3m6EwKmNHylnIZQ.INSTANCE, (String[]) list.toArray(new String[0]));
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            arrayList.addAll(list2);
            TraceUtil.trackEventError(this.f16999e.getMinaIndex(), "JSEngineException", 1008, JSONUtil.toJson(arrayList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean preLoadSingleView(DMMina dMMina, JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        DMMina dMMina2 = dMMina;
        JSAppConfig.DidiPageFrameItem didiPageFrameItem2 = didiPageFrameItem;
        this.f16995G = System.currentTimeMillis();
        String str = dMMina.getJsSdkBundleConfig() != null ? dMMina.getJsSdkBundleConfig().versionCode : null;
        if (TextUtils.isEmpty(str)) {
            str = "0.0.1";
        }
        String transformUrl = BundleManager.getInstance().transformUrl(dMMina2, getPageFrameConfig().root, didiPageFrameItem2.getFileName(str));
        String transformUrl2 = BundleManager.getInstance().transformUrl(dMMina2, getPageFrameConfig().root, didiPageFrameItem.getModelName());
        try {
            String path = new URL(transformUrl).getPath();
            File file = new File(path);
            if (file.exists() && file.length() == 0) {
                LogUtil.iRelease("PAGE_FRAME", "删除空文件:" + path);
                FileUtil.delete(path);
            }
            if (!file.exists()) {
                try {
                    String transformUrl3 = BundleManager.getInstance().transformUrl(dMMina2, Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_JS.DM_WEB_VIEW_NAME);
                    String transformUrl4 = BundleManager.getInstance().transformUrl(dMMina2, "app", Constant.LAUNCHER_JS.APP_WEB_VIEW_NAME);
                    String transformUrl5 = BundleManager.getInstance().transformUrl(dMMina2, "app", Constant.LAUNCHER_JS.APP_WEB_VIEW_STYLE_NAME);
                    String transformUrl6 = BundleManager.getInstance().transformUrl(dMMina2, didiPageFrameItem2.root, Constant.LAUNCHER_JS.APP_WEB_VIEW_NAME);
                    String transformUrl7 = BundleManager.getInstance().transformUrl(dMMina2, didiPageFrameItem2.root, Constant.LAUNCHER_JS.APP_WEB_VIEW_STYLE_NAME);
                    String transformUrl8 = BundleManager.getInstance().transformUrl(dMMina2, didiPageFrameItem2.root, didiPageFrameItem.getJSName());
                    String transformUrl9 = BundleManager.getInstance().transformUrl(dMMina2, didiPageFrameItem2.root, didiPageFrameItem.getCSSName());
                    String replace = FileUtil.read(dMMina.getMinaIndex(), new URL(transformUrl2).getPath()).replace("dipffile://dm-webview.js", transformUrl3).replace("dipffile://app-webview.js", transformUrl4).replace("dipffile://app-webview.css", transformUrl5).replace("./app-webview.js", transformUrl6).replace("./app-webview.css", transformUrl7);
                    String replace2 = replace.replace("." + didiPageFrameItem.getJSName(), transformUrl8);
                    String replace3 = replace2.replace("." + didiPageFrameItem.getCSSName(), transformUrl9);
                    if (file.createNewFile()) {
                        LogUtil.iRelease("PAGE_FRAME", "创建文件:" + path);
                        FileUtil.write(replace3, path);
                    }
                } catch (Exception e) {
                    e = e;
                    LogUtil.iRelease("PAGE_FRAME", "生成特殊DMPage失败：" + getPageFrameConfig().url);
                    e.printStackTrace();
                    return false;
                }
            }
            if (!file.exists()) {
                LogUtil.iRelease("PAGE_FRAME", "写入quick-page-frame.html 失败：" + getPageFrameConfig().url);
                return false;
            }
            LogUtil.iRelease("PAGE_FRAME", "dmpage开始loadview：" + transformUrl);
            m12524a(dMMina2, transformUrl);
            return true;
        } catch (Exception e2) {
            e = e2;
            LogUtil.iRelease("PAGE_FRAME", "生成特殊DMPage失败：" + getPageFrameConfig().url);
            e.printStackTrace();
            return false;
        }
    }

    public void onCreate(Fragment fragment, int i, int i2, NavigateConfig navigateConfig) {
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.PAGE_ON_CREATE, mo55242a().with("minaIndex", Integer.valueOf(i)).with(MessageWrapperBuilder.ARG_STACK_ID, Integer.valueOf(i2)).with("config", navigateConfig).toInfo());
        m12527b();
        this.f17017x = NachoLifecycleManager.LIFECYCLE_ON_CREATE;
        this.f17016w = TimeUtil.currentNanoMillis();
        m12523a(fragment, i, i2, navigateConfig);
        m12529c();
        PageRefreshHelper pageRefreshHelper = new PageRefreshHelper(this.f16999e, this);
        this.f17010q = pageRefreshHelper;
        pageRefreshHelper.mo55314a();
        if (this.poolMark == 2) {
            String str = getNavigateConfig().packages;
            if (TextUtils.isEmpty(str)) {
                str = "app";
            }
            String splitPath = HttpUtil.splitPath(getNavigateConfig().url);
            StringBuilder sb = new StringBuilder();
            sb.append(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_STYLE_PREFIX);
            sb.append((splitPath.startsWith("/") ? splitPath.substring(1) : splitPath).replaceAll("/", "_"));
            String sb2 = sb.toString();
            String transform2AbsolutePath = BundleManager.getInstance().transform2AbsolutePath(this.f16999e, Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_WEB_VIEW.PAGE_FRAME);
            StringBuilder sb3 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, BundleManager.getInstance().transform2AbsolutePath(this.f16999e, str, Constant.LAUNCHER_JS.APP_WEB_VIEW_NAME)));
            StringBuilder sb4 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, BundleManager.getInstance().transform2AbsolutePath(this.f16999e, "app", Constant.LAUNCHER_JS.APP_WEB_VIEW_NAME)));
            StringBuilder sb5 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, BundleManager.getInstance().transform2AbsolutePath(this.f16999e, "app", Constant.LAUNCHER_JS.APP_WEB_VIEW_STYLE_NAME)));
            BundleManager instance = BundleManager.getInstance();
            DMMina dMMina = this.f16999e;
            StringBuilder sb6 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, instance.transform2AbsolutePath(dMMina, str, sb2 + Constant.LAUNCHER_JS.PAGE_WEB_VIEW_STYLE_SUFFIX)));
            BundleManager instance2 = BundleManager.getInstance();
            DMMina dMMina2 = this.f16999e;
            StringBuilder sb7 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, instance2.transform2AbsolutePath(dMMina2, str, sb2 + Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX)));
            JSONObject jSONObject = JSONUtil.toJSONObject(getNavigateConfig().query);
            if (!SameLayerRenderingUtil.isSameLayerRenderingReady(getWebViewContainer().getWebView())) {
                JSONUtil.put(jSONObject, SameLayerRenderingUtil.KEY_DOWNGRADE_VIEW_TYPE, 1);
            } else {
                JSONUtil.put(jSONObject, "downgradeTypeConfig", (Object) SameLayerRenderingUtil.getSameLayerRenderComponentConfig(this));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONUtil.put(jSONObject2, PROPERTY_CURRENT_PATH, (Object) this.f16998d.url);
            JSONUtil.put(jSONObject2, MessageWrapperBuilder.ARG_WEB_VIEW_ID, getWebViewId());
            JSONUtil.put(jSONObject2, "openType", (Object) getNavigateConfig().openType);
            JSONUtil.put(jSONObject2, "route", (Object) splitPath);
            JSONUtil.put(jSONObject2, "query", (Object) JSONUtil.combineJson(HttpUtil.parseUrlQueryJSONObject(this.f16999e.getConfig().getLaunchConfig().getAppId(), getNavigateConfig().url), jSONObject));
            JSONUtil.put(jSONObject2, "appWebViewPath", (Object) sb3.toString());
            JSONUtil.put(jSONObject2, "mainAppWebViewPath", (Object) sb4.toString());
            JSONUtil.put(jSONObject2, "appStyleSheetPath", (Object) sb5.toString());
            JSONUtil.put(jSONObject2, "pageStyleSheetPath", (Object) sb6.toString());
            JSONUtil.put(jSONObject2, "pageJavascriptPath", (Object) sb7.toString());
            JSONObject build = new MessageWrapperBuilder().data(jSONObject2).stackId(getNavigator().getIndex()).webViewId(getWebViewId()).build();
            this.f16999e.getMessageTransfer().sendMessageToWebView(getWebViewContainer().getWebView(), "invokeParamsToWinDone", build);
            this.f16999e.getDmWebViewManager().put(Integer.valueOf(getWebViewId()), getWebViewContainer().getWebView());
            this.f17009o.startPostponedEnterTransition();
            this.f16999e.getPerformance().markWinDone();
            int minaIndex = this.f16999e.getMinaIndex();
            TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PAGE_INVOKE_PARAMS_TO_WIN_DONE, "from: onCreate(), msg: " + build);
        }
        for (DMPageLifecycleListener onCreate : this.f16993E) {
            onCreate.onCreate();
        }
    }

    /* renamed from: b */
    private void m12527b() {
        DMThreadPool.post2HandlerThread(new Runnable() {
            public final void run() {
                DMPage.this.m12533g();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m12533g() {
        LogUtil.m13408d(f16987b, "setDeviceStat apollo enbale");
        this.f16990B = new PageProcessStat();
        DeviceMonitor deviceMonitor = new DeviceMonitor();
        try {
            this.f16990B.setPageCreateMemory((long) deviceMonitor.getAppTotalMemory());
            this.f16990B.setPageCreatePower(deviceMonitor.getPower().floatValue());
        } catch (Exception e) {
            LogUtil.m13408d(f16987b, "setDeviceStat " + e.getMessage());
        }
    }

    public void onShow() {
        TraceUtil.trackEventCoreDotting(this.f16999e.getMinaIndex(), Constant.CORE_DOTTING.PAGE_ON_SHOW, mo55242a().toInfo());
        Boolean bool = this.f16989A;
        if (bool != null) {
            setStatusBarDarkStyle(bool.booleanValue());
        }
        for (DMPageLifecycleListener onShow : this.f16993E) {
            onShow.onShow();
        }
    }

    public void onHide() {
        TraceUtil.trackEventCoreDotting(this.f16999e.getMinaIndex(), Constant.CORE_DOTTING.PAGE_ON_HIDE, mo55242a().toInfo());
        for (DMPageLifecycleListener onHide : this.f16993E) {
            onHide.onHide();
        }
    }

    public void onDestroy() {
        DeviceTraceEvent.trackEvent(this.f16999e.getMinaIndex(), PerformanceDotType.PAGE_DESTROY, new DeviceMonitor(this.f16998d.url), this.f16990B);
        TraceUtil.trackEventCoreDotting(this.f16999e.getMinaIndex(), Constant.CORE_DOTTING.PAGE_ON_DESTROY, mo55242a().toInfo());
        this.f17014u = true;
        for (DMPageLifecycleListener onDestroy : this.f16993E) {
            onDestroy.onDestroy();
        }
        JSModuleWrapper jSModule = this.f16999e.getJSModule("DMWebViewBridgeModule");
        if (jSModule != null) {
            jSModule.releaseWebViewModuleInstance(this.f17004j.getWebView());
        }
        DMWebViewContainer dMWebViewContainer = this.f17004j;
        if (dMWebViewContainer != null) {
            dMWebViewContainer.release(getWebViewId());
        }
        long currentNanoMillis = TimeUtil.currentNanoMillis();
        long j = this.f17016w;
        long j2 = currentNanoMillis - j;
        if (j != -1) {
            TraceUtil.trackPageOnDestroyRendering(this.f16999e.getMinaIndex(), this.f16998d.url, j2, (long) getWebViewId(), this.f17017x);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CoreDottingExtra mo55242a() {
        return CoreDottingExtra.create().with(MessageWrapperBuilder.ARG_WEB_VIEW_ID, Integer.valueOf(getWebViewId()));
    }

    public void onDomReady() {
        DeviceTraceEvent.trackEvent(this.f16999e.getMinaIndex(), PerformanceDotType.DOM_READY, new DeviceMonitor(this.f16998d.url), this.f16990B);
        this.f17015v = true;
        if (!this.f17019z) {
            hideLoadingView();
        } else {
            UIHandlerUtil.postDelayed(new Runnable() {
                public void run() {
                    DMPage.this.hideLoadingView();
                }
            }, this.f16999e.getConfig().getLaunchConfig().getSnapshotConfig().getSnapshotDurationTime());
        }
        for (DMPageLifecycleListener onDomReady : this.f16993E) {
            onDomReady.onDomReady();
        }
    }

    public void hideLoadingView() {
        if (this.f17011r != null) {
            LogUtil.iRelease(f16987b, "hideLoadingView");
            this.f16997c.removeView(this.f17011r);
        }
        AbsLoadingManager absLoadingManager = this.f17006l;
        if (absLoadingManager != null) {
            absLoadingManager.dismiss();
        }
    }

    public void reLoadView() {
        String transformUrl = BundleManager.getInstance().transformUrl(this.f16999e, Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_WEB_VIEW.PAGE_FRAME);
        if (FileUtil.isFileProtocolExists(transformUrl)) {
            this.f17004j.initWebView();
            this.poolMark = 3;
            this.f17004j.getWebView().dmCreate(this.f17004j, this, this.f16999e, this.f17005k);
            this.f17004j.loadUrl(transformUrl);
        }
        this.isWebViewRelease = false;
        TraceUtil.trackEventCoreDotting(this.f16999e.getMinaIndex(), Constant.CORE_DOTTING.PAGE_RELOAD_WEB_VIEW, mo55242a().with("url", transformUrl).toInfo());
        this.f17016w = TimeUtil.currentNanoMillis();
        this.f17017x = "reload";
    }

    public void releaseWebView() {
        TraceUtil.trackEventCoreDotting(this.f16999e.getMinaIndex(), Constant.CORE_DOTTING.PAGE_RELEASE_WEB_VIEW, mo55242a().toInfo());
        DMWebViewContainer dMWebViewContainer = this.f17004j;
        if (dMWebViewContainer != null) {
            dMWebViewContainer.release(getWebViewId());
            this.isWebViewRelease = true;
            getNavigateConfig().openType = "pageReload";
            m12522a((ViewGroup) this.f16997c);
            try {
                TraceUtil.trackWebViewRelease(this.f16999e.getMinaIndex(), System.currentTimeMillis() - this.f16999e.getPerformance().getLaunchTime(), this.f16999e.getPerformance().getDidOpenCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setCapsuleButtonVisibility(boolean z) {
        this.f17003i.setVisibility(z ? 0 : 8);
    }

    public View getCapsuleButton() {
        return this.f17003i;
    }

    public String getUrl() {
        return this.f16998d.url;
    }

    public WebTitleBar getWebTitleBar() {
        return this.f17001g;
    }

    public DMWebViewContainer getWebViewContainer() {
        return this.f17004j;
    }

    public int getWebViewId() {
        return this.f17000f;
    }

    public PageRefreshHelper getRefreshHelper() {
        return this.f17010q;
    }

    public NavigateConfig getNavigateConfig() {
        return this.f16998d;
    }

    public long getRenderStartTime() {
        return this.f17016w;
    }

    /* renamed from: a */
    private void m12523a(Fragment fragment, int i, int i2, NavigateConfig navigateConfig) {
        this.f17009o = fragment;
        DMMina dMMina = DMMinaPool.get(i);
        this.f16999e = dMMina;
        this.f17005k = dMMina.getNavigator(i2);
        this.f16998d = navigateConfig;
    }

    /* renamed from: c */
    private void m12529c() {
        CapsuleButtonService capsuleButtonService;
        m12532f();
        m12522a((ViewGroup) this.f16997c);
        m12530d();
        m12531e();
        this.f17004j.setChangeTitleListener(this.f16996H);
        this.f17004j.initBackground(this.f16998d.url);
        JSAppConfig.PageConfig pageConfig = this.f16999e.getJSAppConfig().getPageConfig(this.f16998d.url);
        if (pageConfig != null) {
            this.f17003i.setVisibility((!this.f16999e.getConfig().getUIConfig().hasCapsuleButton() || !"show".equalsIgnoreCase(pageConfig.capsuleButton)) ? 8 : 0);
            this.f17003i.setBackgroundResource("black".equals(pageConfig.navigationBarTextStyle) ? R.drawable.dimina_capsule_black_icon : R.drawable.dimina_capsule_white_icon);
        }
        if (this.f16999e.getConfig().getCallbackConfig() != null && (capsuleButtonService = this.f16999e.getConfig().getCallbackConfig().getCapsuleButtonService()) != null) {
            this.f17003i.setOnClickListener(new View.OnClickListener(capsuleButtonService) {
                public final /* synthetic */ CapsuleButtonService f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    DMPage.this.m12525a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12525a(CapsuleButtonService capsuleButtonService, View view) {
        capsuleButtonService.onCloseClick(this.f16999e);
    }

    public void setCapsuleButtonColorBlack(Boolean bool) {
        this.f17003i.setBackgroundResource(bool.booleanValue() ? R.drawable.dimina_capsule_black_icon : R.drawable.dimina_capsule_white_icon);
    }

    /* renamed from: a */
    private void m12522a(ViewGroup viewGroup) {
        Bitmap bitmap = null;
        try {
            if (this.f16999e.getConfig().getLaunchConfig().getSnapshotConfig().getSnapshotAllow() && this.f16999e.getJSAppConfig().snapshotAllow && !this.f16999e.getConfig().getLaunchConfig().getSnapshotConfig().getHasUsedSnapshot()) {
                bitmap = SnapShotUtil.getInstance().getSnapshot(this);
            }
            if (bitmap != null) {
                if (bitmap.getHeight() > 0 && bitmap.getWidth() > 0) {
                    this.f16999e.getConfig().getLaunchConfig().getSnapshotConfig().setHasUsedSnapshot(true);
                    this.f17019z = true;
                    LogUtil.iRelease(f16987b, "页面启动使用快照");
                    ImageView imageView = new ImageView(getContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            DMPage.this.m12521a(view);
                        }
                    });
                    this.f17011r = imageView;
                    if (this.f17011r != null && viewGroup != null) {
                        viewGroup.addView(this.f17011r, new LinearLayout.LayoutParams(-1, -1));
                        return;
                    }
                }
            }
            this.f17019z = false;
            LogUtil.iRelease(f16987b, "页面启动使用骨架屏");
            Class<? extends DMBaseLoadingView> pageLoadingViewClass = this.f16999e.getConfig().getUIConfig().getPageLoadingViewClass();
            if (pageLoadingViewClass != null) {
                this.f17011r = (DMBaseLoadingView) pageLoadingViewClass.getConstructor(new Class[]{Context.class, DMMina.class, DMPage.class}).newInstance(new Object[]{getContext(), this.f16999e, this});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f17011r != null) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12521a(View view) {
        getLoadingManager().show();
    }

    private AbsLoadingManager getLoadingManager() {
        if (this.f17006l == null) {
            DMMina dMMina = this.f16999e;
            if (dMMina == null || dMMina.getConfig() == null || this.f16999e.getConfig().getUIConfig().getNoTitleLoadingViewClazz() == null) {
                this.f17006l = new DefaultLoadingManager(getContext(), (String) null, this.f16999e);
            } else {
                this.f17006l = new CustomLoadingManager(getContext(), this.f16999e);
            }
        }
        return this.f17006l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12530d() {
        /*
            r3 = this;
            com.didi.dimina.container.bean.NavigateConfig r0 = r3.f16998d
            java.lang.String r0 = r0.url
            com.didi.dimina.container.DMMina r1 = r3.f16999e
            com.didi.dimina.container.bean.JSAppConfig r1 = r1.getJSAppConfig()
            boolean r2 = r1.containPath(r0)
            if (r2 == 0) goto L_0x0034
            com.didi.dimina.container.bean.JSAppConfig$PageConfig r0 = r1.getPageConfig(r0)
            com.didi.dimina.container.bean.JSAppConfig$GlobalConfig r1 = r1.globalConfig
            java.lang.String r2 = r0.backgroundColor
            boolean r2 = com.didi.dimina.container.util.TextUtil.isEmpty(r2)
            if (r2 != 0) goto L_0x0021
            java.lang.String r0 = r0.backgroundColor
            goto L_0x0036
        L_0x0021:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r0 = r1.window
            if (r0 == 0) goto L_0x0034
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r0 = r1.window
            java.lang.String r0 = r0.backgroundColor
            boolean r0 = com.didi.dimina.container.util.TextUtil.isEmpty(r0)
            if (r0 != 0) goto L_0x0034
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r0 = r1.window
            java.lang.String r0 = r0.backgroundColor
            goto L_0x0036
        L_0x0034:
            java.lang.String r0 = ""
        L_0x0036:
            boolean r1 = com.didi.dimina.container.util.ColorUtil.isValidColorStr(r0)
            if (r1 == 0) goto L_0x0047
            java.lang.String r0 = com.didi.dimina.container.util.ColorUtil.convert3To6(r0)
            int r0 = android.graphics.Color.parseColor(r0)
            r3.setBackgroundColor(r0)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.page.DMPage.m12530d():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b5  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12531e() {
        /*
            r10 = this;
            android.content.Context r0 = r10.getContext()
            boolean r1 = r0 instanceof android.app.Activity
            r2 = 0
            if (r1 == 0) goto L_0x0010
            android.app.Activity r0 = (android.app.Activity) r0
            int r0 = com.didi.dimina.container.p106ui.statusbar.ImmersionBar.getStatusBarHeight((android.app.Activity) r0)
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 >= 0) goto L_0x0014
            r0 = 0
        L_0x0014:
            com.didi.dimina.container.bean.NavigateConfig r1 = r10.f16998d
            java.lang.String r1 = r1.url
            com.didi.dimina.container.DMMina r3 = r10.f16999e
            com.didi.dimina.container.bean.JSAppConfig r3 = r3.getJSAppConfig()
            java.lang.String r4 = "#fff"
            java.lang.String r5 = ""
            boolean r6 = r3.containPath(r1)
            r7 = 8
            java.lang.String r8 = "black"
            if (r6 == 0) goto L_0x0098
            com.didi.dimina.container.bean.JSAppConfig$PageConfig r1 = r3.getPageConfig(r1)
            com.didi.dimina.container.bean.JSAppConfig$GlobalConfig r3 = r3.globalConfig
            java.lang.String r6 = r1.navigationBarBackgroundColor
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x003d
            java.lang.String r4 = r1.navigationBarBackgroundColor
            goto L_0x004f
        L_0x003d:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            if (r6 == 0) goto L_0x004f
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            java.lang.String r6 = r6.navigationBarBackgroundColor
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x004f
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r4 = r3.window
            java.lang.String r4 = r4.navigationBarBackgroundColor
        L_0x004f:
            java.lang.String r6 = r1.navigationBarTitleText
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x005a
            java.lang.String r5 = r1.navigationBarTitleText
            goto L_0x006c
        L_0x005a:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            if (r6 == 0) goto L_0x006c
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            java.lang.String r6 = r6.navigationBarTitleText
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x006c
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r5 = r3.window
            java.lang.String r5 = r5.navigationBarTitleText
        L_0x006c:
            java.lang.String r6 = r1.navigationBarTextStyle
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x0077
            java.lang.String r3 = r1.navigationBarTextStyle
            goto L_0x008b
        L_0x0077:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            if (r6 == 0) goto L_0x008a
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            java.lang.String r6 = r6.navigationBarTextStyle
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x008a
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r3 = r3.window
            java.lang.String r3 = r3.navigationBarTextStyle
            goto L_0x008b
        L_0x008a:
            r3 = r8
        L_0x008b:
            java.lang.String r1 = r1.navigationStyle
            java.lang.String r6 = "custom"
            boolean r1 = android.text.TextUtils.equals(r1, r6)
            if (r1 == 0) goto L_0x0099
            r1 = 8
            goto L_0x009a
        L_0x0098:
            r3 = r8
        L_0x0099:
            r1 = 0
        L_0x009a:
            r6 = 1
            java.lang.String r9 = "dark"
            if (r1 != r7) goto L_0x00b5
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f17001g
            r1.setVisibility(r7)
            boolean r1 = r3.equals(r8)
            if (r1 != 0) goto L_0x00b0
            boolean r1 = r3.equals(r9)
            if (r1 == 0) goto L_0x00b1
        L_0x00b0:
            r2 = 1
        L_0x00b1:
            r10.setStatusBarDarkStyle(r2)
            goto L_0x011a
        L_0x00b5:
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f17001g
            r1.setVisibility(r2)
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f17001g
            r1.setTitle((java.lang.String) r5)
            boolean r1 = r3.equals(r8)
            if (r1 != 0) goto L_0x00cb
            boolean r1 = r3.equals(r9)
            if (r1 == 0) goto L_0x00cc
        L_0x00cb:
            r2 = 1
        L_0x00cc:
            r10.setStatusBarDarkStyle(r2)
            boolean r1 = r3.equals(r8)
            if (r1 != 0) goto L_0x00e8
            boolean r1 = r3.equals(r9)
            if (r1 == 0) goto L_0x00dc
            goto L_0x00e8
        L_0x00dc:
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f17001g
            java.lang.String r2 = "#ffffff"
            int r2 = android.graphics.Color.parseColor(r2)
            r1.setTitleBackgroundColor(r2)
            goto L_0x00f3
        L_0x00e8:
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f17001g
            java.lang.String r2 = "#000000"
            int r2 = android.graphics.Color.parseColor(r2)
            r1.setTitleBackgroundColor(r2)
        L_0x00f3:
            android.view.View r1 = r10.f17002h
            java.lang.String r2 = com.didi.dimina.container.util.ColorUtil.convert3To6(r4)
            int r2 = android.graphics.Color.parseColor(r2)
            r1.setBackgroundColor(r2)
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f17001g
            java.lang.String r2 = com.didi.dimina.container.util.ColorUtil.convert3To6(r4)
            int r2 = android.graphics.Color.parseColor(r2)
            r1.setBackgroundColor(r2)
            android.view.View r1 = r10.f17002h
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            r1.height = r0
            android.view.View r2 = r10.f17002h
            r2.setLayoutParams(r1)
        L_0x011a:
            android.view.View r1 = r10.f17003i
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            int r2 = r1.topMargin
            int r2 = r2 + r0
            r1.topMargin = r2
            android.view.View r0 = r10.f17003i
            r0.setLayoutParams(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.page.DMPage.m12531e():void");
    }

    /* renamed from: f */
    private void m12532f() {
        if (!this.f16991C.booleanValue()) {
            this.f16991C = true;
            LayoutInflater.from(getContext()).inflate(R.layout.dimina_webview_page, this, true);
            this.f17004j = (DMWebViewContainer) findViewById(R.id.webview_container);
            this.f17003i = findViewById(R.id.capsule_button);
            this.f16997c = (FrameLayout) findViewById(R.id.page_container);
            this.f17001g = (WebTitleBar) findViewById(R.id.title_bar);
            this.f17002h = findViewById(R.id.status_bar);
        }
    }

    /* renamed from: a */
    private void m12524a(DMMina dMMina, String str) {
        this.f17000f = dMMina.genWebViewId();
        TraceUtil.trackEventCoreDotting(dMMina.getMinaIndex(), Constant.CORE_DOTTING.PAGE_PRELOAD_WEB_VIEW, mo55242a().with("url", str).toInfo());
        m12532f();
        this.f17004j.syncData(this, dMMina, this.f17005k);
        if (!TextUtils.isEmpty(str)) {
            this.f17004j.loadUrl(str);
        }
        int minaIndex = dMMina.getMinaIndex();
        int i = this.f16994F == 0 ? 0 : 1;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f16994F;
        if (j == 0) {
            j = this.f16995G;
        }
        TraceUtil.trackPreloadWebview(minaIndex, i, currentTimeMillis - j);
    }

    public void showNavigationBar(boolean z) {
        if (this.f17007m != NavigationBarStatus.VISIBLE && this.f17007m != NavigationBarStatus.SCROLLING_DOWN) {
            long j = z ? 200 : 0;
            ObjectAnimator objectAnimator = this.hideAnimation;
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                this.showAnimation = ObjectAnimator.ofFloat(this, "translationY", new float[]{(float) (-this.f17001g.getHeight()), 0.0f});
            } else {
                this.showAnimation = ObjectAnimator.ofFloat(this, "translationY", new float[]{-this.f17008n, 0.0f});
                this.hideAnimation.cancel();
            }
            this.showAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedValue() instanceof Float) {
                        float unused = DMPage.this.f17008n = Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        if (Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue()) == ((float) DMPage.this.f17001g.getHeight())) {
                            NavigationBarStatus unused2 = DMPage.this.f17007m = NavigationBarStatus.VISIBLE;
                        } else {
                            NavigationBarStatus unused3 = DMPage.this.f17007m = NavigationBarStatus.SCROLLING_DOWN;
                        }
                    }
                }
            });
            this.showAnimation.setDuration(j);
            this.showAnimation.start();
        }
    }

    public void hideNavigationBar(boolean z) {
        if (this.f17007m != NavigationBarStatus.GONE && this.f17007m != NavigationBarStatus.SCROLLING_UP) {
            long j = z ? 200 : 0;
            ObjectAnimator objectAnimator = this.showAnimation;
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                this.hideAnimation = ObjectAnimator.ofFloat(this, "translationY", new float[]{0.0f, (float) (-this.f17001g.getHeight())});
            } else {
                this.hideAnimation = ObjectAnimator.ofFloat(this, "translationY", new float[]{-this.f17008n, (float) (-this.f17001g.getHeight())});
                this.showAnimation.cancel();
            }
            this.hideAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedValue() instanceof Float) {
                        float unused = DMPage.this.f17008n = Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        if (Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue()) == ((float) DMPage.this.f17001g.getHeight())) {
                            NavigationBarStatus unused2 = DMPage.this.f17007m = NavigationBarStatus.GONE;
                        } else {
                            NavigationBarStatus unused3 = DMPage.this.f17007m = NavigationBarStatus.SCROLLING_UP;
                        }
                    }
                }
            });
            this.hideAnimation.setDuration(j);
            this.hideAnimation.start();
        }
    }

    public void registerHiddenChangedListener(DMPageLifecycleListener dMPageLifecycleListener) {
        if (!this.f16993E.contains(dMPageLifecycleListener)) {
            this.f16993E.add(dMPageLifecycleListener);
        }
    }

    public void unregisterHiddenChangedListener(DMPageLifecycleListener dMPageLifecycleListener) {
        this.f16993E.remove(dMPageLifecycleListener);
    }

    public void setTitleBackClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f17001g.setOnBackClickListener(onClickListener);
        }
    }

    public boolean canSwipeBack() {
        if (InternalJSMethod.SWITCH_TAB.equals(this.f16998d.openType) || CollectionsUtil.isEmpty((Collection) this.f17005k.getCurrentPages()) || !this.f16999e.getConfig().getUIConfig().canSwipeBack()) {
            return false;
        }
        JSAppConfig.PageConfig pageConfig = this.f16999e.getJSAppConfig().getPageConfig(this.f16998d.url);
        if (pageConfig == null || !TextUtils.equals(pageConfig.type, "map")) {
            return true;
        }
        return false;
    }

    public Fragment getHost() {
        return this.f17009o;
    }

    public DMMina getDMMina() {
        return this.f16999e;
    }

    public DMMinaNavigatorDelegate getNavigator() {
        return this.f17005k;
    }

    public JSAppConfig.DidiPageFrameItem getPageFrameConfig() {
        return this.f17018y;
    }

    public void setPageFrameConfig(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        this.f17018y = didiPageFrameItem;
    }

    public void setRenderFinish() {
        this.f17016w = -1;
    }

    public void setCheckBlankScreenManager(CheckBlankScreenManager checkBlankScreenManager) {
        this.f16992D = checkBlankScreenManager;
    }

    public CheckBlankScreenManager getCheckBlankScreenManager() {
        return this.f16992D;
    }

    public boolean isH5Page() {
        return this.f17012s;
    }

    public boolean isDestroyed() {
        return this.f17014u;
    }

    public boolean isDomReady() {
        return this.f17015v;
    }

    public void setH5Page(boolean z) {
        this.f17012s = z;
    }

    public void setH5WebViewContainer(DMWebViewContainer dMWebViewContainer) {
        this.f17013t = dMWebViewContainer;
    }

    public boolean tryH5GoBack() {
        DMWebViewContainer dMWebViewContainer = this.f17013t;
        if (dMWebViewContainer == null || dMWebViewContainer.getWebView() == null) {
            return false;
        }
        return this.f17013t.getWebView().tryH5GoBack();
    }

    public void setStatusBarDarkStyle(boolean z) {
        if (this.f17009o.getActivity() != null) {
            ImmersionBar with = ImmersionBar.with(this.f17009o);
            with.navigationBarEnable(false).keyboardEnable(true);
            if (ImmersionBar.isSupportStatusBarDarkFont()) {
                with.statusBarDarkFont(z);
                this.f16989A = new Boolean(z);
            }
            with.setOnKeyboardListener(new OnKeyboardListener() {
                public void onKeyboardChange(boolean z, int i, int i2) {
                    if (!z) {
                        DMPage.this.getWebViewContainer().getTouchInterceptFrameLayout().setTranslationY(0.0f);
                    } else if (KeyboardUtils.focusedComponentY > i2 - i) {
                        DMPage.this.getWebViewContainer().getTouchInterceptFrameLayout().setTranslationY((float) (((-KeyboardUtils.focusedComponentY) - i) + i2));
                    }
                }
            });
            with.init();
        }
    }
}
