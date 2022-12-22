package com.didi.component.unenablecity.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class NewPreheatCityView extends PreheatCityView {
    protected TextView mButton;

    public int getLayoutResId() {
        return R.layout.global_new_preheat_city_layout;
    }

    public NewPreheatCityView(Activity activity, ViewGroup viewGroup) {
        super(activity, viewGroup);
        this.mTitleView.setOnClickListener(this);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.tv_global_preheat_left_btn);
        this.mButton = textView;
        textView.setOnClickListener(this);
        this.mRootView.setBackgroundResource(R.drawable.global_new_ui_home_card_bg);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.tv_global_preheat_city_title) {
            onPreheatImageClicked();
        } else if (view.getId() == R.id.tv_global_preheat_left_btn) {
            this.mPresenter.gotoSugPage();
        } else {
            super.onClick(view);
        }
    }
}
