package com.didi.map.global.flow.scene.order.serving.carpool;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.markers.view.ILabelView;
import com.taxis99.R;

public class CarpoolBubble implements ILabelView {

    /* renamed from: a */
    private View f26724a;

    /* renamed from: b */
    private TextView f26725b;

    public /* synthetic */ View getView(Context context, String str) {
        return ILabelView.CC.$default$getView(this, context, str);
    }

    public /* synthetic */ View getView(Context context, String str, int i, boolean z) {
        return ILabelView.CC.$default$getView(this, context, str, i, z);
    }

    public View getView(Context context, String str, int i) {
        if (this.f26724a == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_carpool_bubble_tip_info_window, (ViewGroup) null, false);
            this.f26724a = inflate;
            this.f26725b = (TextView) inflate.findViewById(R.id.tip);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f26725b.setText(str);
        }
        return this.f26724a;
    }
}
