package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import android.view.View;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.model.GuideStartInfo;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.serving.ILocationCallback;
import com.didi.map.global.flow.scene.order.serving.ILockScreenServingController;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.map.global.flow.scene.order.serving.carpool.IFetchCarpoolInfo;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.sdk.address.address.entity.Address;
import java.util.List;

public abstract class BaseScene extends PageScene<ServingParam> implements ILockScreenServingController, IServingController {
    protected BasePage mPage;

    public BaseScene(ServingParam servingParam, MapViewHolder mapViewHolder) {
        super(servingParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.enter(true);
        }
    }

    public void onResume() {
        super.onResume();
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.onPause();
        }
    }

    public void leave() {
        super.leave();
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.leave();
        }
    }

    public void onOrderStateChanged(int i, ServingParam servingParam) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().onOrderStateChanged(i, servingParam);
        }
    }

    public void updateMarkerBubble(MapElementId mapElementId, View view) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().updateMarkerBubble(mapElementId, view);
        }
    }

    public void updateMarkerBubble(MapElementId mapElementId, View view, InfoWindow.Position position) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().updateMarkerBubble(mapElementId, view, position);
        }
    }

    public void destroyMarkerBubble(MapElementId mapElementId) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().destroyMarkerBubble(mapElementId);
        }
    }

    public void hideMarkerBubble(MapElementId mapElementId) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().hideMarkerBubble(mapElementId);
        }
    }

    public void setCarpoolInfo(IFetchCarpoolInfo iFetchCarpoolInfo) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().setCarpoolInfo(iFetchCarpoolInfo);
        }
    }

    public void setCarpoolShowBubblesEnabled(boolean z) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().setCarpoolShowBubblesEnabled(z);
        }
    }

    public EtaEda getLastEtaEda() {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            return basePage.getServingController().getLastEtaEda();
        }
        return null;
    }

    public LatLng getLastDriverPosition() {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            return basePage.getServingController().getLastDriverPosition();
        }
        return null;
    }

    public void setInfoWindowClickListener(MapElementId mapElementId, OnInfoWindowClickListener onInfoWindowClickListener) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().setInfoWindowClickListener(mapElementId, onInfoWindowClickListener);
        }
    }

    public void onPushMsgReceived(byte[] bArr) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().onPushMsgReceived(bArr);
        }
    }

    public void modifyDestination(LatLng latLng) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().modifyDestination(latLng);
        }
    }

    public double getLeftRouteDistance() {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            return basePage.getServingController().getLeftRouteDistance();
        }
        return -1.0d;
    }

    public void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().refreshCarBitmapDescriptor(bitmapDescriptor);
        }
    }

    public boolean refresh3DCarIcons(boolean z, List<String> list) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            return basePage.getServingController().refresh3DCarIcons(z, list);
        }
        return false;
    }

    public void setOdPoints(List<OdPoint> list, long j) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().setOdPoints(list, j);
        }
    }

    public void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().animateCamera(cameraPosition, i, cancelableCallback);
        }
    }

    public void startModifyPickupLocation(Address address, Address address2, float f, ILocationCallback iLocationCallback) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().startModifyPickupLocation(address, address2, f, iLocationCallback);
        }
    }

    public void stopModifyPickupLocation(LatLng latLng) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().stopModifyPickupLocation(latLng);
        }
    }

    public void onStartChangedForSharer(GuideStartInfo guideStartInfo) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().onStartChangedForSharer(guideStartInfo);
        }
    }

    public void updatePickupPoint(LatLng latLng) {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().updatePickupPoint(latLng);
        }
    }

    public void cancelPickupPointRecommend() {
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.getServingController().cancelPickupPointRecommend();
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        BasePage basePage = this.mPage;
        if (basePage != null) {
            basePage.doBestView(padding);
        }
    }
}
