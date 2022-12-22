package com.didi.component.savingcenter;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SavingCenterView.kt */
final class SavingCenterView$onInflate$2 implements View.OnClickListener {
    final /* synthetic */ SavingCenterView this$0;

    SavingCenterView$onInflate$2(SavingCenterView savingCenterView) {
        this.this$0 = savingCenterView;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        AbsSavingCenterPresenter mPresenter = this.this$0.getMPresenter();
        if (mPresenter != null) {
            mPresenter.trackSideBarClick();
        }
        AbsSavingCenterPresenter mPresenter2 = this.this$0.getMPresenter();
        if (mPresenter2 != null) {
            mPresenter2.onIconClick();
        }
    }
}
