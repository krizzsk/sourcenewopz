package com.didi.beatles.p099im.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.utils.IMLocaleUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.activity.IMBaseActivity */
public class IMBaseActivity extends TheOneBaseActivity {
    /* access modifiers changed from: protected */
    public boolean isUseTheme() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        try {
            m5922b();
            m5921a();
            super.onCreate(bundle);
            if (!m5923c()) {
                finish();
            } else {
                onActivityCreate(bundle);
            }
        } catch (Exception unused) {
            finish();
            IMLog.m6631d("IMBaseActivity", "IMBaseActivity Can't Parse Intent Exception");
        }
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        super.onDestroy();
        onActivityDestroy();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        if (isUseTheme() && IMContextInfoHelper.getActivityTheme() != 0) {
            StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
        }
    }

    /* renamed from: a */
    private void m5921a() {
        try {
            if (IMContextInfoHelper.isPad()) {
                SystemUtils.hookSetRequestedOrientation(this, 6);
            }
        } catch (Exception e) {
            IMLog.m6632e("IM initScreenDirection error", e);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        try {
            context = IMLocaleUtil.attachBaseContext(context);
        } catch (Exception e) {
            IMLog.m6633e(e);
        }
        super.attachBaseContext(context);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initStatusBar();
    }

    /* renamed from: b */
    private void m5922b() {
        if (isUseTheme() && IMContextInfoHelper.getActivityTheme() != 0) {
            setTheme(IMContextInfoHelper.getActivityTheme());
        }
    }

    public void onBackPressed() {
        finish();
    }

    /* renamed from: c */
    private boolean m5923c() {
        if (!IMEngine.getInstance(this).hasInit()) {
            IMLog.m6632e("init IM failed!", new Object[0]);
            SystemUtils.showToast(Toast.makeText(this, getString(R.string.im_toast_error), 0));
            return false;
        } else if (IMContextInfoHelper.isLogingNow()) {
            return true;
        } else {
            IMLog.m6632e("user not login !", new Object[0]);
            SystemUtils.showToast(Toast.makeText(this, getString(R.string.im_toast_error), 0));
            return false;
        }
    }
}
