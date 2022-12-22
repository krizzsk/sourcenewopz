package com.didichuxing.comp.telecom.core.voip;

import com.didichuxing.comp.telecom.core.CallThreadDispatcher;
import com.didichuxing.mlcp.drtc.interfaces.CallingServiceListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/CallingServiceListenerWrapper;", "Lcom/didichuxing/mlcp/drtc/interfaces/CallingServiceListener;", "innerListener", "(Lcom/didichuxing/mlcp/drtc/interfaces/CallingServiceListener;)V", "onCameraNoPermission", "", "onConnectReady", "p0", "", "p1", "", "onDisconnectedByError", "onJoinFailed", "", "onNetworkQuality", "onNewRemoteFeed", "onNewRemoteFeedWithCount", "onRemoteFeedLeave", "onRemoteFeedLeaveWithCount", "onSessionDestroy", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: SimpleCallingListener.kt */
public final class CallingServiceListenerWrapper implements CallingServiceListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final CallingServiceListener f46428a;

    public void onCameraNoPermission() {
    }

    public void onNewRemoteFeed(String str) {
    }

    public void onRemoteFeedLeave(String str) {
    }

    public CallingServiceListenerWrapper(CallingServiceListener callingServiceListener) {
        Intrinsics.checkParameterIsNotNull(callingServiceListener, "innerListener");
        this.f46428a = callingServiceListener;
    }

    public void onNewRemoteFeedWithCount(String str, int i) {
        CallingServiceListener.CC.$default$onNewRemoteFeedWithCount(this, str, i);
        CallThreadDispatcher.Companion.getInstance().runOnUiThread(new CallingServiceListenerWrapper$onNewRemoteFeedWithCount$1(this, str, i));
    }

    public void onRemoteFeedLeaveWithCount(String str, int i) {
        CallingServiceListener.CC.$default$onRemoteFeedLeaveWithCount(this, str, i);
        CallThreadDispatcher.Companion.getInstance().runOnUiThread(new CallingServiceListenerWrapper$onRemoteFeedLeaveWithCount$1(this, str, i));
    }

    public void onNetworkQuality(int i) {
        CallingServiceListener.CC.$default$onNetworkQuality(this, i);
        CallThreadDispatcher.Companion.getInstance().runOnUiThread(new CallingServiceListenerWrapper$onNetworkQuality$1(this, i));
    }

    public void onConnectReady(boolean z, int i) {
        CallThreadDispatcher.Companion.getInstance().runOnUiThread(new CallingServiceListenerWrapper$onConnectReady$1(this, z, i));
    }

    public void onDisconnectedByError() {
        CallThreadDispatcher.Companion.getInstance().runOnUiThread(new CallingServiceListenerWrapper$onDisconnectedByError$1(this));
    }

    public void onSessionDestroy() {
        CallThreadDispatcher.Companion.getInstance().runOnUiThread(new CallingServiceListenerWrapper$onSessionDestroy$1(this));
    }

    public void onJoinFailed(String str) {
        CallThreadDispatcher.Companion.getInstance().runOnUiThread(new CallingServiceListenerWrapper$onJoinFailed$1(this, str));
    }
}
