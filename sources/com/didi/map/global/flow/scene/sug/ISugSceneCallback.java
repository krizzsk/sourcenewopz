package com.didi.map.global.flow.scene.sug;

import androidx.fragment.app.FragmentActivity;
import com.didi.address.model.WayPoint;
import com.didi.sdk.address.address.entity.Address;
import java.util.List;

public interface ISugSceneCallback {

    /* renamed from: com.didi.map.global.flow.scene.sug.ISugSceneCallback$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ISugTransferAnimator $default$getSwitchAnimator(ISugSceneCallback iSugSceneCallback) {
            return null;
        }

        public static void $default$onCancelButtonPressed(ISugSceneCallback iSugSceneCallback) {
        }

        public static void $default$onOpenWebUrl(ISugSceneCallback iSugSceneCallback, String str) {
        }

        public static void $default$onStartChoosen(ISugSceneCallback iSugSceneCallback, Address address) {
        }

        public static void $default$onStartEndAddressChanged(ISugSceneCallback iSugSceneCallback, Address address, Address address2) {
        }

        public static void $default$onSubmitWayPoints(ISugSceneCallback iSugSceneCallback, FragmentActivity fragmentActivity, List list, List list2, ISubmitWayPointsCallback iSubmitWayPointsCallback) {
        }

        public static void $default$onSugSessionClosed(ISugSceneCallback iSugSceneCallback) {
        }
    }

    ISugTransferAnimator getSwitchAnimator();

    void onCancelButtonPressed();

    void onOpenWebUrl(String str);

    void onStartChoosen(Address address);

    void onStartEndAddressChanged(Address address, Address address2);

    void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, ISubmitWayPointsCallback iSubmitWayPointsCallback);

    void onSugSessionClosed();

    void setResult(SugResult sugResult);
}
