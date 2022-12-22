package com.didi.map.alpha.maps.internal;

import android.graphics.Rect;
import android.os.Message;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import com.didi.map.base.bubble.BlockBubbleBitmapLoader;
import com.didi.map.base.bubble.BlockBubbleSetting;
import com.didi.map.base.bubble.BlueBubbleBitmapLoader;
import com.didi.map.base.bubble.BlueBubbleBitmapOpt;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.base.bubble.BubbleManager;
import com.didi.map.base.bubble.DynamicBubbleBitmapLoader;
import com.didi.map.base.bubble.DynamicBubbleBitmapOpt;
import com.didi.map.base.bubble.GrayBubbleBitmapLoader;
import com.didi.map.base.bubble.GrayBubbleBitmapOpt;
import com.didi.map.base.bubble.IllegalParkBubbleBitmapLoader;
import com.didi.map.base.bubble.IllegalParkBubbleBitmapOpt;
import com.didi.map.base.bubble.MultiBubbleBitmapLoader;
import com.didi.map.base.bubble.MultiBubbleBitmapOpt;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LableMarkerManager_v3 extends LableMarkerManager {
    private static final int BUBBLE_ZINDEX = 10;
    private Bubble blockBubble;
    private BlockBubbleBitmapLoader blockBubbleBitmapLoader;
    private final BlockBubbleManager blockBubbleManager;
    private BlueBubbleBitmapLoader blueBubbleBitmapLoader;
    private final BubbleManager bubbleManager;
    private Map<String, Bubble> bubbles = new HashMap();
    private DidiMap.OnCameraChangeListener cameraChangeListener = new DidiMap.OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            LableMarkerManager_v3 lableMarkerManager_v3 = LableMarkerManager_v3.this;
            boolean z = true;
            lableMarkerManager_v3.setBlockBubbleVisible(lableMarkerManager_v3.isLableMarkerVisibleForMapScaleChanged(5) && LableMarkerManager_v3.this.bubblesSwitch.congestRoadBubbleVisible);
            LableMarkerManager_v3 lableMarkerManager_v32 = LableMarkerManager_v3.this;
            if (!lableMarkerManager_v32.isLableMarkerVisibleForMapScaleChanged(4) || !LableMarkerManager_v3.this.bubblesSwitch.isMultiBubbleVisible()) {
                z = false;
            }
            lableMarkerManager_v32.setMulitBubbleVisible(z);
        }
    };
    private DynamicBubbleBitmapLoader dynamicBubbleBitmapLoader;
    private GrayBubbleBitmapLoader grayBubbleBitmapLoader;
    private Bubble illegalParkBubble;
    private BaseBubbleBitmapLoader mIllegalParkBubbleBitmapLoad;
    private HashMap<Long, Bubble> multiBubble = new HashMap<>();
    private MultiBubbleBitmapLoader multiBubbleBitmapLoader;

    public LableMarkerManager_v3(DidiMap didiMap) {
        super(didiMap);
        DidiMapExt didiMapExt = (DidiMapExt) didiMap;
        didiMapExt.addOnCameraChangeListener(this.cameraChangeListener);
        this.bubbleManager = didiMapExt.getBubbleManager();
        this.blueBubbleBitmapLoader = new BlueBubbleBitmapLoader(this.context, this.blueLableBubble);
        this.grayBubbleBitmapLoader = new GrayBubbleBitmapLoader(this.context, this.grayLableBubble);
        this.multiBubbleBitmapLoader = new MultiBubbleBitmapLoader(this.context, this.multiRouteLableBubble);
        this.multiBubbleBitmapLoader = new MultiBubbleBitmapLoader(this.context, this.multiRouteLableBubble);
        this.dynamicBubbleBitmapLoader = new DynamicBubbleBitmapLoader(this.context, this.dynamicRouteLableBubble);
        this.blockBubbleBitmapLoader = new BlockBubbleBitmapLoader(this.context, this.blockRouteLableBubble);
        this.mIllegalParkBubbleBitmapLoad = new IllegalParkBubbleBitmapLoader(this.context, this.illegalParkLableBubble);
        this.bubbleManager.registerBitmapLoader(GrayBubbleBitmapLoader.TAG, this.grayBubbleBitmapLoader);
        this.bubbleManager.registerBitmapLoader(BlueBubbleBitmapLoader.TAG, this.blueBubbleBitmapLoader);
        this.bubbleManager.registerBitmapLoader(MultiBubbleBitmapLoader.TAG, this.multiBubbleBitmapLoader);
        this.bubbleManager.registerBitmapLoader(DynamicBubbleBitmapLoader.TAG, this.dynamicBubbleBitmapLoader);
        this.bubbleManager.registerBitmapLoader(BlockBubbleBitmapLoader.TAG, this.blockBubbleBitmapLoader);
        this.bubbleManager.registerBitmapLoader(IllegalParkBubbleBitmapLoader.TAG, this.mIllegalParkBubbleBitmapLoad);
        this.blockBubbleManager = new BlockBubbleManager(this, this.blockRouteLableBubble);
    }

    public void processMarker(List<TextLableOnRoute> list) {
        if (!this.visible || list == null || list.size() == 0) {
            clearMarker();
            removeBockBubble();
            removeIllegalParkBubble();
            return;
        }
        if (this.bubblesSwitch == null || !this.bubblesSwitch.illegalParkVisible) {
            removeIllegalParkBubble();
        } else {
            handleIllegalParkBubble(list);
        }
        handleBubbleData(list);
    }

    /* access modifiers changed from: package-private */
    public BubbleManager getBubbleManager() {
        return this.bubbleManager;
    }

    public LatLng getPosition(TextLableOnRoute textLableOnRoute) {
        return new LatLng(textLableOnRoute.position.f24754y, textLableOnRoute.position.f24753x);
    }

    private void handleBubbleData(List<TextLableOnRoute> list) {
        if (list.size() <= 0) {
            clearBubblesInMap();
            return;
        }
        initData(list);
        trimBubbles(list);
        handleBubbles(list);
    }

    private void handleBubbles(List<TextLableOnRoute> list) {
        for (TextLableOnRoute next : list) {
            String str = next.name;
            if (!isInBlackList(next)) {
                if (this.bubbles.containsKey(str)) {
                    LatLng position = getPosition(next);
                    Bubble bubble = this.bubbles.get(str);
                    if ((next.type == 1 || next.type == 0) && next.name.split(";")[0].equals(this.curRouteName)) {
                        this.bubbleManager.removeBubble(bubble.getId());
                        this.bubbles.remove(str);
                        return;
                    }
                    if (!(bubble.getLatitude() == position.latitude && bubble.getLongitude() == position.longitude)) {
                        bubble.position(position);
                    }
                    if (!isLableMarkerVisibleForMapScaleChanged(next.type)) {
                        if (bubble.isVisible()) {
                            bubble.setVisible(false);
                        }
                    } else if (!bubble.isVisible()) {
                        bubble.setVisible(true);
                    }
                } else {
                    createBubble(next);
                }
            }
        }
    }

    private void trimBubbles(List<TextLableOnRoute> list) {
        Iterator<Map.Entry<String, Bubble>> it = this.bubbles.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            String str = (String) next.getKey();
            Bubble bubble = (Bubble) next.getValue();
            if (bubble != null) {
                boolean z = false;
                Iterator<TextLableOnRoute> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    TextLableOnRoute next2 = it2.next();
                    if (next2.name.equalsIgnoreCase(str) && !isInBlackList(next2)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.bubbleManager.removeBubble(bubble.getId());
                    it.remove();
                }
            }
        }
    }

    private void initData(List<TextLableOnRoute> list) {
        for (TextLableOnRoute next : list) {
            next.name += ";" + next.routeID + ";," + next.diffDistance + "," + next.diffTrafficLights + "," + next.type;
        }
    }

    private boolean isInBlackList(TextLableOnRoute textLableOnRoute) {
        String str = textLableOnRoute.name;
        if (textLableOnRoute.type != 1) {
            return false;
        }
        if (str.contains(this.curRouteName) || str.contains("匝道")) {
            return true;
        }
        return false;
    }

    private void createBubble(TextLableOnRoute textLableOnRoute) {
        if (isLableMarkerVisibleForMapScaleChanged(textLableOnRoute.type)) {
            Bubble bubble = null;
            if (textLableOnRoute.type == 1 && this.bubblesSwitch.mainRouteBubbleVisible) {
                bubble = addBlueRoadBubble(textLableOnRoute);
            } else if (textLableOnRoute.type == 2 && this.bubblesSwitch.otherRouteBubbleVisible) {
                bubble = addGrayRoadBubble(textLableOnRoute);
            } else if (textLableOnRoute.type == 0 && this.bubblesSwitch.currentRouteBubbleVisible) {
                bubble = addBlueRoadBubble(textLableOnRoute);
            } else if (textLableOnRoute.type == 4 && this.bubblesSwitch.isMultiBubbleVisible()) {
                bubble = addMuitlRouteBubble(textLableOnRoute);
            } else if (textLableOnRoute.type == 3 && this.bubblesSwitch.congestRoadBubbleVisible) {
                bubble = addDynamicRouteBubble(textLableOnRoute);
            }
            if (bubble != null) {
                this.bubbles.put(textLableOnRoute.name, bubble);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void refeshMultiRouteBubble() {
        HWLog.m16761i("Lable_v3", "refeshMultiRouteBubble");
        clearMarker();
    }

    public void destroy() {
        if (this.didiMap != null) {
            ((DidiMapExt) this.didiMap).removeOnCameraChangedListener(this.cameraChangeListener);
        }
        super.destroy();
        this.blueBubbleBitmapLoader = null;
        this.grayBubbleBitmapLoader = null;
        this.multiBubbleBitmapLoader = null;
        this.dynamicBubbleBitmapLoader = null;
        this.blockBubbleBitmapLoader = null;
        this.mIllegalParkBubbleBitmapLoad = null;
    }

    public void setBubblesSwitch(LableMarkerManager.BubblesSwitch bubblesSwitch) {
        if (bubblesSwitch != null) {
            this.bubblesSwitch = bubblesSwitch;
            setBlockBubbleVisible(bubblesSwitch.congestRoadBubbleVisible);
            setMulitBubbleVisible(bubblesSwitch.isMultiBubbleVisible());
        }
    }

    public LableMarkerManager.BubblesSwitch getBubbleSwitch() {
        return this.bubblesSwitch;
    }

    public void setDayNight(boolean z) {
        super.setDayNight(z);
        refreshMultiBubbleStyle();
    }

    public void setVisible(boolean z) {
        super.setVisible(z);
        setMulitBubbleVisible(this.bubblesSwitch.isMultiBubbleVisible() && z);
    }

    public void setNaviMapMode(int i) {
        if (this.naviMapMode != i) {
            this.naviMapMode = i;
            Message obtainMessage = this.handlerUi.obtainMessage();
            obtainMessage.what = 1005;
            this.handlerUi.sendMessage(obtainMessage);
            refreshMultiBubbleStyle();
        }
    }

    public void refeshMultiBubbleEta(long j, TextLableOnRoute textLableOnRoute) {
        this.multiBubbleDatas.put(Long.valueOf(j), textLableOnRoute);
        for (Map.Entry<String, Bubble> value : this.bubbles.entrySet()) {
            Bubble bubble = (Bubble) value.getValue();
            if (bubble != null && bubble.getRouteId() == j) {
                if (textLableOnRoute.type == 1) {
                    getDynamicBubble(bubble, textLableOnRoute);
                } else {
                    getMultiBubble(bubble, textLableOnRoute);
                }
                this.bubbleManager.updateBubble(bubble);
            }
        }
        refreshMultiBubble(j, textLableOnRoute);
    }

    public void clearMarker() {
        super.clearMarker();
        clearBubblesInMap();
        removeIllegalParkBubble();
    }

    private void clearBubblesInMap() {
        if (this.bubbles.size() > 0) {
            Iterator<Map.Entry<String, Bubble>> it = this.bubbles.entrySet().iterator();
            while (it.hasNext()) {
                this.bubbleManager.removeBubble(((Bubble) it.next().getValue()).getId());
                it.remove();
            }
        }
    }

    private void removeBockBubble() {
        if (this.blockBubble != null) {
            HWLog.m16761i("hw", "removeBockBubble" + this.blockBubble.getId());
            this.bubbleManager.removeBubble(this.blockBubble.getId());
            this.blockBubble = null;
        }
    }

    private TextLableOnRoute findFitTextLable(List<TextLableOnRoute> list, int i, boolean z) {
        Iterator<TextLableOnRoute> it = list.iterator();
        while (it.hasNext()) {
            TextLableOnRoute next = it.next();
            if (next.type == i) {
                if (!z) {
                    return next;
                }
                it.remove();
                return next;
            }
        }
        return null;
    }

    private void removeIllegalParkBubble() {
        if (this.illegalParkBubble != null) {
            HWLog.m16761i("hw", "IllegalPark--Bubble--remove:" + this.illegalParkBubble.getId());
            this.bubbleManager.removeBubble(this.illegalParkBubble.getId());
            this.illegalParkBubble = null;
        }
    }

    private void handleIllegalParkBubble(List<TextLableOnRoute> list) {
        if (!this.visible) {
            removeIllegalParkBubble();
            return;
        }
        TextLableOnRoute findFitTextLable = findFitTextLable(list, 6, true);
        if (findFitTextLable == null) {
            removeIllegalParkBubble();
            return;
        }
        boolean isLableMarkerVisibleForMapScaleChanged = super.isLableMarkerVisibleForMapScaleChanged(findFitTextLable.type);
        Bubble bubble = this.illegalParkBubble;
        if (bubble == null) {
            if (isLableMarkerVisibleForMapScaleChanged) {
                this.illegalParkBubble = addIllegalParkBubble(findFitTextLable);
            }
        } else if (bubble.isVisible() != isLableMarkerVisibleForMapScaleChanged) {
            this.illegalParkBubble.setVisible(isLableMarkerVisibleForMapScaleChanged);
        }
        Bubble bubble2 = this.illegalParkBubble;
        if (bubble2 != null && bubble2.isVisible()) {
            LatLng position = getPosition(findFitTextLable);
            if (this.illegalParkBubble.getLatitude() != position.latitude || this.illegalParkBubble.getLongitude() != position.longitude) {
                this.illegalParkBubble.position(position);
            }
        }
    }

    private Bubble addIllegalParkBubble(TextLableOnRoute textLableOnRoute) {
        LatLng latLng = new LatLng(textLableOnRoute.position.f24754y, textLableOnRoute.position.f24753x);
        Bubble bubble = new Bubble(new MarkerOptions(latLng));
        bubble.position(latLng);
        bubble.setzIndex(18);
        bubble.setType(64);
        bubble.setCollisionType(BubbleManager.getCollisionType(64));
        bubble.setPriority(501);
        bubble.setInnerType(textLableOnRoute.type);
        int[] bitmapWh = this.illegalParkLableBubble.getBitmapWh(this.context, "", 0, this.illegalParkLableBubble.getMarkerFileName(this.isNight, "", 1), 0);
        bubble.addOverlayRect(getIllegalParkBubbleRect(bubble, bitmapWh[0], bitmapWh[1], "", 1));
        this.bubbleManager.addBubble(bubble);
        HWLog.m16761i("hw", "IllegalPark--Bubble--addIllegalParkBubble--: " + bubble.getId() + " params:" + textLableOnRoute.toString());
        return bubble;
    }

    public boolean isBlockBubbleExist() {
        return this.blockBubbleManager.mo72055b();
    }

    public void addBlockBubble(BlockBubbleSetting blockBubbleSetting) {
        this.blockBubbleManager.mo72052a(blockBubbleSetting);
    }

    public void updateBlockBubble(BlockBubbleSetting blockBubbleSetting) {
        this.blockBubbleManager.mo72054b(blockBubbleSetting);
    }

    public void removeBlockBubble() {
        this.blockBubbleManager.mo72051a();
    }

    /* access modifiers changed from: private */
    public void setBlockBubbleVisible(boolean z) {
        this.blockBubbleManager.mo72053a(z);
    }

    /* access modifiers changed from: private */
    public void setMulitBubbleVisible(boolean z) {
        for (Map.Entry next : this.multiBubble.entrySet()) {
            boolean z2 = this.bubblesSwitch.isMultiBubbleVisible() && TextLableOnRoute.isDataValid((TextLableOnRoute) this.labelCache.get(next.getKey())) && z;
            if (((Bubble) next.getValue()).isVisible() != z2) {
                ((Bubble) next.getValue()).setVisible(z2);
            } else {
                return;
            }
        }
    }

    private void refreshMultiBubbleStyle() {
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<Long, Bubble>> it = this.multiBubble.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            hashMap.put((Long) next.getKey(), (Bubble) next.getValue());
            this.bubbleManager.removeBubble(((Bubble) next.getValue()).getId());
            it.remove();
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            Bubble bubble = (Bubble) entry.getValue();
            TextLableOnRoute textLableOnRoute = (TextLableOnRoute) this.labelCache.get(entry.getKey());
            if (textLableOnRoute == null) {
                HWLog.m16761i("MultiBubble", "textLableOnRoute in labelCache is null");
                textLableOnRoute = new TextLableOnRoute();
                textLableOnRoute.name = bubble.getShowInfo();
                textLableOnRoute.name += ";" + textLableOnRoute.routeID + ";," + textLableOnRoute.diffDistance + "," + textLableOnRoute.diffTrafficLights + "," + textLableOnRoute.type;
            }
            textLableOnRoute.routeID = bubble.getRouteId();
            textLableOnRoute.type = bubble.getInnerType();
            LatLng position = bubble.getMarkerOptions().getPosition();
            textLableOnRoute.position.f24753x = position.longitude;
            textLableOnRoute.position.f24754y = position.latitude;
            addMultiBubble(textLableOnRoute, bubble.getPointArea(), textLableOnRoute.type == 4);
        }
    }

    public void addMultiBubble(final TextLableOnRoute textLableOnRoute, Bubble.PointArea pointArea, boolean z) {
        HWLog.m16761i("multiBubble", "add multibubble-" + textLableOnRoute.name + ",routeid-" + textLableOnRoute.routeID + ",isMulti = " + z);
        boolean z2 = true;
        if (z) {
            Bubble multiBubble2 = getMultiBubble((Bubble) null, textLableOnRoute);
            multiBubble2.setPointArea(pointArea);
            this.bubbleManager.addBubble(multiBubble2);
            if (!TextLableOnRoute.isDataValid(textLableOnRoute) || !this.bubblesSwitch.isMultiBubbleVisible()) {
                z2 = false;
            }
            multiBubble2.setVisible(z2);
            multiBubble2.setOnClickListener(new DidiMap.OnMarkerClickListener() {
                public boolean onMarkerClick(Marker marker) {
                    if (LableMarkerManager_v3.this.onSelectMapRouteIdListener == null) {
                        return true;
                    }
                    LableMarkerManager_v3.this.onSelectMapRouteIdListener.selectRouteId(textLableOnRoute.routeID);
                    return true;
                }
            });
            this.multiBubble.put(Long.valueOf(textLableOnRoute.routeID), multiBubble2);
            this.labelCache.put(Long.valueOf(textLableOnRoute.routeID), textLableOnRoute);
            return;
        }
        Bubble dynamicBubble = getDynamicBubble((Bubble) null, textLableOnRoute);
        dynamicBubble.setPointArea(pointArea);
        this.bubbleManager.addBubble(dynamicBubble);
        if (!TextLableOnRoute.isDataValid(textLableOnRoute) || !this.bubblesSwitch.avoidCongestionBubbleVisible) {
            z2 = false;
        }
        dynamicBubble.setVisible(z2);
        dynamicBubble.setOnClickListener(new DidiMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                if (LableMarkerManager_v3.this.onSelectMapRouteIdListener == null) {
                    return true;
                }
                LableMarkerManager_v3.this.onSelectMapRouteIdListener.selectRouteId(textLableOnRoute.routeID);
                return true;
            }
        });
        this.multiBubble.put(Long.valueOf(textLableOnRoute.routeID), dynamicBubble);
        this.labelCache.put(Long.valueOf(textLableOnRoute.routeID), textLableOnRoute);
    }

    public void removeMultiBubble(long j) {
        HWLog.m16761i("multiBubble", "remove multibubble-" + j);
        Bubble bubble = this.multiBubble.get(Long.valueOf(j));
        if (bubble != null) {
            this.bubbleManager.removeBubble(bubble.getId());
            this.multiBubble.remove(Long.valueOf(j));
            this.labelCache.remove(Long.valueOf(j));
        }
    }

    public void removeAllMultiBubble() {
        HWLog.m16761i("multiBubble", "remove all");
        Iterator<Map.Entry<Long, Bubble>> it = this.multiBubble.entrySet().iterator();
        while (it.hasNext()) {
            this.bubbleManager.removeBubble(((Bubble) it.next().getValue()).getId());
            it.remove();
        }
        this.labelCache.clear();
    }

    public void clearBubble4StopNavi() {
        removeBlockBubble();
        removeAllMultiBubble();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005c, code lost:
        if (r3.bubblesSwitch.isMultiBubbleVisible() != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004d, code lost:
        if (r3.bubblesSwitch.avoidCongestionBubbleVisible != false) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void refreshMultiBubble(long r4, com.didi.map.base.TextLableOnRoute r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "refresh multibubble-"
            r0.append(r1)
            java.lang.String r1 = r6.name
            r0.append(r1)
            java.lang.String r1 = ",routeid-"
            r0.append(r1)
            long r1 = r6.routeID
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "multiBubble"
            com.didi.hawaii.log.HWLog.m16761i(r1, r0)
            java.util.HashMap<java.lang.Long, com.didi.map.base.bubble.Bubble> r0 = r3.multiBubble
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            java.lang.Object r0 = r0.get(r1)
            com.didi.map.base.bubble.Bubble r0 = (com.didi.map.base.bubble.Bubble) r0
            java.util.Map r1 = r3.labelCache
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.put(r4, r6)
            if (r0 == 0) goto L_0x0067
            boolean r4 = com.didi.map.base.TextLableOnRoute.isDataValid(r6)
            int r5 = r6.type
            r1 = 0
            r2 = 1
            if (r5 != r2) goto L_0x0051
            r3.getDynamicBubble(r0, r6)
            if (r4 == 0) goto L_0x005f
            com.didi.map.alpha.maps.internal.LableMarkerManager$BubblesSwitch r4 = r3.bubblesSwitch
            boolean r4 = r4.avoidCongestionBubbleVisible
            if (r4 == 0) goto L_0x005f
        L_0x004f:
            r1 = 1
            goto L_0x005f
        L_0x0051:
            r3.getMultiBubble(r0, r6)
            if (r4 == 0) goto L_0x005f
            com.didi.map.alpha.maps.internal.LableMarkerManager$BubblesSwitch r4 = r3.bubblesSwitch
            boolean r4 = r4.isMultiBubbleVisible()
            if (r4 == 0) goto L_0x005f
            goto L_0x004f
        L_0x005f:
            r0.setVisible(r1)
            com.didi.map.base.bubble.BubbleManager r4 = r3.bubbleManager
            r4.updateBubble(r0)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.alpha.maps.internal.LableMarkerManager_v3.refreshMultiBubble(long, com.didi.map.base.TextLableOnRoute):void");
    }

    private Bubble.OverlayRect getIllegalParkBubbleRect(Bubble bubble, int i, int i2, String str, int i3) {
        String markerFileName = this.illegalParkLableBubble.getMarkerFileName(this.isNight, str, i3);
        HWLog.m16761i("hw", "getIllegalParkBubbleRect--blockBubble--width: " + i + " text:" + str + " height:" + i2 + " fileName:" + markerFileName);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(markerFileName);
        IllegalParkBubbleBitmapOpt illegalParkBubbleBitmapOpt = new IllegalParkBubbleBitmapOpt(IllegalParkBubbleBitmapLoader.TAG, bubble.getId(), str);
        illegalParkBubbleBitmapOpt.setNight(this.isNight);
        illegalParkBubbleBitmapOpt.setFileNams(arrayList);
        float f = i3 == 1 ? 0.0f : i3 == 2 ? 1.0f : 0.5f;
        Bubble.OverlayRect overlayRect = new Bubble.OverlayRect(bubble.getId());
        overlayRect.anchorX = f;
        overlayRect.anchorY = 1.0f;
        overlayRect.width = i;
        overlayRect.height = i2;
        overlayRect.resourcePaths = illegalParkBubbleBitmapOpt;
        return overlayRect;
    }

    private Bubble getDynamicBubble(Bubble bubble, TextLableOnRoute textLableOnRoute) {
        Bubble bubble2;
        String str;
        TextLableOnRoute textLableOnRoute2 = textLableOnRoute;
        if (bubble == null) {
            LatLng latLng = new LatLng(textLableOnRoute2.position.f24754y, textLableOnRoute2.position.f24753x);
            Bubble bubble3 = new Bubble(new MarkerOptions(latLng));
            bubble3.position(latLng);
            bubble3.setzIndex(14);
            bubble3.setType(32);
            bubble3.setRouteId(textLableOnRoute2.routeID);
            bubble2 = bubble3;
        } else {
            bubble2 = bubble;
        }
        bubble2.setCollisionType(BubbleManager.getCollisionType(32));
        bubble2.setPriority(301);
        bubble2.setInnerType(textLableOnRoute2.type);
        String[] split = textLableOnRoute2.name.split(";");
        String str2 = split[0];
        bubble2.setShowInfo(str2);
        String markerFileName = this.dynamicRouteLableBubble.getMarkerFileName(this.isNight, str2, 1);
        if (split.length > 2) {
            str = str2 + split[2];
        } else {
            str = str2;
        }
        int[] bitmapWh = this.dynamicRouteLableBubble.getBitmapWh(this.context, str, textLableOnRoute2.lable, markerFileName, "", false, 0, this.naviMapMode == 2, this.isNight);
        int i = bitmapWh[0];
        int i2 = bitmapWh[1];
        bubble2.clearOverlayRect();
        Bubble bubble4 = bubble2;
        int i3 = i;
        int i4 = i2;
        String str3 = str;
        bubble2.addOverlayRect(getDynamicBubbleRect(bubble4, i3, i4, str3, 1, false));
        bubble2.addOverlayRect(getDynamicBubbleRect(bubble4, i3, i4, str3, 2, false));
        bubble2.setAnimatiomSetting(0, 400, 0);
        return bubble2;
    }

    private Bubble addDynamicRouteBubble(final TextLableOnRoute textLableOnRoute) {
        Bubble dynamicBubble = getDynamicBubble((Bubble) null, textLableOnRoute);
        dynamicBubble.setVisible(TextLableOnRoute.isDataValid(textLableOnRoute) && this.bubblesSwitch.avoidCongestionBubbleVisible);
        this.bubbleManager.addBubble(dynamicBubble);
        dynamicBubble.setOnClickListener(new DidiMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                if (LableMarkerManager_v3.this.onSelectMapRouteIdListener == null) {
                    return true;
                }
                LableMarkerManager_v3.this.onSelectMapRouteIdListener.selectRouteId(textLableOnRoute.routeID);
                return true;
            }
        });
        return dynamicBubble;
    }

    private Bubble.OverlayRect getDynamicBubbleRect(Bubble bubble, int i, int i2, String str, int i3, boolean z) {
        Bubble.OverlayRect overlayRect = new Bubble.OverlayRect(bubble.getId());
        DynamicBubbleBitmapOpt dynamicBubbleBitmapOpt = new DynamicBubbleBitmapOpt(DynamicBubbleBitmapLoader.TAG, bubble.getId(), str);
        dynamicBubbleBitmapOpt.setShowIcon(z);
        String markerFileName = this.dynamicRouteLableBubble.getMarkerFileName(this.isNight, str, i3);
        dynamicBubbleBitmapOpt.setNight(this.isNight);
        dynamicBubbleBitmapOpt.set2Dfullbrowser(this.naviMapMode == 2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(markerFileName);
        dynamicBubbleBitmapOpt.setFileNams(arrayList);
        dynamicBubbleBitmapOpt.setNight(this.isNight);
        float f = 0.5f;
        if (i3 == 1) {
            f = 0.0f;
        } else if (i3 == 2) {
            f = 1.0f;
        }
        overlayRect.anchorX = f;
        overlayRect.anchorY = 1.0f;
        overlayRect.width = i;
        overlayRect.height = i2;
        overlayRect.resourcePaths = dynamicBubbleBitmapOpt;
        return overlayRect;
    }

    private Bubble addMuitlRouteBubble(final TextLableOnRoute textLableOnRoute) {
        TextLableOnRoute textLableOnRoute2;
        if (this.multiBubbleDatas.containsKey(Long.valueOf(textLableOnRoute.routeID))) {
            ((TextLableOnRoute) this.multiBubbleDatas.get(Long.valueOf(textLableOnRoute.routeID))).position.f24753x = textLableOnRoute.position.f24753x;
            ((TextLableOnRoute) this.multiBubbleDatas.get(Long.valueOf(textLableOnRoute.routeID))).position.f24754y = textLableOnRoute.position.f24754y;
            ((TextLableOnRoute) this.multiBubbleDatas.get(Long.valueOf(textLableOnRoute.routeID))).type = textLableOnRoute.type;
            textLableOnRoute2 = (TextLableOnRoute) this.multiBubbleDatas.get(Long.valueOf(textLableOnRoute.routeID));
        } else {
            textLableOnRoute2 = textLableOnRoute;
        }
        Bubble multiBubble2 = getMultiBubble((Bubble) null, textLableOnRoute2);
        multiBubble2.setVisible(TextLableOnRoute.isDataValid(textLableOnRoute2) && this.bubblesSwitch.muitlRouteBubbleVisible);
        this.bubbleManager.addBubble(multiBubble2);
        multiBubble2.setOnClickListener(new DidiMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                if (LableMarkerManager_v3.this.onSelectMapRouteIdListener == null) {
                    return true;
                }
                LableMarkerManager_v3.this.onSelectMapRouteIdListener.selectRouteId(textLableOnRoute.routeID);
                return true;
            }
        });
        return multiBubble2;
    }

    private Bubble getMultiBubble(Bubble bubble, TextLableOnRoute textLableOnRoute) {
        Bubble bubble2;
        String str;
        TextLableOnRoute textLableOnRoute2 = textLableOnRoute;
        if (bubble == null) {
            LatLng latLng = new LatLng(textLableOnRoute2.position.f24754y, textLableOnRoute2.position.f24753x);
            Bubble bubble3 = new Bubble(new MarkerOptions(latLng));
            bubble3.position(latLng);
            bubble3.setInnerType(textLableOnRoute2.type);
            bubble3.setRouteId(textLableOnRoute2.routeID);
            bubble2 = bubble3;
        } else {
            bubble2 = bubble;
        }
        bubble2.setzIndex(14);
        bubble2.setType(32);
        bubble2.setCollisionType(BubbleManager.getCollisionType(32));
        bubble2.setPriority(300);
        String[] split = textLableOnRoute2.name.split(";");
        String str2 = split[0];
        bubble2.setShowInfo(str2);
        String markerFileName = this.multiRouteLableBubble.getMarkerFileName(this.isNight, str2, 1);
        if (split.length > 2) {
            str = str2 + split[2];
        } else {
            str = str2;
        }
        boolean z = this.naviMapMode == 2;
        int[] bitmapWh = this.multiRouteLableBubble.getBitmapWh(this.context, str, textLableOnRoute2.lable, markerFileName, "", false, 0, z, this.isNight);
        int i = bitmapWh[0];
        int i2 = bitmapWh[1];
        bubble2.clearOverlayRect();
        Bubble bubble4 = bubble2;
        int i3 = i;
        int i4 = i2;
        String str3 = str;
        boolean z2 = z;
        bubble2.addOverlayRect(getMuitlBubbleRect(bubble4, i3, i4, str3, 1, false, z2));
        bubble2.addOverlayRect(getMuitlBubbleRect(bubble4, i3, i4, str3, 2, false, z2));
        bubble2.addOverlayRect(getMuitlBubbleRect(bubble4, i3, i4, str3, 4, false, z2));
        bubble2.addOverlayRect(getMuitlBubbleRect(bubble4, i3, i4, str3, 3, false, z2));
        bubble2.setAnimatiomSetting(0, 400, 0);
        return bubble2;
    }

    private Bubble.OverlayRect getMuitlBubbleRect(Bubble bubble, int i, int i2, String str, int i3, boolean z, boolean z2) {
        Bubble.OverlayRect overlayRect = new Bubble.OverlayRect(bubble.getId());
        MultiBubbleBitmapOpt multiBubbleBitmapOpt = new MultiBubbleBitmapOpt(MultiBubbleBitmapLoader.TAG, bubble.getId(), str);
        multiBubbleBitmapOpt.setShowIcon(z);
        multiBubbleBitmapOpt.setNight(this.isNight);
        multiBubbleBitmapOpt.set2Dfullbrowser(z2);
        String markerFileName = this.multiRouteLableBubble.getMarkerFileName(this.isNight, str, i3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(markerFileName);
        multiBubbleBitmapOpt.setFileNams(arrayList);
        float f = 0.0f;
        float f2 = 1.0f;
        if (i3 == 1) {
            overlayRect.paddingCollision = new Rect(DisplayUtils.dip2px(this.context, 10.5f), 0, 0, DisplayUtils.dip2px(this.context, 10.5f));
        } else if (i3 == 2) {
            overlayRect.paddingCollision = new Rect(0, 0, DisplayUtils.dip2px(this.context, 6.0f), DisplayUtils.dip2px(this.context, 6.0f));
            f = 1.0f;
        } else {
            if (i3 == 3) {
                overlayRect.paddingCollision = new Rect(0, DisplayUtils.dip2px(this.context, 6.0f), DisplayUtils.dip2px(this.context, 6.0f), 0);
                f = 1.0f;
            } else if (i3 == 4) {
                overlayRect.paddingCollision = new Rect(DisplayUtils.dip2px(this.context, 6.0f), DisplayUtils.dip2px(this.context, 6.0f), 0, 0);
            } else {
                f = 0.5f;
            }
            f2 = 0.0f;
        }
        overlayRect.anchorX = f;
        overlayRect.anchorY = f2;
        overlayRect.width = i;
        overlayRect.height = i2;
        overlayRect.resourcePaths = multiBubbleBitmapOpt;
        return overlayRect;
    }

    private Bubble addGrayRoadBubble(TextLableOnRoute textLableOnRoute) {
        int i;
        int i2;
        LatLng latLng = new LatLng(textLableOnRoute.position.f24754y, textLableOnRoute.position.f24753x);
        Bubble bubble = new Bubble(new MarkerOptions(latLng));
        bubble.position(latLng);
        bubble.setzIndex(10);
        int i3 = 8;
        bubble.setType(8);
        bubble.setCollisionType(BubbleManager.getCollisionType(8));
        bubble.setInnerType(textLableOnRoute.type);
        bubble.setPriority(0);
        int dip2px = (int) SystemUtil.dip2px(this.context, 7.0f);
        if (BitmapUtil.fDensityXH >= 1.0f) {
            i2 = 19;
            i = 8;
        } else {
            i3 = 14;
            i2 = 31;
            i = 11;
        }
        String str = textLableOnRoute.name.split(";")[0];
        bubble.setShowInfo(str);
        float[] calculateTextWidthAndHeight = this.grayBubbleBitmapLoader.calculateTextWidthAndHeight(str, 18);
        bubble.addOverlayRect(getGrayBubbleRect(bubble, ((int) calculateTextWidthAndHeight[0]) + dip2px + dip2px, i3 + ((int) calculateTextWidthAndHeight[1]) + i + i2, str, 0));
        this.bubbleManager.addBubble(bubble);
        return bubble;
    }

    private Bubble.OverlayRect getGrayBubbleRect(Bubble bubble, int i, int i2, String str, int i3) {
        Bubble.OverlayRect overlayRect = new Bubble.OverlayRect(bubble.getId());
        GrayBubbleBitmapOpt grayBubbleBitmapOpt = new GrayBubbleBitmapOpt(bubble.getId(), GrayBubbleBitmapLoader.TAG, str);
        String markerFileName = this.grayLableBubble.getMarkerFileName(this.isNight, str, i3);
        grayBubbleBitmapOpt.setNight(this.isNight);
        ArrayList arrayList = new ArrayList();
        arrayList.add(markerFileName);
        grayBubbleBitmapOpt.setFileNams(arrayList);
        overlayRect.anchorX = i3 == 1 ? 0.0f : i3 == 2 ? 1.0f : 0.5f;
        overlayRect.anchorY = 1.0f;
        overlayRect.width = i;
        overlayRect.height = i2;
        overlayRect.resourcePaths = grayBubbleBitmapOpt;
        return overlayRect;
    }

    private Bubble addBlueRoadBubble(TextLableOnRoute textLableOnRoute) {
        int i;
        int i2;
        LatLng latLng = new LatLng(textLableOnRoute.position.f24754y, textLableOnRoute.position.f24753x);
        Bubble bubble = new Bubble(new MarkerOptions(latLng));
        bubble.position(latLng);
        int i3 = 14;
        bubble.setzIndex(14);
        bubble.setType(8);
        bubble.setCollisionType(BubbleManager.getCollisionType(8));
        bubble.setPriority(1);
        bubble.setInnerType(textLableOnRoute.type);
        int dip2px = (int) SystemUtil.dip2px(this.context, 7.0f);
        if (BitmapUtil.fDensityXH >= 1.0f) {
            i3 = 8;
            i2 = 19;
            i = 8;
        } else {
            i2 = 31;
            i = 11;
        }
        String str = textLableOnRoute.name.split(";")[0];
        if (str != null && str.equals(this.curRouteName)) {
            return null;
        }
        bubble.setShowInfo(str);
        float[] calculateTextWidthAndHeight = this.blueBubbleBitmapLoader.calculateTextWidthAndHeight(str, 18);
        int i4 = ((int) calculateTextWidthAndHeight[0]) + dip2px + dip2px;
        Bubble bubble2 = bubble;
        int i5 = i4;
        int i6 = i3 + ((int) calculateTextWidthAndHeight[1]) + i + i2;
        String str2 = str;
        bubble.addOverlayRect(getBuleBubbleRect(bubble2, i5, i6, str2, 1));
        bubble.addOverlayRect(getBuleBubbleRect(bubble2, i5, i6, str2, 2));
        bubble.addOverlayRect(getBuleBubbleRect(bubble2, i5, i6, str2, 0));
        bubble.setAnimatiomSetting(0, 400, 0);
        this.bubbleManager.addBubble(bubble);
        return bubble;
    }

    private Bubble.OverlayRect getBuleBubbleRect(Bubble bubble, int i, int i2, String str, int i3) {
        Bubble.OverlayRect overlayRect = new Bubble.OverlayRect(bubble.getId());
        BlueBubbleBitmapOpt blueBubbleBitmapOpt = new BlueBubbleBitmapOpt(bubble.getId(), BlueBubbleBitmapLoader.TAG, str);
        String markerFileName = this.blueLableBubble.getMarkerFileName(this.isNight, str, i3);
        blueBubbleBitmapOpt.setNight(this.isNight);
        ArrayList arrayList = new ArrayList();
        arrayList.add(markerFileName);
        blueBubbleBitmapOpt.setFileNams(arrayList);
        overlayRect.anchorX = i3 == 1 ? 0.0f : i3 == 2 ? 1.0f : 0.5f;
        overlayRect.anchorY = 1.0f;
        overlayRect.width = i;
        overlayRect.height = i2;
        overlayRect.resourcePaths = blueBubbleBitmapOpt;
        return overlayRect;
    }
}
