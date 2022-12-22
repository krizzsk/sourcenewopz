package com.didi.map.global.component.recmarker.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class SingleRecMarkerBubble {

    /* renamed from: a */
    private static SingleRecMarkerBubble f26127a;

    /* renamed from: b */
    private View f26128b;

    /* renamed from: c */
    private TextView f26129c;

    private SingleRecMarkerBubble() {
    }

    public static SingleRecMarkerBubble getInstance() {
        if (f26127a == null) {
            f26127a = new SingleRecMarkerBubble();
        }
        return f26127a;
    }

    public View getView(Context context, String str) {
        if (this.f26128b == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.comprecmarker_departure_recommend_view, (ViewGroup) null);
            this.f26128b = inflate;
            this.f26129c = (TextView) inflate.findViewById(R.id.tv_content);
            if (!TextUtils.isEmpty(str)) {
                this.f26129c.setText(str);
            }
        }
        return this.f26128b;
    }
}
