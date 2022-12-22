package com.didi.map.global.flow.scene.order.bluetooth_meet;

import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMState;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eJ\u001a\u0010#\u001a\u00020\u001e2\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u001eJ\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007J\u0016\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u001cJ\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0019J\u0006\u0010/\u001a\u00020\u001eJ\b\u00100\u001a\u00020\u001eH\u0002J\b\u00101\u001a\u00020\u001eH\u0002J\u0006\u00102\u001a\u00020\u001eJ\b\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020\u001eH\u0002J\u001a\u00105\u001a\u00020\u001e2\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u0007J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0007R\u000e\u0010\u0005\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/BTMOmegaHelper;", "", "orderId", "", "(Ljava/lang/String;)V", "TAG", "connect_error", "", "endGuideTimeStamp", "", "endPairTimeStamp", "firstFailWrapper", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/FailureStateWrapper;", "hasPairingFailed", "getHasPairingFailed", "()Z", "setHasPairingFailed", "(Z)V", "getOrderId", "()Ljava/lang/String;", "secondFailWrapper", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/SecondFailureStateWrapper;", "startGuideTimeStamp", "startPairTimeStamp", "uiState", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMState;", "userInitiaClickClose", "wrongDirectionCount", "", "onClickBluetoothIcon", "", "onCloseWay", "onCloseWhen", "onDestroy", "onFailed", "onPairedFailureDialogClick", "clickContinue", "quit", "onUserInitiaClickClose", "setBluetoothState", "hasPermission", "enable", "setPermissionGrantedState", "granted", "channel", "setUiState", "state", "startPair", "trackFindingProcess", "trackFirstBadcase1ck", "trackMapBtnaviLinkbroken_bt", "trackMapBtnaviPaxmatchBt", "trackSecondBadcase2bt", "trackSecondBadcase2ck", "tryAgain", "fromTryAgainBtn", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMOmegaHelper.kt */
public final class BTMOmegaHelper {

    /* renamed from: a */
    private final String f26435a;

    /* renamed from: b */
    private final String f26436b = "btm_omega";

    /* renamed from: c */
    private long f26437c;

    /* renamed from: d */
    private long f26438d;

    /* renamed from: e */
    private boolean f26439e;

    /* renamed from: f */
    private BTMState f26440f;

    /* renamed from: g */
    private long f26441g;

    /* renamed from: h */
    private long f26442h;

    /* renamed from: i */
    private int f26443i;

    /* renamed from: j */
    private boolean f26444j;

    /* renamed from: k */
    private final FailureStateWrapper f26445k = new FailureStateWrapper();

    /* renamed from: l */
    private final SecondFailureStateWrapper f26446l = new SecondFailureStateWrapper();

    /* renamed from: m */
    private boolean f26447m;

    public BTMOmegaHelper(String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        this.f26435a = str;
    }

    public final String getOrderId() {
        return this.f26435a;
    }

    public final boolean getHasPairingFailed() {
        return this.f26439e;
    }

    public final void setHasPairingFailed(boolean z) {
        this.f26439e = z;
    }

    public final void startPair() {
        if (!this.f26439e) {
            this.f26437c = System.currentTimeMillis();
            this.f26445k.setStartPairTimeStamp(System.currentTimeMillis());
        }
    }

    public final void onFailed() {
        BTMState bTMState = this.f26440f;
        if (bTMState != null) {
            if (bTMState.getValue() < BTMState.PAIRED.getValue() && !this.f26439e) {
                this.f26445k.setEndPairTimeStamp(System.currentTimeMillis());
                this.f26439e = true;
            }
            if (bTMState.getValue() >= BTMState.PAIRED.getValue()) {
                this.f26447m = true;
            }
        }
    }

    public final void tryAgain(boolean z) {
        if (z) {
            this.f26445k.setClickTryAgain(z);
            m18755c();
            this.f26446l.setStartPairTimeStamp(System.currentTimeMillis());
        }
    }

    /* renamed from: a */
    private final void m18753a() {
        int i;
        if (this.f26440f == BTMState.VERY_NEAR || this.f26440f == BTMState.ON_BOARD) {
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("order_id", this.f26435a);
            if (!this.f26444j || !(this.f26440f == BTMState.VERY_NEAR || this.f26440f == BTMState.ON_BOARD)) {
                i = (this.f26444j || this.f26440f != BTMState.ON_BOARD) ? -1 : 1;
            } else {
                i = 0;
            }
            linkedHashMap.put("close_way", Integer.valueOf(i));
            GlobalOmegaTracker.trackEvent("map_btnavi_closeway_ck", linkedHashMap);
        }
    }

    /* renamed from: b */
    private final void m18754b() {
        int i;
        BTMState bTMState = this.f26440f;
        if (bTMState != null) {
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("order_id", this.f26435a);
            if (bTMState == BTMState.PAIRING) {
                i = 0;
            } else if (bTMState == BTMState.PAIRED) {
                i = 1;
            } else if (bTMState == BTMState.INIT_DIRECTION || bTMState == BTMState.RIGHT_DIRECTION || bTMState == BTMState.WRONG_DIRECTION || bTMState == BTMState.WRONG_DIRECTION_TOTALLY || bTMState == BTMState.VERY_NEAR) {
                i = 2;
            } else if (bTMState == BTMState.PAIRING_FAILURE && !this.f26445k.getClickTryAgain()) {
                i = 3;
            } else if (bTMState == BTMState.PAIRING && this.f26445k.getClickTryAgain()) {
                i = 4;
            } else if (bTMState != BTMState.PAIRING_FAILURE || !this.f26445k.getClickTryAgain()) {
                i = bTMState == BTMState.VERY_NEAR ? 6 : (bTMState == BTMState.NO_PERMISSION || bTMState == BTMState.BLUETOOTH_TURNOFF) ? 7 : -1;
            } else {
                i = 5;
            }
            linkedHashMap.put("close_when", Integer.valueOf(i));
            GlobalOmegaTracker.trackEvent("map_btnavi_closewhen_ck", linkedHashMap);
        }
    }

    public final void onClickBluetoothIcon() {
        String str;
        if (this.f26440f == BTMState.PAIRING) {
            str = "map_btnavi_paxmatch1_ck";
        } else if (this.f26440f == BTMState.NO_PERMISSION) {
            str = "map_btnavi_paxmatch2_ck";
        } else {
            str = null;
        }
        if (str != null) {
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("order_id", this.f26435a);
            GlobalOmegaTracker.trackEvent(str, linkedHashMap);
        }
    }

    public final void onUserInitiaClickClose() {
        this.f26444j = true;
    }

    /* renamed from: c */
    private final void m18755c() {
        long j;
        long j2;
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f26435a);
        if (this.f26445k.getStartPairTimeStamp() > 0) {
            if (this.f26445k.getEndPairTimeStamp() == 0) {
                j2 = System.currentTimeMillis();
                j = this.f26445k.getStartPairTimeStamp();
            } else {
                j2 = this.f26445k.getEndPairTimeStamp();
                j = this.f26445k.getStartPairTimeStamp();
            }
            linkedHashMap.put("duration", Long.valueOf(j2 - j));
        }
        GlobalOmegaTracker.trackEvent("map_btnavi_paxbadcase1_ck", linkedHashMap);
    }

    public static /* synthetic */ void onPairedFailureDialogClick$default(BTMOmegaHelper bTMOmegaHelper, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        bTMOmegaHelper.onPairedFailureDialogClick(z, z2);
    }

    public final void onPairedFailureDialogClick(boolean z, boolean z2) {
        trackSecondBadcase2ck(z, z2);
        if (z) {
            this.f26446l.setClickTryAgain(true);
        }
    }

    public static /* synthetic */ void trackSecondBadcase2ck$default(BTMOmegaHelper bTMOmegaHelper, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        bTMOmegaHelper.trackSecondBadcase2ck(z, z2);
    }

    public final void trackSecondBadcase2ck(boolean z, boolean z2) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f26435a);
        linkedHashMap.put("click_continue", Integer.valueOf(z ? 1 : 0));
        linkedHashMap.put("quit", Integer.valueOf(z2 ? 1 : 0));
        GlobalOmegaTracker.trackEvent("map_btnavi_paxbadcase2_ck", linkedHashMap);
    }

    /* renamed from: d */
    private final void m18756d() {
        Boolean secondTrySuccess = this.f26446l.getSecondTrySuccess();
        if (secondTrySuccess != null) {
            boolean booleanValue = secondTrySuccess.booleanValue();
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("order_id", this.f26435a);
            linkedHashMap.put("success", Integer.valueOf(booleanValue ? 1 : 0));
            linkedHashMap.put("duration", Long.valueOf(this.f26446l.getEndPairTimeStamp() - this.f26446l.getStartPairTimeStamp()));
            GlobalOmegaTracker.trackEvent("map_btnavi_paxbadcase2_bt", linkedHashMap);
        }
    }

    public final void trackMapBtnaviLinkbroken_bt() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f26435a);
        GlobalOmegaTracker.trackEvent("map_btnavi_linkbroken_bt", linkedHashMap);
    }

    /* renamed from: e */
    private final void m18757e() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f26435a);
        if (this.f26442h == 0) {
            this.f26442h = System.currentTimeMillis();
        }
        long j = this.f26441g;
        if (j > 0) {
            linkedHashMap.put("duration", Long.valueOf(this.f26442h - j));
        }
        linkedHashMap.put("conn_error", Integer.valueOf(this.f26447m ? 1 : 0));
        linkedHashMap.put("user_initia_quit", Integer.valueOf(this.f26444j ? 1 : 0));
        linkedHashMap.put("wrong_dir_cnt", Integer.valueOf(this.f26443i));
        GlobalOmegaTracker.trackEvent("map_btnavi_paxfind_bt", linkedHashMap);
    }

    public final void setPermissionGrantedState(boolean z, int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f26435a);
        linkedHashMap.put("request_permission", Integer.valueOf(z ? 1 : 0));
        linkedHashMap.put("channel", Integer.valueOf(i));
        GlobalOmegaTracker.trackEvent("map_btnavi_drvbt_ck", linkedHashMap);
    }

    public final void setBluetoothState(boolean z, boolean z2) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f26435a);
        linkedHashMap.put("permission", Integer.valueOf(z ? 1 : 0));
        linkedHashMap.put(JoinPoint.SYNCHRONIZATION_LOCK, Integer.valueOf(z2 ? 1 : 0));
        GlobalOmegaTracker.trackEvent("map_btnavi_paxauthority_bt", linkedHashMap);
    }

    /* renamed from: f */
    private final void m18758f() {
        int i;
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f26435a);
        if (this.f26438d == 0) {
            this.f26438d = System.currentTimeMillis();
        }
        long j = this.f26437c;
        if (j > 0) {
            linkedHashMap.put("pair_duration", Long.valueOf(this.f26438d - j));
        }
        BTMState bTMState = this.f26440f;
        if (bTMState == null) {
            bTMState = BTMState.PAIRING;
        }
        if (this.f26439e || bTMState.compareTo(BTMState.PAIRED) < 0) {
            i = (!this.f26439e || bTMState.compareTo(BTMState.PAIRED) < 0) ? 2 : 1;
        } else {
            i = 0;
        }
        linkedHashMap.put("pair_status", Integer.valueOf(i));
        GlobalOmegaTracker.trackEvent("map_btnavi_paxmatch_bt", linkedHashMap);
    }

    public final void onDestroy() {
        m18758f();
        m18757e();
        m18753a();
        m18754b();
        m18756d();
    }

    public final void setUiState(BTMState bTMState) {
        Intrinsics.checkNotNullParameter(bTMState, "state");
        DLog.m7384d(this.f26436b, Intrinsics.stringPlus("to State ", bTMState), new Object[0]);
        if (bTMState == BTMState.PAIRING) {
            this.f26438d = 0;
        }
        if (bTMState == BTMState.PAIRED) {
            this.f26438d = System.currentTimeMillis();
            this.f26441g = System.currentTimeMillis();
            if (this.f26439e && !this.f26446l.getClickTryAgain()) {
                this.f26446l.setSecondTrySuccess(true);
                this.f26446l.setEndPairTimeStamp(System.currentTimeMillis());
            }
        }
        if (bTMState == BTMState.PAIRING_FAILURE) {
            this.f26438d = System.currentTimeMillis();
            if (this.f26439e && !this.f26446l.getClickTryAgain()) {
                this.f26446l.setSecondTrySuccess(false);
                this.f26446l.setEndPairTimeStamp(System.currentTimeMillis());
            }
        }
        if (bTMState == BTMState.ON_BOARD) {
            this.f26442h = System.currentTimeMillis();
        }
        if (bTMState == BTMState.WRONG_DIRECTION || bTMState == BTMState.WRONG_DIRECTION_TOTALLY) {
            this.f26443i++;
        }
        this.f26440f = bTMState;
    }
}
