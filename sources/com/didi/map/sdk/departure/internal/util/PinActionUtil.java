package com.didi.map.sdk.departure.internal.util;

import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.departure.internal.markers.IRecMarkerController;
import com.didi.map.sdk.departure.internal.pin.DepartureMarkerView;
import com.didi.map.sdk.departure.internal.pin.IPinDrawer;
import com.didi.sdk.util.UiThreadHandler;

public class PinActionUtil {

    /* renamed from: a */
    private static final String f28248a = PinActionUtil.class.getSimpleName();

    public static void animateCamera(Map map, LatLng latLng, CancelableCallback cancelableCallback) {
        animateCamera(map, latLng, true, false, 0.0f, cancelableCallback);
    }

    public static void animateCamera(Map map, LatLng latLng, boolean z, boolean z2, float f, final CancelableCallback cancelableCallback) {
        if (latLng != null && map != null) {
            BestViewer.doBestView(map, z, Float.valueOf(z2 ? 18.0f : (float) map.getCameraPosition().zoom), latLng, map.getPadding(), (BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                public void onFinished() {
                    CancelableCallback cancelableCallback = cancelableCallback;
                    if (cancelableCallback != null) {
                        cancelableCallback.onFinish();
                    }
                }
            });
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
                PinActionUtil.m20059a(IPinDrawer.this, this.f$1, this.f$2);
            }
        }, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m20059a(IPinDrawer iPinDrawer, IRecMarkerController iRecMarkerController, LatLng latLng) {
        if (iPinDrawer != null) {
            iPinDrawer.startJumpAnimation(new DepartureMarkerView.AnimationFinishListener(latLng) {
                public final /* synthetic */ LatLng f$1;

                {
                    this.f$1 = r2;
                }

                public final void onFinish() {
                    PinActionUtil.m20058a(IRecMarkerController.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m20058a(IRecMarkerController iRecMarkerController, LatLng latLng) {
        if (iRecMarkerController != null) {
            iRecMarkerController.showTransientCircles(latLng);
        }
    }
}
