package com.didiglobal.p205sa.biz.activity;

import com.didiglobal.p205sa.biz.fragment.SaTabFragment;
import com.didiglobal.p205sa.biz.tab.manager.SATabManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didiglobal/sa/biz/activity/SuperAppMainActivity$initView$2", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$OnTabItemClickListener;", "onClick", "", "data", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "position", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.activity.SuperAppMainActivity$initView$2 */
/* compiled from: SuperAppMainActivity.kt */
public final class SuperAppMainActivity$initView$2 implements SaTabFragment.OnTabItemClickListener {
    final /* synthetic */ SuperAppMainActivity this$0;

    SuperAppMainActivity$initView$2(SuperAppMainActivity superAppMainActivity) {
        this.this$0 = superAppMainActivity;
    }

    public void onClick(SaTabFragment.TabModel tabModel, int i) {
        Intrinsics.checkNotNullParameter(tabModel, "data");
        SATabManager access$getSaTabManager$p = this.this$0.f50725g;
        if (access$getSaTabManager$p != null) {
            access$getSaTabManager$p.clickTab(tabModel, true);
        }
    }
}
