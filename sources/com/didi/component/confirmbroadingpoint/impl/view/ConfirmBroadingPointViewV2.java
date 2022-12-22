package com.didi.component.confirmbroadingpoint.impl.view;

import android.app.Activity;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class ConfirmBroadingPointViewV2 extends ConfirmBroadingPointView {
    public int getLayoutId() {
        return R.layout.global_confirm_broading_point_view_v2;
    }

    /* access modifiers changed from: protected */
    public boolean showEditEntrance() {
        return true;
    }

    public ConfirmBroadingPointViewV2(Activity activity, ViewGroup viewGroup) {
        super(activity, viewGroup);
        this.mConfirmView.setBackground(DidiThemeManager.getIns().getResPicker(activity).getDrawable(R.attr.submit_btn_bg_new_selector));
        setSubTitle(ResourcesHelper.getString(this.mContext, R.string.GRider_display_Get_on_UOJP));
    }

    public void setConfirmAction(String str) {
        this.mConfirmView.setText(ResourcesHelper.getString(this.mContext, R.string.global_confirm_broading_button));
    }

    public void setSubTitle(CharSequence charSequence) {
        TextView subTitleView = getSubTitleView();
        if (subTitleView != null) {
            subTitleView.setText(charSequence);
            subTitleView.setContentDescription(charSequence);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_CONFIRM_PAGE_SUB_TITLE_SHOWED);
        }
    }

    public void enableContent(boolean z) {
        super.enableContent(z);
        enableConfirm(z);
        if (z) {
            setSubTitleColor(Color.parseColor("#F33F60"));
            setSubTitle(ResourcesHelper.getString(this.mContext, R.string.GRider_display_Get_on_UOJP));
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView mainTitleView = getMainTitleView();
        if (mainTitleView != null) {
            mainTitleView.setText(ResourcesHelper.getString(this.mContext, R.string.GRider_Sug_2020_map_button_pickup));
        }
    }
}
