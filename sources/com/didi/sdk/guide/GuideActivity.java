package com.didi.sdk.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.MainActivity;
import com.didi.sdk.global.DidiGlobalPayApiImpl;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.GuideUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;

public class GuideActivity extends FragmentActivity implements View.OnClickListener {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        if (Build.VERSION.SDK_INT >= 24) {
            MultiLocaleStore.getInstance().getLocaleHelper().refreshAppLocale(this);
        }
        OmegaSDKAdapter.trackEvent("pas_land_sw");
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.global_userguide_guide);
        GuideUtil.isGuideShowed = true;
        OmegaSDKAdapter.trackEvent("tone_p_x_app_welcome_sw");
        ((Button) findViewById(R.id.userguide_start)).setOnClickListener(this);
        View findViewById = findViewById(R.id.linearAnimationGroup);
        findViewById.setVisibility(0);
        findViewById.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.global_guide_up_slide_in));
        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
            public void onSuccess(Activity activity, String str) {
                OneLoginFacade.getFunction().removeLoginListener(this);
                OneLoginFacade.getConfigApi().setHomeCanBack(true);
                if (OneLoginFacade.getStore().isNewUser()) {
                    GuideActivity.this.goToPayment();
                } else {
                    GuideActivity.m25739b(GuideActivity.this);
                }
            }

            public void onCancel() {
                OneLoginFacade.getFunction().removeLoginListener(this);
            }
        });
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OmegaSDKAdapter.trackEvent("tone_p_x_welcome_start_ck");
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            GuideUtil.setNeedGuide(this, false);
            m25739b(this);
        } else {
            m25740c(this);
        }
        finish();
        if (Build.VERSION.SDK_INT >= 5) {
            overridePendingTransition(17432576, 17432577);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m25739b(Activity activity) {
        GuideUtil.setNeedGuide(activity, false);
        Intent intent = new Intent(activity, MainActivity.class);
        if (Build.VERSION.SDK_INT >= 4) {
            intent.setPackage(activity.getPackageName());
        }
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && intent != null) {
            m25739b(this);
            finish();
        }
    }

    /* renamed from: c */
    private void m25740c(Activity activity) {
        OneLoginFacade.getAction().go2Login(activity);
    }

    public void goToPayment() {
        DidiGlobalPayApiImpl didiGlobalPayApiImpl = new DidiGlobalPayApiImpl();
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_GUIDE);
        payMethodListParam.skipAction = getResources().getString(R.string.app_mainactivity_action);
        payMethodListParam.nextAction = getResources().getString(R.string.app_mainactivity_action);
        didiGlobalPayApiImpl.startPayMethodListActivity((Activity) this, 1, payMethodListParam);
    }
}
