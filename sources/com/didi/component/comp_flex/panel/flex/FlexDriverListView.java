package com.didi.component.comp_flex.panel.flex;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.component.business.commonlist.AbsCommonListView;
import com.taxis99.R;

public class FlexDriverListView extends AbsCommonListView {
    public int getRootLayout() {
        return R.layout.flex_list_layout;
    }

    public FlexDriverListView(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }
}
