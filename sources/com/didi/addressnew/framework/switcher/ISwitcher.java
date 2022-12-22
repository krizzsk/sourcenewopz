package com.didi.addressnew.framework.switcher;

import android.app.FragmentManager;
import android.os.Bundle;
import com.didi.address.framework.fragmentmarket.animator.ISwitchAnimator;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPointParam;
import com.didi.addressnew.framework.fragmentmarket.base.IFragment;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.sdk.address.address.entity.Address;

public interface ISwitcher extends IComponent {

    /* renamed from: com.didi.addressnew.framework.switcher.ISwitcher$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$delSwitcherResultAddress(ISwitcher iSwitcher, int i) {
        }

        public static void $default$onFragmentCancel(ISwitcher iSwitcher, SugParams sugParams, IAddressResult iAddressResult) {
        }

        public static void $default$onFragmentConfirm(ISwitcher iSwitcher, SugParams sugParams, IAddressResult iAddressResult) {
        }
    }

    boolean closeSessionImediately();

    boolean closeSessionWithResult(IAddressResult iAddressResult);

    void computeOffset();

    void delSwitcherResultAddress(int i);

    ISwitchAnimator getSwitchAnimator();

    WayPointParam getWaypointParam();

    boolean isCanFinishActivity();

    boolean isFragmentOnTop(IFragment iFragment);

    void onActivityCloseBefore();

    boolean onBackPressed();

    void onCurrentFragmentAttached(IFragment iFragment);

    void onFragmentCancel(SugParams sugParams, IAddressResult iAddressResult);

    void onFragmentConfirm(SugParams sugParams, IAddressResult iAddressResult);

    void onStartChoosen(Address address);

    void resetOffset();

    boolean setResultWithoutCloseSession(IAddressResult iAddressResult);

    void startMainFragment(FragmentManager fragmentManager, int i);

    void switchBack(SugParams sugParams, IAddressResult iAddressResult);

    void switchBack(SugParams sugParams, IAddressResult iAddressResult, int i);

    void switchEditFavorite(SugParams sugParams, IAddressResult iAddressResult);

    void switchEndConfirm(SugParams sugParams, IAddressResult iAddressResult, int i, Bundle bundle);

    void switchFavorite(SugParams sugParams, IAddressResult iAddressResult);

    void switchFull(SugParams sugParams, IAddressResult iAddressResult);

    void switchMapConfirm(SugParams sugParams, IAddressResult iAddressResult, int i, Bundle bundle);

    void switchMapSelect(SugParams sugParams, IAddressResult iAddressResult, int i);

    void switchMapSelect(SugParams sugParams, IAddressResult iAddressResult, int i, Bundle bundle);

    void switchOpenRideConfirm(SugParams sugParams, IAddressResult iAddressResult);

    void switchOpenRideWayPointer(SugParams sugParams, IAddressResult iAddressResult);

    void switchSetting(SugParams sugParams, IAddressResult iAddressResult);

    void switchSingle(SugParams sugParams, IAddressResult iAddressResult, int i);

    void switchWayPointer(SugParams sugParams, IAddressResult iAddressResult);

    void updataSwitcherResultAddressAllowNull(int i, Address address);

    void updateAddressToCurrentFragment(IFragment iFragment);

    void updateAddressToSwitcher(SugParams sugParams, IAddressResult iAddressResult);
}
