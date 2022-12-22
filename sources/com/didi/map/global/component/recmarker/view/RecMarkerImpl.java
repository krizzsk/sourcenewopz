package com.didi.map.global.component.recmarker.view;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.OnMarkerCompClickListener;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.component.recmarker.model.RecMarkerParam;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecMarkerImpl implements IRecMarker {

    /* renamed from: a */
    private Context f26103a;

    /* renamed from: b */
    private Map f26104b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f26105c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RecMarkerParam f26106d;

    /* renamed from: e */
    private SensingCircles f26107e;

    /* renamed from: f */
    private boolean f26108f = false;

    /* renamed from: g */
    private boolean f26109g = false;

    /* renamed from: h */
    private boolean f26110h = false;

    /* renamed from: i */
    private OnMarkerCompClickListener f26111i = new OnMarkerCompClickListener() {
        public boolean onClick(String str) {
            if (!RecMarkerImpl.this.f26105c.equalsIgnoreCase(str) || RecMarkerImpl.this.f26106d == null || RecMarkerImpl.this.f26106d.listener == null) {
                return false;
            }
            RecMarkerImpl.this.f26106d.listener.onClick(RecMarkerImpl.this);
            return false;
        }
    };
    public boolean isPined;
    protected IMarkersCompContract mMarkerComp;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f26103a = context.getApplicationContext();
        this.f26104b = map;
        this.f26105c = "id-" + hashCode();
    }

    public void destroy() {
        remove();
        this.f26104b = null;
        this.f26103a = null;
    }

    public void setConfigParam(RecMarkerParam recMarkerParam) {
        this.f26106d = recMarkerParam;
    }

    public void add() {
        RecMarkerParam recMarkerParam;
        Map map = this.f26104b;
        if (map != null && map.getProjection() != null && (recMarkerParam = this.f26106d) != null && recMarkerParam.point != null && this.f26106d.point.location != null) {
            IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
            if (iMarkersCompContract == null) {
                m18509a();
            } else {
                iMarkersCompContract.updatePosition(this.f26105c, this.f26106d.point.location);
            }
        }
    }

    public void setPined(boolean z) {
        this.isPined = z;
    }

    public String getId() {
        return this.f26105c;
    }

    public void setLabelDirect(int i) {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.updateMarkerLabelDirect(this.f26105c, i);
        }
    }

    public void remove() {
        if (this.mMarkerComp != null) {
            hideCircles();
            this.mMarkerComp.destroy();
            this.mMarkerComp = null;
        }
    }

    public void visible(boolean z) {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setAllMarkersVisible(z);
        }
        m18513c();
    }

    public boolean isVisible() {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract == null) {
            return false;
        }
        List<Marker> markers = iMarkersCompContract.getMarkers();
        if (CollectionUtil.isEmpty((Collection<?>) markers)) {
            return false;
        }
        return markers.get(0).isVisible();
    }

    /* renamed from: a */
    private void m18509a() {
        RecMarkerParam recMarkerParam;
        if (this.f26104b != null && (recMarkerParam = this.f26106d) != null && recMarkerParam.icon != null && this.f26106d.selectedIcon != null && this.f26106d.point != null && this.f26106d.point.location != null) {
            this.mMarkerComp = new MarkersComponent();
            MarkersCompParams.Builder builder = new MarkersCompParams.Builder();
            ArrayList arrayList = new ArrayList();
            MarkerModel markerModel = new MarkerModel();
            markerModel.setMarkerIcon(this.f26106d.icon);
            markerModel.setClickable(true);
            markerModel.setId(this.f26105c);
            markerModel.setAnchorU(0.5f);
            markerModel.setAnchorV(0.5f);
            markerModel.setPoint(this.f26106d.point.location);
            markerModel.setZOrder(99);
            if (this.f26106d.isShowLabel) {
                markerModel.setLabelDirection(this.f26106d.labelDirection);
                markerModel.setAddressName(this.f26106d.point.addrName);
                markerModel.setLabelZIndex(99);
                markerModel.setLabelView(this.f26106d.labelView);
            }
            markerModel.setStrategy(this.f26106d.strategy);
            arrayList.add(markerModel);
            builder.markerModels(arrayList);
            this.mMarkerComp.setConfigParam(builder.build());
            this.mMarkerComp.create(this.f26103a, this.f26104b);
            this.mMarkerComp.setOnClickListener(this.f26111i);
            m18512b();
        }
    }

    /* renamed from: b */
    private void m18512b() {
        boolean isInCenter = isInCenter();
        if (isInCenter) {
            m18514d();
            m18517g();
        } else {
            m18515e();
            m18516f();
        }
        m18510a(isInCenter);
    }

    public void showCircles() {
        RecMarkerParam recMarkerParam;
        hideCircles();
        if (this.f26104b != null && this.f26103a != null && (recMarkerParam = this.f26106d) != null && recMarkerParam.point != null && this.f26106d.point.location != null) {
            SensingCircles sensingCircles = new SensingCircles(this.f26103a, this.f26104b);
            this.f26107e = sensingCircles;
            sensingCircles.show(this.f26106d.point.location);
        }
    }

    public void hideCircles() {
        SensingCircles sensingCircles = this.f26107e;
        if (sensingCircles != null && sensingCircles.isShow()) {
            this.f26107e.hide();
        }
        this.f26107e = null;
    }

    public void showTransientCircles() {
        RecMarkerParam recMarkerParam;
        if (this.f26104b != null && this.f26103a != null && this.mMarkerComp != null && (recMarkerParam = this.f26106d) != null && recMarkerParam.point != null && this.f26106d.point.location != null) {
            this.mMarkerComp.setAllMarkersVisible(true);
            new SensingCircles(this.f26103a, this.f26104b, (int) R.color.map_departure_sensing_circle, SensingCircles.TIME_TRANSIEN_PERIOD, 48.0f).showTransientCircles(this.f26106d.point.location);
        }
    }

    public LatLng getLocation() {
        RecMarkerParam recMarkerParam = this.f26106d;
        if (recMarkerParam == null || recMarkerParam.point == null) {
            return null;
        }
        return this.f26106d.point.location;
    }

    public float getAlpha() {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            return iMarkersCompContract.getAlpha(this.f26105c);
        }
        return 0.0f;
    }

    public void setAlpha(float f) {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setAlpha(this.f26105c, f);
        }
    }

    public boolean isInCenter() {
        if (this.f26104b == null || this.f26106d.point == null) {
            return false;
        }
        if (this.isPined || LatLngUtils.isSameLatLng(this.f26104b.getCameraPosition().target, this.f26106d.point.location)) {
            return true;
        }
        return false;
    }

    public void onMapStable() {
        m18513c();
        this.f26110h = false;
    }

    public void setNeedShowInfoWindow(boolean z) {
        this.f26108f = z;
    }

    public void onMapScroll() {
        this.f26110h = true;
    }

    /* renamed from: c */
    private void m18513c() {
        boolean isInCenter = isInCenter();
        if (isInCenter && !this.f26109g) {
            this.f26109g = true;
            m18514d();
            m18517g();
            m18510a(this.f26109g);
            RecMarkerParam recMarkerParam = this.f26106d;
            if (recMarkerParam != null && recMarkerParam.markerCallback != null) {
                this.f26106d.markerCallback.onRecMarkerShow(this.f26106d.point, this.f26110h);
            }
        } else if (!isInCenter && this.f26109g) {
            this.f26109g = false;
            m18515e();
            m18516f();
            m18510a(this.f26109g);
        } else if (isInCenter && this.f26109g) {
            m18514d();
            m18517g();
            m18510a(this.f26109g);
        }
    }

    /* renamed from: d */
    private void m18514d() {
        if (this.mMarkerComp != null && this.f26104b != null && this.f26103a != null && this.f26106d != null && this.f26108f && isVisible() && !TextUtils.isEmpty(this.f26106d.point.addrName)) {
            this.mMarkerComp.showMarkerInfoWindow(this.f26105c, SingleRecMarkerBubble.getInstance().getView(this.f26103a, this.f26106d.point.addrName), InfoWindow.Position.BOTTOM);
        }
    }

    /* renamed from: e */
    private void m18515e() {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.hideMarkerInfoWindow(this.f26105c);
        }
    }

    /* renamed from: f */
    private void m18516f() {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setLabelVisible(this.f26105c, true);
        }
    }

    /* renamed from: g */
    private void m18517g() {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setLabelVisible(this.f26105c, false);
        }
    }

    /* renamed from: a */
    private void m18510a(boolean z) {
        RecMarkerParam recMarkerParam;
        if (this.mMarkerComp != null && (recMarkerParam = this.f26106d) != null) {
            this.mMarkerComp.updateMarkerIcon(this.f26105c, z ? recMarkerParam.selectedIcon : recMarkerParam.icon);
            int i = 100;
            this.mMarkerComp.updateMarkerZindex(this.f26105c, z ? 100 : 90);
            IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
            String str = this.f26105c;
            if (!z) {
                i = 90;
            }
            iMarkersCompContract.updateLabelZindex(str, i);
        }
    }
}
