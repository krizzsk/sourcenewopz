package com.didi.soda.home.component.bub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.home.bub.TaskBubModel;
import com.didi.soda.home.widget.TaskBubView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/home/component/bub/HomeBubView;", "Lcom/didi/soda/customer/base/ICustomerView;", "Lcom/didi/soda/home/component/bub/HomeBubPresenter;", "()V", "bubViewView", "Lcom/didi/soda/home/widget/TaskBubView;", "getBubViewView", "()Lcom/didi/soda/home/widget/TaskBubView;", "setBubViewView", "(Lcom/didi/soda/home/widget/TaskBubView;)V", "goneView", "", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreate", "randerView", "model", "Lcom/didi/soda/home/bub/TaskBubModel;", "visibleView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeBubView.kt */
public final class HomeBubView extends ICustomerView<HomeBubPresenter> {

    /* renamed from: a */
    private TaskBubView f42555a;

    public final TaskBubView getBubViewView() {
        return this.f42555a;
    }

    public final void setBubViewView(TaskBubView taskBubView) {
        this.f42555a = taskBubView;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_view_home_bub, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…view_home_bub, container)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        LogUtil.m29100d("homebub", "HomeBubView oncreate");
        this.f42555a = (TaskBubView) getView().findViewById(R.id.bub);
    }

    public final void goneView() {
        TaskBubView taskBubView = this.f42555a;
        if (taskBubView != null) {
            taskBubView.setVisibility(8);
        }
    }

    public final void visibleView() {
        TaskBubView taskBubView = this.f42555a;
        if (taskBubView != null) {
            taskBubView.setVisibility(0);
        }
    }

    public final void randerView(TaskBubModel taskBubModel) {
        Intrinsics.checkNotNullParameter(taskBubModel, "model");
        TaskBubView taskBubView = this.f42555a;
        if (taskBubView != null) {
            taskBubView.randerView(taskBubModel);
        }
        TaskBubView taskBubView2 = this.f42555a;
        if (taskBubView2 != null) {
            taskBubView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeBubView.m29994a(TaskBubModel.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29994a(TaskBubModel taskBubModel, View view) {
        Intrinsics.checkNotNullParameter(taskBubModel, "$model");
        OmegaTracker.Builder.create(EventConst.Home.SAILING_C_X_HOMEPAGE_BUBBLE_TASK_CENTER_CK).addEventParam(ParamConst.TASK_TYPE, 2).build().track();
        SchemeHelper.dispatchMsg(taskBubModel.getRedirectUrl());
    }
}
