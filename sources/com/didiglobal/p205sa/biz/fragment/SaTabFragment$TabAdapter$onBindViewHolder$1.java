package com.didiglobal.p205sa.biz.fragment;

import com.didiglobal.p205sa.biz.fragment.SaTabFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didiglobal/sa/biz/fragment/SaTabFragment$TabAdapter$onBindViewHolder$1", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$OnTabItemClickListener;", "onClick", "", "data", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "position", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.fragment.SaTabFragment$TabAdapter$onBindViewHolder$1 */
/* compiled from: SaTabFragment.kt */
public final class SaTabFragment$TabAdapter$onBindViewHolder$1 implements SaTabFragment.OnTabItemClickListener {
    final /* synthetic */ SaTabFragment.TabAdapter this$0;

    SaTabFragment$TabAdapter$onBindViewHolder$1(SaTabFragment.TabAdapter tabAdapter) {
        this.this$0 = tabAdapter;
    }

    public void onClick(SaTabFragment.TabModel tabModel, int i) {
        Intrinsics.checkNotNullParameter(tabModel, "data");
        SaTabFragment.OnTabItemClickListener access$getOnTabItemClickListener$p = this.this$0.onTabItemClickListener;
        if (access$getOnTabItemClickListener$p != null) {
            access$getOnTabItemClickListener$p.onClick(tabModel, i);
        }
    }
}
