package com.didi.map.sdk.sharetrack.external.round;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/external/round/IRoundStatusChangeListener;", "", "onApproaching", "", "eda", "", "onArrived", "lineVisible", "", "onDriveAway", "onLineVisibleChange", "shouldShow", "onPassPointYaw", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: IRoundStatusChangeListener.kt */
public interface IRoundStatusChangeListener {
    void onApproaching(int i);

    void onArrived(boolean z);

    void onDriveAway();

    void onLineVisibleChange(boolean z);

    void onPassPointYaw();
}
