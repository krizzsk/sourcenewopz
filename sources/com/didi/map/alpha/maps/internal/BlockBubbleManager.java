package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Rect;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.base.bubble.BlockBubbleBitmapLoader;
import com.didi.map.base.bubble.BlockBubbleBitmapOpt;
import com.didi.map.base.bubble.BlockBubbleSetting;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.base.bubble.BubbleManager;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.core.element.ClickBlockBubbleParam;
import com.didi.map.core.element.MapTrafficIcon;
import com.didi.map.core.element.OnMapElementClickListener;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerOptions;
import java.util.ArrayList;

public class BlockBubbleManager {

    /* renamed from: a */
    private static final String f24468a = "BlockBubbleManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final LableMarkerManager_v3 f24469b;

    /* renamed from: c */
    private final BubbleManager f24470c;

    /* renamed from: d */
    private final BlockLableBubble f24471d;

    /* renamed from: e */
    private Bubble f24472e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BlockBubbleSetting f24473f = null;

    /* renamed from: a */
    private boolean m17487a(int i) {
        return i == 0 || i == 3 || i == 4 || i == 5;
    }

    public BlockBubbleManager(LableMarkerManager_v3 lableMarkerManager_v3, BlockLableBubble blockLableBubble) {
        this.f24469b = lableMarkerManager_v3;
        this.f24470c = lableMarkerManager_v3.getBubbleManager();
        this.f24471d = blockLableBubble;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72052a(BlockBubbleSetting blockBubbleSetting) {
        m17489c(blockBubbleSetting);
    }

    /* renamed from: c */
    private void m17489c(BlockBubbleSetting blockBubbleSetting) {
        this.f24473f = blockBubbleSetting;
        TextLableOnRoute textLableOnRoute = blockBubbleSetting.textLableOnRoute;
        Bubble.PointArea pointArea = blockBubbleSetting.pointArea;
        int i = blockBubbleSetting.trafficSectionType;
        mo72051a();
        LatLng e = m17491e(blockBubbleSetting);
        HWLog.m16761i(f24468a, "addBlockBubble latLng = " + e);
        Bubble bubble = new Bubble(new MarkerOptions(e));
        bubble.position(e);
        bubble.setzIndex(i == 1 ? 17 : 15);
        if (i == 1) {
            bubble.setNeedSelectBottomRect(true);
        }
        if (ApolloHawaii.USE_NEW_BLOCK_BUBBLE) {
            bubble.setType(8192);
            bubble.setCollisionType(BubbleManager.getCollisionType(8192));
        } else {
            bubble.setType(16);
            bubble.setCollisionType(BubbleManager.getCollisionType(16));
        }
        bubble.setPriority(400);
        bubble.setInnerType(textLableOnRoute.type);
        m17486a(bubble, blockBubbleSetting);
        if (m17487a(i) && pointArea != null) {
            bubble.setPointArea(pointArea);
        }
        this.f24470c.addBubble(bubble);
        if (i != 0) {
            m17485a(bubble);
        }
        boolean z = this.f24469b.bubblesSwitch.congestRoadBubbleVisible;
        bubble.setVisible(z);
        HWLog.m16761i(f24468a, "addBlockRouteBubble = " + bubble.getId() + ", currentBlockBubbleType = " + this.f24473f.trafficSectionType + ", visible = " + z);
        this.f24472e = bubble;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72054b(BlockBubbleSetting blockBubbleSetting) {
        m17490d(blockBubbleSetting);
    }

    /* renamed from: d */
    private void m17490d(BlockBubbleSetting blockBubbleSetting) {
        if (this.f24472e == null || this.f24473f == null) {
            HWLog.m16761i(f24468a, "cacheBlockBubble == null || currentBlockBubbleSetting == null");
        } else if (blockBubbleSetting.trafficSectionType != this.f24473f.trafficSectionType) {
            HWLog.m16761i(f24468a, "refresh bubble , because blockBubbleSetting is different.");
            mo72052a(blockBubbleSetting);
        } else {
            this.f24473f = blockBubbleSetting;
            int i = blockBubbleSetting.trafficSectionType;
            Bubble bubble = this.f24472e;
            HWLog.m16761i(f24468a, "updateBlockBubbleInternal  visible = " + this.f24469b.bubblesSwitch.congestRoadBubbleVisible);
            if (m17487a(blockBubbleSetting.trafficSectionType) && blockBubbleSetting.pointArea != null) {
                bubble.setPointArea(blockBubbleSetting.pointArea);
            }
            if (i == 1) {
                LatLng e = m17491e(blockBubbleSetting);
                bubble.position(e);
                HWLog.m16761i("updateBlockBubble", "latLng = " + e);
            }
            m17486a(bubble, blockBubbleSetting);
            this.f24470c.updateBubble(bubble);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72051a() {
        Bubble bubble = this.f24472e;
        if (bubble != null) {
            this.f24470c.removeBubble(bubble.getId());
            this.f24472e = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72053a(boolean z) {
        Bubble bubble = this.f24472e;
        if (bubble != null && bubble.isVisible() != z) {
            this.f24472e.setVisible(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo72055b() {
        return this.f24472e != null;
    }

    /* renamed from: e */
    private LatLng m17491e(BlockBubbleSetting blockBubbleSetting) {
        TextLableOnRoute textLableOnRoute = blockBubbleSetting.textLableOnRoute;
        if (blockBubbleSetting.trafficSectionType != 1) {
            return new LatLng(textLableOnRoute.position.f24754y, textLableOnRoute.position.f24753x);
        }
        if (blockBubbleSetting.mapTrafficIcon == null || blockBubbleSetting.mapTrafficIcon.getLatLng() == null) {
            return new LatLng(textLableOnRoute.position.f24754y, textLableOnRoute.position.f24753x);
        }
        return blockBubbleSetting.mapTrafficIcon.getLatLng();
    }

    /* renamed from: a */
    private void m17486a(Bubble bubble, BlockBubbleSetting blockBubbleSetting) {
        TextLableOnRoute textLableOnRoute = blockBubbleSetting.textLableOnRoute;
        int i = blockBubbleSetting.trafficSectionType;
        Context context = this.f24469b.context;
        String str = textLableOnRoute.name.split(";")[0];
        bubble.setShowInfo(str + System.currentTimeMillis());
        String markerFileName = this.f24471d.getMarkerFileName(this.f24469b.isNight, str, 1, i);
        LableMarkerManager.BlockBubbleParams blockBubbleParams = new LableMarkerManager.BlockBubbleParams();
        blockBubbleParams.blockBubbleType = i;
        blockBubbleParams.fileName = markerFileName;
        blockBubbleParams.text = str;
        if (i == 5 && blockBubbleSetting.blockBubbleParam != null && blockBubbleSetting.blockBubbleParam.thumbUrl.size() > 0) {
            blockBubbleParams.thumbUrl = blockBubbleSetting.blockBubbleParam.thumbUrl.get(0);
        }
        int[] bitmapWh = this.f24471d.getBitmapWh(context, 0, blockBubbleParams);
        int i2 = bitmapWh[0];
        int i3 = bitmapWh[1];
        bubble.clearOverlayRect();
        Bubble bubble2 = bubble;
        int i4 = i2;
        int i5 = i3;
        LableMarkerManager.BlockBubbleParams blockBubbleParams2 = blockBubbleParams;
        bubble.addOverlayRect(m17484a(bubble2, i4, i5, 1, blockBubbleParams2));
        bubble.addOverlayRect(m17484a(bubble2, i4, i5, 2, blockBubbleParams2));
        if (blockBubbleParams.blockBubbleType == 1) {
            Bubble bubble3 = bubble;
            int i6 = i2;
            int i7 = i3;
            LableMarkerManager.BlockBubbleParams blockBubbleParams3 = blockBubbleParams;
            bubble.addOverlayRect(m17484a(bubble3, i6, i7, 3, blockBubbleParams3));
            bubble.addOverlayRect(m17484a(bubble3, i6, i7, 4, blockBubbleParams3));
        }
    }

    /* renamed from: a */
    private Bubble.OverlayRect m17484a(Bubble bubble, int i, int i2, int i3, LableMarkerManager.BlockBubbleParams blockBubbleParams) {
        float f;
        float f2;
        float f3;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        LableMarkerManager.BlockBubbleParams blockBubbleParams2 = blockBubbleParams;
        boolean z = this.f24469b.isNight;
        Context context = this.f24469b.context;
        String str = blockBubbleParams2.text;
        int i7 = blockBubbleParams2.blockBubbleType;
        Bubble.OverlayRect overlayRect = new Bubble.OverlayRect(bubble.getId());
        BlockBubbleBitmapOpt blockBubbleBitmapOpt = new BlockBubbleBitmapOpt(BlockBubbleBitmapLoader.TAG, bubble.getId(), str);
        blockBubbleBitmapOpt.setBlockBubbleType(i7);
        String markerFileName = this.f24471d.getMarkerFileName(z, str, i6, i7);
        if (markerFileName.isEmpty()) {
            return null;
        }
        blockBubbleBitmapOpt.setNight(z);
        ArrayList arrayList = new ArrayList();
        arrayList.add(markerFileName);
        blockBubbleBitmapOpt.setFileNams(arrayList);
        if (i7 == 5) {
            blockBubbleBitmapOpt.thumbUrl = blockBubbleParams2.thumbUrl;
        }
        int dip2px = DisplayUtils.dip2px(context, 15.0f);
        float f4 = 1.0f;
        if (i6 == 1) {
            f3 = 0.0f;
            if (i7 == 0) {
                f4 = 1.0f - (13.0f / ((float) i5));
            } else if (i7 == 5) {
                f4 = 1.0f - (20.0f / ((float) i5));
                f3 = 25.0f / ((float) i4);
            }
            overlayRect.paddingCollision = new Rect(dip2px, 0, 0, dip2px);
        } else {
            if (i6 == 2) {
                if (i7 == 0) {
                    f2 = 1.0f - (13.0f / ((float) i5));
                } else if (i7 == 5) {
                    f4 = 1.0f - (25.0f / ((float) i4));
                    f2 = 1.0f - (20.0f / ((float) i5));
                } else {
                    f2 = 1.0f;
                }
                overlayRect.paddingCollision = new Rect(0, 0, dip2px, dip2px);
                f = f4;
            } else if (i6 == 3) {
                if (i7 != 1) {
                    return null;
                }
                f3 = 15.0f / ((float) i4);
                f4 = 15.0f / ((float) i5);
                overlayRect.paddingCollision = new Rect(dip2px, dip2px, 0, 0);
            } else if (i6 != 4) {
                f2 = 1.0f;
                f = 0.5f;
            } else if (i7 != 1) {
                return null;
            } else {
                f3 = 1.0f - (15.0f / ((float) i4));
                f4 = 15.0f / ((float) i5);
                overlayRect.paddingCollision = new Rect(0, dip2px, dip2px, 0);
            }
            overlayRect.anchorX = f;
            overlayRect.anchorY = f2;
            overlayRect.width = i4;
            overlayRect.height = i5;
            overlayRect.resourcePaths = blockBubbleBitmapOpt;
            return overlayRect;
        }
        f = f3;
        f2 = f4;
        overlayRect.anchorX = f;
        overlayRect.anchorY = f2;
        overlayRect.width = i4;
        overlayRect.height = i5;
        overlayRect.resourcePaths = blockBubbleBitmapOpt;
        return overlayRect;
    }

    /* renamed from: a */
    private void m17485a(Bubble bubble) {
        bubble.setOnClickListener(new DidiMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                DidiMap didiMap = BlockBubbleManager.this.f24469b.didiMap;
                if (!(didiMap == null || BlockBubbleManager.this.f24473f == null)) {
                    int i = BlockBubbleManager.this.f24473f.trafficSectionType;
                    OnMapElementClickListener mapElementClickListener = ((DidiMapExt) didiMap).getMapElementClickListener();
                    if (mapElementClickListener != null) {
                        if (i == 5) {
                            ClickBlockBubbleParam clickBlockBubbleParam = BlockBubbleManager.this.f24473f.blockBubbleParam;
                            if (clickBlockBubbleParam == null) {
                                HWLog.m16761i(BlockBubbleManager.f24468a, "click blockBubbleParam == null");
                                return true;
                            }
                            mapElementClickListener.onClickBubble(clickBlockBubbleParam);
                        } else {
                            MapTrafficIcon mapTrafficIcon = BlockBubbleManager.this.f24473f.mapTrafficIcon;
                            if (mapTrafficIcon == null) {
                                HWLog.m16761i(BlockBubbleManager.f24468a, "click trafficIcon == null");
                                return true;
                            }
                            mapTrafficIcon.setBlockType(1);
                            mapTrafficIcon.setBlockBubbleStatus(i);
                            mapTrafficIcon.setFromBubble(true);
                            mapElementClickListener.onTrafficIconClick(mapTrafficIcon);
                        }
                    }
                }
                return true;
            }
        });
    }
}
