package com.didi.soda.home.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.home.topgun.component.topicact.TopicActivityComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/home/page/TopicActivityPage;", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "()V", "topicActivityComponent", "Lcom/didi/soda/home/topgun/component/topicact/TopicActivityComponent;", "topicContainer", "Landroid/view/ViewGroup;", "getStatusBarHeight", "", "onHandleBack", "", "onInflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onPageResult", "", "data", "Landroid/os/Bundle;", "setupComponents", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"launchActivityPage", "topicLandingPage"})
/* compiled from: TopicActivityPage.kt */
public class TopicActivityPage extends CustomerPage {

    /* renamed from: a */
    private ViewGroup f42706a;

    /* renamed from: b */
    private TopicActivityComponent f42707b;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_page_topic_activity, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.customer_topic_activity_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…topic_activity_container)");
        this.f42706a = (ViewGroup) findViewById;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…vity_container)\n        }");
        return inflate;
    }

    public void setupComponents(View view) {
        Intrinsics.checkNotNullParameter(view, "container");
        super.setupComponents(view);
        ViewGroup viewGroup = this.f42706a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicContainer");
            viewGroup = null;
        }
        TopicActivityComponent topicActivityComponent = new TopicActivityComponent(viewGroup);
        this.f42707b = topicActivityComponent;
        Unit unit = Unit.INSTANCE;
        addComponent(topicActivityComponent);
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        if (bundle != null && bundle.getInt(Const.PageParams.SUB_FROM_SKU_CHECK_OUT, -1) == 8) {
            DiRouter.request().path(RoutePath.BILL_PAGE).params(bundle).open();
        }
        TopicActivityComponent topicActivityComponent = this.f42707b;
        if (topicActivityComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicActivityComponent");
            topicActivityComponent = null;
        }
        topicActivityComponent.onPageResult(bundle);
    }

    public boolean onHandleBack() {
        TopicActivityComponent topicActivityComponent = this.f42707b;
        if (topicActivityComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicActivityComponent");
            topicActivityComponent = null;
        }
        if (topicActivityComponent.onHandleBack()) {
            return true;
        }
        return super.onHandleBack();
    }
}
