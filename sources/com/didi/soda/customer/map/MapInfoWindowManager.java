package com.didi.soda.customer.map;

import android.content.Context;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.Marker;
import com.didi.foundation.sdk.map.IMapView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/customer/map/MapInfoWindowManager;", "", "()V", "createInfoWindow", "Lcom/didi/common/map/model/InfoWindow;", "rootMarker", "Lcom/didi/common/map/model/Marker;", "mapViewProxy", "Lcom/didi/foundation/sdk/map/IMapView;", "option", "Lcom/didi/soda/customer/map/InfoWindowOptions;", "ctx", "Landroid/content/Context;", "removeInfoWindow", "", "setInfoWindowVisible", "visible", "", "Companion", "InfoWindowHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MapInfoWindowManager.kt */
public final class MapInfoWindowManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f41362a = "InfoWindowManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final MapInfoWindowManager f41363b = InfoWindowHolder.INSTANCE.getHolder();

    public /* synthetic */ MapInfoWindowManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MapInfoWindowManager() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/map/MapInfoWindowManager$InfoWindowHolder;", "", "()V", "holder", "Lcom/didi/soda/customer/map/MapInfoWindowManager;", "getHolder", "()Lcom/didi/soda/customer/map/MapInfoWindowManager;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MapInfoWindowManager.kt */
    private static final class InfoWindowHolder {
        public static final InfoWindowHolder INSTANCE = new InfoWindowHolder();
        private static final MapInfoWindowManager holder = new MapInfoWindowManager((DefaultConstructorMarker) null);

        private InfoWindowHolder() {
        }

        public final MapInfoWindowManager getHolder() {
            return holder;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/customer/map/MapInfoWindowManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/didi/soda/customer/map/MapInfoWindowManager;", "getInstance", "()Lcom/didi/soda/customer/map/MapInfoWindowManager;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MapInfoWindowManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MapInfoWindowManager getInstance() {
            return MapInfoWindowManager.f41363b;
        }
    }

    public final InfoWindow createInfoWindow(Marker marker, IMapView iMapView, InfoWindowOptions infoWindowOptions, Context context) {
        Marker marker2;
        Marker marker3 = null;
        if (infoWindowOptions == null || marker == null || iMapView == null || infoWindowOptions.getContentView() == null) {
            return null;
        }
        InfoWindow buildInfoWindow = marker.buildInfoWindow(iMapView.getDidiCommonMap(), context);
        if (buildInfoWindow != null) {
            buildInfoWindow.showInfoWindow(infoWindowOptions.getContentView());
        }
        if (buildInfoWindow != null) {
            buildInfoWindow.hideInfoWindow();
        }
        if (buildInfoWindow == null) {
            marker2 = null;
        } else {
            marker2 = buildInfoWindow.getInfoWindowMarker();
        }
        if (marker2 != null) {
            marker2.setZIndex(infoWindowOptions.getZIndex());
        }
        if (buildInfoWindow != null) {
            buildInfoWindow.setPosition(infoWindowOptions.getPosition());
        }
        if (buildInfoWindow != null) {
            marker3 = buildInfoWindow.getInfoWindowMarker();
        }
        if (marker3 != null) {
            marker3.setVisible(infoWindowOptions.getVisiable());
        }
        return buildInfoWindow;
    }

    public final void setInfoWindowVisible(Marker marker, boolean z) {
        InfoWindow infoWindow;
        Marker marker2 = null;
        if (!(marker == null || (infoWindow = marker.getInfoWindow()) == null)) {
            marker2 = infoWindow.getInfoWindowMarker();
        }
        if (marker2 != null) {
            marker2.setVisible(z);
        }
    }

    public final void removeInfoWindow(Marker marker) {
        InfoWindow infoWindow;
        Marker infoWindowMarker;
        if (marker != null && (infoWindow = marker.getInfoWindow()) != null && (infoWindowMarker = infoWindow.getInfoWindowMarker()) != null) {
            infoWindowMarker.remove();
        }
    }
}
