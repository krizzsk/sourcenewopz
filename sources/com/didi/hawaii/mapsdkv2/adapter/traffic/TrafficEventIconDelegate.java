package com.didi.hawaii.mapsdkv2.adapter.traffic;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.hawaii.basic.HWContextProvider;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.adapter.MapManagerDelegate;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.IMapControlDelegate;
import com.didi.map.base.TrafficEventModel;
import com.didi.map.base.TrafficEventRoutePoint;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.base.bubble.BubbleManager;
import com.didi.map.base.bubble.TrafficHintShowBarn;
import com.didi.map.common.MapAssets;
import com.didi.map.core.base.OnMapScaleChangedListener;
import com.didi.map.core.element.MapTrafficIcon;
import com.didi.map.core.element.OnMapElementClickListener;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.map.MapView;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.BitmapDescriptorFactory;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TrafficEventIconDelegate {
    private static final long ANIMATE_MARKER2_DEALY = 720;
    private static final long ANIMATE_MARKER2_DURATION = 640;
    private static final long ANIMATE_MARKER_DURATION = 1120;
    private static final long ANIMATE_SECOND_DELAY = 1240;
    private static final long ANIMATE_SUM_DURATION = 2480;
    private static final String INNER_ROUTE_ICON_BG = "traffic_animate_bg.png";
    private static final int NO_HIDE_EVENT = -1;
    private static final PointF ORIGINSCALEXY = new PointF(0.1f, 0.1f);
    private ImageView accidentImageView;
    /* access modifiers changed from: private */
    public Marker animateMarker;
    /* access modifiers changed from: private */
    public Marker animateMarker2;
    private boolean animateMarkerVisible = true;
    private final BubbleManager bubbleManager;
    /* access modifiers changed from: private */
    public Bubble curAnimateBubble = null;
    private long curAnimateEventId = -1;
    private long curAnimateEventyRouteId = -1;
    private long curHideEventId = -1;
    private RouteAttachPoint curRouteAttachPoint = new RouteAttachPoint();
    private boolean debug = false;
    /* access modifiers changed from: private */
    public final DidiMapExt didiMap;
    private long hintIconEventId = -1;
    private int iconSize = 50;
    private boolean isShowFakeTrafficEvent = true;
    private boolean isShowTrafficEvent = true;
    /* access modifiers changed from: private */
    public AnimatorSet mAnimator;
    /* access modifiers changed from: private */
    public AnimatorSet mAnimator2;
    private final IMapControlDelegate mapControlDelegate;
    private final OnMapScaleChangedListener mapScaleChangeListener = new OnMapScaleChangedListener() {
        public void onScaleChanged(OnMapScaleChangedListener.ScaleChangedType scaleChangedType) {
            if (TrafficEventIconDelegate.this.didiMap != null) {
                TrafficEventIconDelegate.this.changeIconVisibleWhenScaleChange(TrafficEventIconDelegate.this.didiMap.getCurScaleLevel());
            }
        }
    };
    private BitmapDescriptor markerBg = null;
    /* access modifiers changed from: private */
    public Paint paint = new Paint();
    private List<TrafficEventRoutePoint> points = new ArrayList();
    private float strokeWidth = 2.0f;
    private byte[] trafficData;
    private Bubble trafficHintBubble;
    private final TrafficIconBitmapLoader trafficIconBitmapLoader;
    private boolean trafficIconVisible = true;
    private HashMap<Bubble, TrafficEventRoutePoint> trafficIcons = new HashMap<>();
    /* access modifiers changed from: private */
    public final Handler uiHandler = new Handler(Looper.getMainLooper());
    private final DidiMap.OnMarkerVisibleChangeListener visibleChangeListener = new DidiMap.OnMarkerVisibleChangeListener() {
        public void onVisibleChange(boolean z, long j) {
            if (TrafficEventIconDelegate.this.animateMarker != null && TrafficEventIconDelegate.this.curAnimateBubble != null && TrafficEventIconDelegate.this.curAnimateBubble.getId() == j) {
                TrafficEventIconDelegate.this.setAnimateMarkerRadarVisible(z);
            }
        }
    };

    public TrafficEventIconDelegate(DidiMapExt didiMapExt, MapManagerDelegate mapManagerDelegate) {
        this.didiMap = didiMapExt;
        this.bubbleManager = didiMapExt.getBubbleManager();
        this.mapControlDelegate = mapManagerDelegate;
        TrafficIconBitmapLoader trafficIconBitmapLoader2 = new TrafficIconBitmapLoader(HWContextProvider.getContext());
        this.trafficIconBitmapLoader = trafficIconBitmapLoader2;
        if (didiMapExt != null) {
            this.bubbleManager.registerBitmapLoader(TrafficIconBitmapLoader.TAG, trafficIconBitmapLoader2);
        }
        didiMapExt.addScaleChangeListener(this.mapScaleChangeListener);
    }

    public boolean isShowTrafficEvent() {
        return this.isShowTrafficEvent;
    }

    public void showTrafficIconRadar(long j, MapTrafficIcon mapTrafficIcon, int i) {
        if (i == 0 || mapTrafficIcon == null) {
            clearAnimateMarker();
        } else if (i == 2) {
            Marker marker = this.animateMarker;
            if (marker != null) {
                marker.setPosition(mapTrafficIcon.getLatLng());
            }
            Marker marker2 = this.animateMarker2;
            if (marker2 != null) {
                marker2.setPosition(mapTrafficIcon.getLatLng());
            }
        } else {
            long id = mapTrafficIcon.getId();
            cancelAnimator();
            long j2 = this.curAnimateEventId;
            Bubble bubble = this.curAnimateBubble;
            if (bubble != null) {
                bubble.setOnVisibleChangeListener((DidiMap.OnMarkerVisibleChangeListener) null);
                this.curAnimateBubble = null;
            }
            for (Map.Entry next : this.trafficIcons.entrySet()) {
                TrafficEventRoutePoint trafficEventRoutePoint = (TrafficEventRoutePoint) next.getValue();
                if (trafficEventRoutePoint.eventId == id && trafficEventRoutePoint.mRouteId == j) {
                    this.curAnimateBubble = (Bubble) next.getKey();
                    this.curAnimateEventId = id;
                    this.curAnimateEventyRouteId = j;
                }
            }
            if (j2 != this.curAnimateEventId) {
                this.animateMarkerVisible = true;
            }
            if (this.curAnimateBubble == null) {
                clearAnimateMarker();
                return;
            }
            if (this.markerBg == null) {
                Bitmap bitmap = MapAssets.bitmap(this.didiMap.getMapView().getContext(), "map/traffic_animate_bg.png");
                BitmapUtil.adaptFromXXhResource(bitmap);
                this.markerBg = BitmapDescriptorFactory.fromBitmap(bitmap);
            }
            Marker marker3 = this.animateMarker;
            if (marker3 == null) {
                this.animateMarker = this.didiMap.addMarker(new MarkerOptions(new LatLng(this.curAnimateBubble.getLatitude(), this.curAnimateBubble.getLongitude())).anchor(0.5f, 0.5f).icon(this.markerBg).is3D(false).flat(false).scaleXY(ORIGINSCALEXY).zIndex(1.0f));
                this.animateMarker2 = this.didiMap.addMarker(new MarkerOptions(new LatLng(this.curAnimateBubble.getLatitude(), this.curAnimateBubble.getLongitude())).anchor(0.5f, 0.5f).icon(this.markerBg).is3D(false).flat(false).scaleXY(ORIGINSCALEXY).zIndex(1.0f));
            } else {
                marker3.setPosition(new LatLng(this.curAnimateBubble.getLatitude(), this.curAnimateBubble.getLongitude()));
                this.animateMarker2.setPosition(new LatLng(this.curAnimateBubble.getLatitude(), this.curAnimateBubble.getLongitude()));
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.1f, 1.0f});
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.95f, 0.0f});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (TrafficEventIconDelegate.this.animateMarker != null) {
                        TrafficEventIconDelegate.this.animateMarker.setScale(new PointF(floatValue, floatValue));
                    }
                }
            });
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (TrafficEventIconDelegate.this.animateMarker != null) {
                        TrafficEventIconDelegate.this.animateMarker.setAlpha(floatValue);
                    }
                }
            });
            ofFloat.setDuration(ANIMATE_MARKER_DURATION);
            ofFloat2.setStartDelay(ANIMATE_MARKER2_DEALY);
            ofFloat2.setDuration(ANIMATE_MARKER2_DURATION);
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimator = animatorSet;
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.1f, 1.0f});
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{0.95f, 0.0f});
            ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (TrafficEventIconDelegate.this.animateMarker2 != null) {
                        TrafficEventIconDelegate.this.animateMarker2.setScale(new PointF(floatValue, floatValue));
                    }
                }
            });
            ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (TrafficEventIconDelegate.this.animateMarker2 != null) {
                        TrafficEventIconDelegate.this.animateMarker2.setAlpha(floatValue);
                    }
                }
            });
            ofFloat3.setDuration(ANIMATE_MARKER_DURATION);
            ofFloat4.setDuration(ANIMATE_MARKER2_DURATION);
            ofFloat4.setStartDelay(ANIMATE_MARKER2_DEALY);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mAnimator2 = animatorSet2;
            animatorSet2.playTogether(new Animator[]{ofFloat3, ofFloat4});
            this.uiHandler.post(new Runnable() {
                public void run() {
                    TrafficEventIconDelegate.this.mAnimator.start();
                    TrafficEventIconDelegate.this.uiHandler.postDelayed(this, TrafficEventIconDelegate.ANIMATE_SUM_DURATION);
                }
            });
            this.uiHandler.postDelayed(new Runnable() {
                public void run() {
                    TrafficEventIconDelegate.this.mAnimator2.start();
                    TrafficEventIconDelegate.this.uiHandler.postDelayed(this, TrafficEventIconDelegate.ANIMATE_SUM_DURATION);
                }
            }, ANIMATE_SECOND_DELAY);
            setAnimateMarkerRadarVisible(this.animateMarkerVisible);
            this.curAnimateBubble.setOnVisibleChangeListener(this.visibleChangeListener);
        }
    }

    private void cancelAnimator() {
        this.uiHandler.removeCallbacksAndMessages((Object) null);
        AnimatorSet animatorSet = this.mAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.mAnimator2;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
    }

    public void setNewestTrafficEventData(byte[] bArr) {
        if (bArr != null) {
            this.trafficData = (byte[]) bArr.clone();
        } else {
            this.trafficData = null;
        }
    }

    public void setTrafficEventData(byte[] bArr) {
        if (!this.isShowTrafficEvent || bArr == null) {
            clearTrafficEventData();
            clearAnimateMarker();
            return;
        }
        clearSeverTrafficIcons();
        this.mapControlDelegate.setTrafficEventData(bArr);
        this.points = this.mapControlDelegate.getTrafficEventRoutePointInfo();
        filterTrafficPoint();
        this.mapControlDelegate.hideTrafficEventExcludeClosure(true);
        addTrafficIcons(this.points);
        updateTrafficHintIcon(this.trafficHintBubble);
    }

    public void setShowTrafficEvent(boolean z) {
        this.isShowTrafficEvent = z;
        if (!z) {
            this.mapControlDelegate.clearTrafficEventData();
            this.points.clear();
            clearSeverTrafficIcons();
            clearAnimateMarker();
        }
    }

    public void updateLocalTrafficIcon(TrafficEventModel[] trafficEventModelArr) {
        if (this.isShowFakeTrafficEvent) {
            List<TrafficEventRoutePoint> convert2List = convert2List(trafficEventModelArr);
            clearOldReportTrafficIcons(convert2List);
            addReportTrafficIcons(convert2List);
        }
    }

    public void updateTrafficItemState(long j, int i, boolean z) {
        if (!z) {
            this.curHideEventId = j;
        } else if (this.curHideEventId == j) {
            this.curHideEventId = -1;
        }
        setTrafficIconVisibleWithEventId(j, i, z);
    }

    public List<TrafficEventRoutePoint> getTrafficEventsPointInfo() {
        return this.points;
    }

    public List<TrafficEventRoutePoint> getTrafficEventRoutePointInfo() {
        List<TrafficEventRoutePoint> list = this.points;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TrafficEventRoutePoint next : this.points) {
            if (next.accessType == 1) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void clearTrafficEventData() {
        this.mapControlDelegate.clearTrafficEventData();
        clearSeverTrafficIcons();
        clearAnimateMarker();
        List<TrafficEventRoutePoint> list = this.points;
        if (list != null) {
            list.clear();
        }
        this.trafficData = null;
    }

    public void setShowFakeTrafficEvent(boolean z) {
        this.isShowFakeTrafficEvent = z;
    }

    public boolean isShowFakeTrafficEvent() {
        return this.isShowFakeTrafficEvent;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.didi.map.base.bubble.Bubble} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showTrafficHintIcon(long r9, com.didi.map.base.bubble.TrafficHintShowBarn r11) {
        /*
            r8 = this;
            r8.hintIconEventId = r9
            java.util.HashMap<com.didi.map.base.bubble.Bubble, com.didi.map.base.TrafficEventRoutePoint> r0 = r8.trafficIcons
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x000d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0042
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            com.didi.map.base.TrafficEventRoutePoint r3 = (com.didi.map.base.TrafficEventRoutePoint) r3
            long r4 = r3.eventId
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 != 0) goto L_0x002b
            java.lang.Object r1 = r2.getKey()
            com.didi.map.base.bubble.Bubble r1 = (com.didi.map.base.bubble.Bubble) r1
        L_0x002b:
            long r4 = r3.eventId
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 != 0) goto L_0x000d
            com.didi.hawaii.mapsdkv2.adapter.traffic.TrafficEventIconDelegate$RouteAttachPoint r4 = r8.curRouteAttachPoint
            long r4 = r4.routeId
            long r6 = r3.mRouteId
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            java.lang.Object r9 = r2.getKey()
            r1 = r9
            com.didi.map.base.bubble.Bubble r1 = (com.didi.map.base.bubble.Bubble) r1
        L_0x0042:
            r8.addTrafficHintIconBubble(r1, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.adapter.traffic.TrafficEventIconDelegate.showTrafficHintIcon(long, com.didi.map.base.bubble.TrafficHintShowBarn):void");
    }

    private void updateTrafficHintIcon(Bubble bubble) {
        if (bubble != null) {
            Bubble bubble2 = null;
            Iterator<Map.Entry<Bubble, TrafficEventRoutePoint>> it = this.trafficIcons.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                TrafficEventRoutePoint trafficEventRoutePoint = (TrafficEventRoutePoint) next.getValue();
                if (trafficEventRoutePoint.eventId == this.hintIconEventId) {
                    bubble2 = (Bubble) next.getKey();
                }
                if (trafficEventRoutePoint.eventId == this.hintIconEventId && this.curRouteAttachPoint.routeId == trafficEventRoutePoint.mRouteId) {
                    bubble2 = (Bubble) next.getKey();
                    break;
                }
            }
            bubble.getTrafficIconAttrs().bindId = bubble2.getId();
            this.bubbleManager.updateBubble(bubble);
        }
    }

    public void removeTrafficHintIcon() {
        Bubble bubble = this.trafficHintBubble;
        if (bubble != null) {
            this.bubbleManager.removeBubble(bubble.getId());
            this.trafficHintBubble = null;
            this.hintIconEventId = -1;
        }
    }

    public void setTrafficEventIconCustomSize(int i, boolean z) {
        if (i == 1) {
            this.iconSize = 32;
        } else if (i == 2) {
            this.iconSize = 40;
        } else if (i == 3) {
            this.iconSize = 50;
        }
        if (z) {
            try {
                for (Bubble next : this.trafficIcons.keySet()) {
                    next.setShowInfo("traffic_icon|" + this.iconSize);
                    ((TrafficIconBitmapOpt) next.getOverlayRect(0).resourcePaths).setIconSize(this.iconSize);
                    this.bubbleManager.updateBubble(next);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void release() {
        if (this.didiMap != null) {
            this.bubbleManager.unregisterBitmapLoader(TrafficIconBitmapLoader.TAG);
        }
        clearAnimateMarker();
    }

    private void addTrafficIcons(List<TrafficEventRoutePoint> list) {
        clearSeverTrafficIcons();
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            Collections.sort(list);
            for (TrafficEventRoutePoint next : list) {
                HWLog.m16761i("addTrafficIcon", next.toString());
                if (!(next == null || next.mType / 100 == 4)) {
                    if (next != null && next.eventId == this.curAnimateEventId && next.mRouteId == this.curAnimateEventyRouteId) {
                        z = true;
                    }
                    addTrafficIconBubble(next);
                }
            }
            this.bubbleManager.handleBubbleCollision();
            if (!z) {
                clearAnimateMarker();
            }
        }
    }

    public boolean removeTrafficIcon(long j, int i, double d) {
        this.curRouteAttachPoint.routeId = j;
        this.curRouteAttachPoint.index = i;
        this.curRouteAttachPoint.shapeOffset = d;
        Iterator<Map.Entry<Bubble, TrafficEventRoutePoint>> it = this.trafficIcons.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry next = it.next();
            TrafficEventRoutePoint trafficEventRoutePoint = (TrafficEventRoutePoint) next.getValue();
            if (trafficEventRoutePoint.mRouteId == j && trafficEventRoutePoint.accessType == 1) {
                if (trafficEventRoutePoint.coorIdx < i || (trafficEventRoutePoint.coorIdx == i && ((double) trafficEventRoutePoint.shapeOffset) < d)) {
                    this.bubbleManager.removeBubble(((Bubble) next.getKey()).getId());
                    it.remove();
                    if (trafficEventRoutePoint.eventId == this.curAnimateEventId) {
                        clearAnimateMarker();
                    }
                    z = true;
                }
            }
        }
        filterTrafficPoint();
        return z;
    }

    public void switchOnOff(boolean z, boolean z2) {
        if (z && !z2) {
            if (this.isShowTrafficEvent && this.trafficIconVisible && this.trafficData != null) {
                this.mapControlDelegate.hideTrafficEventExcludeClosure(false);
                this.mapControlDelegate.setTrafficEventData(this.trafficData);
            }
            clearAllTrafficIcons();
        }
        if (!z && z2 && this.isShowTrafficEvent) {
            this.curRouteAttachPoint.shapeOffset = -1.0d;
            this.curRouteAttachPoint.index = -1;
            this.curRouteAttachPoint.routeId = -1;
            clearAnimateMarker();
            clearAllTrafficIcons();
            this.points = this.mapControlDelegate.getTrafficEventRoutePointInfo();
            this.mapControlDelegate.hideTrafficEventExcludeClosure(true);
            addTrafficIcons(this.points);
        }
        if (!z2) {
            this.mapControlDelegate.hideTrafficEventExcludeClosure(false);
            clearAllTrafficIcons();
            clearAnimateMarker();
        }
    }

    public void refeshTrafficIcon(List<Long> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<Map.Entry<Bubble, TrafficEventRoutePoint>> it = this.trafficIcons.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                Bubble bubble = (Bubble) next.getKey();
                TrafficEventRoutePoint trafficEventRoutePoint = (TrafficEventRoutePoint) next.getValue();
                if (!trafficEventRoutePoint.isFake && !list.contains(Long.valueOf(trafficEventRoutePoint.mRouteId))) {
                    this.bubbleManager.removeBubble(bubble.getId());
                    if (this.curAnimateEventId == trafficEventRoutePoint.eventId && this.curAnimateEventyRouteId == trafficEventRoutePoint.mRouteId) {
                        clearAnimateMarker();
                    }
                    it.remove();
                }
            }
        }
    }

    public void setAllTrafficIconVisible(boolean z, boolean z2) {
        boolean z3 = this.trafficIconVisible;
        if (z3 != z) {
            this.trafficIconVisible = z;
            if (z2) {
                this.mapControlDelegate.hideTrafficEventExcludeClosure(true);
                for (Map.Entry next : this.trafficIcons.entrySet()) {
                    Bubble bubble = (Bubble) next.getKey();
                    TrafficEventRoutePoint trafficEventRoutePoint = (TrafficEventRoutePoint) next.getValue();
                    if (trafficEventRoutePoint.eventId != this.curHideEventId && this.didiMap.getCurScaleLevel() > trafficEventRoutePoint.minShowLevel) {
                        bubble.setVisible(z);
                    }
                }
                this.bubbleManager.handleBubbleCollision();
                if (this.trafficData != null && z && !z3) {
                    List<TrafficEventRoutePoint> list = this.points;
                    if ((list == null || list.isEmpty()) && this.trafficIcons.isEmpty()) {
                        setTrafficEventData(this.trafficData);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void changeIconVisibleWhenScaleChange(int i) {
        for (Map.Entry next : this.trafficIcons.entrySet()) {
            Bubble bubble = (Bubble) next.getKey();
            TrafficEventRoutePoint trafficEventRoutePoint = (TrafficEventRoutePoint) next.getValue();
            if (i <= trafficEventRoutePoint.minShowLevel) {
                bubble.setVisible(false);
            } else if (trafficEventRoutePoint.eventId != this.curHideEventId && this.trafficIconVisible) {
                bubble.setVisible(true);
            }
        }
        this.bubbleManager.handleBubbleCollision();
    }

    private void addReportTrafficIcons(List<TrafficEventRoutePoint> list) {
        if (list != null && !list.isEmpty()) {
            for (TrafficEventRoutePoint next : list) {
                if (!this.trafficIcons.containsValue(next)) {
                    addTrafficIconBubble(next);
                }
            }
            this.bubbleManager.handleBubbleCollision();
        }
    }

    private List<TrafficEventRoutePoint> convert2List(TrafficEventModel[] trafficEventModelArr) {
        ArrayList arrayList = new ArrayList();
        if (trafficEventModelArr != null && trafficEventModelArr.length > 0) {
            for (TrafficEventModel convert2TrafficPoint : trafficEventModelArr) {
                arrayList.add(convert2TrafficPoint(convert2TrafficPoint));
            }
        }
        return arrayList;
    }

    private void clearOldReportTrafficIcons(List<TrafficEventRoutePoint> list) {
        Iterator<Map.Entry<Bubble, TrafficEventRoutePoint>> it = this.trafficIcons.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            TrafficEventRoutePoint trafficEventRoutePoint = (TrafficEventRoutePoint) next.getValue();
            if (!(next == null || next.getKey() == null || next.getValue() == null || !trafficEventRoutePoint.isFake || list.contains(trafficEventRoutePoint))) {
                this.bubbleManager.removeBubble(((Bubble) next.getKey()).getId());
                it.remove();
            }
        }
    }

    private void clearSeverTrafficIcons() {
        Iterator<Map.Entry<Bubble, TrafficEventRoutePoint>> it = this.trafficIcons.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!((TrafficEventRoutePoint) next.getValue()).isFake) {
                this.bubbleManager.removeBubble(((Bubble) next.getKey()).getId());
                it.remove();
            }
        }
    }

    private void clearAllTrafficIcons() {
        for (Bubble id : this.trafficIcons.keySet()) {
            this.bubbleManager.removeBubble(id.getId());
        }
        this.trafficIcons.clear();
    }

    private void setTrafficIconVisibleWithEventId(long j, int i, boolean z) {
        for (Map.Entry next : this.trafficIcons.entrySet()) {
            if (((TrafficEventRoutePoint) next.getValue()).eventId == j) {
                ((Bubble) next.getKey()).setVisible(z);
            }
        }
        this.mapControlDelegate.updateTrafficItemState(j, i, z);
        this.bubbleManager.handleBubbleCollision();
    }

    public void toggleDayNight(boolean z) {
        for (Bubble next : this.trafficIcons.keySet()) {
            next.setShowInfo("traffic_icon|" + z);
            next.getOverlayRect(0).resourcePaths.setNight(z);
            this.bubbleManager.updateBubble(next);
        }
    }

    /* access modifiers changed from: private */
    public void notifyTrafficIconClick(MapTrafficIcon mapTrafficIcon) {
        OnMapElementClickListener mapElementClickListener;
        DidiMapExt didiMapExt = this.didiMap;
        if (didiMapExt != null && (mapElementClickListener = didiMapExt.getMapElementClickListener()) != null) {
            mapElementClickListener.onTrafficIconClick(mapTrafficIcon);
        }
    }

    private TrafficEventRoutePoint convert2TrafficPoint(TrafficEventModel trafficEventModel) {
        TrafficEventRoutePoint trafficEventRoutePoint = new TrafficEventRoutePoint();
        trafficEventRoutePoint.eventId = trafficEventModel.event_id;
        trafficEventRoutePoint.mType = trafficEventModel.event_type;
        trafficEventRoutePoint.pos = new LatLng(trafficEventModel.event_lat, trafficEventModel.event_lng);
        trafficEventRoutePoint.isFake = true;
        trafficEventRoutePoint.minShowLevel = 12;
        return trafficEventRoutePoint;
    }

    private void addTrafficHintIconBubble(Bubble bubble, final TrafficHintShowBarn trafficHintShowBarn) {
        if (bubble != null && bubble.getOverlayRect(0) != null) {
            Bubble bubble2 = this.trafficHintBubble;
            if (bubble2 != null) {
                this.bubbleManager.removeBubble(bubble2.getId());
            }
            if (this.debug) {
                MapView mapView = this.didiMap.getMapView();
                ImageView imageView = this.accidentImageView;
                if (imageView != null) {
                    mapView.removeView(imageView);
                }
                this.strokeWidth = (float) DisplayUtils.dip2px(mapView.getContext(), 1.5f);
                this.paint.setColor(-65536);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setStrokeWidth(this.strokeWidth);
                this.paint.setAntiAlias(true);
                this.accidentImageView = new AppCompatImageView(mapView.getContext()) {
                    /* access modifiers changed from: protected */
                    public void onDraw(Canvas canvas) {
                        super.onDraw(canvas);
                        canvas.drawLine(trafficHintShowBarn.leftTop.x, trafficHintShowBarn.leftTop.y, trafficHintShowBarn.leftTop.x, trafficHintShowBarn.rightBottom.y, TrafficEventIconDelegate.this.paint);
                        Canvas canvas2 = canvas;
                        canvas2.drawArc(new RectF(trafficHintShowBarn.topCenter.x - trafficHintShowBarn.topRadius, trafficHintShowBarn.topCenter.y - trafficHintShowBarn.topRadius, trafficHintShowBarn.topCenter.x + trafficHintShowBarn.topRadius, trafficHintShowBarn.topCenter.y + trafficHintShowBarn.topRadius), -180.0f, 180.0f, false, TrafficEventIconDelegate.this.paint);
                        canvas.drawLine(trafficHintShowBarn.rightBottom.x, trafficHintShowBarn.leftTop.y, trafficHintShowBarn.rightBottom.x, trafficHintShowBarn.rightBottom.y, TrafficEventIconDelegate.this.paint);
                        canvas2.drawArc(new RectF(trafficHintShowBarn.bottomCenter.x - trafficHintShowBarn.bottomRadius, trafficHintShowBarn.bottomCenter.y - trafficHintShowBarn.bottomRadius, trafficHintShowBarn.bottomCenter.x + trafficHintShowBarn.bottomRadius, trafficHintShowBarn.bottomCenter.y + trafficHintShowBarn.bottomRadius), 0.0f, 180.0f, false, TrafficEventIconDelegate.this.paint);
                        canvas.drawCircle(trafficHintShowBarn.targetCenter.x, trafficHintShowBarn.targetCenter.y, 10.0f, TrafficEventIconDelegate.this.paint);
                    }

                    public boolean onTouchEvent(MotionEvent motionEvent) {
                        return super.onTouchEvent(motionEvent);
                    }
                };
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                this.accidentImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.accidentImageView.setBackgroundColor(0);
                mapView.addView(this.accidentImageView, layoutParams);
            }
            LatLng latLng = new LatLng(bubble.getLatitude(), bubble.getLongitude());
            Bubble bubble3 = new Bubble(new MarkerOptions(latLng));
            bubble3.position(latLng);
            bubble3.setzIndex(13);
            bubble3.setType(16384);
            bubble3.setCollisionType(0);
            bubble3.setPriority(211);
            bubble3.setShowInfo("traffic_hint_icon|" + this.didiMap.isNight());
            Bubble.OverlayRect overlayRect = new Bubble.OverlayRect(bubble3.getId());
            overlayRect.anchorX = 0.5f;
            overlayRect.anchorY = 0.5f;
            overlayRect.width = this.trafficIconBitmapLoader.HINT_ICON_WIDTH;
            overlayRect.height = this.trafficIconBitmapLoader.HINT_ICON_HEIGHT;
            overlayRect.resourcePaths = new TrafficIconBitmapOpt(bubble3.getId(), TrafficIconBitmapLoader.TAG, ((TrafficIconBitmapOpt) bubble.getOverlayRect(0).resourcePaths).getTrafficIconType()).setIsHintIcon(true);
            overlayRect.resourcePaths.setNight(this.didiMap.isNight());
            bubble3.addOverlayRect(overlayRect);
            bubble3.setTrafficIconAttrs(true, bubble.getId(), trafficHintShowBarn);
            BubbleManager bubbleManager2 = this.bubbleManager;
            if (bubbleManager2 != null) {
                bubbleManager2.addBubble(bubble3);
            }
            this.trafficHintBubble = bubble3;
        }
    }

    private void addTrafficIconBubble(final TrafficEventRoutePoint trafficEventRoutePoint) {
        if (trafficEventRoutePoint != null) {
            Bubble bubble = new Bubble(new MarkerOptions(trafficEventRoutePoint.pos));
            bubble.position(trafficEventRoutePoint.pos);
            bubble.setzIndex(13);
            bubble.setType(16384);
            bubble.setCollisionType(BubbleManager.getCollisionType(16384));
            bubble.setPriority(trafficEventRoutePoint.isFake ? TrafficEventRoutePoint.getTrafficIconTypePriority(trafficEventRoutePoint.mType) + 200 : 211);
            bubble.setShowInfo("traffic_icon|" + this.didiMap.isNight());
            Bubble.OverlayRect overlayRect = new Bubble.OverlayRect(bubble.getId());
            overlayRect.anchorX = 0.5f;
            overlayRect.anchorY = 0.5f;
            overlayRect.width = this.trafficIconBitmapLoader.ICON_WIDTH;
            overlayRect.height = this.trafficIconBitmapLoader.ICON_HEIGHT;
            overlayRect.resourcePaths = new TrafficIconBitmapOpt(bubble.getId(), TrafficIconBitmapLoader.TAG, trafficEventRoutePoint.mType).setIconSize(this.iconSize);
            overlayRect.resourcePaths.setNight(this.didiMap.isNight());
            bubble.addOverlayRect(overlayRect);
            bubble.setTrafficIconAttrs(trafficEventRoutePoint.mRouteId, trafficEventRoutePoint.isFake);
            BubbleManager bubbleManager2 = this.bubbleManager;
            if (bubbleManager2 != null) {
                bubbleManager2.addBubble(bubble);
                boolean z = this.trafficIconVisible && this.curHideEventId != trafficEventRoutePoint.eventId && this.didiMap.getCurScaleLevel() > trafficEventRoutePoint.minShowLevel;
                bubble.setVisible(z);
                this.trafficIcons.put(bubble, trafficEventRoutePoint);
                bubble.setOnClickListener(new DidiMap.OnMarkerClickListener() {
                    public boolean onMarkerClick(Marker marker) {
                        TrafficEventIconDelegate.this.notifyTrafficIconClick(new MapTrafficIcon(trafficEventRoutePoint.eventId, trafficEventRoutePoint.mSubId, trafficEventRoutePoint.mType, !trafficEventRoutePoint.isFake, trafficEventRoutePoint.pos));
                        return true;
                    }
                });
                if (trafficEventRoutePoint.eventId == this.curAnimateEventId && trafficEventRoutePoint.mRouteId == this.curAnimateEventyRouteId) {
                    Bubble bubble2 = this.curAnimateBubble;
                    if (bubble2 != null) {
                        bubble2.setOnVisibleChangeListener((DidiMap.OnMarkerVisibleChangeListener) null);
                    }
                    setAnimateMarkerRadarVisible(z);
                    this.curAnimateBubble = bubble;
                    bubble.setOnVisibleChangeListener(this.visibleChangeListener);
                }
            }
        }
    }

    private void filterTrafficPoint() {
        List<TrafficEventRoutePoint> list = this.points;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (TrafficEventRoutePoint next : this.points) {
                if (!(next.mRouteId == this.curRouteAttachPoint.routeId && next.accessType == 1 && (next.coorIdx < this.curRouteAttachPoint.index || (next.coorIdx == this.curRouteAttachPoint.index && ((double) next.shapeOffset) < this.curRouteAttachPoint.shapeOffset)))) {
                    arrayList.add(next);
                }
            }
            this.points = arrayList;
        }
    }

    private void clearAnimateMarker() {
        cancelAnimator();
        Marker marker = this.animateMarker;
        if (marker != null) {
            marker.remove();
            this.animateMarker = null;
        }
        Marker marker2 = this.animateMarker2;
        if (marker2 != null) {
            marker2.remove();
            this.animateMarker2 = null;
        }
        Bubble bubble = this.curAnimateBubble;
        if (bubble != null) {
            bubble.setOnVisibleChangeListener((DidiMap.OnMarkerVisibleChangeListener) null);
            this.curAnimateBubble = null;
        }
        this.curAnimateEventId = -1;
        this.curAnimateEventyRouteId = -1;
    }

    /* access modifiers changed from: private */
    public void setAnimateMarkerRadarVisible(boolean z) {
        Marker marker = this.animateMarker;
        if (marker != null) {
            marker.setVisible(z);
        }
        Marker marker2 = this.animateMarker2;
        if (marker2 != null) {
            marker2.setVisible(z);
        }
        this.animateMarkerVisible = z;
    }

    private static class RouteAttachPoint {
        public int index;
        public long routeId;
        public double shapeOffset;

        private RouteAttachPoint() {
            this.routeId = -1;
            this.index = -1;
            this.shapeOffset = -1.0d;
        }
    }
}
