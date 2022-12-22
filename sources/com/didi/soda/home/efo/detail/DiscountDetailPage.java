package com.didi.soda.home.efo.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.flutter.CustomerFlutterPage;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.HubTable;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.PluginRegistry;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/home/efo/detail/DiscountDetailPage;", "Lcom/didi/soda/customer/flutter/CustomerFlutterPage;", "()V", "mDiscountServicePlugin", "Lcom/didi/soda/home/efo/detail/DiscountDetailServicePlugin;", "mPluginListener", "Lcom/didi/soda/home/efo/detail/DiscountDetailPluginListener;", "alias", "", "configureFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "handleDiscountPlugin", "registry", "Lio/flutter/embedding/engine/plugins/PluginRegistry;", "onDestroy", "onInflateFlutterLayout", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/widget/FrameLayout;", "onPageResult", "data", "Landroid/os/Bundle;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"discountDetail"})
/* compiled from: DiscountDetailPage.kt */
public final class DiscountDetailPage extends CustomerFlutterPage {

    /* renamed from: a */
    private DiscountDetailServicePlugin f42635a;

    /* renamed from: b */
    private DiscountDetailPluginListener f42636b;

    public void onPageResult(Bundle bundle) {
        if (bundle == null || bundle.getInt(Const.PageParams.SUB_FROM_SKU_CHECK_OUT, -1) != 8) {
            super.onPageResult(bundle);
        } else {
            DiRouter.request().path(RoutePath.BILL_PAGE).params(bundle).open();
        }
    }

    public View onInflateFlutterLayout(LayoutInflater layoutInflater, FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(frameLayout, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_page_flutter_discount, frameLayout, false);
        View findViewById = inflate.findViewById(R.id.customer_flutter_discount_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…er_flutter_discount_root)");
        ((FrameLayout) findViewById).addView(createFlutterView(getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView");
        return inflate;
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.configureFlutterEngine(flutterEngine);
        PluginRegistry plugins = flutterEngine.getPlugins();
        Intrinsics.checkNotNullExpressionValue(plugins, "flutterEngine.plugins");
        m30110a(plugins);
    }

    /* renamed from: a */
    private final void m30110a(PluginRegistry pluginRegistry) {
        FlutterPlugin flutterPlugin = pluginRegistry.get(DiscountDetailServicePlugin.class);
        if (flutterPlugin instanceof DiscountDetailServicePlugin) {
            this.f42635a = (DiscountDetailServicePlugin) flutterPlugin;
            ScopeContext scopeContext = getScopeContext();
            String pageId = getPageId();
            Intrinsics.checkNotNullExpressionValue(pageId, "pageId");
            DiscountDetailPluginListener discountDetailPluginListener = new DiscountDetailPluginListener(scopeContext, pageId);
            this.f42636b = discountDetailPluginListener;
            DiscountDetailServicePlugin discountDetailServicePlugin = this.f42635a;
            if (discountDetailServicePlugin != null) {
                if (discountDetailPluginListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPluginListener");
                    discountDetailPluginListener = null;
                }
                discountDetailServicePlugin.addCallPluginListener(discountDetailPluginListener);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        DiscountDetailServicePlugin discountDetailServicePlugin = this.f42635a;
        if (discountDetailServicePlugin != null) {
            DiscountDetailPluginListener discountDetailPluginListener = this.f42636b;
            if (discountDetailPluginListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPluginListener");
                discountDetailPluginListener = null;
            }
            discountDetailServicePlugin.removeCallPluginListener(discountDetailPluginListener);
        }
        this.f42635a = null;
    }

    public String alias() {
        String pageId = HubTable.getPageId(getClass());
        Intrinsics.checkNotNullExpressionValue(pageId, "getPageId(this.javaClass)");
        return pageId;
    }
}
