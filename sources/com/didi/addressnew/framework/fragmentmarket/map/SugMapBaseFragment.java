package com.didi.addressnew.framework.fragmentmarket.map;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.address.FromType;
import com.didi.address.model.WayPointParam;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.fragmentmarket.map.mode.OnSugMapGestureListenerAdapter;
import com.didi.addressnew.framework.switcher.result.ParentAddress;
import com.didi.common.map.Map;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.PointType;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;

public abstract class SugMapBaseFragment extends FragmentImpl {

    /* renamed from: a */
    private OnSugMapGestureListenerAdapter f4466a = new OnSugMapGestureListenerAdapter() {
        public boolean onDown(float f, float f2) {
            SugMapBaseFragment.this.onShowMapReset();
            return false;
        }
    };
    protected int mCurrAddressType = -1;
    protected Address mCurrentAddress;
    protected boolean mDestroyed;
    protected ParentAddress mParentAddress;
    protected WayPointParam mWayPointParam;

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    public abstract void onInit(View view);

    /* access modifiers changed from: protected */
    public abstract void onShowMapReset();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        m2831a();
        onInit(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m2831a() {
        this.mWayPointParam = getWaypointParam();
    }

    /* access modifiers changed from: protected */
    public void addOnMapGestureListener(Map map) {
        if (map != null) {
            map.removeOnMapGestureListener(this.f4466a);
            map.addOnMapGestureListener(this.f4466a);
        }
    }

    /* access modifiers changed from: protected */
    public void removeOnMapGestureListener(Map map) {
        if (map != null) {
            map.removeOnMapGestureListener(this.f4466a);
        }
    }

    /* access modifiers changed from: protected */
    public void playAnimationMapLayer(View view) {
        if (view != null) {
            ObjectAnimator objectAnimator = new ObjectAnimator();
            objectAnimator.setPropertyName("alpha");
            objectAnimator.setDuration(1000);
            objectAnimator.setFloatValues(new float[]{1.0f, 0.0f});
            objectAnimator.setTarget(view);
            objectAnimator.start();
        }
    }

    public void onAttach(Activity activity) {
        PointType pointType;
        super.onAttach(activity);
        if (getArguments() != null) {
            this.mCurrAddressType = ((Integer) getArguments().getSerializable(FragmentImpl.KEY_ADDRESS_TYPE)).intValue();
            if (getmParam().fromType != FromType.SETTING) {
                this.mCurrentAddress = getmResult().getResult(this.mCurrAddressType);
            }
            int i = this.mCurrAddressType;
            if (i == 1 || i == 2) {
                this.mParentAddress = getmResult().getParentAddress();
            }
            int i2 = this.mCurrAddressType;
            if (i2 == 1) {
                pointType = PointType.START;
            } else if (i2 == 2) {
                pointType = PointType.END;
            } else if (i2 == 101 || i2 == 101) {
                pointType = PointType.WAY_POINT;
            } else {
                pointType = PointType.OTHER;
            }
            PaxEnvironment.getInstance().setPointType(pointType);
        }
    }

    /* access modifiers changed from: protected */
    public void logWriter(String str) {
        SystemUtils.log(4, "SugMapBaseFragment", getClass().getName() + ":" + str, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.SugMapBaseFragment", 120);
    }
}
