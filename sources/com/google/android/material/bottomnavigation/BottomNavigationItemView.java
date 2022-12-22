package com.google.android.material.bottomnavigation;

import android.content.Context;
import com.google.android.material.navigation.NavigationBarItemView;
import com.taxis99.R;

public class BottomNavigationItemView extends NavigationBarItemView {
    /* access modifiers changed from: protected */
    public int getItemDefaultMarginResId() {
        return R.dimen.design_bottom_navigation_margin;
    }

    /* access modifiers changed from: protected */
    public int getItemLayoutResId() {
        return R.layout.design_bottom_navigation_item;
    }

    public BottomNavigationItemView(Context context) {
        super(context);
    }
}
