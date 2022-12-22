package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.collection.LruCache;
import com.didi.hawaii.basic.HWContextProvider;
import com.didi.hawaii.log.HWLog;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.common.MarkerBitmapUtil;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.animation.AlphaAnimation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LableMarkerManager implements ILableMarkerManager {
    public static final int BLUE_GRAY_MIN_VISIBLE_LEVEL = 15;
    protected static final int DMAPCURRENROUTE = 0;
    protected static final int DMAPMAINROUTE = 1;
    protected static final int DMAPOTHERROUTE = 2;
    public static final int DMapAvoidCongestionBubble = 3;
    public static final int DMapCongestRoadBubble = 5;
    protected static final int DMapIllegalParkRoadBubble = 6;
    public static final int DMapMuitlRouteBubble = 4;
    protected static final int MARKER_DIRECTION_LEFT = 1;
    protected static final int MARKER_DIRECTION_LEFT_BOTTOM = 3;
    protected static final int MARKER_DIRECTION_ORIGINAL = 0;
    protected static final int MARKER_DIRECTION_RIGHT = 2;
    protected static final int MARKER_DIRECTION_RIGHT_BOTTOM = 4;
    protected static final int MESSAGE_TYPE_REFESHMULTIBUBLLE = 1005;
    protected static final int MESSAGE_TYPE_REMOVE_MARKER = 1003;
    protected static final int MESSAGE_TYPE_SETDATA = 1001;
    protected static final int MESSAGE_TYPE_SETOTHER_MARKERS = 1004;
    protected static final int MESSAGE_TYPE_SETVISIBLE = 1002;
    protected static final int MUITL_MIN_VISIBLE_LEVEL = 10;
    public static final int NAVI_MAP_MODE_2DFULLBROWSER = 2;
    public static final int NAVI_MAP_MODE_2DNAVIGATION = 3;
    public static final int NAVI_MAP_MODE_3DNAVIGATION = 1;
    public static final int SUITABLE_BUBBLE_INVISIBLE_LEVEL = 15;
    protected static List<Marker> otherMarkers = new CopyOnWriteArrayList();
    protected Map<String, Bitmap> bitmaps = new HashMap();
    private Marker blockMarker;
    protected final BlockLableBubble blockRouteLableBubble;
    protected TextLableOnRoute blockTextLableOnRoute;
    protected final BlueLableBubble blueLableBubble;
    protected BubblesSwitch bubblesSwitch = new BubblesSwitch();
    protected Marker collideMarker;
    protected Context context;
    protected String curRouteName = "";
    protected int curScaleLevel;
    protected DidiMap didiMap;
    protected List<TextLableOnRoute> drawLables = new LinkedList();
    protected final DynamicRouteLableBubble dynamicRouteLableBubble;
    protected final BlueLableBubble grayLableBubble;
    protected final Handler handlerUi = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                switch (message.what) {
                    case 1001:
                        LableMarkerManager.this.processMarker((List) message.obj);
                        return;
                    case 1002:
                        LableMarkerManager.this.clearMarker();
                        return;
                    case 1003:
                        Marker marker = (Marker) message.obj;
                        if (marker != null) {
                            LableMarkerManager.this.bitmaps.remove(marker.getTitle());
                            marker.remove();
                            return;
                        }
                        return;
                    case 1004:
                        List<Marker> list = (List) message.obj;
                        LableMarkerManager.otherMarkers.clear();
                        if (list != null) {
                            for (Marker add : list) {
                                LableMarkerManager.otherMarkers.add(add);
                            }
                            return;
                        }
                        return;
                    case 1005:
                        LableMarkerManager.this.refeshMultiRouteBubble();
                        return;
                    default:
                        return;
                }
            }
        }
    };
    protected final IllegalParkLableBubble illegalParkLableBubble;
    protected final int isHaveMultiRouteBubbleApollo;
    protected boolean isNight = false;
    protected Map<Long, TextLableOnRoute> labelCache = new HashMap();
    protected LruCache<String, Bitmap> mCacheBitmap = new LruCache<>(5);
    protected final LableMarkerConfig mIllegalParkConfig = LableMarkerConfig.createIllegalParkConfig();
    protected final LableMarkerConfig mainRouteConfig = LableMarkerConfig.createMainRouteConfig();
    protected MarkerBitmapUtil markerBitmapUtil;
    protected Map<String, Marker> markers = new HashMap();
    protected HashMap<Long, TextLableOnRoute> multiBubbleDatas = new HashMap<>();
    protected final MultiRouteLableBubble multiRouteLableBubble;
    protected int naviMapMode = 1;
    protected OnSelectMapRouteIdListener onSelectMapRouteIdListener;
    protected final LableMarkerConfig otherRouteConfig = LableMarkerConfig.createOtherRouteConfig();
    protected Map<String, TextLableOnRoute> preLableMarker = new HashMap();
    protected boolean visible = true;

    public static class BlockBubbleParams {
        public int blockBubbleType;
        public String fileName;
        public int[] padding;
        public String text;
        public int[] textColors;
        public float textSize;
        public String thumbUrl = "";
    }

    public static class MultiBubbleParams {
        public int diffDistance;
        public int diffTrafficLightCnt;
        public String fileName;
        public boolean is2DFullBrowser;
        public boolean isDynamicRoute;
        public boolean isNight;
        public String lable;
        public int[] padding;
        public String strTime;
        public int[] textColorArray;
    }

    public interface OnSelectMapRouteIdListener {
        void selectRouteId(long j);
    }

    public abstract LatLng getPosition(TextLableOnRoute textLableOnRoute);

    public abstract void processMarker(List<TextLableOnRoute> list);

    /* access modifiers changed from: protected */
    public void refeshMultiRouteBubble() {
    }

    public static class BubblesSwitch {
        public boolean avoidCongestionBubbleVisible = true;
        public boolean congestRoadBubbleVisible = true;
        public boolean currentRouteBubbleVisible = true;
        public boolean illegalParkVisible = true;
        public boolean isNaviAnimationState = false;
        public boolean mainRouteBubbleVisible = true;
        public boolean muitlRouteBubbleVisible = true;
        public boolean otherRouteBubbleVisible = true;

        public void all(boolean z) {
            this.currentRouteBubbleVisible = z;
            this.mainRouteBubbleVisible = z;
            this.otherRouteBubbleVisible = z;
            this.avoidCongestionBubbleVisible = z;
            this.muitlRouteBubbleVisible = z;
            this.congestRoadBubbleVisible = z;
            this.illegalParkVisible = z;
        }

        public boolean isMultiBubbleVisible() {
            return this.muitlRouteBubbleVisible && !this.isNaviAnimationState;
        }
    }

    public LableMarkerManager(DidiMap didiMap2) {
        this.didiMap = didiMap2;
        Context context2 = HWContextProvider.getContext();
        this.context = context2;
        if (context2 == null && didiMap2.getMapView() != null) {
            this.context = didiMap2.getMapView().getContext().getApplicationContext();
        }
        this.isHaveMultiRouteBubbleApollo = ApolloHawaii.isHaveMultiRouteBubble();
        MarkerBitmapUtil markerBitmapUtil2 = new MarkerBitmapUtil();
        this.markerBitmapUtil = markerBitmapUtil2;
        this.blueLableBubble = new BlueLableBubble(this.mainRouteConfig, markerBitmapUtil2);
        this.grayLableBubble = new BlueLableBubble(this.otherRouteConfig, this.markerBitmapUtil);
        this.multiRouteLableBubble = new MultiRouteLableBubble((LableMarkerConfig) null, this.markerBitmapUtil);
        this.dynamicRouteLableBubble = new DynamicRouteLableBubble((LableMarkerConfig) null, this.markerBitmapUtil);
        this.blockRouteLableBubble = new BlockLableBubble();
        this.illegalParkLableBubble = new IllegalParkLableBubble(this.mIllegalParkConfig, this.markerBitmapUtil);
    }

    public void clearMarker() {
        this.drawLables.clear();
        this.preLableMarker.clear();
        Iterator<Map.Entry<String, Marker>> it = this.markers.entrySet().iterator();
        while (it.hasNext()) {
            removeMarker((Marker) it.next().getValue());
            it.remove();
        }
        removeBlockMarker();
    }

    /* access modifiers changed from: protected */
    public void removeBlockMarker() {
        Marker marker = this.blockMarker;
        if (marker != null) {
            marker.remove();
            this.blockMarker = null;
            HWLog.m16761i("BJW", "removeRouteBlockBubble");
        }
    }

    public void onLableRouteCallback(List<TextLableOnRoute> list) {
        Message obtainMessage = this.handlerUi.obtainMessage();
        obtainMessage.obj = list;
        obtainMessage.what = 1001;
        this.handlerUi.sendMessage(obtainMessage);
    }

    public void callBackCurRouteName(String str) {
        this.curRouteName = str;
    }

    public void setVisible(boolean z) {
        this.visible = z;
        if (!z) {
            Message obtainMessage = this.handlerUi.obtainMessage();
            obtainMessage.what = 1002;
            this.handlerUi.sendMessage(obtainMessage);
        }
    }

    public void setCollideMarker(Marker marker) {
        this.collideMarker = marker;
    }

    public void setDayNight(boolean z) {
        this.isNight = z;
        Message obtainMessage = this.handlerUi.obtainMessage();
        obtainMessage.what = 1002;
        this.handlerUi.sendMessage(obtainMessage);
    }

    public void setNaviMapMode(int i) {
        if (this.naviMapMode != i) {
            this.naviMapMode = i;
            Message obtainMessage = this.handlerUi.obtainMessage();
            obtainMessage.what = 1005;
            this.handlerUi.sendMessage(obtainMessage);
        }
    }

    public void setCollideMarkers(List<Marker> list) {
        Message obtainMessage = this.handlerUi.obtainMessage();
        obtainMessage.obj = list;
        obtainMessage.what = 1004;
        this.handlerUi.sendMessage(obtainMessage);
    }

    public void setOnSelectMapRouteIdListener(OnSelectMapRouteIdListener onSelectMapRouteIdListener2) {
        this.onSelectMapRouteIdListener = onSelectMapRouteIdListener2;
    }

    public List<Rect> getCollideRects() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Marker> value : this.markers.entrySet()) {
            Marker marker = (Marker) value.getValue();
            if (marker != null && marker.isVisible()) {
                arrayList.add(marker.getScreenRect());
            }
        }
        return arrayList;
    }

    public void destroy() {
        otherMarkers.clear();
        clearMarker();
        this.bitmaps.clear();
        this.markerBitmapUtil.clear();
        this.mCacheBitmap.evictAll();
        Marker marker = this.blockMarker;
        if (marker != null) {
            marker.remove();
            this.blockMarker = null;
        }
        if (this.blockTextLableOnRoute != null) {
            this.blockTextLableOnRoute = null;
        }
        this.didiMap = null;
    }

    /* access modifiers changed from: protected */
    public void markerAnimationOut(Marker marker) {
        if (marker != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500);
            marker.setAnimation(alphaAnimation);
            marker.startAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void removeMarker(Marker marker) {
        if (marker != null) {
            markerAnimationOut(marker);
            Message obtainMessage = this.handlerUi.obtainMessage();
            obtainMessage.obj = marker;
            obtainMessage.what = 1003;
            this.handlerUi.sendMessageDelayed(obtainMessage, 500);
        }
    }

    /* access modifiers changed from: protected */
    public ILableBubble getLableBubble(int i) {
        if (i == 0 || i == 1) {
            return this.blueLableBubble;
        }
        if (i == 2) {
            return this.grayLableBubble;
        }
        if (i == 3) {
            return this.dynamicRouteLableBubble;
        }
        if (i == 4) {
            return this.multiRouteLableBubble;
        }
        if (i != 5) {
            return this.grayLableBubble;
        }
        return this.blockRouteLableBubble;
    }

    /* access modifiers changed from: protected */
    public boolean isLableMarkerVisibleForMapScaleChanged(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 5:
            case 6:
                if (getCurScaleLevel() < 15) {
                    return false;
                }
                return true;
            case 3:
            case 4:
                if (getCurScaleLevel() < 10) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private int getCurScaleLevel() {
        DidiMap didiMap2 = this.didiMap;
        if (didiMap2 == null) {
            return 0;
        }
        int curScaleLevel2 = didiMap2.getCurScaleLevel();
        this.curScaleLevel = curScaleLevel2;
        return curScaleLevel2;
    }

    /* access modifiers changed from: protected */
    public int getTextColor(int i, String str) {
        return getLableBubble(i).getTextColor(this.isNight, str);
    }

    /* access modifiers changed from: protected */
    public Bitmap getMarkerBitmap(String str, int i, String str2, int i2, boolean z, int i3) {
        String str3 = str;
        int i4 = i2;
        String iconFileName = getIconFileName(i4, str3);
        String[] split = str3.split(";");
        String str4 = split[0];
        if (!z) {
            iconFileName = null;
        }
        String str5 = iconFileName;
        ILableBubble lableBubble = getLableBubble(i4);
        if (lableBubble instanceof MultiRouteLableBubble) {
            if (split.length > 2) {
                str4 = str4 + split[2];
            }
            return ((MultiRouteLableBubble) lableBubble).getMarkerBitmap(this.context, str4, i, str2, str5, false, i3, this.naviMapMode == 2, this.isNight);
        } else if (!(lableBubble instanceof DynamicRouteLableBubble)) {
            return lableBubble.getMarkerBitmap(this.context, str4, i, str2, str5, false, i3);
        } else {
            if (split.length > 2) {
                str4 = str4 + split[2];
            }
            return ((DynamicRouteLableBubble) lableBubble).getMarkerBitmap(this.context, str4, i, str2, str5, false, i3, this.naviMapMode == 2, this.isNight);
        }
    }

    /* access modifiers changed from: protected */
    public String getIconFileName(int i, String str) {
        return getLableBubble(i).getIconFileName(this.isNight, str);
    }

    public static void addOtherMarker(Marker marker) {
        if (marker != null && marker.getOptions().isCollideRouteLableBubble()) {
            otherMarkers.add(marker);
        }
    }

    public static void removeOtherMarker(Marker marker) {
        otherMarkers.remove(marker);
    }

    public void clearRefeshData() {
        this.multiBubbleDatas.clear();
    }
}
