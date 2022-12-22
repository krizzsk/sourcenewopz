package com.didi.soda.order.page.preview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.business.page.PreviewImageChangeHandler;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.order.component.preview.EvaluatePreviewImageComponent;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/order/page/preview/EvaluatePreviewImagePage;", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "()V", "initStatusBarModel", "", "isDoingTranslate", "previewImagePopChangeHandler", "Lcom/didi/soda/business/page/PreviewImageChangeHandler;", "getPopHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "getPushHandler", "getStatusBarHeight", "", "isStatusBarLightning", "onCreate", "", "view", "Landroid/view/View;", "onDestroy", "onHandleBack", "onInflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPageChangeEnded", "setupComponents", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"evaluatePreviewImage"})
/* compiled from: EvaluatePreviewImagePage.kt */
public final class EvaluatePreviewImagePage extends CustomerPage {

    /* renamed from: a */
    private boolean f43532a = true;

    /* renamed from: b */
    private PreviewImageChangeHandler f43533b;

    /* renamed from: c */
    private boolean f43534c;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean isStatusBarLightning() {
        return true;
    }

    public ControllerChangeHandler getPopHandler() {
        ScopeContext scopeContext = getScopeContext();
        String str = null;
        Bundle bundle = scopeContext == null ? null : scopeContext.getBundle();
        if (bundle != null) {
            str = bundle.getString(Const.PageParams.TRANSITION_NAMES);
        }
        PreviewImageChangeHandler previewImageChangeHandler = new PreviewImageChangeHandler(str);
        this.f43533b = previewImageChangeHandler;
        return previewImageChangeHandler;
    }

    public ControllerChangeHandler getPushHandler() {
        ScopeContext scopeContext = getScopeContext();
        String str = null;
        Bundle bundle = scopeContext == null ? null : scopeContext.getBundle();
        if (bundle != null) {
            str = bundle.getString(Const.PageParams.TRANSITION_NAMES);
        }
        return new PreviewImageChangeHandler(str);
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f43534c = CustomerSystemUtil.getCurrentBarStatus();
        super.onCreate(view);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_page_business_image, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…_image, container, false)");
        return inflate;
    }

    public boolean onHandleBack() {
        if (this.f43532a) {
            return true;
        }
        return super.onHandleBack();
    }

    public void onPageChangeEnded() {
        super.onPageChangeEnded();
        this.f43532a = false;
    }

    public void setupComponents(View view) {
        Intrinsics.checkNotNullParameter(view, "container");
        super.setupComponents(view);
        View pageView = getPageView();
        if (pageView != null) {
            addComponent(new EvaluatePreviewImageComponent((ViewGroup) pageView));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public void onDestroy() {
        super.onDestroy();
        CustomerSystemUtil.setStatusBarBgLightning(this.f43534c);
    }
}
