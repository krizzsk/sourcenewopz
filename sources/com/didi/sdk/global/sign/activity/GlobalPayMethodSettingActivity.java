package com.didi.sdk.global.sign.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.presenter.GlobalSettingPagePresenter;
import com.didi.sdk.global.sign.view.PayMethodBaseFragmentView;
import com.didi.sdk.global.sign.view.PayMethodSettingFragmentView;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.taxis99.R;

public class GlobalPayMethodSettingActivity extends GlobalBasePayMethodListActivity {

    /* renamed from: a */
    private View f36210a;

    /* renamed from: b */
    private View f36211b;

    /* renamed from: c */
    private PayMethodSettingFragmentView f36212c;
    protected GlobalSettingPagePresenter mPresenter;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        initStatusBar();
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_activity_global_paymethod_setting_list);
        initBase();
        m25584a();
        m25586b();
        m25587c();
    }

    /* renamed from: a */
    private void m25584a() {
        View findViewById = findViewById(R.id.iv_close);
        this.f36211b = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackPayMethodSettingPageCloseCK(GlobalPayMethodSettingActivity.this.mContext, GlobalPayMethodSettingActivity.this.mPresenter.getOmegaSource());
                GlobalPayMethodSettingActivity.this.onBackPressed();
            }
        });
        View findViewById2 = findViewById(R.id.tv_skip);
        this.f36210a = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayMethodSettingActivity.this.onBackPressed();
            }
        });
        this.f36212c = (PayMethodSettingFragmentView) findViewById(R.id.v_pay_setting_view);
        if (this.mParam != null && !TextUtils.isEmpty(this.mParam.skipAction)) {
            this.f36211b.setVisibility(8);
            this.f36210a.setVisibility(0);
        }
    }

    /* renamed from: b */
    private void m25586b() {
        GlobalSettingPagePresenter globalSettingPagePresenter = new GlobalSettingPagePresenter(this);
        this.mPresenter = globalSettingPagePresenter;
        globalSettingPagePresenter.setView(this.f36212c);
        this.mPresenter.initPayMethodSelectAdapter(sAdapter);
        this.mPresenter.initData(this.mParam);
        GlobalOmegaUtils.trackPayMethodSettingPageSW(this.mContext, this.mPresenter.getOmegaSource());
    }

    /* renamed from: c */
    private void m25587c() {
        this.f36212c.setPayMethodPageEventListener(new PayMethodBaseFragmentView.PayMethodPageEventListener() {
            public void onBalanceSwitchClick(boolean z) {
            }

            public void onEnterpriseSwitch(View view, boolean z) {
            }

            public boolean onInterceptPayMethodSelect(View view, PaySelItemData paySelItemData) {
                return false;
            }

            public void onPageUrlClicked(String str) {
            }

            public void onPayMethodSelectEvent(View view, PaySelItemData paySelItemData) {
            }

            public void onPayMethodClickEvent(View view, PaySelItemData paySelItemData) {
                if (paySelItemData != null) {
                    int i = paySelItemData.channelId;
                    if (i == 120) {
                        GlobalPayMethodSettingActivity.this.mPresenter.jumpToBalanceDetailPage(paySelItemData);
                        GlobalOmegaUtils.trackPayMethodSettingPageBalanceCK(GlobalPayMethodSettingActivity.this.mContext, GlobalPayMethodSettingActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaCardCount());
                    } else if (i == 150) {
                        GlobalOmegaUtils.trackPayMethodSettingPageCreditCK(GlobalPayMethodSettingActivity.this.mContext, GlobalPayMethodSettingActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaCardCount());
                        GlobalPayMethodSettingActivity.this.mPresenter.jumpToCreditCardActivity(paySelItemData, GlobalPayMethodSettingActivity.this.mParam);
                    } else if (i == 183) {
                        GlobalPayMethodSettingActivity.this.mPresenter.jumpToPayPalPage(paySelItemData);
                        GlobalOmegaUtils.trackPayMethodSettingPagePaypal2CK(GlobalPayMethodSettingActivity.this.mContext, GlobalPayMethodSettingActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaCardCount());
                    } else if (i != 1000) {
                        switch (i) {
                            case 152:
                                GlobalPayMethodSettingActivity.this.mPresenter.jumpToPayPalPage(paySelItemData);
                                GlobalOmegaUtils.trackPayMethodSettingPagePaypalCK(GlobalPayMethodSettingActivity.this.mContext, GlobalPayMethodSettingActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaCardCount());
                                return;
                            case 153:
                                GlobalPayMethodSettingActivity.this.mPresenter.jumpToCashDescriptionPage(paySelItemData);
                                GlobalOmegaUtils.trackPayMethodSettingPageCashCK(GlobalPayMethodSettingActivity.this.mContext, GlobalPayMethodSettingActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaCardCount());
                                return;
                            case 154:
                                GlobalPayMethodSettingActivity.this.mPresenter.jumpToPosMachineDescriptionPage(paySelItemData);
                                GlobalOmegaUtils.trackPayMethodSettingPagePosCK(GlobalPayMethodSettingActivity.this.mContext, GlobalPayMethodSettingActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaCardCount());
                                return;
                            default:
                                return;
                        }
                    } else {
                        GlobalOmegaUtils.trackPayMethodSettingPageDiscountsCK(GlobalPayMethodSettingActivity.this.mContext, GlobalPayMethodSettingActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSettingActivity.this.mPresenter.getOmegaCardCount());
                        GlobalPayMethodSettingActivity.this.mPresenter.jumpToDiscountActivity(paySelItemData);
                    }
                }
            }

            public void onPageClickEvent(View view, PaySelPageData paySelPageData) {
                int id = view.getId();
                if (id == R.id.ll_empty) {
                    GlobalPayMethodSettingActivity.this.mPresenter.requestDataFromServer(DidiGlobalPayMethodListData.Entrance.FROM_GUIDE);
                } else if (id == R.id.iv_paymethod_rules && paySelPageData != null) {
                    GlobalPayMethodSettingActivity.this.mPresenter.jumpToRulePageActivity(paySelPageData.ruleUrl);
                }
            }
        });
    }

    public void onBackPressed() {
        if (this.mParam == null || TextUtils.isEmpty(this.mParam.skipAction)) {
            setResult(new DidiGlobalPayMethodListData.PayMethodListResult());
        } else {
            m25585a(this.mParam.skipAction);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r2, int r3, android.content.Intent r4) {
        /*
            r1 = this;
            super.onActivityResult(r2, r3, r4)
            r4 = 1
            r0 = -1
            if (r2 == r4) goto L_0x0017
            r4 = 2
            if (r2 == r4) goto L_0x002f
            r4 = 3
            if (r2 == r4) goto L_0x0017
            r4 = 4
            if (r2 == r4) goto L_0x002f
            r4 = 6
            if (r2 == r4) goto L_0x002f
            r4 = 7
            if (r2 == r4) goto L_0x002f
            goto L_0x0038
        L_0x0017:
            if (r3 != r0) goto L_0x002f
            com.didi.sdk.global.DidiGlobalPayMethodListData$PayMethodListParam r2 = r1.mParam
            if (r2 == 0) goto L_0x002f
            com.didi.sdk.global.DidiGlobalPayMethodListData$PayMethodListParam r2 = r1.mParam
            java.lang.String r2 = r2.nextAction
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x002f
            com.didi.sdk.global.DidiGlobalPayMethodListData$PayMethodListParam r2 = r1.mParam
            java.lang.String r2 = r2.nextAction
            r1.m25585a(r2)
            return
        L_0x002f:
            if (r3 != r0) goto L_0x0038
            com.didi.sdk.global.sign.presenter.GlobalSettingPagePresenter r2 = r1.mPresenter
            com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r3 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_GUIDE
            r2.requestDataFromServer(r3)
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.activity.GlobalPayMethodSettingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public void refreshList() {
        if (this.mParam == null || TextUtils.isEmpty(this.mParam.nextAction)) {
            this.mPresenter.requestDataFromServer(DidiGlobalPayMethodListData.Entrance.FROM_GUIDE);
        } else {
            m25585a(this.mParam.nextAction);
        }
    }

    /* renamed from: a */
    private void m25585a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.setPackage(getPackageName());
            intent.setAction(str);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                finish();
                throw th;
            }
            finish();
        }
    }
}
