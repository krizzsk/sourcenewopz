package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.event.home.MapEventKey;
import com.didi.payment.base.event.home.MapEventManager;
import com.didi.payment.base.event.home.WalletEvent;
import com.didi.payment.base.tracker.FinExtAttrBiz;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.commonsdk.utils.NClipBoardUtil;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr.FinSysPopTask;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr.PopTask;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr.WHomePopChain;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountStatusMessage;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.BtnItem;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.CommonResourceState;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.DisposalSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Entry;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModel;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.FreezeInterceptor;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.dialog.WalletDrawerContent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.Constants;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(mo175977d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0014\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001dH\u0016J\u0012\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010'\u001a\u00020\u001d2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010(\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\b\u00100\u001a\u00020\u001dH\u0016J\b\u00101\u001a\u00020\u001dH\u0002J\u0012\u00102\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020\u001dH\u0016J\u0012\u00106\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u00108\u001a\u00020\u001d2\b\u00109\u001a\u0004\u0018\u00010:H\u0007J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\tH\u0016J(\u0010=\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\t2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J\b\u0010A\u001a\u00020\u001dH\u0016J\b\u0010B\u001a\u00020\u001dH\u0016J\b\u0010C\u001a\u00020\u001dH\u0016J\u0010\u0010D\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u00010EJ\u0012\u0010F\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010G\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\tH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006J"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeV2Presenter;", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$Presenter;", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "Lcom/didi/payment/base/event/home/WalletEvent;", "context", "Landroid/app/Activity;", "view", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2View;", "source", "", "(Landroid/app/Activity;Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2View;Ljava/lang/String;)V", "finExtAttrBiz", "Lcom/didi/payment/base/tracker/FinExtAttrBiz;", "mContext", "mDataRefreshed", "", "mDestoryed", "mHomeData", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;", "mModel", "Lcom/didi/payment/wallet/global/model/WalletPageModel;", "mView", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "addSourceStr", "link", "autoDetectQrCode", "", "autoVerifyQRCode", "qrcode", "checkQRCode", "qrCode", "getEndOfDayInMillis", "", "init", "onAccountBlocked2UnBlock", "router", "onAccountMainEnterClicked", "status", "onBankListClick", "url", "onConsumeItemClicked", "item", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Entry;", "onDestroy", "onRefreshPage", "onRefreshUI", "onResponseFailure", "onResponseSuccess", "value", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/WalletHomeModel;", "onResume", "onStatusMsgClicked", "data", "onWalletDataRefreshed", "event", "Lcom/didi/payment/base/event/WalletRefreshDataEvent;", "onWalletEvent", "key", "popUpKycInfoDialog", "productLine", "dialogData", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/DisposalSection;", "requestData", "requestDataIfNeeded", "requestPwdGuideData", "setFinSysPopTaskData", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/CommonResourceState;", "showTopUpGuidePageIfNeeded", "trackResponseSuccessData", "updateFinExtPubAttrs", "sourceFrom", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter */
/* compiled from: WalletHomeV2Presenter.kt */
public final class WalletHomeV2Presenter implements WalletEvent, WalletHomeContract.Presenter, WalletHomeContract.V2Listener {

    /* renamed from: a */
    private String f32657a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f32658b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletHomeContract.V2View f32659c;

    /* renamed from: d */
    private WalletPageModel f32660d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Data f32661e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f32662f;

    /* renamed from: g */
    private boolean f32663g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final FinExtAttrBiz f32664h;

    public void requestPwdGuideData() {
    }

    public WalletHomeV2Presenter(Activity activity, WalletHomeContract.V2View v2View, String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.f32657a = str;
        this.f32664h = new FinExtAttrBiz();
        this.f32658b = activity;
        this.f32659c = v2View;
        this.f32660d = new WalletPageModel(activity);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletHomeV2Presenter(Activity activity, WalletHomeContract.V2View v2View, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, v2View, (i & 4) != 0 ? "2" : str);
    }

    public final String getSource() {
        return this.f32657a;
    }

    public final void setSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f32657a = str;
    }

    public void init() {
        m23104a(FinExtAttrBiz.FROM_HOME_INIT);
        WalletHomeContract.V2View v2View = this.f32659c;
        if (v2View != null) {
            v2View.setListener(this);
        }
        WalletHomeContract.V2View v2View2 = this.f32659c;
        if (v2View2 != null) {
            v2View2.initLoadingDialog(this.f32658b);
        }
        EventBus.getDefault().register(this);
        WalletHomeDialogManager.INSTANCE.init();
        WalletEvent walletEvent = this;
        MapEventManager.INSTANCE.register(MapEventKey.WALLET_HOME_BANK, walletEvent);
        MapEventManager.INSTANCE.register(MapEventKey.WALLET_HOME_UPDATE, walletEvent);
    }

    public void requestData() {
        this.f32663g = false;
        this.f32661e = new Data();
        WalletHomeContract.V2View v2View = this.f32659c;
        if (v2View != null) {
            v2View.showLoadingDialog();
        }
        if (this.f32658b != null) {
            WHomePopChain addTask = WHomePopChain.INSTANCE.addTask(100);
            Activity activity = this.f32658b;
            Intrinsics.checkNotNull(activity);
            addTask.start(activity, 100);
            WHomePopChain addTask2 = WHomePopChain.INSTANCE.addTask(200);
            Activity activity2 = this.f32658b;
            Intrinsics.checkNotNull(activity2);
            addTask2.start(activity2, 200);
        }
        WalletPageModel walletPageModel = this.f32660d;
        if (walletPageModel != null) {
            walletPageModel.getWalletHomeV2Info(this.f32657a, new WalletHomeV2Presenter$requestData$1(this));
        }
    }

    public final void setFinSysPopTaskData(CommonResourceState commonResourceState) {
        PopTask taskById = WHomePopChain.INSTANCE.getTaskById(200);
        if (taskById != null && (taskById instanceof FinSysPopTask)) {
            ((FinSysPopTask) taskById).setData(commonResourceState);
        }
    }

    public void onResume() {
        m23104a(FinExtAttrBiz.FROM_HOME_RESUME);
    }

    /* renamed from: a */
    private final void m23104a(String str) {
        Activity activity = this.f32658b;
        if (activity != null) {
            this.f32664h.updateExtAttrs2FinGlobalAttrs(activity.getIntent().getStringExtra("ext"), str);
        }
    }

    public void onDestroy() {
        this.f32662f = true;
        EventBus.getDefault().unregister(this);
        WalletHomeContract.V2View v2View = this.f32659c;
        if (v2View != null) {
            v2View.dismissLoadingDialog();
        }
        MapEventManager.INSTANCE.unRegister(MapEventKey.WALLET_HOME_BANK);
        MapEventManager.INSTANCE.unRegister(MapEventKey.WALLET_HOME_UPDATE);
    }

    public void requestDataIfNeeded() {
        if (this.f32661e == null || this.f32663g) {
            requestData();
        }
    }

    public void checkQRCode(String str) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                WalletHomeV2Presenter.m23101a(WalletHomeV2Presenter.this);
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23101a(WalletHomeV2Presenter walletHomeV2Presenter) {
        Intrinsics.checkNotNullParameter(walletHomeV2Presenter, "this$0");
        walletHomeV2Presenter.m23100a();
    }

    /* renamed from: a */
    private final void m23100a() {
        String clipboardText = NClipBoardUtil.Companion.getClipboardText(this.f32658b);
        if (!TextUtil.isEmpty(clipboardText)) {
            CharSequence charSequence = clipboardText;
            if (!StringsKt.contains$default(charSequence, (CharSequence) "BR.GOV.BCB.PIX", false, 2, (Object) null)) {
                String lowerCase = "BR.GOV.BCB.PIX".toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (!StringsKt.contains$default(charSequence, (CharSequence) lowerCase, false, 2, (Object) null)) {
                    return;
                }
            }
            m23109b(clipboardText);
        }
    }

    /* renamed from: b */
    private final void m23109b(String str) {
        WalletPageModel walletPageModel = this.f32660d;
        if (walletPageModel != null) {
            walletPageModel.queryPixQrCode(str, new WalletHomeV2Presenter$autoVerifyQRCode$1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23103a(WalletHomeModel walletHomeModel) {
        if (!this.f32662f) {
            WalletHomeContract.V2View v2View = this.f32659c;
            Intrinsics.checkNotNull(v2View);
            v2View.dismissLoadingDialog();
            PayTracker.trackEvent("ibt_gp_didipay_top_banner_mp_sw");
            if (walletHomeModel == null) {
                PayBaseToast.showInfo((Context) this.f32658b, (int) R.string.one_payment_global_net_toast_serverbusy);
            } else if (walletHomeModel.errno == 0) {
                Data data = walletHomeModel.getData();
                if (data != null) {
                    this.f32661e = data;
                    WalletHomeContract.V2View v2View2 = this.f32659c;
                    if (v2View2 != null) {
                        v2View2.updateContent(data);
                    }
                    m23102a(data);
                    m23108b(data);
                    FreezeInterceptor.INSTANCE.init(data.getNewFreezeSection());
                }
            } else if (401 == walletHomeModel.errno || 405 == walletHomeModel.errno) {
                WalletHomeContract.V2View v2View3 = this.f32659c;
                if (v2View3 != null) {
                    v2View3.updateEmptyView(walletHomeModel.errmsg);
                }
            } else {
                PayBaseToast.showInfo((Context) this.f32658b, walletHomeModel.errmsg);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r0 = (r0 = r0.getAccountStatusMessage()).getStatus();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m23102a(com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            goto L_0x005a
        L_0x0003:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r6.getAccountSection()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            r0 = 0
            goto L_0x0023
        L_0x000e:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x0015
            goto L_0x000c
        L_0x0015:
            java.lang.String r0 = r0.getStatus()
            if (r0 != 0) goto L_0x001c
            goto L_0x000c
        L_0x001c:
            int r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r0, r3, r2, r1)
            if (r0 != r2) goto L_0x000c
            r0 = 1
        L_0x0023:
            if (r0 == 0) goto L_0x005a
            java.lang.String r0 = r6.getChannelId()
            if (r0 != 0) goto L_0x002d
        L_0x002b:
            r2 = 0
            goto L_0x0035
        L_0x002d:
            int r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r0, r3, r2, r1)
            r4 = 190(0xbe, float:2.66E-43)
            if (r0 != r4) goto L_0x002b
        L_0x0035:
            if (r2 == 0) goto L_0x005a
            android.app.Activity r0 = r5.f32658b
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.didi.payment.wallet.global.utils.WalletSPUtils.needShowTopUpGuide(r0)
            if (r0 == 0) goto L_0x005a
            android.app.Activity r0 = r5.f32658b
            android.content.Context r0 = (android.content.Context) r0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r6 = r6.getAccountSection()
            if (r6 != 0) goto L_0x004c
            goto L_0x0050
        L_0x004c:
            com.didi.payment.base.service.IWalletService$AccountInfo r1 = r6.getAccountStatus()
        L_0x0050:
            com.didi.payment.wallet.global.utils.WalletRouter.gotoTopUpGuidePage(r0, r1)
            android.app.Activity r6 = r5.f32658b
            android.content.Context r6 = (android.content.Context) r6
            com.didi.payment.wallet.global.utils.WalletSPUtils.topUpGuideHasShowed(r6)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeV2Presenter.m23102a(com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data):void");
    }

    /* renamed from: b */
    private final void m23108b(Data data) {
        String str;
        String interestStatus;
        AccountStatusMessage accountStatusMessage;
        AccountStatusMessage accountStatusMessage2;
        String status;
        PayRichInfo detailsMessage;
        AccountStatusMessage accountStatusMessage3;
        if (data != null) {
            WalletHomeTrackerManager.Companion.trackPaySKUSW(data.getPaySection());
            WalletHomeTrackerManager.Companion.trackFinancialSW(data.getFinancialSection());
            WalletHomeTrackerManager.Companion companion = WalletHomeTrackerManager.Companion;
            CommonResourceState commonResourceState = data.getCommonResourceState();
            companion.trackFinBannerSW(commonResourceState == null ? null : commonResourceState.getBannerState());
            if (data.getAccountSection() != null) {
                AccountSection accountSection = data.getAccountSection();
                PayTracker.putGlobal("wallet_account_status", (accountSection == null || (accountStatusMessage3 = accountSection.getAccountStatusMessage()) == null) ? null : accountStatusMessage3.getStatus());
                AccountSection accountSection2 = data.getAccountSection();
                PayTracker.putGlobal("facial_recognition_status", accountSection2 == null ? null : accountSection2.getAuthenticationStatus());
            }
            if (data.getAccountSection() != null) {
                AccountSection accountSection3 = data.getAccountSection();
                if (!TextUtils.isEmpty((accountSection3 == null || (detailsMessage = accountSection3.getDetailsMessage()) == null) ? null : detailsMessage.text)) {
                    AccountSection accountSection4 = data.getAccountSection();
                    boolean z = true;
                    if (accountSection4 == null || (accountStatusMessage2 = accountSection4.getAccountStatusMessage()) == null || (status = accountStatusMessage2.getStatus()) == null || WalletHomeModelKt.toDefaultInt$default(status, 0, 1, (Object) null) != 1) {
                        z = false;
                    }
                    if (z) {
                        Map hashMap = new HashMap();
                        AccountSection accountSection5 = data.getAccountSection();
                        String str2 = "";
                        if (accountSection5 == null || (accountStatusMessage = accountSection5.getAccountStatusMessage()) == null || (str = accountStatusMessage.getStatus()) == null) {
                            str = str2;
                        }
                        hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, str);
                        AccountSection accountSection6 = data.getAccountSection();
                        if (!(accountSection6 == null || (interestStatus = accountSection6.getInterestStatus()) == null)) {
                            str2 = interestStatus;
                        }
                        hashMap.put("interest_status", str2);
                        PayTracker.trackEvent("ibt_didipay_top_navigation_interest_status_sw", hashMap);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m23107b() {
        if (!this.f32662f) {
            WalletHomeContract.V2View v2View = this.f32659c;
            if (v2View != null) {
                v2View.dismissLoadingDialog();
            }
            PayBaseToast.showInfo((Context) this.f32658b, (int) R.string.one_payment_global_net_toast_connectionerror);
            WalletHomeContract.V2View v2View2 = this.f32659c;
            if (v2View2 != null) {
                v2View2.updateContent(null);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onWalletDataRefreshed(WalletRefreshDataEvent walletRefreshDataEvent) {
        this.f32663g = true;
    }

    public void onRefreshPage() {
        if (!PayBaseParamUtil.isLogin(this.f32658b)) {
            PayBaseParamUtil.doLogin(this.f32658b);
        } else {
            requestData();
        }
    }

    public void onAccountMainEnterClicked(String str, String str2) {
        ((Request) DRouter.build(m23111c(str)).putExtra("key_from", 3)).start(this.f32658b);
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", str2);
        PayTracker.trackEvent("gp_99pay_payment_btn_ck", linkedHashMap);
    }

    public void onAccountBlocked2UnBlock(String str) {
        DRouter.build(str).start(this.f32658b);
    }

    public void onRefreshUI() {
        WalletHomeContract.V2View v2View = this.f32659c;
        if (v2View != null) {
            v2View.onRefreshUI();
        }
    }

    public void onBankListClick(String str) {
        FreezeInterceptor.onInterceptor$default(FreezeInterceptor.INSTANCE, this.f32658b, 2, false, new WalletHomeV2Presenter$onBankListClick$1(str, this), 4, (Object) null);
    }

    public void onConsumeItemClicked(Entry entry) {
        if (entry != null) {
            FreezeInterceptor.onInterceptor$default(FreezeInterceptor.INSTANCE, this.f32658b, 1, false, new WalletHomeV2Presenter$onConsumeItemClicked$1$1(this, entry, entry), 4, (Object) null);
        }
    }

    public void onStatusMsgClicked(Data data) {
        if (data != null) {
            FreezeInterceptor.onInterceptor$default(FreezeInterceptor.INSTANCE, this.f32658b, 2, false, new WalletHomeV2Presenter$onStatusMsgClicked$1$1(data, this, data), 4, (Object) null);
        }
    }

    public void onWalletEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        requestData();
    }

    /* renamed from: c */
    private final String m23111c(String str) {
        if (str == null) {
            return str;
        }
        CharSequence charSequence = str;
        if (!StringsKt.contains$default(charSequence, (CharSequence) GlobalCashierBizPresenter.OMEGA_ATTR_PUB_SOURCE, false, 2, (Object) null)) {
            String str2 = Intrinsics.areEqual((Object) WalletHomeTrackerManager.Companion.getSource(), (Object) "1") ? "wallet_mainlist_topup" : "wallet_home_topup";
            if (StringsKt.contains$default(charSequence, (CharSequence) "?", false, 2, (Object) null)) {
                str = str + "&pub_source=" + str2;
            } else {
                str = str + "?pub_source=" + str2;
            }
        }
        String nextPageExt = this.f32664h.getNextPageExt((String) null);
        CharSequence charSequence2 = str;
        if (!StringsKt.contains$default(charSequence2, (CharSequence) "ddw_top_up", false, 2, (Object) null) || TextUtils.isEmpty(nextPageExt)) {
            return str;
        }
        if (StringsKt.contains$default(charSequence2, (CharSequence) "?", false, 2, (Object) null)) {
            return str + "&ext=" + nextPageExt;
        }
        return str + "?ext=" + nextPageExt;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m23105a(WalletHomeV2Presenter walletHomeV2Presenter, Entry entry, String str, DisposalSection disposalSection, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return walletHomeV2Presenter.m23106a(entry, str, disposalSection);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m23106a(Entry entry, String str, DisposalSection disposalSection) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        BtnItem cancelBtn;
        BtnItem confirmBtn;
        String str7 = str;
        DisposalSection disposalSection2 = disposalSection;
        Activity activity = this.f32658b;
        String str8 = null;
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity == null) {
            return false;
        }
        Context context = fragmentActivity;
        Long skuKycDialogNextShowTime = WalletSPUtils.getSkuKycDialogNextShowTime(context, str7);
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullExpressionValue(skuKycDialogNextShowTime, "nextShownTime");
        if (currentTimeMillis < skuKycDialogNextShowTime.longValue()) {
            return false;
        }
        WalletSPUtils.setSkuKycDialogNextShowTime(context, str7, Long.valueOf(m23110c()));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        WalletDialog.Companion companion = WalletDialog.Companion;
        WalletDrawerContent.Builder builder = new WalletDrawerContent.Builder();
        if (disposalSection2 == null) {
            str2 = null;
        } else {
            str2 = disposalSection.getTitle();
        }
        builder.setTitle(str2);
        if (disposalSection2 == null) {
            str3 = null;
        } else {
            str3 = disposalSection.getDesc();
        }
        builder.setContent(str3);
        if (disposalSection2 == null || (confirmBtn = disposalSection.getConfirmBtn()) == null) {
            str4 = null;
        } else {
            str4 = confirmBtn.getLabel();
        }
        builder.setFirstBtnText(str4);
        builder.setFirstClickListener(new WalletHomeV2Presenter$popUpKycInfoDialog$1$1(str7, disposalSection2, fragmentActivity, objectRef));
        if (disposalSection2 == null || (cancelBtn = disposalSection.getCancelBtn()) == null) {
            str5 = null;
        } else {
            str5 = cancelBtn.getLabel();
        }
        builder.setSecondBtnText(str5);
        builder.setSecondClickListener(new WalletHomeV2Presenter$popUpKycInfoDialog$1$2(str, disposalSection, entry, objectRef, this));
        if (disposalSection2 == null) {
            str6 = null;
        } else {
            str6 = disposalSection.getIcon();
        }
        builder.setImageUrl(str6);
        builder.setShowClose(false);
        Unit unit = Unit.INSTANCE;
        Ref.ObjectRef objectRef2 = objectRef;
        objectRef2.element = WalletDialog.Companion.configDrawer$default(companion, context, builder, false, false, 4, (Object) null);
        SystemUtils.showDialog((WalletDialog) objectRef2.element);
        WalletHomeTrackerManager.Companion companion2 = WalletHomeTrackerManager.Companion;
        if (disposalSection2 != null) {
            str8 = disposalSection.getBlockId();
        }
        companion2.trackHomeKycPopupSW(str7, str8);
        return true;
    }

    /* renamed from: c */
    private final long m23110c() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis() + ((long) Constants.TIME_DAY);
    }
}
