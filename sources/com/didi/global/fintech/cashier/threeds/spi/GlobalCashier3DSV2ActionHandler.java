package com.didi.global.fintech.cashier.threeds.spi;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.core.action.IGlobalCashier3DSV2ActionHandler;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.model.net.request.CVVCardInfo;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.global.fintech.cashier.threeds.ThreeDSDataParser;
import com.didi.global.fintech.cashier.threeds.cvv.GlobalCashierCVVActivity;
import com.didi.global.fintech.cashier.threeds.event.CvvNotifyEvent;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;
import global.didi.pay.threeds.contract.ICybs3DS;
import global.didi.pay.threeds.method.cybs.ICybs3DSListener;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import global.didi.pay.threeds.network.model.ThreedsError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@ServiceProvider(alias = "cashier", value = {IGlobalCashier3DSV2ActionHandler.class})
@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001e\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/spi/GlobalCashier3DSV2ActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashier3DSV2ActionHandler;", "Lglobal/didi/pay/threeds/method/cybs/ICybs3DSListener;", "()V", "mAction", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "mCashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "mCybs3DS", "Lglobal/didi/pay/threeds/contract/ICybs3DS;", "mCybsResponseData", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsDataResponse;", "mUniqueId", "", "handle", "", "activity", "action", "cashierParam", "uniqueId", "onCancel", "", "onCybsThreeDSData", "data", "cvv", "onDestroy", "onEvent", "Lcom/didi/global/fintech/cashier/threeds/event/CvvNotifyEvent;", "onFailure", "error", "Lglobal/didi/pay/threeds/network/model/ThreedsError;", "onSuccess", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashier3DSV2ActionHandler.kt */
public final class GlobalCashier3DSV2ActionHandler implements IGlobalCashier3DSV2ActionHandler, ICybs3DSListener {

    /* renamed from: a */
    private FragmentActivity f21683a;

    /* renamed from: b */
    private ICybs3DS f21684b;

    /* renamed from: c */
    private CashierAction f21685c;

    /* renamed from: d */
    private String f21686d;

    /* renamed from: e */
    private CashierParam f21687e;

    /* renamed from: f */
    private ThreedsCybsDataResponse f21688f;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d2 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handle(androidx.fragment.app.FragmentActivity r3, com.didi.global.fintech.cashier.model.net.request.CashierAction r4, com.didi.global.fintech.cashier.user.model.CashierParam r5, java.lang.String r6) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r2.f21686d = r6
            r2.f21683a = r3
            r2.f21687e = r5
            r5 = r2
            com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSV2ActionHandler r5 = (com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSV2ActionHandler) r5
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x001b
        L_0x0014:
            boolean r0 = r4.threeDSV2()
            if (r0 != 0) goto L_0x0012
            r0 = 1
        L_0x001b:
            if (r0 != 0) goto L_0x0042
            if (r4 != 0) goto L_0x0021
        L_0x001f:
            r0 = 0
            goto L_0x003d
        L_0x0021:
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r0 = r4.getActionData()
            if (r0 != 0) goto L_0x0028
            goto L_0x001f
        L_0x0028:
            java.lang.String r0 = r0.getSessionId()
            if (r0 != 0) goto L_0x002f
            goto L_0x001f
        L_0x002f:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0039
            r0 = 1
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            if (r0 != r5) goto L_0x001f
            r0 = 1
        L_0x003d:
            if (r0 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r0 = 0
            goto L_0x0043
        L_0x0042:
            r0 = 1
        L_0x0043:
            r1 = 0
            if (r0 == 0) goto L_0x0048
            r0 = r2
            goto L_0x0049
        L_0x0048:
            r0 = r1
        L_0x0049:
            com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSV2ActionHandler r0 = (com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSV2ActionHandler) r0
            if (r0 != 0) goto L_0x00d2
            r2.f21685c = r4
            global.didi.pay.threeds.contract.ICybs3DS r4 = r2.f21684b
            if (r4 != 0) goto L_0x009d
            global.didi.pay.threeds.contract.ICybs3DS r3 = global.didi.pay.threeds.ThreeDSFactory.getCybs3DS(r3)
            r2.f21684b = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r3 = (java.util.Map) r3
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils$Companion r4 = com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils.Companion
            java.lang.String r4 = r4.getUid()
            java.lang.String r6 = ""
            if (r4 != 0) goto L_0x006b
            r4 = r6
        L_0x006b:
            java.lang.String r0 = "uid"
            r3.put(r0, r4)
            java.lang.String r4 = "scene"
            java.lang.String r0 = "trade"
            r3.put(r4, r0)
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils$Companion r4 = com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils.Companion
            java.lang.String r4 = r4.getOid()
            if (r4 != 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r6 = r4
        L_0x0084:
            java.lang.String r4 = "order_id"
            r3.put(r4, r6)
            global.didi.pay.threeds.contract.ICybs3DS r4 = r2.f21684b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r4.updateOmegaAttr(r3)
            global.didi.pay.threeds.contract.ICybs3DS r3 = r2.f21684b
            if (r3 != 0) goto L_0x0097
            goto L_0x009d
        L_0x0097:
            r4 = r2
            global.didi.pay.threeds.method.cybs.ICybs3DSListener r4 = (global.didi.pay.threeds.method.cybs.ICybs3DSListener) r4
            r3.registerListener(r4)
        L_0x009d:
            global.didi.pay.threeds.contract.ICybs3DS r3 = r2.f21684b
            if (r3 != 0) goto L_0x00a2
            goto L_0x00d1
        L_0x00a2:
            global.didi.pay.threeds.model.Cybs3DSModel r4 = new global.didi.pay.threeds.model.Cybs3DSModel
            r4.<init>()
            com.didi.global.fintech.cashier.model.net.request.CashierAction r6 = r2.f21685c
            if (r6 != 0) goto L_0x00ad
        L_0x00ab:
            r6 = r1
            goto L_0x00b8
        L_0x00ad:
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r6 = r6.getActionData()
            if (r6 != 0) goto L_0x00b4
            goto L_0x00ab
        L_0x00b4:
            java.lang.String r6 = r6.getSessionId()
        L_0x00b8:
            r4.sessionId = r6
            com.didi.global.fintech.cashier.model.net.request.CashierAction r6 = r2.f21685c
            if (r6 != 0) goto L_0x00bf
            goto L_0x00ca
        L_0x00bf:
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r6 = r6.getActionData()
            if (r6 != 0) goto L_0x00c6
            goto L_0x00ca
        L_0x00c6:
            java.lang.String r1 = r6.getChannelNameOf3ds()
        L_0x00ca:
            r4.channelNameOf3ds = r1
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r3.handleModel(r4)
        L_0x00d1:
            return r5
        L_0x00d2:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSV2ActionHandler.handle(androidx.fragment.app.FragmentActivity, com.didi.global.fintech.cashier.model.net.request.CashierAction, com.didi.global.fintech.cashier.user.model.CashierParam, java.lang.String):boolean");
    }

    public void onDestroy() {
        this.f21685c = null;
        ICybs3DS iCybs3DS = this.f21684b;
        if (iCybs3DS != null) {
            iCybs3DS.unregisterListener();
        }
        this.f21684b = null;
    }

    public void onCancel() {
        FragmentActivity fragmentActivity = this.f21683a;
        String str = null;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = fragmentActivity instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) fragmentActivity : null;
        if (iGlobalCashierActionHandleCallback != null) {
            FragmentActivity fragmentActivity2 = this.f21683a;
            if (fragmentActivity2 != null) {
                str = fragmentActivity2.getString(R.string.threeds_fail_message);
            }
            iGlobalCashierActionHandleCallback.onThreeDSCancel(str, CashierAction.ACTION_THREE_DS_V2);
        }
    }

    public void onFailure(ThreedsError threedsError) {
        Intrinsics.checkNotNullParameter(threedsError, "error");
        new RuntimeException().printStackTrace();
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onFailure: ", threedsError.getMessage()), (Throwable) null, "com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSV2ActionHandler", 80);
        FragmentActivity fragmentActivity = this.f21683a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = fragmentActivity instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) fragmentActivity : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onThreeDSFailed(threedsError.getMessage(), CashierAction.ACTION_THREE_DS_V2);
        }
    }

    public void onSuccess(ThreedsCybsDataResponse threedsCybsDataResponse) {
        CashierActionData actionData;
        Intrinsics.checkNotNullParameter(threedsCybsDataResponse, "data");
        GlobalCashier3DSV2ActionHandler globalCashier3DSV2ActionHandler = this;
        CVVCardInfo cVVCardInfo = null;
        GlobalCashier3DSV2ActionHandler globalCashier3DSV2ActionHandler2 = threedsCybsDataResponse.getNeedCvv() ^ true ? this : null;
        if (globalCashier3DSV2ActionHandler2 == null) {
            globalCashier3DSV2ActionHandler2 = null;
        } else {
            globalCashier3DSV2ActionHandler2.m15809a(threedsCybsDataResponse, (String) null);
        }
        if (globalCashier3DSV2ActionHandler2 == null) {
            globalCashier3DSV2ActionHandler.f21688f = threedsCybsDataResponse;
            if (!EventBus.getDefault().isRegistered(globalCashier3DSV2ActionHandler)) {
                EventBus.getDefault().register(globalCashier3DSV2ActionHandler);
            }
            FragmentActivity fragmentActivity = globalCashier3DSV2ActionHandler.f21683a;
            if (fragmentActivity != null) {
                GlobalCashierCVVActivity.Companion companion = GlobalCashierCVVActivity.Companion;
                FragmentActivity fragmentActivity2 = globalCashier3DSV2ActionHandler.f21683a;
                Intrinsics.checkNotNull(fragmentActivity2);
                Context context = fragmentActivity2;
                CashierParam cashierParam = globalCashier3DSV2ActionHandler.f21687e;
                CashierAction cashierAction = globalCashier3DSV2ActionHandler.f21685c;
                if (!(cashierAction == null || (actionData = cashierAction.getActionData()) == null)) {
                    cVVCardInfo = actionData.getCvvCardInfo();
                }
                fragmentActivity.startActivity(companion.startIntent(context, cashierParam, cVVCardInfo, globalCashier3DSV2ActionHandler.f21686d));
            }
        }
    }

    @Subscribe
    public final void onEvent(CvvNotifyEvent cvvNotifyEvent) {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        GlobalCashier3DSV2ActionHandler globalCashier3DSV2ActionHandler = this;
        String str = null;
        GlobalCashier3DSV2ActionHandler globalCashier3DSV2ActionHandler2 = (cvvNotifyEvent == null ? null : cvvNotifyEvent.getCvv()) == null ? this : null;
        if (globalCashier3DSV2ActionHandler2 == null) {
            globalCashier3DSV2ActionHandler2 = null;
        } else {
            globalCashier3DSV2ActionHandler2.onCancel();
        }
        if (globalCashier3DSV2ActionHandler2 == null) {
            ThreedsCybsDataResponse threedsCybsDataResponse = globalCashier3DSV2ActionHandler.f21688f;
            if (cvvNotifyEvent != null) {
                str = cvvNotifyEvent.getCvv();
            }
            globalCashier3DSV2ActionHandler.m15809a(threedsCybsDataResponse, str);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m15808a(GlobalCashier3DSV2ActionHandler globalCashier3DSV2ActionHandler, ThreedsCybsDataResponse threedsCybsDataResponse, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        globalCashier3DSV2ActionHandler.m15809a(threedsCybsDataResponse, str);
    }

    /* renamed from: a */
    private final void m15809a(ThreedsCybsDataResponse threedsCybsDataResponse, String str) {
        FragmentActivity fragmentActivity = this.f21683a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = fragmentActivity instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) fragmentActivity : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onCybsThreeDSSuccess(ThreeDSDataParser.ThreedsCybsDataToThreeDSV2(threedsCybsDataResponse), str);
        }
    }
}
