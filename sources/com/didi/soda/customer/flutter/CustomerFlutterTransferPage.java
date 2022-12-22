package com.didi.soda.customer.flutter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.FadeChangeHandler;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/customer/flutter/CustomerFlutterTransferPage;", "Lcom/didi/soda/customer/flutter/CustomerFlutterPage;", "()V", "getPopHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "getPushHandler", "onInflateFlutterLayout", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/widget/FrameLayout;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"flutterTransferCommonPage"})
/* compiled from: CustomerFlutterTransferPage.kt */
public final class CustomerFlutterTransferPage extends CustomerFlutterPage {
    public View onInflateFlutterLayout(LayoutInflater layoutInflater, FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(frameLayout, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_page_flutter_transfer, frameLayout, false);
        View findViewById = inflate.findViewById(R.id.customer_fl_pop_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…ustomer_fl_pop_container)");
        FrameLayout frameLayout2 = (FrameLayout) findViewById;
        frameLayout2.addView(createFlutterView(getContext()));
        frameLayout2.setAlpha(0.995f);
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView");
        return inflate;
    }

    public ControllerChangeHandler getPopHandler() {
        return new FadeChangeHandler(false);
    }

    public ControllerChangeHandler getPushHandler() {
        return new FadeChangeHandler(false);
    }
}
