package com.component.android.comp_location.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.business.util.UiUtils;
import com.taxis99.R;

public class GlobalConfirmLocationView extends GlobalHomeLocationView {
    public GlobalConfirmLocationView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onInflate(View view) {
        super.onInflate(view);
        ViewGroup.LayoutParams layoutParams = this.mOverviewBtn.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mOverviewBtn.setLayoutParams(layoutParams);
        this.mOverviewParentBtn.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams2 = this.mStartOrEndView.getLayoutParams();
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        this.mStartOrEndView.setLayoutParams(layoutParams2);
        this.mStartOrEndParentView.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams3 = this.mOverviewBtn.getLayoutParams();
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        this.mResetBtnView.setLayoutParams(layoutParams3);
        this.mResetBtnView.setImageResource(R.drawable.global_confirm_location_resetview_bg);
        this.mResetBtnParentView.setPadding(0, 0, 0, 0);
    }

    public void setOverviewVisibility(int i) {
        super.show();
        if (this.mOverviewParentBtn != null) {
            this.mOverviewParentBtn.setVisibility(i);
            this.mOverviewParentBtn.setPadding(0, 0, 0, 0);
            if (i == 0) {
                this.mResetBtnParentView.setTranslationY((float) (-UiUtils.dip2px(this.mContext, -25.0f)));
                return;
            }
            this.mResetBtnParentView.setTranslationY(0.0f);
        }
    }

    public void setStartOrEndOverviewVisible(int i) {
        super.show();
        if (this.mStartOrEndParentView != null) {
            this.mStartOrEndParentView.setVisibility(i);
            this.mStartOrEndParentView.setPadding(0, 0, 0, 0);
            if (i == 0) {
                this.mResetBtnParentView.setTranslationY((float) (-UiUtils.dip2px(this.mContext, -25.0f)));
                return;
            }
            this.mResetBtnParentView.setTranslationY(0.0f);
        }
    }

    public void setTranslationY(int i) {
        super.setTranslationY(i + UiUtils.dip2px(getContext(), 4.0f));
    }
}
