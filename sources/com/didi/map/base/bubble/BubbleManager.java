package com.didi.map.base.bubble;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.OmegaUtils;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.MapGestureListener;
import com.didi.map.outer.model.MapGestureListenerAdapter;
import com.didi.map.outer.model.Marker;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BubbleManager implements DidiMapExt.BubbleLoadBitmapListener {
    private static final String TAG = "BubbleManager";
    private final Map<Long, Bubble> bubblesMap = new ConcurrentHashMap();
    private Map<String, Bubble> businessBubble = new HashMap();
    private Map<String, Marker> businessMarker = new HashMap();
    private final DidiMap.OnCameraChangeListener cameraChangeListener = new DidiMap.OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            float f = cameraPosition.zoom;
            float f2 = cameraPosition.bearing;
            float f3 = cameraPosition.tilt;
            if (BubbleManager.this.lastZoom != f && f != 0.0f) {
                float unused = BubbleManager.this.lastZoom = f;
                BubbleManager.this.handleBubbleCollisionInner();
            } else if (BubbleManager.this.lastBearing != f2 && f2 != 0.0f) {
                float unused2 = BubbleManager.this.lastBearing = f2;
                BubbleManager.this.handleBubbleCollisionInner();
            } else if (BubbleManager.this.lastTilt != f3 && f3 != 0.0f) {
                float unused3 = BubbleManager.this.lastTilt = f3;
                BubbleManager.this.handleBubbleCollisionInner();
            }
        }
    };
    /* access modifiers changed from: private */
    public DidiMapExt didiMapExt;
    private final Handler handlerUi = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public float lastBearing;
    /* access modifiers changed from: private */
    public float lastTilt;
    /* access modifiers changed from: private */
    public float lastZoom;
    private final Map<String, BaseBubbleBitmapLoader> loaderMap = new ConcurrentHashMap();
    private final MapGestureListener mapGestureListener = new MapGestureListenerAdapter() {
        public void onMapStable() {
            BubbleManager.this.didiMapExt.handleBubbleCollision();
        }
    };
    private final Runnable runnable = new Runnable() {
        public void run() {
            BubbleManager.this.didiMapExt.handleBubbleCollision();
        }
    };

    public static int getPriority(int i) {
        if (i != 16) {
            return i != 128 ? 1 : 401;
        }
        return 400;
    }

    public BubbleManager(DidiMap didiMap) {
        DidiMapExt didiMapExt2 = (DidiMapExt) didiMap;
        this.didiMapExt = didiMapExt2;
        didiMapExt2.setBubbleLoadBitmapListener(this);
        didiMap.addMapGestureListener(this.mapGestureListener);
        didiMap.setOnCameraChangeListener(this.cameraChangeListener);
    }

    public void addBubble(Bubble bubble) {
        bubble.setMarker(this.didiMapExt.addMarker(bubble.getMarkerOptions().setCollideRouteLableBubble(false)));
        this.didiMapExt.addBubble(bubble);
        this.bubblesMap.put(Long.valueOf(bubble.getId()), bubble);
        handleBubbleCollisionInner();
    }

    public void removeBubble(long j) {
        removeBubble(j, true);
    }

    private void removeBubble(long j, boolean z) {
        this.didiMapExt.removeBubble(j);
        Bubble remove = this.bubblesMap.remove(Long.valueOf(j));
        if (!(remove == null || remove.getTrafficIconAttrs() == null || !remove.getTrafficIconAttrs().isHintIcon)) {
            this.didiMapExt.removeRemoteBubble(remove.getTrafficIconAttrs().bindId);
        }
        if (remove != null && z) {
            remove.remove();
            handleBubbleCollisionInner();
        }
    }

    public void updateBubble(Bubble bubble) {
        this.didiMapExt.updateBubble(bubble);
    }

    public void handleBubbleCollision() {
        handleBubbleCollisionInner();
    }

    /* access modifiers changed from: private */
    public void handleBubbleCollisionInner() {
        controlCollisionFrequency();
    }

    public void registerBitmapLoader(String str, BaseBubbleBitmapLoader baseBubbleBitmapLoader) {
        if (str != null && baseBubbleBitmapLoader != null) {
            this.loaderMap.put(str, baseBubbleBitmapLoader);
        }
    }

    public void unregisterBitmapLoader(String str) {
        this.loaderMap.remove(str);
    }

    private BaseBubbleBitmapLoader getBitmapLoader(String str) {
        return this.loaderMap.get(str);
    }

    public Bubble getBubble(long j) {
        return this.bubblesMap.get(Long.valueOf(j));
    }

    public void onDestory() {
        this.handlerUi.removeCallbacksAndMessages((Object) null);
        this.didiMapExt.removeBubbleListener();
        for (Map.Entry<String, BaseBubbleBitmapLoader> value : this.loaderMap.entrySet()) {
            ((BaseBubbleBitmapLoader) value.getValue()).onDestory();
        }
        this.loaderMap.clear();
        this.bubblesMap.clear();
        this.didiMapExt.setOnCameraChangeListener((DidiMap.OnCameraChangeListener) null);
        this.didiMapExt.removeMapGestureListener(this.mapGestureListener);
    }

    public Bitmap onBitmapLoader(int i, String str) {
        BaseBubbleBitmapLoader bitmapLoader;
        Bubble bubble;
        if (str.indexOf("|") == -1) {
            return null;
        }
        String[] split = str.split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG);
        if (split.length > 2) {
            try {
                String str2 = split[1];
                if (!(str2 == null || (bitmapLoader = getBitmapLoader(str2)) == null || (bubble = getBubble(Long.valueOf(split[2]).longValue())) == null)) {
                    int intValue = Integer.valueOf(split[4]).intValue();
                    Bitmap loadBitmap = bitmapLoader.loadBitmap(bubble, intValue);
                    if (loadBitmap == null) {
                        String str3 = "loadBubbleBitmap = null" + str2 + intValue;
                        OmegaUtils.reportBubbleException(str3);
                        HWLog.m16761i(TAG, str3);
                    }
                    return loadBitmap;
                }
            } catch (Exception e) {
                String stackTraceString = Log.getStackTraceString(e);
                OmegaUtils.reportBubbleException(stackTraceString);
                HWLog.m16761i(TAG, "bubbleExcception: " + stackTraceString);
            }
        }
        return null;
    }

    public void addBusinessMarker(Marker marker) {
        Bitmap bitmap;
        if (!this.businessMarker.containsKey(marker.getId()) && this.didiMapExt.getMapView() != null && (bitmap = marker.getOptions().getIcon().getBitmap(this.didiMapExt.getMapView().getContext().getApplicationContext())) != null) {
            Bubble bubble = new Bubble(marker.getOptions(), true);
            bubble.position(marker.getPosition());
            bubble.setzIndex((int) marker.getOptions().getZIndex());
            bubble.setType(32768);
            bubble.setCollisionType(getCollisionType(32768));
            bubble.setPriority(10);
            bubble.setVirtual(true);
            bubble.setShowInfo("业务层");
            Bubble.OverlayRect overlayRect = new Bubble.OverlayRect(bubble.getId());
            overlayRect.anchorX = marker.getAnchorU();
            overlayRect.anchorY = marker.getAnchorV();
            overlayRect.width = bitmap.getWidth();
            overlayRect.height = bitmap.getHeight();
            overlayRect.resourcePaths = new NullBubbleBitmapOpt("null", bubble.getId());
            bubble.addOverlayRect(overlayRect);
            addBubble(bubble, marker);
            this.businessMarker.put(marker.getId(), marker);
            this.businessBubble.put(marker.getId(), bubble);
        }
    }

    public void removeBusinessMarker(String str) {
        if (this.businessMarker.containsKey(str)) {
            removeBubble(this.businessBubble.get(str).getId(), false);
            this.businessMarker.remove(str);
            this.businessBubble.remove(str);
        }
    }

    private void addBubble(Bubble bubble, Marker marker) {
        bubble.setMarker(marker);
        this.didiMapExt.addBubble(bubble);
        this.bubblesMap.put(Long.valueOf(bubble.getId()), bubble);
    }

    public static int getCollisionType(int i) {
        if (i == 1) {
            return 10;
        }
        if (i == 2) {
            return 8251;
        }
        if (i == 4) {
            return ApolloHawaii.IS_USE_BLOCKOPT ? 57404 : 44;
        }
        if (i == 8) {
            return 57535;
        }
        if (i != 16) {
            if (i == 32) {
                return 41150;
            }
            if (i == 128) {
                return 49320;
            }
            if (i != 8192) {
                if (i != 16384) {
                    return i != 32768 ? 0 : 41148;
                }
                return 16524;
            } else if (ApolloHawaii.IS_USE_BLOCKOPT) {
                return 41022;
            }
        } else if (ApolloHawaii.IS_USE_BLOCKOPT) {
            return 41022;
        }
        return 40;
    }

    private void controlCollisionFrequency() {
        this.handlerUi.removeCallbacks(this.runnable);
        this.handlerUi.postDelayed(this.runnable, 300);
    }
}
