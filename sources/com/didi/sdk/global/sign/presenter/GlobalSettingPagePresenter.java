package com.didi.sdk.global.sign.presenter;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.balance.activity.GlobalBalanceDetailActivity;
import com.didi.sdk.global.sign.model.convert.SettingPageInfoConverter;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.model.server.PayMethodPageResponse;

public class GlobalSettingPagePresenter extends GlobalBasePagePresenter {

    /* renamed from: a */
    private DidiGlobalPayMethodListData.PayMethodListParam f36297a;

    /* renamed from: b */
    private PaySelPageData f36298b;

    public GlobalSettingPagePresenter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public void onRequestSuccess(PaySelPageData paySelPageData) {
        this.f36298b = paySelPageData;
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f36297a;
        if (payMethodListParam != null && payMethodListParam.from == DidiGlobalPayMethodListData.Entrance.FROM_GUIDE) {
            this.f36298b.ruleUrl = "";
        }
        this.mView.updateContentView(this.f36298b, this.f36297a.from, (EnterprisePayway) null);
    }

    public void onRequestSuccess(PayMethodPageResponse payMethodPageResponse) {
        this.f36298b = SettingPageInfoConverter.convert(payMethodPageResponse);
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f36297a;
        if (payMethodListParam != null && payMethodListParam.from == DidiGlobalPayMethodListData.Entrance.FROM_GUIDE) {
            this.f36298b.ruleUrl = "";
        }
        this.mView.updateContentView(this.f36298b, this.f36297a.from, (EnterprisePayway) null);
    }

    public void initData(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        if (payMethodListParam == null) {
            this.mView.showEmptyView();
            return;
        }
        this.f36297a = payMethodListParam;
        requestDataFromServer(DidiGlobalPayMethodListData.Entrance.FROM_GUIDE);
    }

    public int getOmegaSource() {
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f36297a;
        if (payMethodListParam == null) {
            return 1;
        }
        int i = C123001.f36299x8a3a0836[payMethodListParam.from.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 2;
        }
        if (i != 5) {
            return 1;
        }
        return 5;
    }

    /* renamed from: com.didi.sdk.global.sign.presenter.GlobalSettingPagePresenter$1 */
    static /* synthetic */ class C123001 {

        /* renamed from: $SwitchMap$com$didi$sdk$global$DidiGlobalPayMethodListData$Entrance */
        static final /* synthetic */ int[] f36299x8a3a0836;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance[] r0 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f36299x8a3a0836 = r0
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f36299x8a3a0836     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f36299x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_UNIFIED_PAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f36299x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_GUIDE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f36299x8a3a0836     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_BIKE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.presenter.GlobalSettingPagePresenter.C123001.<clinit>():void");
        }
    }

    public int getOmegaCardCount() {
        PaySelPageData paySelPageData = this.f36298b;
        int i = 0;
        if (paySelPageData == null || paySelPageData.payMethodList == null || this.f36298b.payMethodList.size() == 0) {
            return 0;
        }
        for (PaySelItemData paySelItemData : this.f36298b.payMethodList) {
            if (paySelItemData.channelId == 150) {
                i++;
            }
        }
        return i >= 1 ? i - 1 : i;
    }

    public int getOmegaClickType(PaySelItemData paySelItemData) {
        if (paySelItemData == null || paySelItemData.channelId != 150 || paySelItemData.status == 1) {
            return 1;
        }
        return 3;
    }

    public void jumpToBalanceDetailPage(PaySelItemData paySelItemData) {
        GlobalBalanceDetailActivity.launch(this.mFragmentActivity, 7);
    }

    public void jumpToCashDescriptionPage(PaySelItemData paySelItemData) {
        if (paySelItemData != null) {
            String str = paySelItemData.nextPageUrl;
            if (TextUtils.isEmpty(str)) {
                str = "about:blank";
            }
            WebBrowserUtil.startInternalWebActivity(this.mFragmentActivity, str, "");
        }
    }

    public void jumpToPosMachineDescriptionPage(PaySelItemData paySelItemData) {
        if (paySelItemData != null) {
            String str = paySelItemData.nextPageUrl;
            if (TextUtils.isEmpty(str)) {
                str = "about:blank";
            }
            WebBrowserUtil.startInternalWebActivity(this.mFragmentActivity, str, "");
        }
    }

    public void jumpToDiscountActivity(PaySelItemData paySelItemData) {
        if (paySelItemData != null) {
            String str = paySelItemData.nextPageUrl;
            if (TextUtils.isEmpty(str)) {
                str = "about:blank";
            }
            WebBrowserUtil.startInternalWebActivity(this.mFragmentActivity, str, "");
        }
    }

    public void jumpToRulePageActivity(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "about:blank";
        }
        WebBrowserUtil.startInternalWebActivity(this.mFragmentActivity, str, "");
    }
}
