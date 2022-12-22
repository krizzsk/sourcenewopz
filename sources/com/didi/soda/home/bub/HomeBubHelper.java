package com.didi.soda.home.bub;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.repo.RepoFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/home/bub/HomeBubHelper;", "", "()V", "mIsScrolling", "", "attach", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "homeFeedSetData", "model", "Lcom/didi/soda/home/bub/TaskBubModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeBubHelper.kt */
public final class HomeBubHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f42546a;

    public final void attach(ScopeContext scopeContext, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new HomeBubHelper$attach$1(this));
        }
    }

    public final void homeFeedSetData(TaskBubModel taskBubModel) {
        Unit unit;
        if (taskBubModel == null) {
            unit = null;
        } else {
            OmegaTracker.Builder.create(EventConst.Home.SAILING_C_X_HOMEPAGE_BUBBLE_TASK_CENTER_SW).addEventParam(ParamConst.TASK_TYPE, 2).build().track();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            HomeBubHelper homeBubHelper = this;
            LogUtil.m29100d("homebub", "null自动隐藏气泡");
        }
        ((HomeBubRepo) RepoFactory.getRepo(HomeBubRepo.class)).setValue(taskBubModel);
    }
}
