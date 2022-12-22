package com.didi.sdk.guide;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.app.router.PageRouter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayPayData;
import com.didi.sdk.logtime.DiDiLaunchingLogTimer;
import com.didi.sdk.logtime.DiDiLogLaunchTimer;
import com.didi.sdk.performance.OnlineImageConstant;
import com.didi.sdk.resource.warehouse.image.ICacheProvider;
import com.didi.sdk.resource.warehouse.image.OnlineImageCacheManager;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import com.didi.sdk.resource.warehouse.tools.OmegaUtil;
import com.didi.sdk.view.GlobalTitleBar;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;

public class CardsBindGuideActivity extends FragmentActivity {

    /* renamed from: a */
    private static final int f36358a = 10011;

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_cards_bind_guide);
        m25734a();
        m25736b();
        if (Build.VERSION.SDK_INT >= 23) {
            StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        }
        OmegaSDKAdapter.trackEvent("gp_paymethod_sw");
    }

    /* renamed from: a */
    private void m25734a() {
        final View findViewById = findViewById(R.id.paypay_skip_2_bind);
        final boolean hasCache = OnlineImageCacheManager.getInstance(this).hasCache(OnlineImageConstant.URL_BIND_GUIDE_PAYPAY_BG, ICacheProvider.PROVIDER_KEY_GLIDE);
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        String simpleName = CardsBindGuideActivity.class.getSimpleName();
        LogUtil.m26314i(simpleName, "initTitle:url = https://img0.didiglobal.com/static/quickbolt/b9cau4SEWZAXEMhH.webp, hasCache = " + hasCache);
        OmegaUtil.loadUrlEvent(OnlineImageConstant.URL_BIND_GUIDE_PAYPAY_BG, hasCache);
        Glide.with((FragmentActivity) this).load(OnlineImageConstant.URL_BIND_GUIDE_PAYPAY_BG).into(new CustomTarget<Drawable>() {
            public void onLoadCleared(Drawable drawable) {
            }

            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                findViewById.setBackground(drawable);
                String simpleName = CardsBindGuideActivity.class.getSimpleName();
                LogUtil.m26314i(simpleName, "initTitle.onResourceReady:url = https://img0.didiglobal.com/static/quickbolt/b9cau4SEWZAXEMhH.webp, hasCache = " + hasCache);
                if (!hasCache) {
                    OmegaUtil.loadUrlIfNeedDownloadSuccessEvent(OnlineImageConstant.URL_BIND_GUIDE_PAYPAY_BG, SystemClock.elapsedRealtime() - elapsedRealtime);
                }
            }

            public void onLoadFailed(Drawable drawable) {
                super.onLoadFailed(drawable);
                String simpleName = CardsBindGuideActivity.class.getSimpleName();
                LogUtil.m26314i(simpleName, "initTitle.onLoadFailed:url = https://img0.didiglobal.com/static/quickbolt/b9cau4SEWZAXEMhH.webp, hasCache = " + hasCache + ", errorDrawable = " + drawable);
                long elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                StringBuilder sb = new StringBuilder();
                sb.append("errorDrawable = ");
                sb.append(drawable);
                OmegaUtil.loadUrlIfNeedDownloadFailEvent(OnlineImageConstant.URL_BIND_GUIDE_PAYPAY_BG, elapsedRealtime, sb.toString());
            }
        });
        GlobalTitleBar globalTitleBar = (GlobalTitleBar) findViewById(R.id.cards_bind_title);
        globalTitleBar.setRightText(getResources().getString(R.string.cards_bind_guide_skip_string));
        globalTitleBar.setLeftVisible(8);
        globalTitleBar.setTitle((int) R.string.cards_bind_guide_title);
        globalTitleBar.setTitleLineVisible(0);
        globalTitleBar.setRightClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaSDKAdapter.trackEvent("pas_add_card_intro_close");
                CardsBindGuideActivity.this.m25737c();
            }
        });
    }

    /* renamed from: b */
    private void m25736b() {
        ((RelativeLayout) findViewById(R.id.skip_2_bind)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardsBindGuideActivity.this.go2BindCard();
            }
        });
        ((RelativeLayout) findViewById(R.id.paypay_skip_2_bind)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardsBindGuideActivity.this.go2PayPayBindCard();
            }
        });
    }

    public void go2BindCard() {
        OmegaSDKAdapter.trackEvent("pas_add_card_intro_addcard");
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 5;
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity((Activity) this, 10011, addCardParam);
    }

    public void go2PayPayBindCard() {
        OmegaSDKAdapter.trackEvent("gp_payadd_ck");
        DidiGlobalPayPayData.AddPayPayParam addPayPayParam = new DidiGlobalPayPayData.AddPayPayParam();
        addPayPayParam.bindType = 5;
        DidiGlobalPayApiFactory.createDidiPay().startAddPayPayActivity((Activity) this, addPayPayParam, (DidiGlobalPayPayData.PayPayCallback) new DidiGlobalPayPayData.PayPayCallback() {
            public void onResult(int i, String str) {
                if (i == 0) {
                    OmegaSDKAdapter.trackEvent("gp_paysuctoast_sw");
                    CardsBindGuideActivity.this.m25737c();
                    return;
                }
                OmegaSDKAdapter.trackEvent("gp_payfailtoast_sw");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10011 && i2 == -1) {
            m25737c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m25737c() {
        Intent intent = new Intent();
        intent.putExtra("no_res", true);
        intent.setPackage(getPackageName());
        PageRouter.getInstance().startMainActivity(this, intent);
        finish();
        overridePendingTransition(17432576, 17432577);
        DiDiLaunchingLogTimer.get().methodEnd(DiDiLogLaunchTimer.KEY_TIME_LAUNCHING);
    }
}
