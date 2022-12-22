package com.didichuxing.comp.telecom.core.voip;

import com.didichuxing.mlcp.drtc.interfaces.CallingServiceListener;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016¨\u0006\u0015"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/SimpleCallingListener;", "Lcom/didichuxing/mlcp/drtc/interfaces/CallingServiceListener;", "()V", "onCameraNoPermission", "", "onConnectReady", "isVoiceLow", "", "feedCount", "", "onDisconnectedByError", "onJoinFailed", "p0", "", "onNetworkQuality", "onNewRemoteFeed", "onNewRemoteFeedWithCount", "feedId", "onRemoteFeedLeave", "onRemoteFeedLeaveWithCount", "onSessionDestroy", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: SimpleCallingListener.kt */
public class SimpleCallingListener implements CallingServiceListener {
    public void onCameraNoPermission() {
    }

    public void onConnectReady(boolean z, int i) {
    }

    public void onDisconnectedByError() {
    }

    public void onJoinFailed(String str) {
    }

    public void onNewRemoteFeed(String str) {
    }

    public void onRemoteFeedLeave(String str) {
    }

    public void onSessionDestroy() {
    }

    public void onNewRemoteFeedWithCount(String str, int i) {
        CallingServiceListener.CC.$default$onNewRemoteFeedWithCount(this, str, i);
    }

    public void onRemoteFeedLeaveWithCount(String str, int i) {
        CallingServiceListener.CC.$default$onRemoteFeedLeaveWithCount(this, str, i);
    }

    public void onNetworkQuality(int i) {
        CallingServiceListener.CC.$default$onNetworkQuality(this, i);
    }
}
