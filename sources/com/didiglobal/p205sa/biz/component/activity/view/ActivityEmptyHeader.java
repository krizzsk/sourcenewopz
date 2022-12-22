package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.common.util.UIUtils;
import com.didi.sdk.util.AppUtils;
import com.didiglobal.p205sa.biz.component.activity.ActivityRecAdapter;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityEmptyHeader */
public class ActivityEmptyHeader implements ActivityRecAdapter.ItemView {

    /* renamed from: a */
    private Context f50755a;

    public void onBindView(View view) {
    }

    public ActivityEmptyHeader(Context context) {
        this.f50755a = context;
    }

    public View onCreateView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f50755a).inflate(R.layout.activity_empty_head, viewGroup, false);
        if (inflate.getLayoutParams() != null) {
            inflate.getLayoutParams().height = (int) (UIUtils.dip2px(this.f50755a, 72.0f) + ((float) AppUtils.getStatusBarHeight(this.f50755a)));
        }
        return inflate;
    }
}
