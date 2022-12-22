package com.didi.dimina.container.page;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bean.NavigateConfig;
import com.didi.dimina.container.bridge.blankscreen.CheckBlankScreenManager;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.p106ui.swipeback.SwipeBackFragment;
import com.didi.dimina.container.p106ui.swipeback.SwipeBackLayout;
import com.didi.dimina.container.p106ui.webview.FileChooserOpener;
import com.didi.dimina.container.p106ui.webview.FileChooserParams;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.KeyboardUtils;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.taxis99.R;
import org.json.JSONObject;

public class DMFragment extends SwipeBackFragment implements KeyEvent.Callback, IPageHost, FileChooserOpener {
    public static final String ARG_MINA_INDEX = "mina_index";
    public static final String ARG_STACK_INDEX = "stack_index";
    public static final String ARG_WEB_VIEW_FRAGMENT_URL = "arg_web_view_fragment_url";
    public static final String TAG_DM_FRAGMENT = "DMFragment";
    public static final String TAG_PAGE_FRAME = "PAGE_FRAME";

    /* renamed from: c */
    private static final int f16967c = 233;

    /* renamed from: a */
    SwipeBackLayout.OnSwipeListener f16968a = new SwipeBackLayout.OnSwipeListener() {
        public void onDragScrolled(float f) {
        }

        public void onDragStateChange(int i) {
        }

        public void onEdgeTouch(int i) {
        }

        public void onPageFinish() {
            if (DMFragment.this.getView() != null) {
                DMFragment.this.getView().post(new Runnable() {
                    public void run() {
                        DMFragment.this.doPopBack();
                    }
                });
            }
        }
    };

    /* renamed from: d */
    private DMMina f16969d;

    /* renamed from: e */
    private DMPage f16970e;

    /* renamed from: f */
    private DMMinaNavigatorDelegate f16971f;

    /* renamed from: g */
    private int f16972g;

    /* renamed from: h */
    private int f16973h;

    /* renamed from: i */
    private NavigateConfig f16974i;

    /* renamed from: j */
    private boolean f16975j = false;

    /* renamed from: k */
    private IPageHost.OnPageHostBackListener f16976k;

    /* renamed from: l */
    private long f16977l = -1;

    /* renamed from: m */
    private long f16978m = -1;

    /* renamed from: n */
    private long f16979n = -1;

    /* renamed from: o */
    private boolean f16980o = true;
    protected OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
        public void handleOnBackPressed() {
            DMFragment.this.handleOnBackPressed(this);
        }
    };

    /* renamed from: p */
    private WebViewEngine.WebViewEngineValueCallback<Uri[]> f16981p;

    /* renamed from: q */
    private FileChooserParams f16982q;

    public Fragment getPageHost() {
        return this;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    public /* synthetic */ void switchTabLoadJSFileToDataThreadFinish(JSONObject jSONObject) {
        IPageHost.CC.$default$switchTabLoadJSFileToDataThreadFinish(this, jSONObject);
    }

    public static IPageHost newInstance(int i, int i2, NavigateConfig navigateConfig) {
        if (DMTabBarPageHostFragment.m12558a(i, i2, navigateConfig)) {
            return DMTabBarPageHostFragment.m12559b(i, i2, navigateConfig);
        }
        return newPageFragment(i, i2, navigateConfig);
    }

    protected static IPageHost newPageFragment(int i, int i2, NavigateConfig navigateConfig) {
        DMFragment dMFragment = new DMFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mina_index", i);
        bundle.putInt(ARG_STACK_INDEX, i2);
        bundle.putSerializable("arg_web_view_fragment_url", navigateConfig);
        dMFragment.setArguments(bundle);
        return dMFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            LogUtil.eRelease(TAG_DM_FRAGMENT, "onCreate() argument == null");
        }
        if (arguments != null) {
            this.f16972g = arguments.getInt("mina_index", -1);
            this.f16973h = arguments.getInt(ARG_STACK_INDEX, -1);
            LogUtil.iRelease(TAG_DM_FRAGMENT, "mMinaIndex = " + this.f16972g);
            DMMina dMMina = DMMinaPool.get(this.f16972g);
            this.f16969d = dMMina;
            if (dMMina == null) {
                LogUtil.iRelease(TAG_DM_FRAGMENT, "mDMMina=null, 结束掉页面");
                getActivity().finish();
                return;
            }
            this.f16979n = System.currentTimeMillis();
            this.f16971f = this.f16969d.getNavigator(this.f16973h);
            this.f16974i = (NavigateConfig) arguments.getSerializable("arg_web_view_fragment_url");
            TraceUtil.trackOpenPageStart(this.f16969d.getMinaIndex(), m12516a());
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getOnBackPressedDispatcher().addCallback(this, this.onBackPressedCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void handleOnBackPressed(OnBackPressedCallback onBackPressedCallback2) {
        LogUtil.iRelease(TAG_DM_FRAGMENT, "handleOnBackPressed()");
        if (this.f16970e != null) {
            onBackPressed();
            return;
        }
        onBackPressedCallback2.remove();
        onBackPressedCallback2.setEnabled(false);
    }

    public void setOnBackPressedCallbackEnable(boolean z) {
        OnBackPressedCallback onBackPressedCallback2 = this.onBackPressedCallback;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.setEnabled(z);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogUtil.iRelease(TAG_DM_FRAGMENT, "onCreateView()");
        this.f16978m = TimeUtil.currentNanoMillis();
        if (this.f16974i != null) {
            this.f16970e = this.f16969d.getDmPagePool().getReadyDMPage(this.f16974i.url);
        } else {
            this.f16970e = this.f16969d.getDmPagePool().getReadyDMPage("");
        }
        if (this.f16970e == null) {
            LogUtil.iRelease("PAGE_FRAME", "未命中分包及通用缓存项： 开始新建一个通用的模板");
            LogUtil.iRelease(TAG_DM_FRAGMENT, "onCreateView");
            DMPage dMPage = (DMPage) LayoutInflater.from(getContext()).inflate(R.layout.dimina_webview_fragment, viewGroup, false);
            this.f16970e = dMPage;
            dMPage.poolMark = 3;
            this.f16970e.preLoadView(this.f16969d);
            this.f16980o = true;
        }
        this.f16970e.onCreate(this, this.f16972g, this.f16973h, this.f16974i);
        this.f16970e.setTitleBackClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DMFragment.this.onBackPressed();
            }
        });
        getSwipeBackLayout().addSwipeListener(this.f16968a);
        if (this.f16970e.canSwipeBack()) {
            setSwipeBackEnable(true);
            return attachToSwipeBack(this.f16970e);
        }
        setSwipeBackEnable(false);
        return this.f16970e;
    }

    public void onResume() {
        super.onResume();
        LogUtil.iRelease(TAG_DM_FRAGMENT, "onResume");
        DMPage dMPage = this.f16970e;
        if (dMPage != null) {
            dMPage.onShow();
        }
    }

    public void onPause() {
        super.onPause();
        LogUtil.iRelease(TAG_DM_FRAGMENT, "onPause");
        DMPage dMPage = this.f16970e;
        if (dMPage != null) {
            dMPage.onHide();
            CheckBlankScreenManager checkBlankScreenManager = this.f16970e.getCheckBlankScreenManager();
            if (checkBlankScreenManager != null) {
                checkBlankScreenManager.stop();
            }
        }
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        LogUtil.iRelease(TAG_DM_FRAGMENT, "onHiddenChanged");
        DMPage dMPage = this.f16970e;
        if (dMPage == null) {
            return;
        }
        if (z) {
            dMPage.onHide();
        } else {
            dMPage.onShow();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.iRelease(TAG_DM_FRAGMENT, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
        getSwipeBackLayout().removeSwipeListener(this.f16968a);
        if (getActivity() != null && !getActivity().isFinishing() && KeyboardUtils.isSoftInputVisible(getActivity())) {
            KeyboardUtils.hideSoftInput((Activity) getActivity());
        }
        DMPage dMPage = this.f16970e;
        if (dMPage != null) {
            dMPage.onDestroy();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        LogUtil.iRelease(TAG_DM_FRAGMENT, "onBackPressed()");
        onBackPressed();
        return true;
    }

    public DMPage getPage() {
        return this.f16970e;
    }

    public void invokeDomReady() {
        this.f16970e.onDomReady();
        this.f16977l = TimeUtil.currentNanoMillis();
        TraceUtil.trackOpenPageEnd(this.f16969d.getMinaIndex(), m12516a(), this.f16980o, Long.valueOf(System.currentTimeMillis() - this.f16979n));
    }

    public void enableAlertBeforeUnload(IPageHost.OnPageHostBackListener onPageHostBackListener) {
        this.f16976k = onPageHostBackListener;
        this.f16975j = true;
    }

    public void disableAlertBeforeUnload() {
        this.f16975j = false;
    }

    public void onBackPressed() {
        IPageHost.OnPageHostBackListener onPageHostBackListener;
        DMPage dMPage = this.f16970e;
        if (dMPage == null) {
            LogUtil.iRelease(TAG_DM_FRAGMENT, "onBackPressed mDMPage is null");
        } else if (dMPage.isDomReady() || TimeUtil.currentNanoMillis() - this.f16978m >= 5000) {
            CheckBlankScreenManager checkBlankScreenManager = this.f16970e.getCheckBlankScreenManager();
            if (checkBlankScreenManager != null && checkBlankScreenManager.isCheckingBlank()) {
                LogUtil.iRelease(TAG_DM_FRAGMENT, "onBackPressed CheckBlankScreenManager isRunningTaskInBackground");
            } else if (this.f16970e.isDomReady() && TimeUtil.currentNanoMillis() - this.f16977l < 200) {
                LogUtil.iRelease(TAG_DM_FRAGMENT, "onBackPressed dom ready 200ms can deal with back pressed");
            } else if (!this.f16975j || (onPageHostBackListener = this.f16976k) == null) {
                onBackPressedInner();
            } else {
                onPageHostBackListener.OnBack();
            }
        } else {
            LogUtil.iRelease(TAG_DM_FRAGMENT, "onBackPressed onBackPressed when dmPage not domReady");
        }
    }

    public void onBackPressedInner() {
        if (!this.f16970e.tryH5GoBack()) {
            CheckBlankScreenManager checkBlankScreenManager = this.f16970e.getCheckBlankScreenManager();
            if (checkBlankScreenManager != null) {
                checkBlankScreenManager.stop();
            }
            if (this.f16971f.getCurrentPages().size() == 1) {
                doPopBack();
                return;
            }
            this.f16970e.getWebViewContainer().getTouchInterceptFrameLayout().setInterceptEnabled(true);
            setSwipeBackEnable(false);
            getSwipeBackLayout().postBack();
        }
    }

    public void doPopBack() {
        this.f16971f.navigateBack(this.f16972g, this.f16973h, 1);
        syncWebViewInfo();
    }

    public void syncWebViewInfo() {
        IPageHost currentPage = this.f16971f.getCurrentPage();
        if (currentPage != null && currentPage.getPage() != null) {
            DMPage page = currentPage.getPage();
            this.f16970e.poolMark = 4;
            JSONObject build = new MessageWrapperBuilder().stackId(this.f16971f.getIndex()).webViewId(page.getWebViewId()).build();
            this.f16969d.getMessageTransfer().sendMessageToServiceFromNative("navigateBackNative", build);
            int minaIndex = this.f16969d.getMinaIndex();
            TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.NAVIGATE_NAVIGATE_BACK_NATIVE, "msg: " + build);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        WebViewEngine.WebViewEngineValueCallback<Uri[]> webViewEngineValueCallback;
        Uri[] uriArr;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 233 && this.f16981p != null) {
                FileChooserParams fileChooserParams = this.f16982q;
                if (fileChooserParams == null) {
                    uriArr = FileChooserParams.parseResult(i2, intent);
                } else {
                    uriArr = fileChooserParams.getResult(i2, intent);
                }
                this.f16981p.onReceiveValue(uriArr);
                this.f16981p = null;
            }
        } else if (i == 233 && (webViewEngineValueCallback = this.f16981p) != null) {
            webViewEngineValueCallback.onReceiveValue(null);
            this.f16981p = null;
        }
    }

    public void openFileChooser(WebViewEngine.WebViewEngineValueCallback<Uri[]> webViewEngineValueCallback, FileChooserParams fileChooserParams) {
        this.f16981p = webViewEngineValueCallback;
        this.f16982q = fileChooserParams;
        try {
            startActivityForResult(fileChooserParams.createIntent(), 233);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private String m12516a() {
        NavigateConfig navigateConfig = this.f16974i;
        return navigateConfig != null ? HttpUtil.splitPath(navigateConfig.url) : "";
    }
}
