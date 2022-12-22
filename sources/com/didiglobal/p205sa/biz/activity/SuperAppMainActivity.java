package com.didiglobal.p205sa.biz.activity;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.compatible.old.topbar.OneConfManager;
import com.didi.app.SchemeDispatcherImpl;
import com.didi.app.router.PageRouter;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.core.IPresenter;
import com.didi.drouter.api.DRouter;
import com.didi.flutter.nacho.Nacho;
import com.didi.global.flutter.linker.FlutterApplicationDelegate;
import com.didi.map.global.flow.MapFlowView;
import com.didi.map.global.flow.presenter.IMapFlowPresenter;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.mainpage.ICarMainPageController;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BaseMainActivity;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextHelper;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.app.DidiBroadcastReceiverImpl;
import com.didi.sdk.app.IBizNavBarDelegate;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.app.IStatusBar;
import com.didi.sdk.app.IStatusBarDelegate;
import com.didi.sdk.app.ITitleBarDelegate;
import com.didi.sdk.app.MainActivityIntentFilter;
import com.didi.sdk.app.OnBackResultListener;
import com.didi.sdk.app.SuperAppBroadcastSender;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.app.business.BusinessInitCallback;
import com.didi.sdk.app.business.ISABusiness;
import com.didi.sdk.app.business.SaTabIds;
import com.didi.sdk.common.TaskScheduler;
import com.didi.sdk.config.GlobalConfigCenter;
import com.didi.sdk.events.OpenSideBarPageEvent;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.sdk.log.Logger;
import com.didi.sdk.logtime.DiDiLaunchingLogTimer;
import com.didi.sdk.logtime.DiDiLogLaunchTimer;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.map.MapFragment;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.SideBarInitialization;
import com.didi.sdk.sidebar.data.DataContainer;
import com.didi.sdk.sidebar.fragment.HomeNavDrawerFragment;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.sidebar.templet.AutoLinker;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.ExitUtil;
import com.didi.sdk.util.GuideUtil;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.webview.WebViewModel;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.fragment.SaTabFragment;
import com.didiglobal.p205sa.biz.fragment.SaWebFragment;
import com.didiglobal.p205sa.biz.tab.manager.SATabManager;
import com.didiglobal.p205sa.biz.tab.manager.SaSideBarUiManager;
import com.didiglobal.p205sa.biz.tab.manager.SaTabDataManager;
import com.didiglobal.p205sa.biz.tab.model.SaTabDataModel;
import com.didiglobal.p205sa.biz.util.CloseSideBarEvent;
import com.didiglobal.p205sa.biz.util.MapRedayEvent;
import com.didiglobal.verify.HotPatchVerify;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(mo175977d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u001bH\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0007J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010-\u001a\u00020\u000eH\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020\u001bH\u0016J\b\u00104\u001a\u00020\u001bH\u0002J\b\u00105\u001a\u00020\u001bH\u0016J\b\u00106\u001a\u00020\u001bH\u0016J\u0010\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\tH\u0002J\b\u00109\u001a\u00020\u001bH\u0002J\b\u0010:\u001a\u00020\u001bH\u0002J\b\u0010;\u001a\u00020\u001bH\u0002J\b\u0010<\u001a\u00020\u001bH\u0002J\b\u0010=\u001a\u00020\u001bH\u0002J\b\u0010>\u001a\u00020\u001bH\u0002J\b\u0010?\u001a\u00020\u001bH\u0002J\b\u0010@\u001a\u00020\u001bH\u0002J\b\u0010A\u001a\u00020\u001bH\u0002J\b\u0010B\u001a\u00020\u001bH\u0002J\"\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020/2\b\u0010E\u001a\u0004\u0018\u00010,2\u0006\u00108\u001a\u00020\tH\u0002J\b\u0010F\u001a\u00020\u001bH\u0002J\b\u0010G\u001a\u00020\u001bH\u0016J\"\u0010H\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020*2\b\u0010K\u001a\u0004\u0018\u00010LH\u0014J\u0012\u0010M\u001a\u00020\u001b2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\b\u0010P\u001a\u00020\u001bH\u0014J\u001a\u0010Q\u001a\u00020!2\u0006\u0010R\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010SH\u0016J\u0012\u0010T\u001a\u00020\u001b2\b\u0010U\u001a\u0004\u0018\u00010LH\u0014J\b\u0010V\u001a\u00020\u001bH\u0014J\u0012\u0010W\u001a\u00020\u001b2\b\u0010X\u001a\u0004\u0018\u00010OH\u0016J-\u0010Y\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020*2\u000e\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0[2\u0006\u0010\\\u001a\u00020]H\u0016¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020\u001bH\u0014J\b\u0010`\u001a\u00020\u001bH\u0014J\u0010\u0010a\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020OH\u0014J\u0010\u0010c\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020dH\u0007J\b\u0010e\u001a\u00020\u001bH\u0014J\b\u0010f\u001a\u00020\u001bH\u0014J\u0010\u0010g\u001a\u00020\u001b2\u0006\u0010h\u001a\u00020!H\u0016J\b\u0010i\u001a\u00020\u001bH\u0002J\b\u0010j\u001a\u00020\u001bH\u0002J\b\u0010k\u001a\u00020\u001bH\u0002J\u0010\u0010l\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020mH\u0016J\u0010\u0010n\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020*H\u0016J\b\u0010o\u001a\u00020\u001bH\u0016J\u0010\u0010p\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020*H\u0016J\b\u0010q\u001a\u00020\u001bH\u0016J\b\u0010r\u001a\u00020\u001bH\u0016J\b\u0010s\u001a\u00020\u001bH\u0002J\u0010\u0010t\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020uH\u0007J\u0010\u0010v\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020uH\u0002J\u0010\u0010w\u001a\u00020\u001b2\u0006\u0010x\u001a\u00020!H\u0002J\b\u0010y\u001a\u00020\u001bH\u0002J\b\u0010z\u001a\u00020\u001bH\u0002J\u001a\u0010{\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020*2\b\u0010|\u001a\u0004\u0018\u00010}H\u0016R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006~"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/activity/SuperAppMainActivity;", "Lcom/didi/sdk/app/BaseMainActivity;", "Lcom/didi/sdk/app/ITitleBarDelegate;", "Lcom/didi/sdk/app/IStatusBarDelegate;", "Lcom/didi/sdk/app/IBizNavBarDelegate;", "Lcom/didi/sdk/app/OnBackResultListener;", "()V", "businessCallBackMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "businessContextHelper", "Lcom/didi/sdk/app/BusinessContextHelper;", "drawerFragment", "Lcom/didi/sdk/sidebar/fragment/HomeNavDrawerFragment;", "mainIntentSet", "Ljava/util/HashSet;", "Lcom/didi/sdk/app/MainActivityIntentFilter;", "saTabFragment", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment;", "saTabManager", "Lcom/didiglobal/sa/biz/tab/manager/SATabManager;", "saTabSideBarUiManager", "Lcom/didiglobal/sa/biz/tab/manager/SaSideBarUiManager;", "statusBarPlaceHolder", "Landroid/view/View;", "addViewToRightRegion", "", "p0", "adjustBusinessFragmentStack", "loadFragmentName", "changeStatusBar", "needStatusBar", "", "changedStatusBar", "isFull", "checkDRouterUrl", "closeSideBar", "event", "Lcom/didiglobal/sa/biz/util/CloseSideBarEvent;", "fetchUserInfo", "getBizBarHeight", "", "getCommonBusinessContext", "Lcom/didi/sdk/app/BusinessContext;", "getDrawerFragment", "getHomeBizNarFragment", "Landroidx/fragment/app/Fragment;", "getTitleBarFragment", "getTopBusiness", "hideBizBar", "hideBizBarDivider", "hideSaFragment", "hideTitleBar", "hideTitleBarRightBtn", "initBusinessCallBack", "groupType", "initBusinessContextHelper", "initDrawer", "initFlutterEngine", "initLaunchLogTimer", "initListener", "initManager", "initSideBar", "initStatusBar", "initView", "initWindowAttr", "loadFragment", "fragment", "businessContext", "loadSuperAppFragment", "mapCallBack", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyUp", "keyCode", "Landroid/view/KeyEvent;", "onNewIntent", "intent", "onPause", "onPopBackToHome", "bundle", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeFragments", "onSaveInstanceState", "outState", "onSideBarPageRequested", "Lcom/didi/sdk/events/OpenSideBarPageEvent;", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "preInitMap", "registerListener", "requestLocation", "resetTitleBarAlpha", "", "resetTitleBarYPosition", "restoreTitleBar", "setBizBarBackgroundColor", "showBizBar", "showBizBarDivider", "showSaFragment", "switch", "Lcom/didi/sdk/events/SwitchTypeEvent;", "switchBusiness", "trackBusinessSwitch", "isBack", "unregisterListener", "updateStatusBar", "updateTitleBarLeftBtn", "p1", "Landroid/view/View$OnClickListener;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.activity.SuperAppMainActivity */
/* compiled from: SuperAppMainActivity.kt */
public final class SuperAppMainActivity extends BaseMainActivity implements IBizNavBarDelegate, IStatusBarDelegate, ITitleBarDelegate, OnBackResultListener {

    /* renamed from: b */
    private HomeNavDrawerFragment f50720b;

    /* renamed from: c */
    private BusinessContextHelper f50721c;

    /* renamed from: d */
    private HashMap<String, String> f50722d = new HashMap<>();

    /* renamed from: e */
    private View f50723e;

    /* renamed from: f */
    private SaTabFragment f50724f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SATabManager f50725g;

    /* renamed from: h */
    private SaSideBarUiManager f50726h;

    /* renamed from: i */
    private final HashSet<MainActivityIntentFilter> f50727i = new HashSet<>();

    public void addViewToRightRegion(View view) {
    }

    public int getBizBarHeight() {
        return 0;
    }

    public Fragment getHomeBizNarFragment() {
        return null;
    }

    public void hideBizBar() {
    }

    public void hideBizBarDivider() {
    }

    public void hideTitleBar() {
    }

    public void hideTitleBarRightBtn() {
    }

    public void onPopBackToHome(Bundle bundle) {
    }

    public void resetTitleBarAlpha(float f) {
    }

    public void resetTitleBarYPosition(int i) {
    }

    public void restoreTitleBar() {
    }

    public void setBizBarBackgroundColor(int i) {
    }

    public void showBizBar() {
    }

    public void showBizBarDivider() {
    }

    public void updateTitleBarLeftBtn(int i, View.OnClickListener onClickListener) {
    }

    /* renamed from: a */
    private final void m36398a() {
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m36421p();
        super.onCreate(bundle);
        m36398a();
        setContentView((int) R.layout.activity_super_app_main);
        m36414i();
        m36404b();
        m36415j();
        m36408c();
        m36417l();
        m36418m();
        m36419n();
        m36422q();
        m36411f();
        m36425t();
        m36423r();
        m36427v();
    }

    /* renamed from: b */
    private final void m36404b() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        SaTabFragment saTabFragment = this.f50724f;
        Intrinsics.checkNotNull(saTabFragment);
        View findViewById = findViewById(R.id.super_app_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ViewGroup>(R.id.super_app_container)");
        SATabManager sATabManager = new SATabManager(supportFragmentManager, R.id.super_app_container, saTabFragment, (ViewGroup) findViewById);
        this.f50725g = sATabManager;
        if (sATabManager != null) {
            sATabManager.setAndUpdateData(SaTabDataManager.getTabData$default(SaTabDataManager.INSTANCE, SaTabIds.TAB_HOME.getId(), (SaTabDataModel) null, 2, (Object) null));
        }
        SATabManager sATabManager2 = this.f50725g;
        if (sATabManager2 != null) {
            sATabManager2.setDefault();
        }
    }

    /* renamed from: c */
    private final void m36408c() {
        LocationPerformer.getInstance().start(this);
    }

    /* renamed from: d */
    private final String m36409d() {
        Bundle arguments;
        String string;
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount <= 0 || 1 > backStackEntryCount) {
            return "sa_home";
        }
        while (true) {
            int i = backStackEntryCount - 1;
            String name = getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount - 1).getName();
            if (!TextUtil.isEmpty(name)) {
                Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(name);
                String str = "";
                if (!(findFragmentByTag == null || (arguments = findFragmentByTag.getArguments()) == null || (string = arguments.getString(SuperAppBusinessManager.KEY_SA_SELECT_TYPE)) == null)) {
                    str = string;
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
            if (1 > i) {
                return "sa_home";
            }
            backStackEntryCount = i;
        }
    }

    /* renamed from: e */
    private final void m36410e() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            String name = getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount - 1).getName();
            if (!TextUtil.isEmpty(name)) {
                Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(name);
                if (findFragmentByTag instanceof IStatusBar) {
                    m36403a(((IStatusBar) findFragmentByTag).showStatusBar());
                } else {
                    m36403a(false);
                }
            }
        }
    }

    /* renamed from: f */
    private final void m36411f() {
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            public final void onBackStackChanged() {
                SuperAppMainActivity.m36401a(SuperAppMainActivity.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36401a(SuperAppMainActivity superAppMainActivity) {
        Intrinsics.checkNotNullParameter(superAppMainActivity, "this$0");
        superAppMainActivity.m36410e();
        SuperAppBusinessManager.INSTANCE.setCurrentBusiness(superAppMainActivity.m36409d());
        SuperAppBusinessManager.INSTANCE.update();
        if (superAppMainActivity.getSupportFragmentManager().getBackStackEntryCount() < 1) {
            superAppMainActivity.m36407b(true);
            superAppMainActivity.m36412g();
            return;
        }
        superAppMainActivity.m36413h();
    }

    /* renamed from: g */
    private final void m36412g() {
        SATabManager sATabManager = this.f50725g;
        if (sATabManager != null) {
            sATabManager.showFragment();
        }
    }

    /* renamed from: h */
    private final void m36413h() {
        SATabManager sATabManager = this.f50725g;
        if (sATabManager != null) {
            sATabManager.hideFragment();
        }
    }

    /* renamed from: i */
    private final void m36414i() {
        this.mMapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.home_map_fragment);
        this.f50723e = findViewById(R.id.statusBarPlaceHolder);
        SaTabFragment saTabFragment = new SaTabFragment();
        this.f50724f = saTabFragment;
        if (saTabFragment != null) {
            saTabFragment.setRefreshTabNotification(new SuperAppMainActivity$initView$1(this));
        }
        SaTabFragment saTabFragment2 = this.f50724f;
        if (saTabFragment2 != null) {
            saTabFragment2.setOnTabItemClickListener(new SuperAppMainActivity$initView$2(this));
        }
    }

    /* renamed from: a */
    private final void m36403a(boolean z) {
        View view = this.f50723e;
        ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
        if (z) {
            if (layoutParams != null) {
                layoutParams.height = AppUtils.getStatusBarHeight(this);
            }
        } else if (layoutParams != null) {
            layoutParams.height = 0;
        }
        View view2 = this.f50723e;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: j */
    private final void m36415j() {
        EventBus.getDefault().register(this);
    }

    /* renamed from: k */
    private final void m36416k() {
        EventBus.getDefault().unregister(this);
    }

    /* renamed from: l */
    private final void m36417l() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, 0);
    }

    /* renamed from: m */
    private final void m36418m() {
        BusinessContextHelper businessContextHelper = new BusinessContextHelper(this, this, this, this, BusinessContext.class, R.id.fragment_container, IPresenter.templateMapping);
        this.f50721c = businessContextHelper;
        Intrinsics.checkNotNull(businessContextHelper);
        businessContextHelper.setOnBackResultListener(this);
        BusinessContextHelper businessContextHelper2 = this.f50721c;
        Intrinsics.checkNotNull(businessContextHelper2);
        businessContextHelper2.registerStaticReceivers(DidiBroadcastReceiverImpl.class);
    }

    /* renamed from: n */
    private final void m36419n() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        if (findFragmentById != null) {
            this.f50720b = (HomeNavDrawerFragment) findFragmentById;
            View findViewById = findViewById(R.id.drawer_layout);
            if (findViewById != null) {
                BusinessContext o = m36420o();
                this.f50726h = new SaSideBarUiManager(this.f50720b, getSupportFragmentManager(), (DrawerLayout) findViewById, o);
                SuperAppBusinessManager.INSTANCE.setCommonBusinessContext(o);
                SuperAppBusinessManager.INSTANCE.setBusinessContext(o);
                PageRouter.getInstance().setBusinessContext(o);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.drawerlayout.widget.DrawerLayout");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.sdk.sidebar.fragment.HomeNavDrawerFragment");
    }

    /* renamed from: o */
    private final BusinessContext m36420o() {
        BusinessContextHelper businessContextHelper = this.f50721c;
        MapFlowView mapFlowView = null;
        BusinessContext businessContext = businessContextHelper == null ? null : (BusinessContext) businessContextHelper.getBusinessContext("sa_home", BusinessContext.class);
        if (businessContext != null) {
            businessContext.setCountryInfo(ConfProxy.getInstance().getCountryInfo());
        }
        if (businessContext != null) {
            MapFragment mapFragment = this.mMapFragment;
            if (mapFragment != null) {
                mapFlowView = mapFragment.getmMapFlowView();
            }
            businessContext.setMapFlowView(mapFlowView);
        }
        if (businessContext != null) {
            businessContext.setBusinessGroupType("sa_home");
        }
        return businessContext;
    }

    /* renamed from: p */
    private final void m36421p() {
        DiDiLaunchingLogTimer.get().methodStart(DiDiLogLaunchTimer.KEY_TIME_MAINLAUNCH);
        DiDiLaunchingLogTimer.get().stampCreate();
        Application application = getApplication();
        if (application instanceof DIDIBaseApplication) {
            DiDiLaunchingLogTimer.get().setHotLaunch(((DIDIBaseApplication) application).isHotLaunch());
        }
    }

    /* renamed from: q */
    private final void m36422q() {
        String locCountry = NationTypeUtil.getNationComponentData().getLocCountry();
        String gLang = NationTypeUtil.getNationComponentData().getGLang();
        GlobalConfigCenter.getConfigCenter().loadConfig(getApplicationContext(), locCountry);
        DataContainer.getInstance().initData(getApplicationContext(), gLang);
        SideBarInitialization.init();
        m36424s();
        initPush();
        initNetDetect();
        startAppUpdateCheck();
        HotPatchVerify.init(getApplication());
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        BusinessContextHelper businessContextHelper = this.f50721c;
        if (businessContextHelper != null) {
            businessContextHelper.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x003a A[LOOP:1: B:7:0x003a->B:10:0x004f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNewIntent(android.content.Intent r5) {
        /*
            r4 = this;
            super.onNewIntent(r5)
            java.util.HashSet<com.didi.sdk.app.MainActivityIntentFilter> r0 = r4.f50727i
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0034
            java.lang.Class<com.didi.sdk.app.MainActivityIntentFilter> r0 = com.didi.sdk.app.MainActivityIntentFilter.class
            com.didichuxing.foundation.spi.ServiceLoader r0 = com.didichuxing.foundation.spi.ServiceLoader.load(r0)
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = "loader.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L_0x001a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0051
            java.lang.Object r1 = r0.next()
            com.didi.sdk.app.MainActivityIntentFilter r1 = (com.didi.sdk.app.MainActivityIntentFilter) r1
            java.util.HashSet<com.didi.sdk.app.MainActivityIntentFilter> r2 = r4.f50727i
            r2.add(r1)
            r2 = r4
            android.app.Activity r2 = (android.app.Activity) r2
            com.didi.sdk.app.BusinessContextHelper r3 = r4.f50721c
            r1.doFilter(r5, r2, r3)
            goto L_0x001a
        L_0x0034:
            java.util.HashSet<com.didi.sdk.app.MainActivityIntentFilter> r0 = r4.f50727i
            java.util.Iterator r0 = r0.iterator()
        L_0x003a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0051
            java.lang.Object r1 = r0.next()
            com.didi.sdk.app.MainActivityIntentFilter r1 = (com.didi.sdk.app.MainActivityIntentFilter) r1
            r2 = r4
            android.app.Activity r2 = (android.app.Activity) r2
            com.didi.sdk.app.BusinessContextHelper r3 = r4.f50721c
            boolean r1 = r1.doFilter(r5, r2, r3)
            if (r1 == 0) goto L_0x003a
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.activity.SuperAppMainActivity.onNewIntent(android.content.Intent):void");
    }

    /* renamed from: r */
    private final void m36423r() {
        Intent intent = getIntent();
        if (intent != null) {
            String str = null;
            try {
                str = intent.getStringExtra(SchemeDispatcherImpl.PARAM_DROUTER_URL);
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str)) {
                Logger.m25808d(Intrinsics.stringPlus(" checkDrouterUrl,start with drouter url = ", str), new Object[0]);
                intent.putExtra(SchemeDispatcherImpl.PARAM_DROUTER_URL, "");
                DRouter.build(str).start(this);
            }
        }
    }

    /* renamed from: s */
    private final void m36424s() {
        TaskScheduler.getDefault().scheduleUiTask(new Runnable() {
            public final void run() {
                SuperAppMainActivity.m36405b(SuperAppMainActivity.this);
            }
        }, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m36405b(SuperAppMainActivity superAppMainActivity) {
        Intrinsics.checkNotNullParameter(superAppMainActivity, "this$0");
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            UserCenterFacade.getIns().fetchUserInfo(superAppMainActivity.getApplicationContext(), NationTypeUtil.getNationComponentData().getLoginInfo().getToken(), NationTypeUtil.getNationComponentData().getGLang(), (RpcService.Callback<UserInfo>) null);
        }
    }

    /* renamed from: t */
    private final void m36425t() {
        SuperAppBusinessManager.INSTANCE.setCurrentBusiness("sa_home");
        SuperAppBusinessManager.INSTANCE.update();
    }

    public void changedStatusBar(boolean z) {
        m36403a(!z);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    /* renamed from: switch  reason: not valid java name */
    public final void m47049switch(SwitchTypeEvent switchTypeEvent) {
        Intrinsics.checkNotNullParameter(switchTypeEvent, "event");
        m36400a(switchTypeEvent);
    }

    /* renamed from: a */
    private final void m36400a(SwitchTypeEvent switchTypeEvent) {
        String str;
        Fragment fragment;
        MapFlowView mapFlowView;
        IMapFlowPresenter presenter;
        IMapFlowPresenter presenter2;
        Bundle bundle = switchTypeEvent.extraBundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        String common_h5_scheme = SuperAppBusinessManager.INSTANCE.getCOMMON_H5_SCHEME();
        IScene iScene = null;
        if (!TextUtils.isEmpty(switchTypeEvent.scheme)) {
            String str2 = switchTypeEvent.scheme;
            Intrinsics.checkNotNullExpressionValue(str2, "event.scheme");
            if (StringsKt.startsWith$default(str2, common_h5_scheme, false, 2, (Object) null)) {
                if (!TextUtils.isEmpty(switchTypeEvent.type)) {
                    SuperAppBusinessManager superAppBusinessManager = SuperAppBusinessManager.INSTANCE;
                    String str3 = switchTypeEvent.type;
                    Intrinsics.checkNotNullExpressionValue(str3, "event.type");
                    superAppBusinessManager.setCurrentBusiness(str3);
                }
                String queryParameter = Uri.parse(switchTypeEvent.scheme).getQueryParameter("url");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                if (!TextUtil.isEmpty(queryParameter)) {
                    WebViewModel webViewModel = new WebViewModel();
                    webViewModel.isAddCommonParam = true;
                    webViewModel.url = queryParameter;
                    Map<String, Object> hashMap = new HashMap<>();
                    hashMap.put("fullscreen", 1);
                    Unit unit = Unit.INSTANCE;
                    webViewModel.queryParamMap = hashMap;
                    SaWebFragment saWebFragment = new SaWebFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putAll(bundle);
                    bundle2.putSerializable("web_view_model", webViewModel);
                    saWebFragment.setArguments(bundle2);
                    BusinessContext commonBusinessContext = SuperAppBusinessManager.INSTANCE.getCommonBusinessContext();
                    String str4 = switchTypeEvent.type;
                    Intrinsics.checkNotNullExpressionValue(str4, "event.type");
                    m36399a(saWebFragment, commonBusinessContext, str4);
                    m36407b(false);
                    return;
                }
                return;
            }
        }
        String str5 = switchTypeEvent.type;
        BusinessContextHelper businessContextHelper = this.f50721c;
        BusinessContext businessContext = businessContextHelper == null ? null : (BusinessContext) businessContextHelper.getBusinessContext(str5, BusinessContext.class);
        if (businessContext != null) {
            businessContext.setMapFlowView(this.mMapFragment.getmMapFlowView());
        }
        if (TextUtil.isEmpty(switchTypeEvent.scheme)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format(Intrinsics.stringPlus(NationTypeUtil.getNationComponentData().getProductPreFix(), "OneTravel://%s/entrance"), Arrays.copyOf(new Object[]{str5}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        } else {
            str = switchTypeEvent.scheme;
        }
        ISABusiness iSABusiness = (ISABusiness) ServiceLoader.load(ISABusiness.class, str5).get();
        if (iSABusiness == null) {
            fragment = null;
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "scheme");
            fragment = iSABusiness.transitionFragment(str);
        }
        if (fragment != null) {
            MapFlowView mapFlowView2 = this.mMapFragment.getmMapFlowView();
            if (!(mapFlowView2 == null || (presenter2 = mapFlowView2.getPresenter()) == null)) {
                iScene = presenter2.getCurrentScene();
            }
            if (!(((iScene instanceof ICarMainPageController) && Intrinsics.areEqual((Object) str5, (Object) "ride")) || (mapFlowView = this.mMapFragment.getmMapFlowView()) == null || (presenter = mapFlowView.getPresenter()) == null)) {
                presenter.clear();
            }
            SuperAppBusinessManager superAppBusinessManager2 = SuperAppBusinessManager.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(str5, "businessTag");
            superAppBusinessManager2.setCurrentBusiness(str5);
            if (businessContext != null) {
                businessContext.setBusinessGroupType(str5);
            }
            if (businessContext != null) {
                businessContext.setCountryInfo(ConfProxy.getInstance().getCountryInfo());
            }
            if (fragment.getArguments() != null) {
                Bundle arguments = fragment.getArguments();
                Intrinsics.checkNotNull(arguments);
                arguments.putAll(bundle);
            } else {
                fragment.setArguments(bundle);
            }
            SuperAppBusinessManager.INSTANCE.update();
            SuperAppBusinessManager.INSTANCE.setBusinessContext(businessContext);
            PageRouter.getInstance().setBusinessContext(businessContext);
            String name = fragment.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "fragment::class.java.name");
            m36406b(name);
            m36402a(str5);
            m36399a(fragment, businessContext, str5);
            m36407b(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        BusinessContextHelper businessContextHelper = this.f50721c;
        if (businessContextHelper != null) {
            businessContextHelper.onPause();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        super.onResumeFragments();
        BusinessContextHelper businessContextHelper = this.f50721c;
        if (businessContextHelper != null) {
            businessContextHelper.onResume();
        }
    }

    /* renamed from: b */
    private final void m36407b(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "navigation");
        hashMap.put("pre_bizmodule", SuperAppBusinessManager.INSTANCE.getLastBusiness());
        hashMap.put("bizmodule", SuperAppBusinessManager.INSTANCE.getCurrentBusiness());
        OmegaSDKAdapter.trackEvent("ibt_gp_bizmodule_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private final void m36402a(String str) {
        BusinessInitCallback businessInitCallback = (BusinessInitCallback) ServiceLoader.load(BusinessInitCallback.class, str).get();
        if (businessInitCallback != null) {
            if (!this.f50722d.containsKey(str)) {
                this.f50722d.put(str, str);
                businessInitCallback.onSyncInit(this);
            }
            businessInitCallback.onSwitchToBusiness(this, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m36406b(java.lang.String r9) {
        /*
            r8 = this;
            androidx.fragment.app.FragmentManager r0 = r8.getSupportFragmentManager()
            int r0 = r0.getBackStackEntryCount()
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = 1
            if (r3 > r0) goto L_0x004c
        L_0x0014:
            int r4 = r0 + -1
            androidx.fragment.app.FragmentManager r5 = r8.getSupportFragmentManager()
            int r0 = r0 - r3
            androidx.fragment.app.FragmentManager$BackStackEntry r0 = r5.getBackStackEntryAt(r0)
            java.lang.String r0 = r0.getName()
            boolean r5 = com.didi.sdk.util.TextUtil.isEmpty(r0)
            if (r5 == 0) goto L_0x002a
            goto L_0x0047
        L_0x002a:
            androidx.fragment.app.FragmentManager r5 = r8.getSupportFragmentManager()
            androidx.fragment.app.Fragment r5 = r5.findFragmentByTag(r0)
            r6 = 0
            if (r0 != 0) goto L_0x0036
            goto L_0x003e
        L_0x0036:
            r7 = 2
            boolean r7 = kotlin.text.StringsKt.startsWith$default(r0, r9, r6, r7, r2)
            if (r7 != r3) goto L_0x003e
            r6 = 1
        L_0x003e:
            if (r6 == 0) goto L_0x0042
            r2 = r5
            goto L_0x004d
        L_0x0042:
            if (r5 == 0) goto L_0x0047
            r1.add(r5)
        L_0x0047:
            if (r3 <= r4) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r0 = r4
            goto L_0x0014
        L_0x004c:
            r0 = r2
        L_0x004d:
            if (r2 == 0) goto L_0x00ac
            com.didi.sdk.app.BusinessContextManager r9 = com.didi.sdk.app.BusinessContextManager.getInstance()
            com.didi.sdk.app.BaseBusinessContext r9 = r9.getCurBusinessContext()
            com.didi.sdk.app.INavigation r9 = r9.getNavigation()
            r9.popBackStack((java.lang.String) r0, (int) r3)
            int r9 = r1.size()
            if (r9 <= 0) goto L_0x00ac
            if (r3 > r9) goto L_0x00ac
        L_0x0066:
            int r0 = r9 + -1
            int r9 = r9 - r3
            java.lang.Object r9 = r1.get(r9)
            java.lang.String r2 = "cacheFragmentList.get(i - 1)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            androidx.fragment.app.Fragment r9 = (androidx.fragment.app.Fragment) r9
            android.os.Bundle r2 = r9.getArguments()
            java.lang.String r4 = ""
            if (r2 != 0) goto L_0x007d
            goto L_0x008f
        L_0x007d:
            java.lang.String r5 = "sa_select_group_type"
            java.lang.Object r2 = r2.get(r5)
            if (r2 != 0) goto L_0x0087
            goto L_0x008f
        L_0x0087:
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L_0x008e
            goto L_0x008f
        L_0x008e:
            r4 = r2
        L_0x008f:
            boolean r2 = r9 instanceof com.didi.sdk.home.BizEntranceFragment
            if (r2 == 0) goto L_0x009e
            r2 = r9
            com.didi.sdk.home.BizEntranceFragment r2 = (com.didi.sdk.home.BizEntranceFragment) r2
            com.didi.sdk.app.BusinessContext r2 = r2.getBusinessContext()
            r8.m36399a(r9, r2, r4)
            goto L_0x00a7
        L_0x009e:
            com.didi.sdk.app.SuperAppBusinessManager r2 = com.didi.sdk.app.SuperAppBusinessManager.INSTANCE
            com.didi.sdk.app.BusinessContext r2 = r2.getCommonBusinessContext()
            r8.m36399a(r9, r2, r4)
        L_0x00a7:
            if (r3 <= r0) goto L_0x00aa
            goto L_0x00ac
        L_0x00aa:
            r9 = r0
            goto L_0x0066
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.activity.SuperAppMainActivity.m36406b(java.lang.String):void");
    }

    /* renamed from: a */
    private final void m36399a(Fragment fragment, BusinessContext businessContext, String str) {
        Intent intent = new Intent();
        intent.setClass(this, fragment.getClass());
        INavigation.TransactionAnimation transactionAnimation = new INavigation.TransactionAnimation(0, 0, 0, 0);
        intent.putExtra(INavigation.BUNDLE_KEY_SET_REORDERING_ALLOWED, true);
        intent.putExtra(INavigation.BUNDLE_KEY_MAP_NEED, true);
        intent.putExtra(INavigation.BUNDLE_KEY_ALLOW_COVER_PAGE, true);
        intent.putExtra(INavigation.BUNDLE_KEY_FRAGMENT_NAME, fragment.getClass().getName());
        intent.putExtra(SuperAppBusinessManager.KEY_SA_SELECT_TYPE, str);
        Bundle arguments = fragment.getArguments();
        if (arguments != null) {
            intent.putExtras(arguments);
        }
        SaSideBarUiManager saSideBarUiManager = this.f50726h;
        if (saSideBarUiManager != null) {
            saSideBarUiManager.updateBusinessContext(businessContext);
        }
        BusinessContextManager.getInstance().getCurBusinessContext().getNavigation().transition(businessContext, intent, transactionAnimation);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        m36416k();
        BusinessContextHelper businessContextHelper = this.f50721c;
        if (businessContextHelper != null) {
            businessContextHelper.removeStaticReceivers();
        }
        BusinessContextHelper businessContextHelper2 = this.f50721c;
        if (businessContextHelper2 != null) {
            businessContextHelper2.onPause();
        }
        GuideUtil.cleanFirstLaunchApp(this);
        DiDiLaunchingLogTimer.get().clearData();
        killAppOnDestory();
        SATabManager sATabManager = this.f50725g;
        if (sATabManager != null) {
            sATabManager.release();
        }
        super.onDestroy();
    }

    public void mapCallBack() {
        SuperAppBroadcastSender.INSTANCE.initBroadcastSender(this);
        BusinessContext commonBusinessContext = SuperAppBusinessManager.INSTANCE.getCommonBusinessContext();
        if (commonBusinessContext != null) {
            MapFragment mapFragment = this.mMapFragment;
            commonBusinessContext.setMapFlowView(mapFragment == null ? null : mapFragment.getmMapFlowView());
        }
        EventBus.getDefault().post(new MapRedayEvent());
    }

    public Fragment getTitleBarFragment() {
        return new Fragment();
    }

    public HomeNavDrawerFragment getDrawerFragment() {
        HomeNavDrawerFragment homeNavDrawerFragment = this.f50720b;
        Intrinsics.checkNotNull(homeNavDrawerFragment);
        return homeNavDrawerFragment;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        DiDiLaunchingLogTimer.get().stampStart();
        m36426u();
    }

    /* renamed from: u */
    private final void m36426u() {
        MapFragment mapFragment = this.mMapFragment;
        if (mapFragment != null) {
            mapFragment.startInitMap();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SuperAppBusinessManager.INSTANCE.updateActivityResume(true);
        MultiLocaleStore.getInstance().getLocaleHelper().refreshAppLocale(this);
        addLaunchingSliceTimeStatistics();
        DiDiLaunchingLogTimer.get().stampResume();
        DiDiLaunchingLogTimer.get().methodStart(DiDiLogLaunchTimer.KEY_TIME_RENDER);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SuperAppBusinessManager.INSTANCE.updateActivityResume(false);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        BusinessContextHelper businessContextHelper = this.f50721c;
        if (businessContextHelper != null && businessContextHelper.onKeyUp(i, keyEvent)) {
            return true;
        }
        if (i != 4) {
            try {
                return super.onKeyUp(i, keyEvent);
            } catch (Exception unused) {
                return false;
            }
        } else {
            SaSideBarUiManager saSideBarUiManager = this.f50726h;
            if (saSideBarUiManager != null && saSideBarUiManager.onKeyUp(i, keyEvent)) {
                return true;
            }
            int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
            if (backStackEntryCount != 0) {
                FragmentManager.BackStackEntry backStackEntryAt = getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount - 1);
                Intrinsics.checkNotNullExpressionValue(backStackEntryAt, "supportFragmentManager.g…(backStackEntryCount - 1)");
                Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(backStackEntryAt.getName());
                if (findFragmentByTag instanceof SaWebFragment) {
                    ((SaWebFragment) findFragmentByTag).onBackPress();
                    return true;
                }
                try {
                    return super.onKeyUp(i, keyEvent);
                } catch (Exception unused2) {
                    return false;
                }
            } else if (!ExitUtil.isValidExit(this)) {
                return true;
            } else {
                OmegaSDKAdapter.trackEvent("gp_home_common_exit");
                this.killApp = true;
                ExitUtil.doExit();
                try {
                    return super.onKeyUp(i, keyEvent);
                } catch (Exception unused3) {
                    return false;
                }
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        OneConfManager.INSTANCE.onWindowFocusChanged(z);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            FragmentManager.BackStackEntry backStackEntryAt = getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount - 1);
            Intrinsics.checkNotNullExpressionValue(backStackEntryAt, "supportFragmentManager.g…(backStackEntryCount - 1)");
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(backStackEntryAt.getName());
            if (findFragmentByTag instanceof SaWebFragment) {
                ((SaWebFragment) findFragmentByTag).onActivityResult(i, i2, intent);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        try {
            getSupportFragmentManager().executePendingTransactions();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        BusinessContextHelper businessContextHelper = this.f50721c;
        if (businessContextHelper != null) {
            businessContextHelper.onPause();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onSideBarPageRequested(OpenSideBarPageEvent openSideBarPageEvent) {
        Intrinsics.checkNotNullParameter(openSideBarPageEvent, "event");
        AutoLinker.getLinker().linkToTarget(openSideBarPageEvent.item, BusinessContextManager.getInstance().getCurBusinessContext(), openSideBarPageEvent.subLevel);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void closeSideBar(CloseSideBarEvent closeSideBarEvent) {
        Intrinsics.checkNotNullParameter(closeSideBarEvent, "event");
        SaSideBarUiManager saSideBarUiManager = this.f50726h;
        if (saSideBarUiManager != null) {
            saSideBarUiManager.close();
        }
    }

    /* renamed from: v */
    private final void m36427v() {
        if (SaApolloUtil.INSTANCE.getSaUserTabShow() && SaApolloUtil.INSTANCE.getSaOneState()) {
            Nacho.getInstance().getEngine(FlutterApplicationDelegate.USER_CENTER_ENGINE_ID);
        }
    }
}
