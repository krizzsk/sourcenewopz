package com.didi.soda.search.component.result.binder;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.home.topgun.binder.HomeFilterNoResultBinder;
import com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel;
import com.didi.soda.home.topgun.manager.FilterNoResultLogicRepo;
import com.didi.soda.home.topgun.widget.HomeFilterNoResultView;
import com.taxis99.R;

public class SearchNoResultBinderLogic extends HomeFilterNoResultBinder.HomeFilterNoResultLogic {
    public Class<FilterNoResultLogicRepo> bindLogicRepoType() {
        return FilterNoResultLogicRepo.class;
    }

    public void onButtonClick() {
        ((FilterNoResultLogicRepo) getLogicRepo()).setSearchStatus(1);
        ((FilterNoResultLogicRepo) getLogicRepo()).setValue((Integer) ((FilterNoResultLogicRepo) getLogicRepo()).getValue());
    }

    public HomeFilterNoResultView.ResetSizeListener getResetListener() {
        return $$Lambda$SearchNoResultBinderLogic$KKj4INnXVmgJpGQDGpcW17gzhE.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m31079a(HomeNoResultRvModel homeNoResultRvModel, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, CustomerAppCompatTextView customerAppCompatTextView) {
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_300);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = dimensionPixelSize;
        layoutParams.topMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_48);
        imageView.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_609);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setPadding(0, 0, 0, 0);
    }
}
