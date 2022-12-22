package com.didi.map.global.component.departure.bubble;

import com.didi.common.map.Map;
import com.didi.map.global.component.departure.bubble.MapBubble;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.pin.IPinDrawer;
import com.sdk.poibase.model.RpcPoi;

public class DepartureBubbleController {

    /* renamed from: d */
    private static final String f24882d = "DptBubbleController";

    /* renamed from: a */
    private Map f24883a;

    /* renamed from: b */
    private IPinDrawer f24884b;

    /* renamed from: c */
    private MapBubble.OnClickListener f24885c;

    /* renamed from: a */
    private void m17712a(DepartureAddress departureAddress) {
    }

    /* renamed from: a */
    private void m17713a(String str, MapBubble.OnClickListener onClickListener) {
    }

    /* renamed from: a */
    private boolean m17714a(RpcPoi rpcPoi) {
        return true;
    }

    /* renamed from: b */
    private void m17715b(DepartureAddress departureAddress) {
    }

    /* renamed from: b */
    private boolean m17716b(RpcPoi rpcPoi) {
        return true;
    }

    /* renamed from: c */
    private void m17717c(DepartureAddress departureAddress) {
    }

    /* renamed from: c */
    private boolean m17718c(RpcPoi rpcPoi) {
        return true;
    }

    /* renamed from: d */
    private boolean m17719d(DepartureAddress departureAddress) {
        return true;
    }

    /* renamed from: e */
    private boolean m17720e(DepartureAddress departureAddress) {
        return true;
    }

    public static boolean enableBubblePicture(RpcPoi rpcPoi) {
        return true;
    }

    public void removeBubble() {
    }

    public void showBubble(DepartureAddress departureAddress) {
    }

    public void showLoaddingBubble() {
    }

    public DepartureBubbleController(Map map, IPinDrawer iPinDrawer) {
        this.f24883a = map;
        this.f24884b = iPinDrawer;
    }

    public void setOnClickListener(MapBubble.OnClickListener onClickListener) {
        this.f24885c = onClickListener;
    }
}
