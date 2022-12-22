package com.didi.entrega.customer.widget.xpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0002R.\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006'"}, mo175978d2 = {"Lcom/didi/entrega/customer/widget/xpanel/XPanelFrameTouchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hitFrames", "", "", "", "", "getHitFrames", "()Ljava/util/List;", "setHitFrames", "(Ljava/util/List;)V", "isScrolling", "", "()Z", "setScrolling", "(Z)V", "mapTouchHeight", "getMapTouchHeight", "()D", "setMapTouchHeight", "(D)V", "sodaMapView", "getSodaMapView", "()Landroid/widget/FrameLayout;", "setSodaMapView", "(Landroid/widget/FrameLayout;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isHitFrames", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: XPanelFrameTouchLayout.kt */
public final class XPanelFrameTouchLayout extends FrameLayout {

    /* renamed from: a */
    private FrameLayout f20632a;

    /* renamed from: b */
    private double f20633b;

    /* renamed from: c */
    private boolean f20634c;

    /* renamed from: d */
    private List<? extends Map<String, Double>> f20635d;

    public void _$_clearFindViewByIdCache() {
    }

    public final FrameLayout getSodaMapView() {
        return this.f20632a;
    }

    public final void setSodaMapView(FrameLayout frameLayout) {
        this.f20632a = frameLayout;
    }

    public final double getMapTouchHeight() {
        return this.f20633b;
    }

    public final void setMapTouchHeight(double d) {
        this.f20633b = d;
    }

    public final boolean isScrolling() {
        return this.f20634c;
    }

    public final void setScrolling(boolean z) {
        this.f20634c = z;
    }

    public final List<Map<String, Double>> getHitFrames() {
        return this.f20635d;
    }

    public final void setHitFrames(List<? extends Map<String, Double>> list) {
        this.f20635d = list;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public XPanelFrameTouchLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public XPanelFrameTouchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public XPanelFrameTouchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (this.f20632a == null || motionEvent.getY() >= ((float) DisplayUtils.dip2px(getContext(), (float) this.f20633b)) || this.f20634c || m15080a(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        FrameLayout frameLayout = this.f20632a;
        Intrinsics.checkNotNull(frameLayout);
        return frameLayout.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private final boolean m15080a(MotionEvent motionEvent) {
        float f;
        float f2;
        float f3;
        List<? extends Map<String, Double>> list = this.f20635d;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (!list.isEmpty()) {
                List<? extends Map<String, Double>> list2 = this.f20635d;
                Intrinsics.checkNotNull(list2);
                int size = list2.size() - 1;
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        List<? extends Map<String, Double>> list3 = this.f20635d;
                        Intrinsics.checkNotNull(list3);
                        Map map = (Map) list3.get(i);
                        Context context = getContext();
                        float f4 = 0.0f;
                        if (map.get("x") == null) {
                            f = 0.0f;
                        } else {
                            Object obj = map.get("x");
                            Intrinsics.checkNotNull(obj);
                            f = (float) ((Number) obj).doubleValue();
                        }
                        int dip2px = DisplayUtils.dip2px(context, f);
                        Context context2 = getContext();
                        if (map.get(SameLayerRenderingUtil.KEY_COMP_Y) == null) {
                            f2 = 0.0f;
                        } else {
                            Object obj2 = map.get(SameLayerRenderingUtil.KEY_COMP_Y);
                            Intrinsics.checkNotNull(obj2);
                            f2 = (float) ((Number) obj2).doubleValue();
                        }
                        int dip2px2 = DisplayUtils.dip2px(context2, f2);
                        Context context3 = getContext();
                        if (map.get("width") == null) {
                            f3 = 0.0f;
                        } else {
                            Object obj3 = map.get("width");
                            Intrinsics.checkNotNull(obj3);
                            f3 = (float) ((Number) obj3).doubleValue();
                        }
                        int dip2px3 = DisplayUtils.dip2px(context3, f3);
                        Context context4 = getContext();
                        if (map.get("height") != null) {
                            Object obj4 = map.get("height");
                            Intrinsics.checkNotNull(obj4);
                            f4 = (float) ((Number) obj4).doubleValue();
                        }
                        int dip2px4 = DisplayUtils.dip2px(context4, f4);
                        if (motionEvent.getY() > ((float) dip2px2) && motionEvent.getY() < ((float) (dip2px2 + dip2px4)) && motionEvent.getX() > ((float) dip2px) && motionEvent.getX() < ((float) (dip2px + dip2px3))) {
                            return true;
                        }
                        if (i2 > size) {
                            break;
                        }
                        i = i2;
                    }
                }
            }
        }
        return false;
    }
}
