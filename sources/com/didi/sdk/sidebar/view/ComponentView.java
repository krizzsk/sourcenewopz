package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

public abstract class ComponentView implements View.OnClickListener {
    protected Context context;

    public abstract View createView();

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public void setName(String str) {
    }

    public ComponentView(Context context2) {
        this.context = context2;
    }
}
