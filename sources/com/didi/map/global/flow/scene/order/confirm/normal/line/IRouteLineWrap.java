package com.didi.map.global.flow.scene.order.confirm.normal.line;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.Marker;
import com.didi.map.global.flow.scene.order.confirm.component.OnElementShowCallback;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0012H&J\u0018\u0010\u001e\u001a\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\tH\u0016J\u0012\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0012H\u0016¨\u0006&"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/normal/line/IRouteLineWrap;", "", "create", "", "destroy", "drawLine", "bubbleId", "", "getBestViewElements", "", "Lcom/didi/common/map/internal/IMapElement;", "getDefaultBubbleContent", "getDefaultRouteId", "", "getOptionBubbleContent", "getOptionRouteId", "getSelectedRouteId", "hasLine", "", "hasMultiLine", "onlyShowDefaultLine", "showDefaultLine", "setEpfOrderType", "type", "Lcom/didi/map/sdk/proto/driver_gl/EpfOrderType;", "setLineSelectedListener", "listener", "Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineSelectedListener;", "setLineVisible", "visible", "setMarkersCollide", "sizes", "Lcom/didi/common/map/model/Marker;", "setOnElementShowCallback", "elementShowCallback", "Lcom/didi/map/global/flow/scene/order/confirm/component/OnElementShowCallback;", "setUseCache", "useCache", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IRouteLineWrap.kt */
public interface IRouteLineWrap {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IRouteLineWrap.kt */
    public static final class DefaultImpls {
        public static String getDefaultBubbleContent(IRouteLineWrap iRouteLineWrap) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
            return "";
        }

        public static long getDefaultRouteId(IRouteLineWrap iRouteLineWrap) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
            return 0;
        }

        public static String getOptionBubbleContent(IRouteLineWrap iRouteLineWrap) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
            return "";
        }

        public static long getOptionRouteId(IRouteLineWrap iRouteLineWrap) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
            return 0;
        }

        public static long getSelectedRouteId(IRouteLineWrap iRouteLineWrap) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
            return 0;
        }

        public static boolean hasMultiLine(IRouteLineWrap iRouteLineWrap) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
            return false;
        }

        public static void onlyShowDefaultLine(IRouteLineWrap iRouteLineWrap, boolean z) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
        }

        public static void setEpfOrderType(IRouteLineWrap iRouteLineWrap, EpfOrderType epfOrderType) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
        }

        public static void setLineSelectedListener(IRouteLineWrap iRouteLineWrap, ILineSelectedListener iLineSelectedListener) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
        }

        public static void setMarkersCollide(IRouteLineWrap iRouteLineWrap, List<? extends Marker> list) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
        }

        public static void setOnElementShowCallback(IRouteLineWrap iRouteLineWrap, OnElementShowCallback onElementShowCallback) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
        }

        public static void setUseCache(IRouteLineWrap iRouteLineWrap, boolean z) {
            Intrinsics.checkNotNullParameter(iRouteLineWrap, "this");
        }
    }

    void create();

    void destroy();

    void drawLine(String str);

    List<IMapElement> getBestViewElements();

    String getDefaultBubbleContent();

    long getDefaultRouteId();

    String getOptionBubbleContent();

    long getOptionRouteId();

    long getSelectedRouteId();

    boolean hasLine();

    boolean hasMultiLine();

    void onlyShowDefaultLine(boolean z);

    void setEpfOrderType(EpfOrderType epfOrderType);

    void setLineSelectedListener(ILineSelectedListener iLineSelectedListener);

    void setLineVisible(boolean z);

    void setMarkersCollide(List<? extends Marker> list);

    void setOnElementShowCallback(OnElementShowCallback onElementShowCallback);

    void setUseCache(boolean z);
}
