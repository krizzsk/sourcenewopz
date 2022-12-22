package com.didi.entrega.info.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.entrega.customer.base.pages.CustomerPage;
import com.didi.entrega.customer.base.pages.changehandler.CustomerHorizontalChangeHandler;
import com.didi.entrega.info.component.receive.ReceiveContactComponent;
import com.didi.entrega.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u0017H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\""}, mo175978d2 = {"Lcom/didi/entrega/info/page/EditReceivePage;", "Lcom/didi/entrega/customer/base/pages/CustomerPage;", "()V", "container", "Landroid/widget/FrameLayout;", "getContainer", "()Landroid/widget/FrameLayout;", "setContainer", "(Landroid/widget/FrameLayout;)V", "receiveComponent", "Lcom/didi/entrega/info/component/receive/ReceiveContactComponent;", "getReceiveComponent", "()Lcom/didi/entrega/info/component/receive/ReceiveContactComponent;", "setReceiveComponent", "(Lcom/didi/entrega/info/component/receive/ReceiveContactComponent;)V", "getPopHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "getPushHandler", "getStatusBarHeight", "", "onCreate", "", "view", "Landroid/view/View;", "onHandleBack", "", "onInflateView", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "onPageResult", "data", "Landroid/os/Bundle;", "setupComponents", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"editReceivePage"})
/* compiled from: EditReceivePage.kt */
public final class EditReceivePage extends CustomerPage {
    public FrameLayout container;
    public ReceiveContactComponent receiveComponent;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public final FrameLayout getContainer() {
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("container");
        return null;
    }

    public final void setContainer(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.container = frameLayout;
    }

    public final ReceiveContactComponent getReceiveComponent() {
        ReceiveContactComponent receiveContactComponent = this.receiveComponent;
        if (receiveContactComponent != null) {
            return receiveContactComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("receiveComponent");
        return null;
    }

    public final void setReceiveComponent(ReceiveContactComponent receiveContactComponent) {
        Intrinsics.checkNotNullParameter(receiveContactComponent, "<set-?>");
        this.receiveComponent = receiveContactComponent;
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_info_send_page, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.fl_info_send_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.fl_info_send_container)");
        setContainer((FrameLayout) findViewById);
        Intrinsics.checkNotNullExpressionValue(inflate, "root");
        return inflate;
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        setReceiveComponent(new ReceiveContactComponent(getContainer()));
        addComponent(getReceiveComponent());
    }

    public boolean onHandleBack() {
        getReceiveComponent().onHandleBack();
        return true;
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        getReceiveComponent().onPageResult(bundle);
    }

    public ControllerChangeHandler getPopHandler() {
        return new CustomerHorizontalChangeHandler(200, false);
    }

    public ControllerChangeHandler getPushHandler() {
        return new CustomerHorizontalChangeHandler(200, false);
    }
}
