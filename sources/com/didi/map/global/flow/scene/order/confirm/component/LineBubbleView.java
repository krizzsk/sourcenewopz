package com.didi.map.global.flow.scene.order.confirm.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.markers.view.ILabelView;
import com.taxis99.R;

public class LineBubbleView implements ILabelView {

    /* renamed from: a */
    private View f26584a;

    /* renamed from: b */
    private TextView f26585b;

    public /* synthetic */ View getView(Context context, String str) {
        return ILabelView.CC.$default$getView(this, context, str);
    }

    public /* synthetic */ View getView(Context context, String str, int i) {
        return ILabelView.CC.$default$getView(this, context, str, i);
    }

    public View getView(Context context, String str, int i, boolean z) {
        if (this.f26584a == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.line_bubble_view, (ViewGroup) null, false);
            this.f26584a = inflate;
            this.f26585b = (TextView) inflate.findViewById(R.id.bubble_content);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f26585b.setText(str);
        }
        if (z) {
            this.f26585b.setTextColor(context.getResources().getColor(R.color.multi_line_bubble_strong_text_color));
            this.f26584a.setBackground(context.getResources().getDrawable(R.drawable.map_bubble_bg_shadow_selected));
        } else {
            this.f26585b.setTextColor(context.getResources().getColor(R.color.multi_line_bubble_weak_text_color));
            this.f26584a.setBackground(context.getResources().getDrawable(R.drawable.map_bubble_bg_shadow_normal));
        }
        if (i == 8) {
            this.f26585b.setBackground(context.getResources().getDrawable(R.drawable.shape_map_bubble_right_top));
        } else if (i == 2) {
            this.f26585b.setBackground(context.getResources().getDrawable(R.drawable.shape_map_bubble_left_top));
        } else if (i == 32) {
            this.f26585b.setBackground(context.getResources().getDrawable(R.drawable.shape_map_bubble_right_bottom));
        } else if (i == 128) {
            this.f26585b.setBackground(context.getResources().getDrawable(R.drawable.shape_map_bubble_left_bottom));
        }
        return this.f26584a;
    }
}
