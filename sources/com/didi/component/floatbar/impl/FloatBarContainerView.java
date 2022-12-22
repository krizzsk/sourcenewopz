package com.didi.component.floatbar.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.floatbar.AbsFloatBarPresenter;
import com.didi.component.floatbar.IFloatBarContainerView;

public class FloatBarContainerView implements View.OnClickListener, IFloatBarContainerView {

    /* renamed from: a */
    private LinearLayout f13729a;

    /* renamed from: b */
    private AbsFloatBarPresenter f13730b;

    /* renamed from: c */
    private Context f13731c;

    public FloatBarContainerView(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f13729a = linearLayout;
        linearLayout.setOrientation(1);
        this.f13729a.setGravity(5);
        this.f13731c = context;
    }

    public View getView() {
        return this.f13729a;
    }

    public void setPresenter(AbsFloatBarPresenter absFloatBarPresenter) {
        this.f13730b = absFloatBarPresenter;
    }

    public void setContentView(View view) {
        this.f13729a.removeAllViews();
        this.f13729a.addView(view);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        AbsFloatBarPresenter absFloatBarPresenter = this.f13730b;
        if (absFloatBarPresenter != null) {
            absFloatBarPresenter.onFloatBarClicked();
        }
    }
}
