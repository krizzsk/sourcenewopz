package com.didi.payment.wallet.global.risk;

import android.text.TextUtils;
import android.view.View;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import java.util.HashMap;

public class LimitRiskReminderHandler {

    /* renamed from: a */
    private LEGODrawer f31777a;

    public void show(LimitRiskReminderVo limitRiskReminderVo, FragmentActivity fragmentActivity, String str, int i, Consumer<Integer> consumer) {
        LimitRiskReminderVo limitRiskReminderVo2 = limitRiskReminderVo;
        Consumer<Integer> consumer2 = consumer;
        if (limitRiskReminderVo2 != null) {
            dismissDialog();
            final LimitRiskReminderVo limitRiskReminderVo3 = limitRiskReminderVo;
            final FragmentActivity fragmentActivity2 = fragmentActivity;
            final String str2 = str;
            final int i2 = i;
            C111122 r9 = new LEGODrawerModel1(limitRiskReminderVo2.title, new LEGOBtnTextAndCallback(limitRiskReminderVo2.rightText, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    LimitRiskReminderHandler.this.dismissDialog();
                    if (!TextUtils.isEmpty(limitRiskReminderVo3.rightLink)) {
                        DRouter.build(limitRiskReminderVo3.rightLink).start(fragmentActivity2);
                    }
                    LimitRiskReminderHandler.m22537d(str2, i2);
                }
            })) {
                /* access modifiers changed from: protected */
                public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
                    lEGODrawerModel.isTwoBtnHorizontal = false;
                    return lEGODrawerModel;
                }
            };
            if (!TextUtils.isEmpty(limitRiskReminderVo2.leftText)) {
                final Consumer<Integer> consumer3 = consumer;
                final LimitRiskReminderVo limitRiskReminderVo4 = limitRiskReminderVo;
                final String str3 = str;
                final int i3 = i;
                r9.addMinorBtn(new LEGOBtnTextAndCallback(limitRiskReminderVo2.leftText, new LEGOOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        LimitRiskReminderHandler.this.dismissDialog();
                        Consumer consumer = consumer3;
                        if (consumer != null) {
                            consumer.accept(Integer.valueOf(limitRiskReminderVo4.leftStatus));
                        }
                        LimitRiskReminderHandler.m22538e(str3, i3);
                    }
                }));
            }
            r9.setSubTitle(limitRiskReminderVo2.subTitle);
            this.f31777a = LEGOUICreator.showDrawerTemplate(fragmentActivity, r9);
            m22536c(str, i);
        } else if (consumer2 != null) {
            consumer2.accept(1);
        }
    }

    /* renamed from: c */
    private static void m22536c(String str, int i) {
        if (!TextUtils.isEmpty(str) && i != -1) {
            HashMap hashMap = new HashMap();
            hashMap.put("pub_page", str);
            hashMap.put("pub_target", Const.POPUP);
            hashMap.put("pub_biz", "fintech");
            hashMap.put("popup_theme", "amount_limited");
            if (i > 0) {
                hashMap.put("product_line", Integer.valueOf(i));
            }
            hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
            FinOmegaSDK.trackEvent("ibt_fintech_passenger_popup_sw", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m22537d(String str, int i) {
        if (!TextUtils.isEmpty(str) && i != -1) {
            HashMap hashMap = new HashMap();
            hashMap.put("pub_page", str);
            hashMap.put("pub_target", Const.POPUP);
            hashMap.put("pub_biz", "fintech");
            hashMap.put("popup_theme", "amount_limited");
            if (i > 0) {
                hashMap.put("product_line", Integer.valueOf(i));
            }
            hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
            hashMap.put("button_name", LoginOmegaUtil.NEED_VERIFY_EMAIL);
            FinOmegaSDK.trackEvent("ibt_fintech_passenger_popup_ck", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m22538e(String str, int i) {
        if (!TextUtils.isEmpty(str) && i != -1) {
            HashMap hashMap = new HashMap();
            hashMap.put("pub_page", str);
            hashMap.put("pub_target", Const.POPUP);
            hashMap.put("pub_biz", "fintech");
            hashMap.put("popup_theme", "amount_limited");
            if (i > 0) {
                hashMap.put("product_line", Integer.valueOf(i));
            }
            hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
            hashMap.put("button_name", "skip");
            FinOmegaSDK.trackEvent("ibt_fintech_passenger_popup_ck", hashMap);
        }
    }

    public void dismissDialog() {
        LEGODrawer lEGODrawer = this.f31777a;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            this.f31777a.dismiss();
        }
        this.f31777a = null;
    }

    public void destroy() {
        dismissDialog();
    }
}
