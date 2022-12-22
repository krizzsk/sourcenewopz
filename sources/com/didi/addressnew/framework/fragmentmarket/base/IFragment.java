package com.didi.addressnew.framework.fragmentmarket.base;

import android.app.Fragment;
import com.didi.address.model.SugParams;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.switcher.ISwitcher;
import com.didi.addressnew.framework.switcher.result.IAddressResult;

public interface IFragment extends ISwitcher {

    public enum ParentNode {
        FULL,
        WAYPOINT,
        WAYPOINT_SELECTOR,
        FAV,
        SETTING,
        CHILD
    }

    void disableAnimation(boolean z);

    Fragment getFragment();

    ParentNode getNodeType();

    FragmentFactory.FragmentType getType();

    boolean isFragmentOnDuty();

    void onCancel(SugParams sugParams, IAddressResult iAddressResult);

    void onConfirm(SugParams sugParams, IAddressResult iAddressResult);

    void onPageEnter();

    void onPageExit();

    void setParentNodeType(ParentNode parentNode);

    void updateAddressRetToFragment(SugParams sugParams, IAddressResult iAddressResult);
}
