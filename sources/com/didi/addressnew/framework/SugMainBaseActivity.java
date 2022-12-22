package com.didi.addressnew.framework;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.didi.address.GlobalSugCallback;
import com.didi.addressnew.framework.mapholder.SugSharedMapView;
import com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.view.SugViewLayout;
import com.didi.common.map.util.DLog;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public abstract class SugMainBaseActivity extends FragmentActivity implements ISugMainPageView, SugViewLayout.OnSugViewDragListener {

    /* renamed from: a */
    private static final String f4312a = SugMainBaseActivity.class.getSimpleName();

    /* renamed from: h */
    private static volatile boolean f4313h;

    /* renamed from: i */
    private static volatile boolean f4314i;

    /* renamed from: b */
    private boolean f4315b = false;

    /* renamed from: c */
    private GlobalSugCallback f4316c = null;

    /* renamed from: d */
    private boolean f4317d = false;

    /* renamed from: e */
    private final int f4318e = 0;

    /* renamed from: f */
    private final int f4319f = 1;

    /* renamed from: g */
    private volatile Point[] f4320g = new Point[2];

    /* renamed from: j */
    private boolean f4321j;
    protected RelativeLayout mSugPageContainer;

    /* renamed from: c */
    private void m2628c() {
    }

    /* access modifiers changed from: protected */
    public abstract int getActLayoutId();

    /* access modifiers changed from: protected */
    public abstract void initViews();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setPageStatusBarBgLightning();
        setContentView(getActLayoutId());
        m2625a();
        initViews();
        m2627b();
    }

    /* access modifiers changed from: protected */
    public void setPageStatusBarBgLightning() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, 0);
    }

    /* renamed from: a */
    private void m2625a() {
        this.mSugPageContainer = (RelativeLayout) findViewById(R.id.sugPageContainer);
    }

    /* renamed from: b */
    private void m2627b() {
        if (SwitcherImpl.getInstance() != null) {
            logWrite("startMainFragment...");
            SwitcherImpl.getInstance().startMainFragment(getFragmentManager(), R.id.sugPageContainer);
        }
    }

    public void onCloseSugPage() {
        logWrite("onCloseSugPage...");
        if (!isFinishing()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void logWrite(String str) {
        SystemUtils.log(4, "SugMainBaseActivity", str, (Throwable) null, "com.didi.addressnew.framework.SugMainBaseActivity", 91);
    }

    /* access modifiers changed from: protected */
    public int getScreenRealHeight(Context context) {
        boolean isAllScreenDevice;
        int i;
        int i2;
        WindowManager windowManager;
        if (Build.VERSION.SDK_INT < 17 || !(isAllScreenDevice = isAllScreenDevice(context))) {
            return getScreenHeight(context);
        }
        char c = 0;
        int navigationBarHeight = (!isAllScreenDevice || !ViewUtils.isNavigationBarShow(context)) ? 0 : ViewUtils.getNavigationBarHeight(this);
        if (context != null) {
            i = context.getResources().getConfiguration().orientation;
        } else {
            i = getResources().getConfiguration().orientation;
        }
        if (i != 1) {
            c = 1;
        }
        if (this.f4320g[c] == null) {
            if (context != null) {
                windowManager = (WindowManager) getSystemService("window");
            } else {
                windowManager = (WindowManager) getSystemService("window");
            }
            if (windowManager == null) {
                return getScreenHeight(context);
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            this.f4320g[c] = point;
        }
        if (this.f4320g[c] == null || (i2 = this.f4320g[c].y - navigationBarHeight) <= 0) {
            return getScreenHeight(context);
        }
        return i2;
    }

    public int getScreenHeight(Context context) {
        if (context != null) {
            return getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    public boolean isAllScreenDevice(Context context) {
        int i;
        float f;
        if (f4313h) {
            return f4314i;
        }
        f4313h = true;
        f4314i = false;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        WindowManager windowManager = (WindowManager) getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (point.x < point.y) {
                f = (float) point.x;
                i = point.y;
            } else {
                f = (float) point.y;
                i = point.x;
            }
            if (((float) i) / f >= 1.97f) {
                f4314i = true;
            }
        }
        return f4314i;
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f4321j = false;
        if (SwitcherImpl.getInstance() != null) {
            ((SwitcherImpl) SwitcherImpl.getInstance()).allowPopFragment = allowFragmentCommit();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SugSharedMapView.getInstance(this).onPause();
        DLog.m7384d("sugActivity", getClass().getSimpleName() + "::onPause isFinishing=" + isFinishing() + ",isClosingAnimating=" + this.f4315b, new Object[0]);
        m2626a(this.f4315b);
        this.f4317d = true;
    }

    /* renamed from: a */
    private void m2626a(boolean z) {
        if (isFinishing() || z) {
            GlobalSugCallback globalSugCallback = this.f4316c;
            if (globalSugCallback != null) {
                globalSugCallback.onSugSessionClosed();
            }
            if (SwitcherImpl.getInstance() != null) {
                SwitcherImpl.getInstance().onExit();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f4317d = false;
        this.f4315b = false;
        SugSharedMapView.getInstance(this).onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        SugSharedMapView.getInstance(this).onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        SugSharedMapView.getInstance(this).onStop();
    }

    public void onLowMemory() {
        super.onLowMemory();
        SugSharedMapView.getInstance(this).onLowMemory();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        logWrite("onDestroy...");
        if (SwitcherImpl.getInstance() != null) {
            SwitcherImpl.getInstance().onExit();
        }
        ActivityReference.getInstance().setCurrentActivity((SugMainDialogActivity) null);
        SugSharedMapView.getInstance(this).onDestroy();
    }

    public void finish() {
        String str = f4312a;
        SystemUtils.log(4, str, "finish() is called ,isFinishing = " + isFinishing() + ",isPaused " + this.f4317d, new Throwable(), "com.didi.addressnew.framework.SugMainBaseActivity", 250);
        if (!isFinishing()) {
            if (this.f4317d) {
                m2626a(true);
            }
            super.finish();
            overridePendingTransition(0, 0);
        }
    }

    public void onSugViewIsStartMove() {
        hideKeyboard();
    }

    public void onSugViewIsReset() {
        hideKeyboard();
    }

    public void onSugViewStartClose() {
        DLog.m7384d("sugActivity", getClass().getSimpleName() + "::onSugViewIsClose isFinishing=" + isFinishing() + ",isClosingAnimating=" + this.f4315b, new Object[0]);
        this.f4315b = true;
    }

    public void onSugViewIsClose() {
        DLog.m7384d("sugActivity", getClass().getSimpleName() + "::onSugViewIsClose isFinishing=" + isFinishing() + ",isClosingAnimating=" + this.f4315b, new Object[0]);
        if (SwitcherImpl.getInstance() != null) {
            SwitcherImpl.getInstance().onActivityCloseBefore();
        }
        onCloseSugPage();
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(this);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.f4321j = true;
        if (SwitcherImpl.getInstance() != null) {
            ((SwitcherImpl) SwitcherImpl.getInstance()).allowPopFragment = allowFragmentCommit();
        }
        super.onResumeFragments();
    }

    public boolean allowFragmentCommit() {
        return this.f4321j;
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        this.f4321j = true;
        if (SwitcherImpl.getInstance() != null) {
            ((SwitcherImpl) SwitcherImpl.getInstance()).allowPopFragment = allowFragmentCommit();
        }
        super.onPostResume();
    }

    public void postAsyncSessionCloseCallback(GlobalSugCallback globalSugCallback) {
        this.f4316c = globalSugCallback;
    }
}
