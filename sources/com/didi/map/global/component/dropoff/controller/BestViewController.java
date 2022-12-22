package com.didi.map.global.component.dropoff.controller;

import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.util.BestViewUtil;
import com.didi.map.global.component.dropoff.util.DropOffAddressUtils;
import com.didi.map.global.component.dropoff.util.DropOffUtils;
import com.sdk.poibase.model.RpcPoi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BestViewController {
    public static final int M_200 = 200;
    public static final int M_2000 = 2000;

    /* renamed from: a */
    private Map f25448a;

    /* renamed from: b */
    private Padding f25449b;

    /* renamed from: c */
    private Padding f25450c;

    /* renamed from: d */
    private PinViewAttachListener f25451d;

    public interface PinViewAttachListener {
        void onAttach(LatLng latLng);
    }

    public BestViewController(Map map) {
        this.f25448a = map;
    }

    public void setMapPadding(Padding padding) {
        this.f25449b = padding;
    }

    public void setInPadding(Padding padding) {
        this.f25450c = padding;
    }

    public void setPinViewAttachListener(PinViewAttachListener pinViewAttachListener) {
        this.f25451d = pinViewAttachListener;
    }

    public void start(DropOffLocationInfo dropOffLocationInfo) {
        if (dropOffLocationInfo != null && this.f25448a != null) {
            LatLng latLng = dropOffLocationInfo.latLng;
            List<LatLng> boundsForDistance = BestViewUtil.getBoundsForDistance(2000, latLng);
            BestViewUtil.adjustMapCamera(this.f25448a, latLng, boundsForDistance, this.f25449b, this.f25450c, (BestViewer.IBestViewListener) null);
            DropOffUtils.LOGD("radius = " + DDSphericalUtil.computeDistanceBetween(latLng, boundsForDistance.get(0)));
        }
    }

    public void adjustMapCameraInternal(boolean z, RpcPoi rpcPoi, DropOffLocationInfo dropOffLocationInfo, List<RpcPoi> list, boolean z2, float f, BestViewer.IBestViewListener iBestViewListener) {
        LatLng latLng;
        List<LatLng> list2;
        Map map = this.f25448a;
        if (map != null) {
            if (rpcPoi != null) {
                latLng = new LatLng(rpcPoi.base_info.lat, rpcPoi.base_info.lng);
            } else if (z) {
                latLng = dropOffLocationInfo.latLng;
            } else {
                latLng = DropOffUtils.getMapCenterPoint(map);
            }
            LatLng latLng2 = latLng;
            if (z) {
                if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                    list2 = DropOffAddressUtils.getRecLatLngList(list);
                } else {
                    list2 = BestViewUtil.getBoundsForDistance(2000, latLng2);
                }
                BestViewUtil.adjustMapCamera(this.f25448a, latLng2, list2, this.f25449b, this.f25450c, iBestViewListener);
            } else if (z2) {
                attachPinViewToAdsorptionPoi(rpcPoi, latLng2, true, true, false, f);
            } else {
                List<LatLng> boundsForDistance = BestViewUtil.getBoundsForDistance(200, latLng2);
                BestViewUtil.adjustMapCamera(this.f25448a, latLng2, boundsForDistance, this.f25449b, this.f25450c, (BestViewer.IBestViewListener) null);
            }
        }
    }

    public void attachPinViewToAdsorptionPoi(RpcPoi rpcPoi, LatLng latLng, boolean z, boolean z2, boolean z3, float f) {
        if (rpcPoi == null && latLng == null) {
            DropOffUtils.LOGD("animateToAdsorbPoi() is null, return.");
            return;
        }
        LatLng latLng2 = null;
        if (rpcPoi != null && rpcPoi.base_info != null) {
            latLng2 = new LatLng(rpcPoi.base_info.lat, rpcPoi.base_info.lng);
        } else if (latLng != null) {
            latLng2 = latLng;
        }
        if (latLng2 != null) {
            PinViewAttachListener pinViewAttachListener = this.f25451d;
            if (pinViewAttachListener != null) {
                pinViewAttachListener.onAttach(latLng2);
            }
            BestViewUtil.adjustCameraForPinView(this.f25448a, latLng, true, z3, f, this.f25449b, (BestViewer.IBestViewListener) null);
        }
    }

    public void discountStart(DropOffLocationInfo dropOffLocationInfo) {
        LatLng latLng;
        if (this.f25448a != null && dropOffLocationInfo != null) {
            if (dropOffLocationInfo.sugPoi != null) {
                latLng = new LatLng(dropOffLocationInfo.sugPoi.latitude, dropOffLocationInfo.sugPoi.longitude);
            } else {
                latLng = DropOffUtils.getMapCenterPoint(this.f25448a);
            }
            LatLng latLng2 = latLng;
            ArrayList arrayList = new ArrayList();
            if (dropOffLocationInfo.parentPoi != null) {
                arrayList.add(new LatLng(dropOffLocationInfo.parentPoi.latitude, dropOffLocationInfo.parentPoi.longitude));
            }
            BestViewUtil.adjustMapCamera(this.f25448a, latLng2, arrayList, this.f25449b, this.f25450c, (BestViewer.IBestViewListener) null);
        }
    }

    public void discountAdjustMapCameraInternal(DropOffLocationInfo dropOffLocationInfo, BestViewer.IBestViewListener iBestViewListener) {
        LatLng latLng;
        if (this.f25448a != null && dropOffLocationInfo != null) {
            if (dropOffLocationInfo.sugPoi != null) {
                latLng = new LatLng(dropOffLocationInfo.sugPoi.latitude, dropOffLocationInfo.sugPoi.longitude);
            } else {
                latLng = DropOffUtils.getMapCenterPoint(this.f25448a);
            }
            BestViewUtil.adjustMapCamera(this.f25448a, latLng, dropOffLocationInfo.parentPoi != null ? Collections.singletonList(new LatLng(dropOffLocationInfo.parentPoi.latitude, dropOffLocationInfo.parentPoi.longitude)) : null, this.f25449b, this.f25450c, iBestViewListener);
        }
    }

    public void discountAdjustMapCameraIncludesInternal(DropOffLocationInfo dropOffLocationInfo, List<IMapElement> list) {
        LatLng latLng;
        if (this.f25448a != null && dropOffLocationInfo != null) {
            if (dropOffLocationInfo.sugPoi != null) {
                latLng = new LatLng(dropOffLocationInfo.sugPoi.latitude, dropOffLocationInfo.sugPoi.longitude);
            } else {
                latLng = DropOffUtils.getMapCenterPoint(this.f25448a);
            }
            LatLng latLng2 = latLng;
            if (this.f25448a.getMapVendor() == MapVendor.DIDI) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (IMapElement next : list) {
                    if (next != null && !CollectionUtil.isEmpty((Collection<?>) next.getBounderPoints())) {
                        builder.include(next.getBounderPoints());
                    }
                }
                LatLngBounds build = builder.build();
                if (this.f25449b == null) {
                    this.f25449b = new Padding(0, 0, 0, 0);
                }
                BestViewUtil.adjustCameraForPinView(this.f25448a, latLng2, false, false, this.f25448a.calculateZoomToSpanLevel(this.f25449b.left, this.f25449b.right, this.f25449b.top, this.f25449b.bottom, build.northeast, build.southwest), this.f25449b, (BestViewer.IBestViewListener) null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (IMapElement next2 : list) {
                if (!CollectionUtil.isEmpty((Collection<?>) next2.getBounderPoints())) {
                    arrayList.addAll(next2.getBounderPoints());
                }
            }
            BestViewUtil.adjustMapCamera(this.f25448a, latLng2, arrayList, this.f25449b, this.f25450c, (BestViewer.IBestViewListener) null);
        }
    }

    public void destroy() {
        this.f25449b = null;
        this.f25450c = null;
        this.f25448a = null;
    }
}
