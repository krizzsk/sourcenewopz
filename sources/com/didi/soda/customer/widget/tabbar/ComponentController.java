package com.didi.soda.customer.widget.tabbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H&J\u0006\u0010\u001e\u001a\u00020\u0010J\u0010\u0010\u001f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\b\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0012\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u0010H\u0016J\b\u0010)\u001a\u00020\u0010H\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u0018\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u001cH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u00062"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "", "()V", "componentList", "", "Lcom/didi/soda/customer/widget/tabbar/ComponentInfo;", "getComponentList", "()Ljava/util/List;", "pageCallback", "Lcom/didi/soda/customer/widget/tabbar/PageCallback;", "<set-?>", "Landroid/os/Bundle;", "params", "getParams", "()Landroid/os/Bundle;", "addComponent", "", "component", "Lcom/didi/app/nova/skeleton/Component;", "attach", "p", "getContext", "Landroid/content/Context;", "getHostPage", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "getScopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "getTabView", "Landroid/view/View;", "context", "internOnTabRemoveEvent", "internOnTabUpdate", "onCreate", "onDestroy", "onDoubleClickTab", "onPageResult", "data", "onPause", "onResume", "onStart", "onStop", "onTabRemoveEvent", "onTabUpdateEvent", "onTabVisibleChanged", "visible", "", "fromUser", "setupComponents", "container", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComponentController.kt */
public abstract class ComponentController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "TabBarComponentController";

    /* renamed from: a */
    private final List<ComponentInfo> f42186a = new ArrayList();

    /* renamed from: b */
    private PageCallback f42187b;

    /* renamed from: c */
    private Bundle f42188c;

    public abstract View getTabView(Context context);

    public void onDoubleClickTab() {
    }

    public void onTabRemoveEvent() {
    }

    public void onTabUpdateEvent() {
    }

    public final List<ComponentInfo> getComponentList() {
        return this.f42186a;
    }

    public final Bundle getParams() {
        return this.f42188c;
    }

    public final void attach(PageCallback pageCallback, Bundle bundle) {
        Intrinsics.checkNotNullParameter(pageCallback, "pageCallback");
        this.f42187b = pageCallback;
        Bundle bundle2 = new Bundle();
        this.f42188c = bundle2;
        if (bundle != null && bundle2 != null) {
            bundle2.putAll(bundle);
        }
    }

    public void onTabVisibleChanged(boolean z, boolean z2) {
        LogUtil.m29100d(TAG, "onTabVisibleChanged : visible = " + z + "  fromUser = " + z2);
    }

    public final void internOnTabUpdate(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        this.f42188c = bundle2;
        if (!(bundle == null || bundle2 == null)) {
            bundle2.putAll(bundle);
        }
        onTabUpdateEvent();
    }

    public final void internOnTabRemoveEvent() {
        this.f42186a.clear();
        onTabRemoveEvent();
    }

    public void onCreate() {
        LogUtil.m29100d(TAG, Intrinsics.stringPlus(getClass().getSimpleName(), " >>>>>>> onCreate <<<<<<<"));
    }

    public void onStart() {
        LogUtil.m29100d(TAG, Intrinsics.stringPlus(getClass().getSimpleName(), " >>>>>>> onStart <<<<<<<"));
    }

    public void onResume() {
        LogUtil.m29100d(TAG, Intrinsics.stringPlus(getClass().getSimpleName(), " >>>>>>> onResume <<<<<<<"));
    }

    public void onStop() {
        LogUtil.m29100d(TAG, Intrinsics.stringPlus(getClass().getSimpleName(), " >>>>>>> onStop <<<<<<<"));
    }

    public void onPause() {
        LogUtil.m29100d(TAG, Intrinsics.stringPlus(getClass().getSimpleName(), " >>>>>>> onPause <<<<<<<"));
    }

    public void onDestroy() {
        LogUtil.m29100d(TAG, Intrinsics.stringPlus(getClass().getSimpleName(), " >>>>>>> onDestroy <<<<<<<"));
    }

    public final ScopeContext getScopeContext() {
        PageCallback pageCallback = this.f42187b;
        if (pageCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageCallback");
            pageCallback = null;
        }
        return pageCallback.getScopeContext();
    }

    public final Context getContext() {
        PageCallback pageCallback = this.f42187b;
        if (pageCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageCallback");
            pageCallback = null;
        }
        return pageCallback.getContext();
    }

    public final CustomerPage getHostPage() {
        PageCallback pageCallback = this.f42187b;
        if (pageCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageCallback");
            pageCallback = null;
        }
        return pageCallback.getHostPage();
    }

    public void setupComponents(View view) {
        Intrinsics.checkNotNullParameter(view, "container");
        LogUtil.m29100d(TAG, Intrinsics.stringPlus(getClass().getSimpleName(), " >>>>>>> setupComponents <<<<<<<"));
    }

    public void onPageResult(Bundle bundle) {
        for (ComponentInfo componentInfo : this.f42186a) {
            if (componentInfo.getComponent() instanceof ITabComponent) {
                ((ITabComponent) componentInfo.getComponent()).onPageResult(bundle);
            }
        }
    }

    public final void addComponent(Component component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.f42186a.add(new ComponentInfo(component, false));
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/tabbar/ComponentController$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComponentController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
