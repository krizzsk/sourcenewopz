package com.didiglobal.p205sa.biz.component.businesscard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didiglobal.p205sa.biz.component.businesscard.model.BusinessCardModel;

/* renamed from: com.didiglobal.sa.biz.component.businesscard.view.BusinessRowItemView */
public class BusinessRowItemView extends LinearLayout {
    public BusinessRowItemView(Context context) {
        super(context);
        m36481a();
    }

    public BusinessRowItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m36481a();
    }

    public BusinessRowItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m36481a();
    }

    /* renamed from: a */
    private void m36481a() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        setOrientation(0);
        setLayoutParams(layoutParams);
    }

    public void updateLayoutParames(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int dip2px = UiUtils.dip2px(getContext(), 1.0f);
        if (z) {
            layoutParams.setMargins(dip2px, 0, 0, 0);
        } else {
            layoutParams.setMargins(dip2px, UiUtils.dip2px(getContext(), -18.0f), 0, 0);
        }
        setOrientation(0);
        setLayoutParams(layoutParams);
    }

    public View addBusinessItem(BusinessCardModel.BusinessMenuModel businessMenuModel, boolean z, boolean z2) {
        AbsBusinessItemView absBusinessItemView;
        if (businessMenuModel == null) {
            return null;
        }
        if (businessMenuModel.style == BusinessCardModel.Style.BIG.getType()) {
            absBusinessItemView = new BigBusinessItemView(getContext());
        } else if (businessMenuModel.style == BusinessCardModel.Style.MID.getType()) {
            absBusinessItemView = new MidBusinessItemView(getContext());
        } else if (businessMenuModel.style == BusinessCardModel.Style.SMALL.getType()) {
            absBusinessItemView = new SmallBusinessItemView(getContext());
        } else {
            absBusinessItemView = new SmallBusinessItemView(getContext());
        }
        absBusinessItemView.updateLayoutParams(z, z2);
        absBusinessItemView.setData(businessMenuModel);
        absBusinessItemView.setTag(businessMenuModel.groupType);
        addView(absBusinessItemView);
        return absBusinessItemView;
    }

    public void addMoreItem(BusinessCardModel businessCardModel) {
        if (businessCardModel != null) {
            MoreBusinessItemView moreBusinessItemView = new MoreBusinessItemView(getContext());
            moreBusinessItemView.setData(businessCardModel);
            addView(moreBusinessItemView);
        }
    }

    public void addEmptyView(float f) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        UiUtils.dip2px(getContext(), -9.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.weight = f;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
    }
}
