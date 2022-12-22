package com.didi.sdk.global.sign.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.paypal.model.bean.BaseResult;
import com.didi.sdk.global.sign.model.convert.SelectPageInfoConverter;
import com.didi.sdk.global.sign.model.convert.SelectPageInfoRefresher;
import com.didi.sdk.global.sign.model.convert.SettingPageInfoConverter;
import com.didi.sdk.global.sign.model.event.PayMethodConfirmEvent;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.model.server.PayMethodPageResponse;
import com.didi.sdk.global.sign.model.server.PayMethodRpcModel;
import com.didi.sdk.global.sign.view.PayMethodSelectFragmentView;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class GlobalSelectPagePresenter extends GlobalBasePagePresenter {

    /* renamed from: a */
    private DidiGlobalPayMethodListData.PayMethodListParam f36287a;

    /* renamed from: b */
    private PaySelPageData f36288b;

    /* renamed from: c */
    private RequestItem f36289c;

    /* renamed from: d */
    private RequestItem f36290d;

    /* renamed from: e */
    private EnterprisePayway f36291e;

    /* renamed from: f */
    private String f36292f;

    /* renamed from: g */
    private int f36293g;

    /* renamed from: h */
    private int f36294h;

    /* renamed from: i */
    private Context f36295i;
    protected PayMethodRpcModel mModel = new PayMethodRpcModel(this.mFragmentActivity);

    private class RequestItem {
        public String cardIndex;
        public int channelId;

        public RequestItem(int i, String str) {
            this.channelId = i;
            this.cardIndex = str;
        }
    }

    public GlobalSelectPagePresenter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.f36295i = fragmentActivity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveEvent(PayMethodConfirmEvent payMethodConfirmEvent) {
        RequestItem requestItem = this.f36290d;
        if (requestItem != null) {
            m25670a(this.f36288b, requestItem.channelId, this.f36290d.cardIndex);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void initData(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        if (payMethodListParam == null) {
            this.mView.showEmptyView();
            return;
        }
        this.f36287a = payMethodListParam;
        this.f36288b = SelectPageInfoConverter.convert(payMethodListParam);
        EnterprisePayway parseFromParam = SelectPageInfoConverter.parseFromParam(this.f36287a);
        this.f36291e = parseFromParam;
        if (parseFromParam != null) {
            for (PaySelItemData next : this.f36288b.payMethodList) {
                if (next != null && next.channelId == 153) {
                    this.f36292f = next.subTitle;
                    this.f36293g = next.titleStyle;
                    this.f36294h = next.subTitleStyle;
                }
            }
        }
        EnterprisePayway enterprisePayway = this.f36291e;
        if (enterprisePayway != null) {
            m25671a(enterprisePayway.toggle);
        }
        this.mView.updateContentView(this.f36288b, this.f36287a.from, this.f36291e);
    }

    public void onRequestSuccess(PaySelPageData paySelPageData) {
        SystemUtils.log(3, "wallet", "Select page requested data from server", (Throwable) null, "com.didi.sdk.global.sign.presenter.GlobalSelectPagePresenter", 130);
        this.mHasRequestDataFromServer = true;
        this.f36288b = paySelPageData;
        EnterprisePayway enterprisePayway = this.f36291e;
        if (enterprisePayway != null) {
            m25671a(enterprisePayway.toggle);
        }
        this.mView.updateContentView(this.f36288b, this.f36287a.from, this.f36291e);
        RequestItem requestItem = this.f36289c;
        if (requestItem != null) {
            m25670a(this.f36288b, requestItem.channelId, this.f36289c.cardIndex);
        }
    }

    public void onRequestSuccess(PayMethodPageResponse payMethodPageResponse) {
        RequestItem requestItem;
        PaySelPageData paySelPageData = this.f36288b;
        if (paySelPageData == null || (requestItem = this.f36289c) == null) {
            this.mView.updateContentView(SettingPageInfoConverter.convert(payMethodPageResponse), this.f36287a.from, this.f36291e);
        } else if (SelectPageInfoRefresher.refresh(paySelPageData, payMethodPageResponse, requestItem.channelId, this.f36289c.cardIndex)) {
            this.mView.updateContentView(this.f36288b, this.f36287a.from, this.f36291e);
            m25670a(this.f36288b, this.f36289c.channelId, this.f36289c.cardIndex);
        }
    }

    public void refreshDataFromLocal(int i, String str) {
        SelectPageInfoRefresher.refreshPayMethodStatus(this.f36288b, i, str);
        EnterprisePayway enterprisePayway = this.f36291e;
        if (enterprisePayway != null) {
            m25671a(enterprisePayway.toggle);
        }
        this.mView.updateContentView(this.f36288b, this.f36287a.from, this.f36291e);
        m25670a(this.f36288b, i, str);
    }

    public void refreshDataFromServer(int i, String str) {
        this.f36289c = new RequestItem(i, str);
        SystemUtils.log(3, "wallet", "Refresh data from server for item: " + this.f36289c.toString(), (Throwable) null, "com.didi.sdk.global.sign.presenter.GlobalSelectPagePresenter", 199);
        requestDataFromServer(this.f36287a.from);
    }

    public void refreshDataFromServer() {
        this.f36289c = null;
        requestDataFromServer(this.f36287a.from);
    }

    /* renamed from: a */
    private void m25670a(PaySelPageData paySelPageData, int i, String str) {
        PaySelItemData next;
        if (paySelPageData != null && paySelPageData.payMethodList != null && paySelPageData.payMethodList.size() != 0 && i != -1) {
            if (i == 121) {
                ((PayMethodSelectFragmentView) this.mView).doEnterprisePayMethodPerformClick(i);
                this.mFragmentActivity.onBackPressed();
                return;
            }
            boolean z = false;
            PaySelItemData paySelItemData = null;
            Iterator<PaySelItemData> it = paySelPageData.payMethodList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
                if (next != null) {
                    if (next.channelId == 150) {
                        if (!TextUtils.isEmpty(next.cardIndex) && next.cardIndex.equals(str)) {
                            break;
                        }
                    } else if (next.channelId == i) {
                        break;
                    }
                }
            }
            paySelItemData = next;
            if (paySelItemData != null) {
                if (paySelItemData.channelId != 150 ? !(paySelItemData.channelId != 190 ? !paySelItemData.isEnabled || paySelItemData.status != 1 : !paySelItemData.isEnabled || paySelItemData.status != 1 || !paySelItemData.isSufficient) : paySelItemData.status == 1) {
                    z = true;
                }
                if (z) {
                    ((PayMethodSelectFragmentView) this.mView).doPayMethodPerformClick(paySelItemData);
                }
            }
        }
    }

    public int getOmegaSource() {
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f36287a;
        if (payMethodListParam == null) {
            return 1;
        }
        int i = C122992.f36296x8a3a0836[payMethodListParam.from.ordinal()];
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

    /* renamed from: com.didi.sdk.global.sign.presenter.GlobalSelectPagePresenter$2 */
    static /* synthetic */ class C122992 {

        /* renamed from: $SwitchMap$com$didi$sdk$global$DidiGlobalPayMethodListData$Entrance */
        static final /* synthetic */ int[] f36296x8a3a0836;

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
                f36296x8a3a0836 = r0
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f36296x8a3a0836     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f36296x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_UNIFIED_PAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f36296x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_GUIDE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f36296x8a3a0836     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_BIKE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.presenter.GlobalSelectPagePresenter.C122992.<clinit>():void");
        }
    }

    public int getOmegaCardCount() {
        PaySelPageData paySelPageData = this.f36288b;
        int i = 0;
        if (paySelPageData == null || paySelPageData.payMethodList == null || this.f36288b.payMethodList.size() == 0) {
            return 0;
        }
        for (PaySelItemData paySelItemData : this.f36288b.payMethodList) {
            if (paySelItemData.channelId == 150) {
                i++;
            }
        }
        return i >= 1 ? i - 1 : i;
    }

    public int getOmegaClickType(PaySelItemData paySelItemData) {
        if (paySelItemData == null) {
            return 1;
        }
        if (paySelItemData.channelId == 150) {
            if (paySelItemData.status == 1) {
                return 2;
            }
            return 3;
        } else if (paySelItemData.channelId == 121) {
            return 1;
        } else {
            return (paySelItemData.channelId == 120 || paySelItemData.status == 1) ? 2 : 1;
        }
    }

    public String getOmegaDefaultPayment() {
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f36287a;
        String str = "";
        if (!(payMethodListParam == null || payMethodListParam.list == null || this.f36287a.list.size() == 0)) {
            for (DidiGlobalPayMethodListData.PayMethodInfo next : this.f36287a.list) {
                if (next.isSelected) {
                    if (TextUtil.isEmpty(str)) {
                        str = str + next.channelId;
                    } else {
                        str = str + "," + next.channelId;
                    }
                }
            }
        }
        return str;
    }

    public void updateEnterpriseView(boolean z) {
        PaySelPageData paySelPageData = this.f36288b;
        if (paySelPageData != null && paySelPageData.payMethodList != null) {
            if (this.f36291e != null) {
                m25671a(z);
            }
            this.f36291e.toggle = z;
            this.mView.updateContentView(this.f36288b, this.f36287a.from, this.f36291e);
        }
    }

    /* renamed from: a */
    private void m25671a(boolean z) {
        for (PaySelItemData next : this.f36288b.payMethodList) {
            if (next != null && next.channelId == 153) {
                if (z) {
                    next.isEnabled = false;
                    next.subTitle = this.f36295i.getString(R.string.one_payment_global_enterprise_cash_tips);
                    next.titleStyle = 2;
                    next.subTitleStyle = 0;
                } else {
                    next.isEnabled = true;
                    next.subTitle = this.f36292f;
                    next.titleStyle = this.f36293g;
                    next.subTitleStyle = this.f36294h;
                }
            }
        }
    }

    public int getEnterpriseFlag() {
        return this.mView.getEnterpriseFlag();
    }

    public boolean hasAvailableCard() {
        PaySelPageData paySelPageData = this.f36288b;
        if (paySelPageData == null || CollectionUtil.isEmpty((Collection<?>) paySelPageData.payMethodList)) {
            return false;
        }
        for (PaySelItemData next : this.f36288b.payMethodList) {
            if (next.channelId == 150 && next.status == 1) {
                return true;
            }
        }
        return false;
    }

    public void postSelectedItemDelay(int i, String str) {
        this.f36290d = new RequestItem(i, str);
    }

    public int getCurrentSelectedChannelId() {
        PaySelPageData paySelPageData = this.f36288b;
        if (paySelPageData == null || CollectionUtil.isEmpty((Collection<?>) paySelPageData.payMethodList)) {
            return 0;
        }
        for (PaySelItemData next : this.f36288b.payMethodList) {
            if (next != null && next.isSelected) {
                return next.channelId;
            }
        }
        return 0;
    }

    public void setCombinePaymentStatus(boolean z) {
        this.mView.showProgressDialog("");
        this.mModel.setCombinePaymentStatus(z, new RpcService.Callback<BaseResult>() {
            public void onSuccess(BaseResult baseResult) {
                GlobalSelectPagePresenter.this.mView.dismissProgressDialog();
            }

            public void onFailure(IOException iOException) {
                GlobalSelectPagePresenter.this.mView.dismissProgressDialog();
            }
        });
    }
}
