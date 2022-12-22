package com.didi.soda.home.bub;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.widget.HomeTaskBubStateEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/home/bub/HomeBubHelper$attach$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeBubHelper.kt */
public final class HomeBubHelper$attach$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ HomeBubHelper this$0;

    HomeBubHelper$attach$1(HomeBubHelper homeBubHelper) {
        this.this$0 = homeBubHelper;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            this.this$0.f42546a = false;
            TaskBubModel taskBubModel = (TaskBubModel) ((HomeBubRepo) RepoFactory.getRepo(HomeBubRepo.class)).getValue();
            if (taskBubModel != null) {
                taskBubModel.setCurrentState(HomeTaskBubStateEnum.INSTANCE.getSCROLL_STOP());
                ((HomeBubRepo) RepoFactory.getRepo(HomeBubRepo.class)).setValue(taskBubModel);
            }
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (!this.this$0.f42546a && Math.abs(i2) >= 5) {
            TaskBubModel taskBubModel = (TaskBubModel) ((HomeBubRepo) RepoFactory.getRepo(HomeBubRepo.class)).getValue();
            if (taskBubModel != null) {
                taskBubModel.setCurrentState(HomeTaskBubStateEnum.INSTANCE.getSCROLL());
                ((HomeBubRepo) RepoFactory.getRepo(HomeBubRepo.class)).setValue(taskBubModel);
            }
            this.this$0.f42546a = true;
        }
    }
}
