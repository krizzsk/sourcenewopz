package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didiglobal.p205sa.biz.component.sapanel.view.SaShadowCard;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityPanelItemContainer */
public class ActivityPanelItemContainer extends SaShadowCard {

    /* renamed from: a */
    private int f50760a;

    /* renamed from: b */
    private String f50761b;

    public ActivityPanelItemContainer(String str, int i, Context context) {
        super(context);
        this.f50761b = str;
        this.f50760a = i;
        m36454a();
    }

    /* renamed from: a */
    private void m36454a() {
        int dip2px = UiUtils.dip2px(getContext(), 14.0f);
        int i = this.f50760a;
        setPadding((int) getContext().getResources().getDimension(R.dimen.view_padding), 0, (int) getContext().getResources().getDimension(R.dimen.view_padding), dip2px);
    }
}
