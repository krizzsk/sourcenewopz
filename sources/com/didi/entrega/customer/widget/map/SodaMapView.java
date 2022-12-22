package com.didi.entrega.customer.widget.map;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.Projection;
import com.didi.common.map.UiSettings;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.map.OnMapInitCallback;
import com.didi.entrega.customer.map.marker.ReceiverMarker;
import com.didi.entrega.customer.map.marker.SenderMarker;
import com.didi.entrega.customer.map.model.BestViewModel;
import com.didi.foundation.sdk.map.MapViewImpl;
import com.didichuxing.dfbasesdk.utils.UIHandler;

public class SodaMapView extends RelativeLayout {

    /* renamed from: a */
    private static final int f20597a = 1000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map f20598b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MapViewImpl f20599c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f20600d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnMapReadyCallBack f20601e;

    public void onPause() {
    }

    public SodaMapView(Context context) {
        super(context);
        m15062a();
    }

    public SodaMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15062a();
    }

    public SodaMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15062a();
    }

    public void centerBestView(BestViewModel bestViewModel, BestViewer.IBestViewListener iBestViewListener) {
        BestViewModel bestViewModel2 = bestViewModel;
        if (this.f20600d) {
            BestViewer.setDefaultDuration(1000);
            if (bestViewModel2.mIncludes.size() == 1) {
                BestViewer.doBestView(this.f20598b, true, Float.valueOf(15.0f), bestViewModel2.mIncludes.get(0), bestViewModel2.mPadding, iBestViewListener);
            } else {
                BestViewer.doBestView(this.f20598b, true, (LatLng) null, bestViewModel2.mIncludes, bestViewModel2.mPadding, (Padding) null, iBestViewListener);
            }
        }
    }

    public void centerBestZoomView(BestViewModel bestViewModel) {
        if (this.f20600d && bestViewModel != null && bestViewModel.mIncludes.size() > 0) {
            BestViewer.setDefaultDuration(1000);
            BestViewer.doBestView(this.f20598b, true, bestViewModel.zoomCenter, bestViewModel.mIncludes, bestViewModel.mPadding, (Padding) null);
        }
    }

    public void centerBestZoomViewNoAnimation(BestViewModel bestViewModel) {
        if (this.f20600d && bestViewModel != null && bestViewModel.mIncludes.size() > 0) {
            BestViewer.doBestView(this.f20598b, false, bestViewModel.zoomCenter, bestViewModel.mIncludes, bestViewModel.mPadding, (Padding) null);
        }
    }

    public MapViewImpl getMapImpl() {
        return this.f20599c;
    }

    public void getSodaMapAsync(OnMapReadyCallBack onMapReadyCallBack) {
        if (this.f20600d) {
            onMapReadyCallBack.onMapReady(this.f20598b);
        } else {
            this.f20601e = onMapReadyCallBack;
        }
    }

    public PointF getScreenLocation(LatLng latLng) {
        Projection projection = this.f20598b.getProjection();
        if (projection == null || latLng == null) {
            return null;
        }
        try {
            return projection.toScreenLocation(latLng);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PointF getVisibleRegionCenterInScreen() {
        if (this.f20600d) {
            return getMapImpl().getDidiCommonMap().getVisibleRegionCenterInScreen();
        }
        return new PointF();
    }

    public void setTopViewToCenter(View view) {
        if (this.f20600d) {
            UIHandler.post(new Runnable(view) {
                public final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SodaMapView.this.m15063a(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15063a(View view) {
        getMapImpl().getDidiCommonMap().setTopViewToCenter(view, 0.5f, 1.0f);
    }

    public void setMapGestureEnable(boolean z) {
        if (this.f20600d && getMapImpl().getDidiCommonMap().getUiSettings() != null) {
            getMapImpl().getDidiCommonMap().getUiSettings().setAllGesturesEnabled(z);
            getMapImpl().getDidiCommonMap().getUiSettings().setZoomEnabled(z);
        }
    }

    public void removeTopView() {
        if (this.f20600d) {
            UIHandler.post(new Runnable() {
                public final void run() {
                    SodaMapView.this.m15066b();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15066b() {
        getMapImpl().getDidiCommonMap().removeTopView();
    }

    public LatLng getMapCenterLatLng() {
        if (this.f20600d) {
            return getMapImpl().getDidiCommonMap().getMapVisibleRegionCenter();
        }
        return null;
    }

    public void onDestroy() {
        if (this.f20600d) {
            GlobalContext.onMapDestroy();
            this.f20599c.clearElements();
            this.f20601e = null;
        }
    }

    public void onResume() {
        GlobalContext.onMapResume();
    }

    public void removeAllElement() {
        if (this.f20600d && this.f20599c != null) {
            removeTopView();
            this.f20599c.removeElement(SenderMarker.TAG_SENDER_ADDRESS_MARKER);
            this.f20599c.removeElement(ReceiverMarker.TAG_RECEIVER_ADDRESS_MARKER);
            this.f20599c.removeElement("tag_rider_marker");
        }
    }

    /* renamed from: a */
    private void m15062a() {
        GlobalContext.initMapView(new OnMapInitCallback() {
            public void onMapInitFinish(Map map) {
                boolean unused = SodaMapView.this.f20600d = true;
                Map unused2 = SodaMapView.this.f20598b = map;
                SodaMapView sodaMapView = SodaMapView.this;
                MapViewImpl unused3 = sodaMapView.f20599c = new MapViewImpl(sodaMapView.getContext(), SodaMapView.this.f20598b);
                SodaMapView.this.f20599c.setAllGesturesEnable(true);
                SodaMapView.this.f20599c.setRotateGesturesEnabled(false);
                SodaMapView.this.f20599c.setTiltEnabled(false);
                SodaMapView.this.f20599c.hideTrafficRoute();
                if (SodaMapView.this.f20601e != null) {
                    SodaMapView.this.f20601e.onMapReady(map);
                }
            }
        });
    }

    public void setLogoVisibility(boolean z) {
        UiSettings uiSettings;
        if (this.f20600d && (uiSettings = this.f20599c.getDidiCommonMap().getUiSettings()) != null) {
            uiSettings.setLogoVisibility(z ? 0 : 8);
        }
    }
}
