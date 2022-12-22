package com.didi.soda.customer.widget.map;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.Projection;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.foundation.sdk.map.MapViewImpl;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.map.OnMapInitCallback;
import com.didi.soda.customer.map.marker.AddressMarker;
import com.didi.soda.customer.map.marker.BusinessMarker;
import com.didi.soda.customer.map.marker.DebugMarker;
import com.didi.soda.customer.map.marker.DestAddressMarker;
import com.didi.soda.customer.map.marker.LineCenterLocationMarker;
import com.didi.soda.customer.map.model.BestViewModel;
import com.didichuxing.dfbasesdk.utils.UIHandler;

public class SodaMapView extends RelativeLayout {

    /* renamed from: a */
    private static final int f42142a = 1000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map f42143b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MapViewImpl f42144c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f42145d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnMapReadyCallBack f42146e;

    public void onPause() {
    }

    public SodaMapView(Context context) {
        super(context);
        m29714a();
    }

    public SodaMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29714a();
    }

    public SodaMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29714a();
    }

    public void centerBestView(BestViewModel bestViewModel, BestViewer.IBestViewListener iBestViewListener) {
        BestViewModel bestViewModel2 = bestViewModel;
        if (this.f42145d) {
            BestViewer.setDefaultDuration(1000);
            if (bestViewModel2.mIncludes.size() == 1) {
                BestViewer.doBestView(this.f42143b, true, Float.valueOf(15.0f), bestViewModel2.mIncludes.get(0), bestViewModel2.mPadding, iBestViewListener);
            } else {
                BestViewer.doBestView(this.f42143b, true, (LatLng) null, bestViewModel2.mIncludes, bestViewModel2.mPadding, (Padding) null, iBestViewListener);
            }
        }
    }

    public void centerBestViewWithMapElement(BestViewModel bestViewModel, BestViewer.IBestViewListener iBestViewListener) {
        if (this.f42145d && bestViewModel != null) {
            if (!CollectionsUtil.isEmpty(bestViewModel.mapElements)) {
                BestViewer.setDefaultDuration(1000);
                BestViewer.doBestView(this.f42143b, true, bestViewModel.mapElements, bestViewModel.mPadding, (Padding) null, iBestViewListener);
                return;
            }
            centerBestView(bestViewModel, iBestViewListener);
        }
    }

    public void centerBestZoomView(BestViewModel bestViewModel) {
        if (this.f42145d && bestViewModel != null && bestViewModel.mIncludes.size() > 0) {
            BestViewer.setDefaultDuration(1000);
            BestViewer.doBestView(this.f42143b, true, bestViewModel.zoomCenter, bestViewModel.mIncludes, bestViewModel.mPadding, (Padding) null);
        }
    }

    public void centerBestZoomViewNoAnimation(BestViewModel bestViewModel) {
        if (this.f42145d && bestViewModel != null && bestViewModel.mIncludes.size() > 0) {
            BestViewer.doBestView(this.f42143b, false, bestViewModel.zoomCenter, bestViewModel.mIncludes, bestViewModel.mPadding, (Padding) null);
        }
    }

    public MapViewImpl getMapImpl() {
        return this.f42144c;
    }

    public void getSodaMapAsync(OnMapReadyCallBack onMapReadyCallBack) {
        if (this.f42145d) {
            onMapReadyCallBack.onMapReady(this.f42143b);
        } else {
            this.f42146e = onMapReadyCallBack;
        }
    }

    public PointF getScreenLocation(LatLng latLng) {
        Projection projection = this.f42143b.getProjection();
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
        if (this.f42145d) {
            return getMapImpl().getDidiCommonMap().getVisibleRegionCenterInScreen();
        }
        return new PointF();
    }

    public void setTopViewToCenter(View view) {
        if (this.f42145d) {
            UIHandler.post(new Runnable(view) {
                public final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SodaMapView.this.m29715a(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29715a(View view) {
        getMapImpl().getDidiCommonMap().setTopViewToCenter(view, 0.5f, 1.0f);
    }

    public void setMapGestureEnable(boolean z) {
        if (this.f42145d && getMapImpl().getDidiCommonMap().getUiSettings() != null) {
            getMapImpl().getDidiCommonMap().getUiSettings().setAllGesturesEnabled(z);
            getMapImpl().getDidiCommonMap().getUiSettings().setZoomEnabled(z);
        }
    }

    public void removeTopView() {
        if (this.f42145d) {
            UIHandler.post(new Runnable() {
                public final void run() {
                    SodaMapView.this.m29718b();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m29718b() {
        getMapImpl().getDidiCommonMap().removeTopView();
    }

    public LatLng getMapCenterLatLng() {
        if (this.f42145d) {
            return getMapImpl().getDidiCommonMap().getMapVisibleRegionCenter();
        }
        return null;
    }

    public void onDestroy() {
        if (this.f42145d) {
            GlobalContext.onMapDestroy();
            this.f42144c.clearElements();
            this.f42146e = null;
        }
    }

    public void onResume() {
        GlobalContext.onMapResume();
    }

    public void removeAllElement() {
        if (this.f42145d && this.f42144c != null) {
            removeTopView();
            this.f42144c.removeElement(AddressMarker.TAG_ADDRESS_MARKER);
            this.f42144c.removeElement(BusinessMarker.TAG_BUSINESS_MARKER);
            this.f42144c.removeElement(DebugMarker.TAG_DEBUG_MARKER);
            this.f42144c.removeElement(DestAddressMarker.TAG_DEST_ADDRESS_MARKER);
            this.f42144c.removeElement("tag_rider_marker");
            this.f42144c.removeElement(LineCenterLocationMarker.TAG_LINE_CENTER_MARKER);
        }
    }

    /* renamed from: a */
    private void m29714a() {
        GlobalContext.initMapView(new OnMapInitCallback() {
            public void onMapInitFinish(Map map) {
                boolean unused = SodaMapView.this.f42145d = true;
                Map unused2 = SodaMapView.this.f42143b = map;
                SodaMapView sodaMapView = SodaMapView.this;
                MapViewImpl unused3 = sodaMapView.f42144c = new MapViewImpl(sodaMapView.getContext(), SodaMapView.this.f42143b);
                SodaMapView.this.f42144c.setAllGesturesEnable(true);
                SodaMapView.this.f42144c.setRotateGesturesEnabled(false);
                SodaMapView.this.f42144c.setTiltEnabled(false);
                SodaMapView.this.f42144c.hideTrafficRoute();
                if (SodaMapView.this.f42146e != null) {
                    SodaMapView.this.f42146e.onMapReady(map);
                }
            }
        });
    }
}
