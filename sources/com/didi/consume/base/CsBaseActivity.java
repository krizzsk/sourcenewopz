package com.didi.consume.base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingRenderType;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.Locale;

public class CsBaseActivity extends TheOneBaseActivity implements WalletLoadingContract {

    /* renamed from: a */
    private View f16229a;
    protected GGKDrawer mConfirmDrawer;

    public Context getContext() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        initStatusBar();
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* access modifiers changed from: protected */
    public void initProgressDialog(FragmentActivity fragmentActivity, int i) {
        this.f16229a = fragmentActivity.findViewById(i);
    }

    /* access modifiers changed from: protected */
    public View getLoadingAnchorView() {
        return this.f16229a;
    }

    public void showLoadingDialog() {
        View loadingAnchorView = getLoadingAnchorView();
        if (loadingAnchorView != null) {
            Loading.make((Context) this, LoadingRenderType.ANIMATION, loadingAnchorView, true).show();
        }
    }

    public void dismissLoadingDialog() {
        View loadingAnchorView = getLoadingAnchorView();
        if (loadingAnchorView != null) {
            Loading.hide(loadingAnchorView);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(m11894a(context));
    }

    /* renamed from: a */
    private Context m11894a(Context context) {
        Locale b = m11899b(context.getApplicationContext());
        return b != null ? m11895a(context, b) : context;
    }

    /* renamed from: b */
    private Locale m11899b(Context context) {
        if (context != null) {
            return context.getResources().getConfiguration().locale;
        }
        return null;
    }

    /* renamed from: a */
    private Context m11895a(Context context, Locale locale) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    public void showConfirmDialog(String str, String str2, String str3, DoubleCheckOnClickListener doubleCheckOnClickListener) {
        showChooseDialog(str, str2, str3, (String) null, doubleCheckOnClickListener, (DoubleCheckOnClickListener) null);
    }

    public void showChooseDialog(String str, String str2, String str3, String str4, DoubleCheckOnClickListener doubleCheckOnClickListener, DoubleCheckOnClickListener doubleCheckOnClickListener2) {
        m11898a(str, str2, str3, str4, doubleCheckOnClickListener, doubleCheckOnClickListener2, false);
    }

    /* renamed from: a */
    private void m11898a(String str, String str2, String str3, String str4, final DoubleCheckOnClickListener doubleCheckOnClickListener, final DoubleCheckOnClickListener doubleCheckOnClickListener2, final boolean z) {
        C73042 r0 = new GGKDrawerModel1(str, new GGKBtnTextAndCallback(str3, new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                CsBaseActivity.this.m11896a();
                DoubleCheckOnClickListener doubleCheckOnClickListener = doubleCheckOnClickListener;
                if (doubleCheckOnClickListener != null) {
                    doubleCheckOnClickListener.onClick(view);
                }
            }
        })) {
            /* access modifiers changed from: protected */
            public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
                if (!z) {
                    return super.convertOthers(gGKDrawerModel);
                }
                gGKDrawerModel.isTwoBtnHorizontal = true;
                return gGKDrawerModel;
            }
        };
        if (!TextUtil.isEmpty(str2)) {
            r0.setSubTitle(str2);
        }
        if (doubleCheckOnClickListener2 != null) {
            r0.addMinorBtn(new GGKBtnTextAndCallback(str4, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsBaseActivity.this.m11896a();
                    doubleCheckOnClickListener2.onClick(view);
                }
            }));
        }
        GGKDrawer showDrawerModel = GGKUICreatorWithThemeCheck.showDrawerModel(this, r0);
        this.mConfirmDrawer = showDrawerModel;
        showDrawerModel.setCanceledOnTouchOutside(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11896a() {
        GGKDrawer gGKDrawer = this.mConfirmDrawer;
        if (gGKDrawer != null) {
            gGKDrawer.dismiss();
        }
    }
}
