package com.didi.map.sdk.departure.internal.markers;

import android.animation.ValueAnimator;
import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.departure.internal.rec.IRecMarker;
import com.didi.map.sdk.departure.internal.rec.RecMarkerImpl;
import com.didi.map.sdk.departure.internal.rec.RecMarkerParam;
import com.didi.map.sdk.departure.internal.rec.SquareHelper;
import com.didi.map.sdk.departure.internal.util.LatLngUtil;
import com.didi.map.sdk.departure.internal.util.OmegaUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecMarkerController implements IRecMarkerController {

    /* renamed from: a */
    private static final String f28160a = "RecMarkerController";

    /* renamed from: b */
    private Context f28161b;

    /* renamed from: c */
    private Map f28162c;

    /* renamed from: d */
    private RecMarkerControllerParam f28163d;

    /* renamed from: e */
    private boolean f28164e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<IRecMarker> f28165f;

    /* renamed from: g */
    private double f28166g;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f28161b = context.getApplicationContext();
        this.f28162c = map;
        this.f28165f = new ArrayList();
        this.f28166g = this.f28162c.getCameraPosition().zoom;
    }

    public void destroy() {
        remove();
        this.f28161b = null;
        this.f28162c = null;
        List<IRecMarker> list = this.f28165f;
        if (list != null) {
            list.clear();
            this.f28165f = null;
        }
    }

    public void setConfigParam(RecMarkerControllerParam recMarkerControllerParam) {
        this.f28163d = recMarkerControllerParam;
    }

    public void add() {
        RecMarkerControllerParam recMarkerControllerParam = this.f28163d;
        if (recMarkerControllerParam != null && this.f28162c != null) {
            if (CollectionUtil.isEmpty((Collection<?>) recMarkerControllerParam.list)) {
                remove();
                return;
            }
            remove();
            for (RecPoint next : this.f28163d.list) {
                DLog.m7384d(f28160a, "loop:" + next.location.toString() + "," + next.addrName, new Object[0]);
                RecMarkerImpl recMarkerImpl = new RecMarkerImpl();
                recMarkerImpl.create(this.f28161b, this.f28162c);
                RecMarkerParam recMarkerParam = new RecMarkerParam();
                recMarkerParam.point = next;
                recMarkerParam.selectedIcon = this.f28163d.selectedIcon;
                recMarkerParam.icon = this.f28163d.icon;
                recMarkerParam.isClickEnable = this.f28163d.isClickable;
                recMarkerParam.listener = this.f28163d.markerClickListener;
                recMarkerImpl.setConfigParam(recMarkerParam);
                recMarkerImpl.add();
                this.f28165f.add(recMarkerImpl);
                OmegaUtil.trackShowRecMarker(next);
            }
            if (!CollectionUtil.isEmpty((Collection<?>) this.f28165f) && this.f28161b != null) {
                SquareHelper.sortAndHideWithWeight(new ArrayList(this.f28165f));
            }
        }
    }

    public void remove() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28165f)) {
            for (IRecMarker next : this.f28165f) {
                if (next != null) {
                    next.remove();
                }
            }
            this.f28165f.clear();
        }
    }

    public void remove(int i) {
        if (i <= 10) {
            remove();
        }
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28165f)) {
            IRecMarker iRecMarker = this.f28165f.get(0);
            if (iRecMarker == null) {
                for (IRecMarker next : this.f28165f) {
                    if (next != null) {
                        next.remove();
                    }
                }
                this.f28165f.clear();
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{iRecMarker.getAlpha(), 0.0f});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() > 0.9f) {
                        for (IRecMarker iRecMarker : RecMarkerController.this.f28165f) {
                            if (iRecMarker != null) {
                                iRecMarker.remove();
                            }
                        }
                        RecMarkerController.this.f28165f.clear();
                        return;
                    }
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    for (IRecMarker iRecMarker2 : RecMarkerController.this.f28165f) {
                        if (iRecMarker2 != null) {
                            iRecMarker2.setAlpha(floatValue);
                        }
                    }
                }
            });
            ofFloat.setDuration((long) i);
            ofFloat.start();
        }
    }

    public void showCircles() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28165f)) {
            for (IRecMarker next : this.f28165f) {
                if (next != null) {
                    next.showCircles();
                }
            }
        }
    }

    public void hideCircles() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28165f)) {
            for (IRecMarker next : this.f28165f) {
                if (next != null) {
                    next.hideCircles();
                }
            }
        }
    }

    public void visible(boolean z) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28165f)) {
            this.f28164e = z;
            for (IRecMarker next : this.f28165f) {
                if (next != null) {
                    next.visible(z);
                }
            }
        }
    }

    public boolean isVisible() {
        return this.f28164e;
    }

    public void showTransientCircles(LatLng latLng) {
        IRecMarker findMarker = findMarker(latLng);
        if (findMarker != null) {
            findMarker.showTransientCircles();
        }
    }

    public IRecMarker findMarker(LatLng latLng) {
        if (latLng == null || CollectionUtil.isEmpty((Collection<?>) this.f28165f)) {
            return null;
        }
        for (IRecMarker next : this.f28165f) {
            if (LatLngUtil.isSameLatLng(latLng, next.getLocation())) {
                return next;
            }
        }
        return null;
    }

    public void onMapStable() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28165f)) {
            for (IRecMarker next : this.f28165f) {
                if (next != null) {
                    next.onMapStable();
                }
            }
        }
    }

    public void onZoomChange(double d) {
        if (Math.abs(d - this.f28166g) >= 0.1d) {
            this.f28166g = d;
            if (!CollectionUtil.isEmpty((Collection<?>) this.f28165f) && this.f28161b != null) {
                SquareHelper.sortAndHideWithWeight(new ArrayList(this.f28165f));
            }
        }
    }

    public void setNeedShowInfoWindow(boolean z) {
        SystemUtils.log(3, "ccc", "setNeedShowInfoWindow need:" + z, (Throwable) null, "com.didi.map.sdk.departure.internal.markers.RecMarkerController", 270);
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28165f)) {
            for (IRecMarker next : this.f28165f) {
                if (next != null) {
                    next.setNeedShowInfoWindow(z);
                }
            }
        }
    }
}
