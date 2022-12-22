package com.didi.map.global.component.departure.fence;

import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.PolygonUtil;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.util.DepartureUtils;
import com.didi.map.global.component.departure.util.FenceUtils;
import com.sdk.poibase.model.poi.AroundFenceInfo;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.FenceLatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FenceController {

    /* renamed from: a */
    private static final String f25130a = "FenceController";

    /* renamed from: b */
    private Map f25131b;

    /* renamed from: c */
    private IFence f25132c;

    /* renamed from: d */
    private DepartureAddress f25133d;

    /* renamed from: e */
    private DepartureFenceOptions f25134e;

    /* renamed from: f */
    private int f25135f = DepartureConstants.FENCE_FILL_COLOR;

    /* renamed from: g */
    private int f25136g = DepartureConstants.FENCE_STROKE_COLOR;

    /* renamed from: h */
    private int f25137h = 2;

    /* renamed from: i */
    private int f25138i = DepartureConstants.NO_PARKING_FENCE_FILL_COLOR;

    /* renamed from: j */
    private int f25139j = DepartureConstants.NO_PARKING_FENCE_STROKE_COLOR;

    /* renamed from: k */
    private int f25140k = 2;

    public FenceController(Map map, DepartureFenceOptions departureFenceOptions) {
        this.f25131b = map;
        this.f25134e = departureFenceOptions;
    }

    public void showFence(DepartureAddress departureAddress) {
        removeFence();
        if (departureAddress == null) {
            this.f25133d = null;
            return;
        }
        FenceInfo fenceInfo = departureAddress.getFenceInfo();
        if (fenceInfo == null || fenceInfo.drawFence == 0 || CollectionUtil.isEmpty((Collection<?>) fenceInfo.polygon)) {
            m18050a("FenceController.showFence addFence fail, return fenceInfo=" + fenceInfo);
            this.f25133d = null;
            return;
        }
        this.f25133d = departureAddress;
        m18050a("FenceController.showFence addFence ok , " + fenceInfo);
        int i = 1;
        if (fenceInfo.fenceType != 1) {
            i = departureAddress.getZoneType();
        }
        Fence fence = new Fence(m18048a(fenceInfo.polygon, i), DepartureConstants.FENCE_TAG);
        this.f25132c = fence;
        fence.addToMap(this.f25131b);
    }

    public void removeFence() {
        this.f25133d = null;
        IFence iFence = this.f25132c;
        if (iFence != null) {
            iFence.remove();
            DLog.m7384d(f25130a, "删除围栏" + this.f25132c.hashCode(), new Object[0]);
            this.f25132c = null;
        }
    }

    public void showAroundFenceList(ArrayList<AroundFenceInfo> arrayList) {
        removeAroundFenceList();
        if (arrayList != null && !arrayList.isEmpty() && this.f25131b != null) {
            Iterator<AroundFenceInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AroundFenceInfo next = it.next();
                if (next.polygon != null && !next.polygon.isEmpty()) {
                    PolygonOptions polygonOptions = new PolygonOptions();
                    for (FenceLatLng next2 : next.polygon) {
                        polygonOptions.add(new LatLng(next2.lat, next2.lng));
                    }
                    polygonOptions.setPolygonPatternType(0);
                    polygonOptions.fillColor(this.f25138i).strokeColor(this.f25139j).strokeWidth((float) DisplayUtils.dp2px(this.f25131b.getContext(), (float) this.f25140k));
                    m18050a("FenceController.showAroundFenceList ok");
                    this.f25131b.addPolygon(DepartureConstants.NO_PARKING_FENCE_TAG, polygonOptions).setData(next.fenceId);
                }
            }
        }
    }

    public void removeAroundFenceList() {
        Map map = this.f25131b;
        if (map != null) {
            map.removeElementGroupByTag(DepartureConstants.NO_PARKING_FENCE_TAG);
        }
    }

    public int isInFence(LatLng latLng) {
        boolean z;
        if (latLng == null) {
            return 2;
        }
        FenceInfo fenceInfo = getFenceInfo();
        boolean z2 = false;
        if (fenceInfo != null) {
            z = FenceUtils.positionIsInFence(this.f25131b, fenceInfo, latLng);
            if (z) {
                return fenceInfo.fenceType;
            }
        } else {
            z = false;
        }
        if (z) {
            return 2;
        }
        if (isInAroundFence(latLng) != null) {
            z2 = true;
        }
        return z2 ? 3 : 2;
    }

    public String isInAroundFence(LatLng latLng) {
        ArrayList<IMapElement> elementGroup;
        Map map = this.f25131b;
        if (map == null || latLng == null || (elementGroup = map.getElementGroup(DepartureConstants.NO_PARKING_FENCE_TAG)) == null || elementGroup.isEmpty()) {
            return null;
        }
        Iterator<IMapElement> it = elementGroup.iterator();
        while (it.hasNext()) {
            IMapElement next = it.next();
            if (next instanceof Polygon) {
                Polygon polygon = (Polygon) next;
                ArrayList arrayList = new ArrayList();
                for (LatLng next2 : polygon.getBounderPoints()) {
                    arrayList.add(new LatLng(next2.latitude, next2.longitude));
                }
                if (PolygonUtil.contains(this.f25131b, (List<LatLng>) arrayList, new LatLng(latLng.latitude, latLng.longitude))) {
                    return (String) polygon.getData();
                }
            }
        }
        return null;
    }

    public int getFenceType() {
        return getFenceType(DepartureUtils.getMapCenterPoint(this.f25131b));
    }

    public int getFenceType(LatLng latLng) {
        DepartureAddress departureAddress = this.f25133d;
        int zoneType = departureAddress != null ? departureAddress.getZoneType() : 2;
        if (zoneType == 2 && isInAroundFence(latLng) != null) {
            zoneType = 1;
        }
        m18050a("FenceController.getFenceType zoneType=" + zoneType);
        return zoneType;
    }

    public FenceInfo getFenceInfo() {
        DepartureAddress departureAddress = this.f25133d;
        if (departureAddress != null) {
            return departureAddress.getFenceInfo();
        }
        return null;
    }

    /* renamed from: a */
    private FenceOptions m18048a(List<FenceLatLng> list, int i) {
        if (this.f25131b == null) {
            return null;
        }
        FenceOptions fenceOptions = new FenceOptions();
        ArrayList arrayList = new ArrayList();
        m18049a();
        arrayList.add(FenceUtils.convert2FencePolygon(list));
        fenceOptions.setFences(arrayList);
        fenceOptions.setLimitZoom(13.0d);
        if (i == 0) {
            fenceOptions.setFillColor(this.f25135f);
            fenceOptions.setStrokeColor(this.f25136g);
            fenceOptions.setStrokeWidth((float) DisplayUtils.dp2px(this.f25131b.getContext(), (float) this.f25137h));
        } else if (i == 1) {
            fenceOptions.setFillColor(this.f25138i);
            fenceOptions.setStrokeColor(this.f25139j);
            fenceOptions.setStrokeWidth((float) DisplayUtils.dp2px(this.f25131b.getContext(), (float) this.f25140k));
        }
        return fenceOptions;
    }

    /* renamed from: a */
    private void m18049a() {
        DepartureFenceOptions departureFenceOptions = this.f25134e;
        if (departureFenceOptions != null) {
            if (departureFenceOptions.fenceFillColor != 0) {
                this.f25135f = this.f25134e.fenceFillColor;
            }
            if (this.f25134e.fenceStrokeColor != 0) {
                this.f25136g = this.f25134e.fenceStrokeColor;
            }
            if (this.f25134e.fenceStrokeWidth != 0) {
                this.f25137h = this.f25134e.fenceStrokeWidth;
            }
            if (this.f25134e.noParkingFenceFillColor != 0) {
                this.f25138i = this.f25134e.noParkingFenceFillColor;
            }
            if (this.f25134e.noParkingFenceStrokeColor != 0) {
                this.f25139j = this.f25134e.noParkingFenceStrokeColor;
            }
            if (this.f25134e.noParkingFenceStrokeWidth != 0) {
                this.f25140k = this.f25134e.noParkingFenceStrokeWidth;
            }
        }
    }

    /* renamed from: a */
    private void m18050a(String str) {
        DLog.m7384d("DepartureCompDebug", "FenceController: " + str, new Object[0]);
    }

    public void setFenceVisible(boolean z) {
        IFence iFence = this.f25132c;
        if (iFence != null) {
            iFence.setFenceVisible(z);
        }
        Map map = this.f25131b;
        if (map != null) {
            map.setGroupElementVisible(DepartureConstants.NO_PARKING_FENCE_TAG, z);
        }
    }
}
