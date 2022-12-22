package com.didi.map.sdk.sharetrack.external.round;

import com.didi.common.map.util.DLog;
import com.didi.map.sdk.sharetrack.common.ShareTrackApolloHelper;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/external/round/NearNoRoundStrategy;", "Lcom/didi/map/sdk/sharetrack/external/round/BaseRoundStrategy;", "()V", "checkArriveStatus", "", "getArriveThreshold", "", "getDriveAwayThreshold", "getRoundType", "initComplete", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NearNoRoundStrategy.kt */
public final class NearNoRoundStrategy extends BaseRoundStrategy {
    public int getRoundType() {
        return 2;
    }

    public int getArriveThreshold() {
        return ShareTrackApolloHelper.INSTANCE.getEDA_arrived_pass();
    }

    public int getDriveAwayThreshold() {
        return ShareTrackApolloHelper.INSTANCE.getDistance_pass_long_normal();
    }

    public void checkArriveStatus() {
        if (getMIsNeverArrived()) {
            setMIsNeverArrived(false);
            handleArrive(true);
        } else if (!getMHasArrived()) {
            int arriveThreshold = getArriveThreshold();
            int meda = getMEDA();
            if (meda >= 0 && arriveThreshold > meda) {
                DLog.m7384d(BaseRoundStrategy.TAG, "near no round arrive: YES", new Object[0]);
                handleArrive(true);
            } else if (getMEDA() < 200) {
                DLog.m7384d(BaseRoundStrategy.TAG, "EDA: " + getMEDA() + ", near no round arrive: NO", new Object[0]);
            }
        }
    }

    public void initComplete() {
        checkArriveStatus();
    }
}
