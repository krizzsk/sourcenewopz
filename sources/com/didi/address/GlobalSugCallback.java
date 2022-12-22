package com.didi.address;

import androidx.fragment.app.FragmentActivity;
import com.didi.address.framework.fragmentmarket.animator.ISwitchAnimator;
import com.didi.address.model.IWayPointsPostCallback;
import com.didi.address.model.WayPoint;
import com.didi.sdk.address.address.entity.Address;
import java.util.List;

public abstract class GlobalSugCallback {
    public SugBuild getSugBuild() {
        return null;
    }

    public ISwitchAnimator getSwitchAnimator() {
        return null;
    }

    public void onAttach(int i) {
    }

    public void onCancelButtonPressed() {
    }

    public void onCloseButtonClick() {
    }

    public boolean onCloseButtonIntercept() {
        return false;
    }

    public void onDetach(int i) {
    }

    @Deprecated
    public void onEnterWayPoint(Address address, Address address2) {
    }

    public void onOpenWebUrl(String str) {
    }

    public void onStartChoosen(Address address) {
    }

    public void onStartEndAddressChanged(Address address, Address address2) {
    }

    public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, IWayPointsPostCallback iWayPointsPostCallback) {
    }

    public void onSugSessionClosed() {
    }

    public int requestSugWindowFeature() {
        return 2;
    }

    public abstract void setResult(AddressResult addressResult);
}
