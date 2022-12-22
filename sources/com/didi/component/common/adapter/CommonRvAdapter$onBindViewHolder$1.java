package com.didi.component.common.adapter;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.adapter.CommonRvAdapter;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n"}, mo175978d2 = {"<anonymous>", "", "T", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonRvAdapter.kt */
final class CommonRvAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ CommonRvVH $holder;
    final /* synthetic */ int $position;
    final /* synthetic */ CommonRvAdapter<T> this$0;

    CommonRvAdapter$onBindViewHolder$1(CommonRvAdapter<T> commonRvAdapter, CommonRvVH commonRvVH, int i) {
        this.this$0 = commonRvAdapter;
        this.$holder = commonRvVH;
        this.$position = i;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        CommonRvAdapter.ItemClickListener access$getMItemClickListener$p = this.this$0.mItemClickListener;
        if (access$getMItemClickListener$p != null) {
            access$getMItemClickListener$p.onItemClick(this.$holder, this.$position);
        }
    }
}
