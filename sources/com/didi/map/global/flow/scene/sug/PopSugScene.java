package com.didi.map.global.flow.scene.sug;

import android.animation.Animator;
import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.didi.address.AddressException;
import com.didi.address.AddressResult;
import com.didi.address.GlobalSugCallback;
import com.didi.address.SugBuild;
import com.didi.address.framework.fragmentmarket.animator.ISwitchAnimator;
import com.didi.address.model.IWayPointsPostCallback;
import com.didi.address.model.WayPoint;
import com.didi.addressnew.NewAddressApiFactory;
import com.didi.addressnew.framework.IDidiAddressNewApi;
import com.didi.addressnew.framework.IDidiAddressNewApiImpl;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

@IScene.Scene(mo74615id = 1011)
public class PopSugScene extends PageScene<PopSugSceneParam> implements IPopSugSceneController {

    /* renamed from: a */
    private static final String f27048a = "PopSugScene";

    /* renamed from: b */
    private IDidiAddressNewApi f27049b;

    /* renamed from: c */
    private GlobalSugCallback f27050c = new GlobalSugCallback() {
        public void onCloseButtonClick() {
            SystemUtils.log(6, "ccc", "onStartChoosen", (Throwable) null, "com.didi.map.global.flow.scene.sug.PopSugScene$1", 43);
        }

        public void onStartChoosen(Address address) {
            SystemUtils.log(6, "ccc", "onStartChoosen", (Throwable) null, "com.didi.map.global.flow.scene.sug.PopSugScene$1", 48);
            if (PopSugScene.this.mParam != null && ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback() != null) {
                ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback().onStartChoosen(address);
            }
        }

        public void onSugSessionClosed() {
            SystemUtils.log(6, "ccc", "onSugSessionClosed", (Throwable) null, "com.didi.map.global.flow.scene.sug.PopSugScene$1", 56);
            if (PopSugScene.this.mParam != null && ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback() != null) {
                ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback().onSugSessionClosed();
            }
        }

        public void onStartEndAddressChanged(Address address, Address address2) {
            SystemUtils.log(6, "ccc", "onStartEndAddressChanged", (Throwable) null, "com.didi.map.global.flow.scene.sug.PopSugScene$1", 64);
            if (PopSugScene.this.mParam != null && ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback() != null) {
                ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback().onStartEndAddressChanged(address, address2);
            }
        }

        public void onCancelButtonPressed() {
            SystemUtils.log(6, "ccc", "onCancelButtonPressed", (Throwable) null, "com.didi.map.global.flow.scene.sug.PopSugScene$1", 72);
            if (PopSugScene.this.mParam != null && ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback() != null) {
                ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback().onCancelButtonPressed();
            }
        }

        public void setResult(AddressResult addressResult) {
            if (PopSugScene.this.mParam != null && ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback() != null) {
                ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback().setResult(convertSugResult(addressResult));
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
            if (PopSugScene.this.mParam != null && ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback() != null) {
                ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback().onSubmitWayPoints(fragmentActivity, list, list2, convertSubmitWayPointsCallback(iWayPointsPostCallback));
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
            if (PopSugScene.this.mParam == null || ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback() == null) {
                return super.getSwitchAnimator();
            }
            return convertSwitchAnimator(((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback().getSwitchAnimator());
        }

        public SugBuild getSugBuild() {
            SugBuild sugBuild = new SugBuild();
            sugBuild.setVersion(2);
            return sugBuild;
        }

        public void onOpenWebUrl(String str) {
            if (PopSugScene.this.mParam != null && ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback() != null) {
                ((PopSugSceneParam) PopSugScene.this.mParam).getSugSceneCallback().onOpenWebUrl(str);
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
    };

    public PopSugScene(PopSugSceneParam popSugSceneParam, MapViewHolder mapViewHolder) {
        super(popSugSceneParam, mapViewHolder);
        this.mParam = popSugSceneParam;
        this.mMapView = mapViewHolder;
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        IDidiAddressNewApiImpl createDidiAddress = NewAddressApiFactory.createDidiAddress(getContext());
        this.f27049b = createDidiAddress;
        try {
            createDidiAddress.startSugActivity((Activity) ((PopSugSceneParam) this.mParam).getContext(), ((PopSugSceneParam) this.mParam).getSugParams(), this.f27050c);
        } catch (AddressException e) {
            e.printStackTrace();
        }
    }

    public void leave() {
        super.leave();
        IDidiAddressNewApi iDidiAddressNewApi = this.f27049b;
        if (iDidiAddressNewApi != null) {
            iDidiAddressNewApi.closeSugSession();
            this.f27049b = null;
        }
    }

    public void closeSugSession() {
        IDidiAddressNewApi iDidiAddressNewApi = this.f27049b;
        if (iDidiAddressNewApi != null) {
            iDidiAddressNewApi.closeSugSession();
            this.f27049b = null;
        }
    }
}
