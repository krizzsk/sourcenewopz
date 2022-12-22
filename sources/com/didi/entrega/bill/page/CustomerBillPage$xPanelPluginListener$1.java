package com.didi.entrega.bill.page;

import com.didi.entrega.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.entrega.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.entrega.customer.widget.xpanel.XPanelFrameTouchLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/bill/page/CustomerBillPage$xPanelPluginListener$1", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnCallPluginListener;", "callPlugin", "", "action", "", "params", "", "", "resultListener", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnPluginResultListener;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillPage.kt */
public final class CustomerBillPage$xPanelPluginListener$1 implements OnCallPluginListener {
    final /* synthetic */ CustomerBillPage this$0;

    CustomerBillPage$xPanelPluginListener$1(CustomerBillPage customerBillPage) {
        this.this$0 = customerBillPage;
    }

    public void callPlugin(String str, Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener) {
        Intrinsics.checkNotNullParameter(str, "action");
        XPanelFrameTouchLayout xPanelFrameTouchLayout = null;
        if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus("setXPanelConfig", this.this$0.getPageId()))) {
            if (map != null) {
                XPanelFrameTouchLayout access$getFlutterView$p = this.this$0.f19577c;
                if (access$getFlutterView$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("flutterView");
                    access$getFlutterView$p = null;
                }
                Object obj = map.get("offsetHeight");
                if (obj != null) {
                    access$getFlutterView$p.setMapTouchHeight(((Double) obj).doubleValue());
                    XPanelFrameTouchLayout access$getFlutterView$p2 = this.this$0.f19577c;
                    if (access$getFlutterView$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("flutterView");
                    } else {
                        xPanelFrameTouchLayout = access$getFlutterView$p2;
                    }
                    Object obj2 = map.get("isScrolling");
                    if (obj2 != null) {
                        xPanelFrameTouchLayout.setScrolling(((Boolean) obj2).booleanValue());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus("setHitFrames", this.this$0.getPageId())) && map != null && map.get("hitFrames") != null) {
            XPanelFrameTouchLayout access$getFlutterView$p3 = this.this$0.f19577c;
            if (access$getFlutterView$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flutterView");
            } else {
                xPanelFrameTouchLayout = access$getFlutterView$p3;
            }
            xPanelFrameTouchLayout.setHitFrames((List) map.get("hitFrames"));
        }
    }
}
