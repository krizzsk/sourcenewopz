package com.rider.rlab_im_map_plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.PageInstrumentFactory;
import com.didi.app.nova.skeleton.SkeletonActivity;
import com.didi.app.nova.skeleton.conductor.ChangeHandlerFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.rider.rlab_im_map_plugin.bean.ImBusinessBean;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.gps.AppGpsDialog;
import com.rider.rlab_im_map_plugin.page.ImFlutterNachoPage;
import com.rider.rlab_im_map_plugin.page.ImMapPage;
import com.rider.rlab_im_map_plugin.page.ImNavPage;
import com.rider.rlab_im_map_plugin.tool.ImCallFrom;
import com.rider.rlab_im_map_plugin.tool.ImCommons;
import com.rider.rlab_im_map_plugin.tool.ImFavorFrom;
import com.rider.rlab_im_map_plugin.tool.ImMapUtils;
import com.rider.rlab_im_map_plugin.tool.ImScopeLifecycle;
import com.rider.rlab_im_map_plugin.tool.LocaleUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.Locale;

public class ImMapActivity extends SkeletonActivity {

    /* renamed from: j */
    private static final String[] f55818j = {Permission.ACCESS_FINE_LOCATION};

    /* renamed from: a */
    private final Logger f55819a = LoggerFactory.getLogger("ImMapActivity");

    /* renamed from: b */
    private RelativeLayout f55820b;

    /* renamed from: c */
    private ChangeHandlerFrameLayout f55821c;

    /* renamed from: d */
    private ChangeHandlerFrameLayout f55822d;

    /* renamed from: e */
    private DialogFrameLayout f55823e;

    /* renamed from: f */
    private PageInstrument f55824f;

    /* renamed from: g */
    private PageInstrument f55825g;

    /* renamed from: h */
    private ImNavPage f55826h;

    /* renamed from: i */
    private ImBusinessBean f55827i;

    /* renamed from: k */
    private AppGpsDialog f55828k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ImMapPage f55829l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ImFlutterNachoPage f55830m;
    protected boolean mStateSaved;

    public static void show(Context context, ImBusinessBean imBusinessBean) {
        Intent intent = new Intent();
        intent.setClass(context, ImMapActivity.class);
        if (imBusinessBean != null) {
            intent.putExtra(ImCommons.BUNDLE_IM_DATA, imBusinessBean);
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        try {
            context = LocaleUtils.attachBaseContext(context, ImMapConfig.getInstance().getLocale());
        } catch (Exception e) {
            Logger logger = this.f55819a;
            logger.error("attachBaseContext set locale : " + e, new Object[0]);
        }
        super.attachBaseContext(context);
    }

    /* access modifiers changed from: protected */
    public void onAfterCreate(Bundle bundle) {
        Logger logger = this.f55819a;
        logger.debug("onAfterCreate " + this + " savedInstanceState: " + bundle, new Object[0]);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, 0);
        setContentView((int) R.layout.rider_im_map_page);
        m40246c();
        m40244b();
        m40242a(bundle);
        m40247d();
        mo166310a();
    }

    /* renamed from: b */
    private void m40244b() {
        Bundle extras = getIntent() == null ? null : getIntent().getExtras();
        if (extras != null) {
            this.f55827i = (ImBusinessBean) extras.getParcelable(ImCommons.BUNDLE_IM_DATA);
        }
    }

    public PageInstrument getPageInstrument() {
        return this.f55824f;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f55819a.info("onNewIntent", new Object[0]);
    }

    /* renamed from: c */
    private void m40246c() {
        this.f55820b = (RelativeLayout) findViewById(R.id.rider_root_layout);
        this.f55821c = (ChangeHandlerFrameLayout) findViewById(R.id.rider_map_container);
        this.f55822d = (ChangeHandlerFrameLayout) findViewById(R.id.rider_business_container);
        this.f55823e = (DialogFrameLayout) findViewById(R.id.rider_popup_container);
    }

    /* renamed from: a */
    private void m40242a(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("LifecycleHandler.routerState" + this.f55822d.getId());
        }
        Logger logger = this.f55819a;
        logger.info("installHomePage after remove savedInstanceState: " + bundle, new Object[0]);
        PageInstrument install = PageInstrumentFactory.install(this, this.f55822d, bundle);
        this.f55824f = install;
        install.registerPageLifecycleCallback(new ImScopeLifecycle() {
            public void onDestroy(ILive iLive) {
                super.onDestroy(iLive);
                if (ImMapActivity.this.f55830m != null) {
                    ImFlutterNachoPage unused = ImMapActivity.this.f55830m = null;
                }
            }
        });
    }

    /* renamed from: d */
    private void m40247d() {
        PageInstrument install = PageInstrumentFactory.install(this, this.f55821c, (Bundle) null);
        this.f55825g = install;
        install.attachDialogFrame(this.f55823e);
        this.f55825g.registerPageLifecycleCallback(new ImScopeLifecycle() {
            public void onDestroy(ILive iLive) {
                super.onDestroy(iLive);
                if (ImMapActivity.this.f55829l != null) {
                    ImMapPage unused = ImMapActivity.this.f55829l = null;
                }
            }
        });
        this.f55829l = new ImMapPage();
        Bundle bundle = new Bundle();
        ImBusinessBean imBusinessBean = this.f55827i;
        if (imBusinessBean != null) {
            int type = imBusinessBean.getType();
            double lat = this.f55827i.getLat();
            double lng = this.f55827i.getLng();
            bundle.putInt(ImCommons.BUNDLE_TYPE, type);
            bundle.putDouble("lat", lat);
            bundle.putDouble("lng", lng);
        }
        if (ImMapConfig.getInstance().getMockLatLng() != null) {
            bundle.putDouble("lat", this.f55827i.getLat());
            bundle.putDouble("lng", this.f55827i.getLng());
        }
        this.f55829l.setArgs(bundle);
        this.f55825g.setRootPage(this.f55829l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo166310a() {
        this.f55830m = new ImFlutterNachoPage(this.f55821c);
        Bundle bundle = new Bundle();
        ImBusinessBean imBusinessBean = this.f55827i;
        if (imBusinessBean != null) {
            bundle.putInt(ImCommons.BUNDLE_TYPE, imBusinessBean.getType());
            bundle.putDouble("lat", this.f55827i.getLat());
            bundle.putDouble("lng", this.f55827i.getLng());
            bundle.putInt(ImCommons.BUNDLE_NAV_TYPE, this.f55827i.getNav());
            bundle.putString("address", this.f55827i.getAddressName());
            bundle.putString("displayname", this.f55827i.getSectionName());
            bundle.putSerializable(ImCommons.BUNDLE_MAP, this.f55827i.getMap());
            bundle.putString("orderId", this.f55827i.getOrderId());
            bundle.putString(ImCommons.BUNDLE_C_ORDER_ID, this.f55827i.getCOrderId());
        }
        if (ImMapConfig.getInstance().getMockLatLng() != null) {
            bundle.putDouble("lat", this.f55827i.getLat());
            bundle.putDouble("lng", this.f55827i.getLng());
        }
        bundle.putString("path", ImCommons.IM_FLUTTER_PATH);
        ImCallFrom callFrom = ImMapConfig.getInstance().getCallFrom();
        if (callFrom == ImCallFrom.IMMAP_RLAB_D) {
            bundle.putInt(ImCommons.BUNDLE_CALL_FROM, 3);
        } else if (callFrom == ImCallFrom.IMMAP_RLAB_C) {
            bundle.putInt(ImCommons.BUNDLE_CALL_FROM, 2);
        }
        if (ImMapConfig.getInstance().getFavorFrom() == ImFavorFrom.IMMAP_BRAZIL) {
            bundle.putString(ImCommons.BUNDLE_FAVOR, "brazil");
        } else {
            bundle.putString(ImCommons.BUNDLE_FAVOR, "global");
        }
        Locale locale = ImMapConfig.getInstance().getLocale();
        if (locale == null) {
            locale = LocaleUtils.getAppLocale(ImMapConfig.getInstance().getContext());
        }
        bundle.putString("lang", locale.getLanguage());
        bundle.putBoolean(ImCommons.BUNDLE_DOWNGRADE_MAP, ImMapConfig.getInstance().isDowngradeMap());
        this.f55830m.setArgs(bundle);
        this.f55824f.setRootPage(this.f55830m);
    }

    public void startMapNavigation(double d, double d2, String str) {
        Bundle bundle = new Bundle();
        bundle.putDouble("lat", d);
        bundle.putDouble("lng", d2);
        bundle.putString("address", str);
        m40245b(bundle);
    }

    /* renamed from: b */
    private void m40245b(Bundle bundle) {
        if (!this.f55825g.containsPageInBackStack(ImNavPage.class) || this.f55826h == null) {
            ImNavPage imNavPage = new ImNavPage();
            this.f55826h = imNavPage;
            imNavPage.setArgs(bundle);
            this.f55825g.pushPage(this.f55826h);
        } else if (bundle != null) {
            Logger logger = this.f55819a;
            logger.debug("showGoogleNavPage() called with: args = [" + bundle + Const.jaRight, new Object[0]);
            this.f55826h.setArgs(bundle);
            this.f55826h.reLoad();
        }
    }

    /* renamed from: e */
    private void m40248e() {
        if (this.f55828k != null) {
            m40249f();
        }
        if (!ImMapUtils.getGpsStatus(this) && getScopeContext() != null) {
            AppGpsDialog appGpsDialog = new AppGpsDialog();
            this.f55828k = appGpsDialog;
            appGpsDialog.setCancelable(false);
            this.f55828k.show(this.f55825g, "bottomSheet");
            this.f55828k.bind(getScopeContext());
            this.f55828k.setOnCancelListener(new AppGpsDialog.OnCancelListener() {
                public void onCancel() {
                    ImMapActivity.this.finish();
                }
            });
        }
    }

    /* renamed from: f */
    private void m40249f() {
        AppGpsDialog appGpsDialog = this.f55828k;
        if (appGpsDialog != null) {
            appGpsDialog.dismiss();
            this.f55828k = null;
        }
    }

    public void closeNewGoogleNaviPage() {
        this.f55819a.info("closeGoogleNaviPage() called", new Object[0]);
        PageInstrument pageInstrument = this.f55825g;
        if (pageInstrument != null && pageInstrument.containsPageInBackStack(ImNavPage.class)) {
            this.f55825g.pop();
            this.f55826h = null;
        }
    }

    public void onBackPressed() {
        if (1 != this.f55824f.getBackstackSize() || !this.f55825g.containsPageInBackStack(ImNavPage.class)) {
            super.onBackPressed();
            return;
        }
        this.f55819a.info("onBackPressed: isNavigation on and return", new Object[0]);
        this.f55825g.handleBack();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Context context = ImMapConfig.getInstance().getContext();
        if (context != null && -1 == context.getPackageManager().checkPermission(Permission.ACCESS_FINE_LOCATION, context.getPackageName()) && Build.VERSION.SDK_INT >= 23) {
            requestPermissions(f55818j, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mStateSaved = false;
        Logger logger = this.f55819a;
        logger.debug("onResume mStateSaved = " + this.mStateSaved, new Object[0]);
        Context context = ImMapConfig.getInstance().getContext();
        if (context != null && context.getPackageManager().checkPermission(Permission.ACCESS_FINE_LOCATION, context.getPackageName()) == 0) {
            m40248e();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            Logger logger = this.f55819a;
            logger.debug("onRequestPermissionsResult = " + i, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mStateSaved = true;
        Logger logger = this.f55819a;
        logger.debug("onSaveInstanceState mStateSaved = " + this.mStateSaved, new Object[0]);
    }
}
