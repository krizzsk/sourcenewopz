package com.didi.entrega.bill.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.entrega.bill.plugin.BillServiceImp;
import com.didi.entrega.customer.flutter.CustomerFlutterPage;
import com.didi.entrega.customer.flutter.FlutterCommons;
import com.didi.entrega.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.widget.xpanel.XPanelFrameTouchLayout;
import com.didi.entrega.customer.widget.xpanel.XPanelPlugin;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.entrega.router.annotations.Route;
import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.PluginRegistry;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/entrega/bill/page/CustomerBillPage;", "Lcom/didi/entrega/customer/flutter/CustomerFlutterPage;", "()V", "billAddressComponent", "LBillAddressMapComponent;", "billService", "Lcom/didi/entrega/bill/plugin/BillServiceImp;", "billServiceListener", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnCallPluginListener;", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterView", "Lcom/didi/entrega/customer/widget/xpanel/XPanelFrameTouchLayout;", "mapRootView", "Landroid/widget/FrameLayout;", "newParams", "", "xPanelPlugin", "Lcom/didi/entrega/customer/widget/xpanel/XPanelPlugin;", "xPanelPluginListener", "configureFlutterEngine", "", "getPushHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "handleDestroy", "initView", "onCreate", "view", "Landroid/view/View;", "onFinalize", "onInflateFlutterLayout", "inflater", "Landroid/view/LayoutInflater;", "container", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"flutterBillPage"})
/* compiled from: CustomerBillPage.kt */
public final class CustomerBillPage extends CustomerFlutterPage {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public BillAddressMapComponent f19575a;

    /* renamed from: b */
    private BillServiceImp f19576b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public XPanelFrameTouchLayout f19577c;

    /* renamed from: d */
    private FrameLayout f19578d;

    /* renamed from: e */
    private FlutterEngine f19579e;

    /* renamed from: f */
    private XPanelPlugin f19580f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f19581g = "";

    /* renamed from: h */
    private final OnCallPluginListener f19582h = new CustomerBillPage$billServiceListener$1(this);

    /* renamed from: i */
    private OnCallPluginListener f19583i = new CustomerBillPage$xPanelPluginListener$1(this);

    public ControllerChangeHandler getPushHandler() {
        return null;
    }

    public void onCreate(View view) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        m14613a();
        ScopeContext scopeContext = getScopeContext();
        String str = null;
        if (!(scopeContext == null || (bundle = scopeContext.getBundle()) == null)) {
            str = bundle.getString("path");
        }
        if (Intrinsics.areEqual((Object) FlutterCommons.FLUTTER_ROUTE_DELIVERY_PAGE, (Object) str)) {
            CustomerRpcManagerProxy.get().getCommonInfo(new CustomerBillPage$onCreate$1());
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.configureFlutterEngine(flutterEngine);
        this.f19579e = flutterEngine;
        PluginRegistry plugins = flutterEngine.getPlugins();
        Intrinsics.checkNotNullExpressionValue(plugins, "flutterEngine.plugins");
        FlutterPlugin flutterPlugin = plugins.get(XPanelPlugin.class);
        if (flutterPlugin instanceof XPanelPlugin) {
            XPanelPlugin xPanelPlugin = (XPanelPlugin) flutterPlugin;
            this.f19580f = xPanelPlugin;
            if (xPanelPlugin != null) {
                xPanelPlugin.addCallPluginListener(this.f19583i);
            }
        }
        GLEUniBillNativeModuleService gLEUniBillNativeModuleService = (GLEUniBillNativeModuleService) UniAPI.get(GLEUniBillNativeModuleService.class);
        if (gLEUniBillNativeModuleService instanceof BillServiceImp) {
            BillServiceImp billServiceImp = (BillServiceImp) gLEUniBillNativeModuleService;
            this.f19576b = billServiceImp;
            if (billServiceImp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billService");
                billServiceImp = null;
            }
            billServiceImp.addCallPluginListener(this.f19582h);
        }
    }

    public View onInflateFlutterLayout(LayoutInflater layoutInflater, FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(frameLayout, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_page_bill, frameLayout, false);
        View findViewById = inflate.findViewById(R.id.entrega_bill_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.entrega_bill_root_view)");
        this.f19577c = (XPanelFrameTouchLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.entrega_custom_address_map_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.e…om_address_map_container)");
        this.f19578d = (FrameLayout) findViewById2;
        XPanelFrameTouchLayout xPanelFrameTouchLayout = this.f19577c;
        XPanelFrameTouchLayout xPanelFrameTouchLayout2 = null;
        if (xPanelFrameTouchLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flutterView");
            xPanelFrameTouchLayout = null;
        }
        xPanelFrameTouchLayout.addView(createFlutterView(getContext()));
        XPanelFrameTouchLayout xPanelFrameTouchLayout3 = this.f19577c;
        if (xPanelFrameTouchLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flutterView");
            xPanelFrameTouchLayout3 = null;
        }
        FrameLayout frameLayout2 = this.f19578d;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapRootView");
            frameLayout2 = null;
        }
        xPanelFrameTouchLayout3.setSodaMapView(frameLayout2);
        XPanelFrameTouchLayout xPanelFrameTouchLayout4 = this.f19577c;
        if (xPanelFrameTouchLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flutterView");
        } else {
            xPanelFrameTouchLayout2 = xPanelFrameTouchLayout4;
        }
        xPanelFrameTouchLayout2.setAlpha(0.995f);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return inflate;
    }

    /* renamed from: a */
    private final void m14613a() {
        FrameLayout frameLayout = this.f19578d;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapRootView");
            frameLayout = null;
        }
        BillAddressMapComponent billAddressMapComponent = new BillAddressMapComponent(frameLayout);
        this.f19575a = billAddressMapComponent;
        if (billAddressMapComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billAddressComponent");
            billAddressMapComponent = null;
        }
        addComponent(billAddressMapComponent);
    }

    /* renamed from: b */
    private final void m14614b() {
        BillAddressMapComponent billAddressMapComponent = this.f19575a;
        BillServiceImp billServiceImp = null;
        if (billAddressMapComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billAddressComponent");
            billAddressMapComponent = null;
        }
        billAddressMapComponent.removeMarker();
        XPanelPlugin xPanelPlugin = this.f19580f;
        if (xPanelPlugin != null) {
            xPanelPlugin.removeCallPluginListener(this.f19583i);
        }
        BillServiceImp billServiceImp2 = this.f19576b;
        if (billServiceImp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billService");
        } else {
            billServiceImp = billServiceImp2;
        }
        billServiceImp.removeCallPluginListener(this.f19582h);
        ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).clear();
    }

    public void onFinalize() {
        m14614b();
        super.onFinalize();
    }
}
