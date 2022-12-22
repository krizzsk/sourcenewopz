package com.didi.map.global.component.recmarker;

import android.animation.ValueAnimator;
import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.recmarker.model.RecMarkerParam;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.map.global.component.recmarker.view.IRecMarker;
import com.didi.map.global.component.recmarker.view.RecMarkerImpl;
import com.didi.sdk.util.collection.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecMarkerController implements IRecMarkerController {

    /* renamed from: a */
    private static final String f26096a = "RecMarkerController";

    /* renamed from: b */
    private Context f26097b;

    /* renamed from: c */
    private Map f26098c;

    /* renamed from: d */
    private RecMarkerControllerParam f26099d;

    /* renamed from: e */
    private boolean f26100e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<IRecMarker> f26101f;

    /* renamed from: g */
    private boolean f26102g;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f26097b = context.getApplicationContext();
        this.f26098c = map;
        this.f26101f = new ArrayList();
    }

    public void destroy() {
        remove();
        this.f26097b = null;
        this.f26098c = null;
        List<IRecMarker> list = this.f26101f;
        if (list != null) {
            list.clear();
            this.f26101f = null;
        }
    }

    public void setConfigParam(RecMarkerControllerParam recMarkerControllerParam) {
        this.f26099d = recMarkerControllerParam;
    }

    public void add() {
        RecMarkerControllerParam recMarkerControllerParam = this.f26099d;
        if (recMarkerControllerParam != null && this.f26098c != null) {
            if (CollectionUtil.isEmpty((Collection<?>) recMarkerControllerParam.list)) {
                remove();
                return;
            }
            remove();
            for (RecPoint next : this.f26099d.list) {
                DLog.m7384d(f26096a, "loop:" + next.location.toString() + "," + next.addrName, new Object[0]);
                RecMarkerImpl recMarkerImpl = new RecMarkerImpl();
                recMarkerImpl.create(this.f26097b, this.f26098c);
                RecMarkerParam recMarkerParam = new RecMarkerParam();
                recMarkerParam.point = next;
                recMarkerParam.selectedIcon = this.f26099d.selectedIcon;
                recMarkerParam.icon = this.f26099d.icon;
                recMarkerParam.isClickEnable = this.f26099d.isClickable;
                recMarkerParam.listener = this.f26099d.markerClickListener;
                recMarkerParam.markerCallback = this.f26099d.markerCallback;
                recMarkerParam.isShowLabel = this.f26099d.isShowLabel;
                recMarkerParam.labelView = this.f26099d.labelView;
                recMarkerParam.labelDirection = this.f26099d.labelDirection;
                recMarkerParam.strategy = this.f26099d.strategy;
                recMarkerImpl.setConfigParam(recMarkerParam);
                recMarkerImpl.setNeedShowInfoWindow(this.f26102g);
                recMarkerImpl.setPined(m18507a(next, this.f26099d.pinedPoint));
                recMarkerImpl.add();
                this.f26101f.add(recMarkerImpl);
            }
        }
    }

    /* renamed from: a */
    private boolean m18507a(RecPoint recPoint, RecPoint recPoint2) {
        if (recPoint2 == null) {
            return false;
        }
        return LatLngUtils.isCompletedSameLatLng(recPoint.location, recPoint2.location);
    }

    public void remove() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26101f)) {
            for (IRecMarker next : this.f26101f) {
                if (next != null) {
                    next.remove();
                }
            }
            this.f26101f.clear();
        }
    }

    public void remove(int i) {
        if (i <= 10) {
            remove();
        }
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26101f)) {
            IRecMarker iRecMarker = this.f26101f.get(0);
            if (iRecMarker == null) {
                for (IRecMarker next : this.f26101f) {
                    if (next != null) {
                        next.remove();
                    }
                }
                this.f26101f.clear();
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{iRecMarker.getAlpha(), 0.0f});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() > 0.9f) {
                        for (IRecMarker iRecMarker : RecMarkerController.this.f26101f) {
                            if (iRecMarker != null) {
                                iRecMarker.remove();
                            }
                        }
                        RecMarkerController.this.f26101f.clear();
                        return;
                    }
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    for (IRecMarker iRecMarker2 : RecMarkerController.this.f26101f) {
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
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26101f)) {
            for (IRecMarker next : this.f26101f) {
                if (next != null) {
                    next.showCircles();
                }
            }
        }
    }

    public void hideCircles() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26101f)) {
            for (IRecMarker next : this.f26101f) {
                if (next != null) {
                    next.hideCircles();
                }
            }
        }
    }

    public void visible(boolean z) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26101f)) {
            this.f26100e = z;
            for (IRecMarker next : this.f26101f) {
                if (next != null) {
                    next.visible(z);
                }
            }
        }
    }

    public boolean isVisible() {
        return this.f26100e;
    }

    public void setLabelDirect(String str, int i) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26101f) && str != null && !str.isEmpty()) {
            for (IRecMarker next : this.f26101f) {
                if (next != null && next.getId() == str) {
                    next.setLabelDirect(i);
                }
            }
        }
    }

    public void setVisible(String str, boolean z) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26101f) && str != null && !str.isEmpty()) {
            for (IRecMarker next : this.f26101f) {
                if (next != null && next.getId() == str) {
                    next.visible(z);
                }
            }
        }
    }

    public void showTransientCircles(LatLng latLng) {
        IRecMarker findMarker = findMarker(latLng);
        if (findMarker != null) {
            findMarker.showTransientCircles();
        }
    }

    public IRecMarker findMarker(LatLng latLng) {
        if (latLng == null || CollectionUtil.isEmpty((Collection<?>) this.f26101f)) {
            return null;
        }
        for (IRecMarker next : this.f26101f) {
            if (LatLngUtils.isSameLatLng(latLng, next.getLocation())) {
                return next;
            }
        }
        return null;
    }

    public void updateMarkerPinedState(LatLng latLng) {
        if (latLng != null && !CollectionUtil.isEmpty((Collection<?>) this.f26101f)) {
            for (IRecMarker next : this.f26101f) {
                if (next instanceof RecMarkerImpl) {
                    ((RecMarkerImpl) next).isPined = LatLngUtils.isCompletedSameLatLng(latLng, next.getLocation());
                }
            }
        }
    }

    public void onMapStable() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26101f)) {
            for (IRecMarker next : this.f26101f) {
                if (next != null) {
                    next.onMapStable();
                }
            }
        }
    }

    public void onMapScroll() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26101f)) {
            for (IRecMarker next : this.f26101f) {
                if (next != null) {
                    next.onMapScroll();
                }
            }
        }
    }

    public void setNeedShowInfoWindow(boolean z) {
        this.f26102g = z;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26101f)) {
            for (IRecMarker next : this.f26101f) {
                if (next != null) {
                    next.setNeedShowInfoWindow(z);
                }
            }
        }
    }
}
