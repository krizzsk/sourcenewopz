package com.didi.map.global.component.departure.util;

import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.departure.pin.DepartureMarkerView;
import com.didi.map.global.component.departure.pin.IPinDrawer;
import com.didi.map.global.component.recmarker.IRecMarkerController;
import com.didi.sdk.util.UiThreadHandler;

public class PinActionUtils {
    public static void animateCamera(Map map, LatLng latLng, boolean z, boolean z2, float f, Padding padding, BestViewer.IBestViewListener iBestViewListener) {
        if (latLng != null && map != null) {
            if (f == 0.0f) {
                f = 14.0f;
            }
            if (!z2) {
                f = (float) map.getCameraPosition().zoom;
            }
            BestViewer.doBestView(map, z, Float.valueOf(f), latLng, padding, iBestViewListener);
        }
    }

    public static void startAdsorbRecommendAnimation(IPinDrawer iPinDrawer, long j, IRecMarkerController iRecMarkerController, LatLng latLng) {
        UiThreadHandler.postDelayed(new Runnable(iRecMarkerController, latLng) {
            public final /* synthetic */ IRecMarkerController f$1;
            public final /* synthetic */ LatLng f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                PinActionUtils.m18107a(IPinDrawer.this, this.f$1, this.f$2);
            }
        }, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m18107a(IPinDrawer iPinDrawer, IRecMarkerController iRecMarkerController, LatLng latLng) {
        if (iPinDrawer != null) {
            iPinDrawer.startJumpAnimation(new DepartureMarkerView.AnimationFinishListener(latLng) {
                public final /* synthetic */ LatLng f$1;

                {
                    this.f$1 = r2;
                }

                public final void onFinish() {
                    PinActionUtils.m18108a(IRecMarkerController.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m18108a(IRecMarkerController iRecMarkerController, LatLng latLng) {
        if (iRecMarkerController != null) {
            iRecMarkerController.showTransientCircles(latLng);
        }
    }

    public static void startAdsorbRecommendAnimation(IPinDrawer iPinDrawer, long j, DepartureMarkerView.AnimationFinishListener animationFinishListener) {
        UiThreadHandler.postDelayed(new Runnable(animationFinishListener) {
            public final /* synthetic */ DepartureMarkerView.AnimationFinishListener f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                PinActionUtils.m18106a(IPinDrawer.this, this.f$1);
            }
        }, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m18106a(IPinDrawer iPinDrawer, DepartureMarkerView.AnimationFinishListener animationFinishListener) {
        if (iPinDrawer != null) {
            iPinDrawer.startJumpAnimation(animationFinishListener);
        }
    }
}
