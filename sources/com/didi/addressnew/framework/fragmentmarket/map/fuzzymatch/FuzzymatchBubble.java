package com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.markers.view.ILabelView;
import com.taxis99.R;

public class FuzzymatchBubble implements ILabelView {

    /* renamed from: a */
    private View f7166a;

    /* renamed from: b */
    private TextView f7167b;

    /* renamed from: c */
    private int f7168c;

    public /* synthetic */ View getView(Context context, String str) {
        return ILabelView.CC.$default$getView(this, context, str);
    }

    public /* synthetic */ View getView(Context context, String str, int i, boolean z) {
        return ILabelView.CC.$default$getView(this, context, str, i, z);
    }

    public FuzzymatchBubble(int i) {
        this.f7168c = i;
    }

    public View getView(Context context, String str, int i) {
        if (this.f7166a == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.fuzzy_bubble_view_layout, (ViewGroup) null, false);
            this.f7166a = inflate;
            this.f7167b = (TextView) inflate.findViewById(R.id.fuzzy_bubble_text);
        }
        if (this.f7168c == 1) {
            this.f7167b.setTextColor(context.getResources().getColor(R.color.map_sug_fuzzy_marker_label_start));
        } else {
            this.f7167b.setTextColor(context.getResources().getColor(R.color.map_sug_fuzzy_marker_label_end));
        }
        if (!TextUtils.isEmpty(str)) {
            this.f7167b.setText(str);
        }
        return this.f7166a;
    }
}
