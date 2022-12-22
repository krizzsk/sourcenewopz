package com.didi.map.global.flow.scene.order.waiting;

import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.waiting.temp.GuideLine;
import com.didi.map.global.flow.scene.order.waiting.temp.GuideLineParam;
import com.didi.map.global.flow.scene.order.waiting.temp.StartEndMarker;
import com.didi.map.global.model.location.LocationHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.ArrayList;
import java.util.List;

@IScene.Scene(mo74615id = 1004)
public class WaitingForReplyOldScene extends PageScene<WaitingForReplyParam> implements IWaitingForReplyController {

    /* renamed from: a */
    private StartEndMarker f26951a;

    /* renamed from: b */
    private LatLng f26952b;

    /* renamed from: c */
    private GuideLine f26953c;

    public void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback) {
    }

    public void sendOrderSuc(String str, String str2) {
    }

    public WaitingForReplyOldScene(WaitingForReplyParam waitingForReplyParam, MapViewHolder mapViewHolder) {
        super(waitingForReplyParam, mapViewHolder);
    }

    /* renamed from: a */
    private void m19022a(boolean z) {
        if (z && this.f26951a != null) {
            GuideLine guideLine = new GuideLine(getContext(), getMap());
            this.f26953c = guideLine;
            guideLine.setParam(new GuideLineParam(((WaitingForReplyParam) this.mParam).getDottedLineColor(), this.f26951a.getStartMarkerPosition()));
            this.f26953c.show();
        }
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        StartEndMarker startEndMarker = new StartEndMarker(this.mMapView.getMapView());
        this.f26951a = startEndMarker;
        startEndMarker.update(((WaitingForReplyParam) this.mParam).getStartEndMarkerModel());
        m19022a(((WaitingForReplyParam) this.mParam).isShowWalkLine());
    }

    public void leave() {
        super.leave();
        StartEndMarker startEndMarker = this.f26951a;
        if (startEndMarker != null) {
            startEndMarker.destroy();
            this.f26951a = null;
        }
        GuideLine guideLine = this.f26953c;
        if (guideLine != null) {
            guideLine.destroy();
            this.f26953c = null;
        }
    }

    public void onResume() {
        if (this.isSceneValid) {
            GuideLine guideLine = this.f26953c;
            if (guideLine != null) {
                guideLine.show();
            }
            doBestView(getMap().getPadding());
        }
    }

    public void onPause() {
        GuideLine guideLine;
        if (this.isSceneValid && (guideLine = this.f26953c) != null) {
            guideLine.hide();
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.isSceneValid && getMap() != null) {
            hideResetView();
            this.mHandler.removeCallbacksAndMessages((Object) null);
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
            if (lastKnownLocation != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()));
                arrayList.add(this.f26951a.getStartMarkerPosition());
                int dp2px = DisplayUtils.dp2px(getContext(), 40.0f);
                BestViewer.doBestView(getMap(), true, this.f26951a.getStartMarkerPosition(), (List<LatLng>) arrayList, padding, new Padding(dp2px, dp2px, DisplayUtils.dp2px(getContext(), 40.0f), dp2px));
                return;
            }
            BestViewer.doBestView(getMap(), true, Float.valueOf(15.0f), this.f26951a.getStartMarkerPosition(), padding, (BestViewer.IBestViewListener) null);
        }
    }

    public void updateWaitingForReplyBubble(View view) {
        StartEndMarker startEndMarker;
        if (this.isSceneValid && (startEndMarker = this.f26951a) != null) {
            startEndMarker.showStartMarkerInfoWindow(view, (InfoWindow.Position) null);
        }
    }
}
