package com.didi.map.global.flow.scene.sug;

import android.animation.Animator;
import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.didi.address.AddressResult;
import com.didi.address.GlobalSugCallback;
import com.didi.address.SugBuild;
import com.didi.address.framework.fragmentmarket.animator.ISwitchAnimator;
import com.didi.address.model.IWayPointsPostCallback;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.addressnew.NewAddressApiFactory;
import java.util.List;

public class SettingSug {
    public static void startSugActivity(Activity activity, SugParams sugParams, final ISugSceneCallback iSugSceneCallback) {
        NewAddressApiFactory.createDidiAddress(activity.getApplicationContext()).startSugActivity(activity, sugParams, new GlobalSugCallback() {
            public void setResult(AddressResult addressResult) {
                ISugSceneCallback iSugSceneCallback = iSugSceneCallback;
                if (iSugSceneCallback != null) {
                    iSugSceneCallback.setResult(convertSugResult(addressResult));
                }
            }

            private SugResult convertSugResult(AddressResult addressResult) {
                if (addressResult == null) {
                    return null;
                }
                SugResult sugResult = new SugResult();
                sugResult.common = addressResult.common;
                sugResult.company = addressResult.company;
                sugResult.end = addressResult.end;
                sugResult.fromType = addressResult.fromType;
                sugResult.home = addressResult.home;
                sugResult.isStartNeedNearRoad = addressResult.isStartNeedNearRoad;
                sugResult.start = addressResult.start;
                sugResult.type = addressResult.type;
                return sugResult;
            }

            public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, IWayPointsPostCallback iWayPointsPostCallback) {
                ISugSceneCallback iSugSceneCallback = iSugSceneCallback;
                if (iSugSceneCallback != null) {
                    iSugSceneCallback.onSubmitWayPoints(fragmentActivity, list, list2, convertSubmitWayPointsCallback(iWayPointsPostCallback));
                }
            }

            private ISubmitWayPointsCallback convertSubmitWayPointsCallback(final IWayPointsPostCallback iWayPointsPostCallback) {
                if (iWayPointsPostCallback == null) {
                    return null;
                }
                return new ISubmitWayPointsCallback() {
                    public void onSuccess() {
                        iWayPointsPostCallback.onSuccess();
                    }

                    public void onFailure(String str) {
                        iWayPointsPostCallback.onFailure(str);
                    }
                };
            }

            public ISwitchAnimator getSwitchAnimator() {
                ISugSceneCallback iSugSceneCallback = iSugSceneCallback;
                if (iSugSceneCallback != null) {
                    return convertSwitchAnimator(iSugSceneCallback.getSwitchAnimator());
                }
                return super.getSwitchAnimator();
            }

            public SugBuild getSugBuild() {
                SugBuild sugBuild = new SugBuild();
                sugBuild.setVersion(2);
                return sugBuild;
            }

            public void onOpenWebUrl(String str) {
                ISugSceneCallback iSugSceneCallback = iSugSceneCallback;
                if (iSugSceneCallback != null) {
                    iSugSceneCallback.onOpenWebUrl(str);
                }
            }

            private ISwitchAnimator convertSwitchAnimator(final ISugTransferAnimator iSugTransferAnimator) {
                if (iSugTransferAnimator == null) {
                    return null;
                }
                return new ISwitchAnimator() {
                    public Animator getEnterAnimator() {
                        return iSugTransferAnimator.getEnterAnimator();
                    }

                    public Animator getExitAnimator() {
                        return iSugTransferAnimator.getExitAnimator();
                    }

                    public Animator getSecondaryPageEnterAnimator() {
                        return iSugTransferAnimator.getSecondaryPageEnterAnimator();
                    }

                    public Animator getSecondaryPageExitAnimator() {
                        return iSugTransferAnimator.getSecondaryPageExitAnimator();
                    }
                };
            }
        });
    }
}
